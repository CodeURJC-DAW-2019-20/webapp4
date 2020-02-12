package es.urjc.daw.urjc_share.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class init {

    @RequestMapping("/init")
    public String init(Model model) {
        System.out.println("Hola controller init");
        model.addAttribute("name", "World");
        return "init_template";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
