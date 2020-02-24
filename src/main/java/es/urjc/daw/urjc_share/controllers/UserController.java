package es.urjc.daw.urjc_share.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.User;
import es.urjc.daw.urjc_share.services.ImageService;
import es.urjc.daw.urjc_share.services.sendMailService;
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

    @Autowired
    private sendMailService mailSender;


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
        mailSender.sendEmail(user.getEmail(), "Bienvenido a URJCshare",
                "Hola "+user.getNickname()+"\nBienvenido a la página para compartir apuntes de URJC! Es un placer tenerte con nosotros");

        return "redirect:/";
    }
    
    @PostMapping("/loginUser")
    public String loginUser(){
    	return "login";
    }

    @GetMapping("/usuario/{id}")
    public String seeUser(Model model, @PathVariable long id) {
        User user = repository.findById(id);
        model.addAttribute("usuario", user);
        
        return "myprofile";
    }
}