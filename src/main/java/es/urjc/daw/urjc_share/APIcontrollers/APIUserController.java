package es.urjc.daw.urjc_share.APIcontrollers;

import com.fasterxml.jackson.annotation.JsonView;
import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Score;
import es.urjc.daw.urjc_share.model.Subject;
import es.urjc.daw.urjc_share.model.User;
import es.urjc.daw.urjc_share.services.ImageService;
import es.urjc.daw.urjc_share.services.NoteService;
import es.urjc.daw.urjc_share.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/users")
public class APIUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private NoteService noteService;
    
    private AtomicLong lastId = new AtomicLong();

    interface UsersView extends User.BasicView, Note.BasicViewUser {
    }
    @JsonView(UsersView.class)
    @GetMapping("")
    public ResponseEntity<List<User>> getUsers(Pageable page) {
        Page<User> usersPage = userService.getUsers(page);
        if (!usersPage.isEmpty()) {
            return new ResponseEntity<>(usersPage.getContent(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @JsonView(UsersView.class)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> newUser(@RequestBody User user) throws IOException {
        if (!userService.createUser(user)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @JsonView(UsersView.class)
    @PostMapping("/{id}/image")
    public ResponseEntity<User> postImage(@PathVariable long id, @RequestParam MultipartFile imageFile) throws IOException {
        Optional<User> user = Optional.ofNullable(userService.getUser(id));
        if (user.isPresent()) {
            user.get().setImage(true);
            userService.saveUser(user.get());
            imageService.saveImage("users", user.get().getId(), imageFile);
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @JsonView(UsersView.class)
    @PutMapping("/{id}")
    public ResponseEntity<User> putUser(@PathVariable long id, @RequestBody User userUpdated) {
        User user = userService.getUser(id);
        if (user != null) {
            userService.editUser(user, userUpdated);
            return new ResponseEntity<>(userUpdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @JsonView(UsersView.class)
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @JsonView(UsersView.class)
    @GetMapping("/{id}/image")
    public ResponseEntity<Object> getImageUser(@PathVariable long id) throws IOException {
        Optional<User> user = Optional.ofNullable(userService.getUser(id));
        if (user.isPresent()) {
            if (user.get().getImage()) {
                return this.imageService.createResponseFromImage("users", id);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(UsersView.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        User user = userService.getUser(id);
        if (user != null) {
            List<Note> notes = user.getNotes();
            for (Note note : notes) {
                user.getNotes().remove(note);
            }
            userService.deleteUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @JsonView(UsersView.class)
    @GetMapping("/ranking")
    public ResponseEntity<List<User>> showRanking() {
    	List<User> users = userService.getSortedUsers();
    	if(!users.isEmpty()) {
    		return new ResponseEntity<>(users, HttpStatus.OK);
    	}else {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    }
}
