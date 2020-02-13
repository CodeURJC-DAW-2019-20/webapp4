package es.urjc.daw.urjc_share.controllers;

import es.urjc.daw.urjc_share.Apunte;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class Apunte_Controller {

    private Map<Integer,Apunte> apuntes = new ConcurrentHashMap<>();
    private AtomicInteger id = new AtomicInteger();
    @RequestMapping("/apuntes")
    public String saveFile(Model model, Apunte apunte) {
        apuntes.put(id.getAndIncrement(), apunte);
        model.addAttribute("apuntes", apuntes.values());

        return "allNotes";
    }
    @RequestMapping("/subir_apunte")
    public String Apunte_Controller() {
        return "subirApunte";
    }
}
