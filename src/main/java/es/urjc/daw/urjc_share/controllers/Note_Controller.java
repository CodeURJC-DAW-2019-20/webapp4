package es.urjc.daw.urjc_share.controllers;


import es.urjc.daw.urjc_share.component.UserComponent;
import es.urjc.daw.urjc_share.data.NoteRepository;
import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.services.UploadFileService;
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
    @Autowired
    private UserComponent currentUser;
    @RequestMapping("/notes")
    public String saveNote(Model model) {
        List<Note> notes = noteRepository.findAll();
        model.addAttribute("usuarios", notes);

        return "allNotes";
    }
    @Autowired
    private UploadFileService uploadFileService;
    @PostMapping("/apunte_guardado")
    public String newNote(Model model, Note note, @RequestParam MultipartFile file) throws IOException {
        note.setUser(currentUser.getEntityUser());
        noteRepository.save(note);
        if(!file.isEmpty()){String [] s = file.getOriginalFilename().split(".");
            uploadFileService.saveFile(file,note.getId());
        }
        String [] s = file.getOriginalFilename().split("\\.");
        note.setRuta(note.getId()+"."+s[s.length-1]);
        note.setExtension(s[s.length-1]);
        noteRepository.save(note);
        return "redirect:/";
    }

    @PostMapping("/subir_apunte")
    public String noteController(Note note) {
        noteRepository.save(note);
        return "allNotes";
    }


}
