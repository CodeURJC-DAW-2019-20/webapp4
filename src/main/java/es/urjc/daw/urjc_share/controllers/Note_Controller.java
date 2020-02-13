package es.urjc.daw.urjc_share.controllers;

import es.urjc.daw.urjc_share.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class Note_Controller {

    private Map<Integer, Note> notes = new ConcurrentHashMap<>();
    private AtomicInteger id = new AtomicInteger();
    @RequestMapping("/apuntes")
    public String saveNote(Model model, Note apunte) {
        notes.put(id.getAndIncrement(), apunte);
        model.addAttribute("notes", notes.values());

        return "allNotes";
    }
    @RequestMapping("/subir_apunte")
    public String noteController() {
        return "uploadNote";
    }
}
