package es.urjc.daw.urjc_share.APIcontrollers;

import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.User;
import es.urjc.daw.urjc_share.services.ImageService;
import es.urjc.daw.urjc_share.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/users")
public class APIUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageService imageService;
    private AtomicLong lastId = new AtomicLong();

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.users();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> newUser(@RequestBody User user) throws IOException {
        if (!userService.createUser(user)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}/image")
    public ResponseEntity<User> putImage(@PathVariable long id, @RequestParam MultipartFile imagenFile) throws IOException {
        Optional<User> user = Optional.ofNullable(userService.getUser(id));
        if (user.isPresent()) {
            user.get().setImage(true);
            userRepository.save(user.get());
            imageService.saveImage("users", user.get().getId(), imagenFile);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> putUser(@PathVariable long id, @RequestBody User userUpdated) {
        User user = userService.getUser(id);
        if (user != null) {
            userService.editUser(user,userUpdated);
            return new ResponseEntity<>(userUpdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/imagen")
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


    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        User user = userService.getUser(id);
        if (user != null) {
            userService.deleteUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
