package es.urjc.daw.urjc_share.controllers;


import es.urjc.daw.urjc_share.data.NoteRepository;
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
import java.util.List;
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
    private NoteRepository noteRepository;

    @RequestMapping("/notes")
    public String saveNote(Model model) {
        List<Note> notes = noteRepository.findAll();
        model.addAttribute("usuarios", notes);

        return "allNotes";
    }
    @PostMapping("/apunte_guardado")
    public String newNote(Model model, Note note, @RequestParam MultipartFile file) throws IOException {
        noteRepository.save(note);
        return "index";
    }
    @RequestMapping("/subir_apunte")
    public String noteController(Note note) {
        noteRepository.save(note);
        return "allNotes";
    }


}
