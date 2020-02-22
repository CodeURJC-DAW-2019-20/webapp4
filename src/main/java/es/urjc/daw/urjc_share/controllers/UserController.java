package es.urjc.daw.urjc_share.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.User;
import es.urjc.daw.urjc_share.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ImageService imgService;


    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        List<User> users = (List<User>) repository.findAll();
        model.addAttribute("usuarios", users);
        return "users";
    }

    @GetMapping("/usuario/nuevo")
    public String nuevoAnuncioForm() {
        return "new_user";
    }
   

    @PostMapping("/createUser")
    public String newUser(User user, @RequestParam MultipartFile imagenFile) throws IOException {
        user.setImage(true);
        user.setRoles(new ArrayList<>(Arrays.asList("ROLE_USER")));
        repository.save(user);
        imgService.saveImage("usuarios", user.getId(), imagenFile);
        return "redirect:/";
    }
    
    @PostMapping("/loginUser")
    public String loginUser(){
    	return "login";
    }

    @GetMapping("/usuario/{id}")
    public String seeUser(Model model, @PathVariable long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("usuario", user.get());
        }
        return "myprofile";
    }
}