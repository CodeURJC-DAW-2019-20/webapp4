package es.urjc.daw.urjc_share.services;

import es.urjc.daw.urjc_share.data.NoteRepository;
import es.urjc.daw.urjc_share.data.ScoreRepository;
import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Score;
import es.urjc.daw.urjc_share.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Configuration
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private NoteRepository noteRepository;
    
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ImageService imgService;

    @Autowired
    private SendMailService mailSender;

    public Page<User> getUsers(Pageable page) {
        return userRepository.findAll(page);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public boolean createUser(User user) throws IOException {
        user.setRoles(user.getRoles());
        userRepository.save(user);
        if(!user.getRoles().contains("ROLE_ADMIN")) {
        	mailSender.sendEmail(user.getEmail(), "Bienvenido a URJCshare",
                "Hola " + user.getNickname() + "\nBienvenido a la página para compartir apuntes de URJC! Es un placer tenerte con nosotros");
        }
        return true;
    }
    public boolean checkUserDispo(User user){
        return userRepository.findByNickname(user.getNickname())==null;
    }
    public User getUser(long id) {
        return userRepository.findById(id);
    }
    
    public void saveUser(User user) {
    	userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(long id, User userUpdated) {
        userRepository.save(userUpdated);
        userUpdated.setId(id);
    }

    public void editUser(User user, User userUpdated) {
        userUpdated.setId(user.getId());
        userUpdated.setRoles(user.getRoles());
        userRepository.saveAndFlush(userUpdated);
    }
    
    public List<User> getSortedUsers(){
    	List<Note> noteByUser;
        List<Score> scoreByNote;
        float auxMedia = 0;
        int numScores = 0;
		List <User> listUsers = userRepository.findAll();
        for (User userAux:listUsers){
            noteByUser = noteRepository.findAllByUser(userAux);
            for (Note auxNote:noteByUser) {
                scoreByNote = scoreRepository.findAllByNote(auxNote);
                for (Score auxScore:scoreByNote) {
                    auxMedia += auxScore.getScore();
                }
                numScores += scoreByNote.size();
            }
            if(numScores != 0){
				userAux.setMedia(auxMedia/numScores);
			}
            auxMedia = 0;
            numScores = 0;
        }
		Collections.sort(listUsers, (o1, o2) -> {
			User u1 = o1;
			User u2 = o2;
			return Float.compare(u2.getMedia(), u1.getMedia());
		});
		return listUsers;
    }
}
