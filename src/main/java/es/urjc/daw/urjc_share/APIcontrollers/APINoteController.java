package es.urjc.daw.urjc_share.APIcontrollers;

import com.fasterxml.jackson.annotation.JsonView;
import es.urjc.daw.urjc_share.model.*;
import es.urjc.daw.urjc_share.services.NoteService;
import es.urjc.daw.urjc_share.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/notes")
public class APINoteController {
    @Autowired
    private NoteService noteService;
    private SubjectService subjectService;

    private AtomicLong lastId = new AtomicLong();
    interface NotesView extends Note.BasicViewNote, User.BasicViewUserForNote, Score.BasicViewScore, Subject.BasicViewSubjectForNotes, Degree.BasicViewSubject{ }

    @JsonView(NotesView.class)
    @GetMapping("")
    public ResponseEntity<List<Note>> Notes() {
        List<Note> notes = noteService.notes();
        if (!notes.isEmpty()) {
            return new ResponseEntity<>(notes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @JsonView(NotesView.class)
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Note> newNote(@RequestBody Note note) {
        if (!noteService.createNote(note)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PutMapping("/{id}/")
    public ResponseEntity<Note> updateNote(@PathVariable long id, @RequestBody Note noteUpdated) {
        Note note = noteService.getNote(id);
        if (note != null) {
            noteService.updateNote(id, noteUpdated);
            return new ResponseEntity<>(noteUpdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(note, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable long id) {
        Note note = noteService.getNote(id);
        if (note != null) {
            return new ResponseEntity<>(note, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Note> borraItem(@PathVariable long id) {
        Note note = noteService.getNote(id);
        if (note != null) {
            noteService.deleteNote(id);
            return new ResponseEntity<>(note, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
