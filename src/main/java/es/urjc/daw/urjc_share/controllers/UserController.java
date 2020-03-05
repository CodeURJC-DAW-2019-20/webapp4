package es.urjc.daw.urjc_share.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import es.urjc.daw.urjc_share.component.UserComponent;
import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.User;
import es.urjc.daw.urjc_share.services.ImageService;
import es.urjc.daw.urjc_share.services.SendMailService;
import es.urjc.daw.urjc_share.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private UserComponent userComponent;

    @PostMapping("/createUser")
    public String newUser(User user, @RequestParam MultipartFile imagenFile) throws IOException {
        userService.createUser(user);
        imageService.saveImage("users", user.getId(), imagenFile);
        return "redirect:/";
    }

    @PostMapping("/editProfile")
    public String editProfile(User userUpdated, @RequestParam MultipartFile imagenFile) throws IOException {
        User user = userComponent.getEntityUser();
        imageService.saveImage("users",user.getId(),imagenFile);
        userService.editUser(user,userUpdated);
        return "redirect:/";
    }

    @PostMapping("/loginUser")
    public String loginUser() {
        return "login";
    }

    @GetMapping("/user/{id}")
    public String seeUser(Model model, @PathVariable long id) {
        model.addAttribute("user", userService.getUser(id));
        return "myprofile";
    }
}