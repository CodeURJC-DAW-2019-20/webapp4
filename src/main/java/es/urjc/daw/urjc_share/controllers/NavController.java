package es.urjc.daw.urjc_share.controllers;

import es.urjc.daw.urjc_share.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class NavController {

    @GetMapping("/")
    public String goToIndex(Model model) {
        return "index";
    }
    
    @GetMapping("/ranking/")
    public String goToRanking(Model model) {
        return "ranking";
    }
    
    @GetMapping("/profile/")
    public String goToMyProfile(Model model) {
        return "myprofile";
    }
    
    @GetMapping("/login/")
    public String goToSignin(Model model) {
        return "login";
    }
    
    @GetMapping("/join/")
    public String goToMySignup(Model model) {
        return "register";
    }
}
