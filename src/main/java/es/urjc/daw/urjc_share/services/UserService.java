package es.urjc.daw.urjc_share.services;

import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Configuration
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private ImageService imgService;

    @Autowired
    private SendMailService mailSender;

    public List<User> users() {
        return repository.findAll();
    }

    public boolean createUser(User user) throws IOException {
        user.setImage(true);
        user.setRoles(new ArrayList<>(Arrays.asList("ROLE_USER")));
        repository.save(user);
        mailSender.sendEmail(user.getEmail(), "Bienvenido a URJCshare",
                "Hola " + user.getNickname() + "\nBienvenido a la página para compartir apuntes de URJC! Es un placer tenerte con nosotros");

        return true;
    }

    public User getUser(long id) {
        return repository.findById(id);
    }

    public void deleteUser(long id) {
        repository.deleteById(id);
    }

    public void updateUser(long id, User userUpdated) {
        repository.save(userUpdated);
        userUpdated.setId(id);
    }
}
