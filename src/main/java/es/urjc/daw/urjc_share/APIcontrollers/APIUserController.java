package es.urjc.daw.urjc_share.APIcontrollers;

import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.User;
import es.urjc.daw.urjc_share.services.ImageService;
import es.urjc.daw.urjc_share.services.SendMailService;
import es.urjc.daw.urjc_share.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/users")
public class APIUserController {
    @Autowired
    private UserService userService;

    private AtomicLong lastId = new AtomicLong();

    @GetMapping("/")
    public List<User> Users() {
        return userService.users();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> newUser(@RequestBody User user,@RequestParam MultipartFile imagenFile) throws IOException {
        if(!userService.createUser(user, imagenFile)){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}/")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userUpdated) {
        User user = userService.getUser(id);
        if (user != null) {
            userService.updateUser(id, userUpdated);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<User> borraItem(@PathVariable long id) {
        User user = userService.getUser(id);
        if (user != null) {
            userService.deleteUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
