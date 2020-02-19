package es.urjc.daw.urjc_share.controllers;


import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.User;
import es.urjc.daw.urjc_share.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class Note_Controller {

    private Map<Integer, Note> notes = new ConcurrentHashMap<>();
    private AtomicInteger id = new AtomicInteger();
    @Autowired
    private UserRepository repository;
    @Autowired
    ImageService imgService;

    @RequestMapping("/notes")
    public String saveNote(Model model, Note apunte) {
        notes.put(id.getAndIncrement(), apunte);
        model.addAttribute("notes", notes.values());

        return "allNotes";
    }

    @RequestMapping("/subir_apunte")
    public String noteController() {
        return "allNotes";
    }


}
