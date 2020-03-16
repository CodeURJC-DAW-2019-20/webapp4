package es.urjc.daw.urjc_share.controllers;


import es.urjc.daw.urjc_share.component.UserComponent;
import es.urjc.daw.urjc_share.data.NoteRepository;
import es.urjc.daw.urjc_share.data.ScoreRepository;
import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Score;
import es.urjc.daw.urjc_share.model.User;
import es.urjc.daw.urjc_share.services.ImageService;
import es.urjc.daw.urjc_share.services.NoteService;
import es.urjc.daw.urjc_share.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
public class NoteController {

    private Map<Integer, Note> notes = new ConcurrentHashMap<>();
    private AtomicInteger id = new AtomicInteger();
    @Autowired
    private UserRepository repository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NavController navController;

    @Autowired
    private UserComponent currentUser;

    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private NoteService noteService;

    @RequestMapping("/notes")
    public String saveNote(Model model) {
        List<Note> notes = noteService.getNotes();
        model.addAttribute("user", notes);

        return "allNotes";
    }

    @PostMapping("/note_save")
    public String newNote(Model model, Note note, @RequestParam MultipartFile file) throws IOException {
        note.setUser(currentUser.getEntityUser());
        noteService.createNote(note);
        if (!file.isEmpty()) {
            String[] s = file.getOriginalFilename().split(".");
            uploadFileService.saveFile("notes", file, note.getId());
        }
        String[] s = file.getOriginalFilename().split("\\.");
        note.setRuta("note-" + note.getId() + "." + s[s.length - 1]);
        note.setExtension(s[s.length - 1]);
        noteService.createNote(note);
        return "redirect:/";
    }

    @PostMapping("/notes/{noteID}/addScoreNote")
    public String noteController(@PathVariable int noteID, @RequestParam int value, Model model) {
        noteService.createScore(noteID, new Score(value, null, null));
        return "redirect:/notes/" + noteID;
    }


}
