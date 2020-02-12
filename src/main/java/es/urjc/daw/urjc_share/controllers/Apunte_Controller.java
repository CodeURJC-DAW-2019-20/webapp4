package es.urjc.daw.urjc_share.controllers;

import es.urjc.daw.urjc_share.Apunte;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Apunte_Controller {
    @RequestMapping("/subirApunte")
    public String Apunte_Controller(Model model, Apunte apunte) {
        model.addAttribute("apunte", apunte);

        return "allNotes";
    }
}
