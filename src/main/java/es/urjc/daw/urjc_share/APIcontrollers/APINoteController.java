package es.urjc.daw.urjc_share.APIcontrollers;

import com.fasterxml.jackson.annotation.JsonView;
import es.urjc.daw.urjc_share.model.*;
import es.urjc.daw.urjc_share.services.NoteService;
import es.urjc.daw.urjc_share.services.SubjectService;
import es.urjc.daw.urjc_share.services.UploadFileService;
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
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private UploadFileService uploadFileService;

    private AtomicLong lastId = new AtomicLong();
    interface NotesView extends Note.BasicViewNote, User.BasicViewUserForNote, Score.BasicViewScore, Subject.BasicViewSubjectForNotes, Degree.BasicViewSubject{ }
    interface ScoreView extends Score.BasicViewScore, User.BasicViewUserForNote{ }

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
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Note> newNote(@RequestBody Note note) {
        Subject subject = subjectService.getSubject(note.getSubject().getId());
        if(subject != null) {
            note.setSubject(subject);
            if (noteService.createNote(note)) {
                return new ResponseEntity<>(note, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(NotesView.class)
    @PutMapping("/{id}/file")
    public ResponseEntity<Note> putImage(@PathVariable long id, @RequestParam MultipartFile file) throws IOException {
        Note note = noteService.getNote(id);
        if (!noteService.isOwner(note)){
          return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (note != null) {
            if(!file.isEmpty()) {
                String[] s = file.getOriginalFilename().split("\\.");
                uploadFileService.saveFile(file, note.getId());
                note.setRuta(note.getId() + "." + s[s.length - 1]);
                note.setExtension(s[s.length - 1]);
                noteService.createNote(note);
                return new ResponseEntity<>(note, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @JsonView(NotesView.class)
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable long id, @RequestBody Note noteUpdated) {
        Note note = noteService.getNote(id);
        if (!noteService.isOwner(note)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Subject subject = subjectService.getSubject(note.getSubject().getId());
        if(subject != null) {
            note.setSubject(subject);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (note != null) {
            noteService.updateNote(id, noteUpdated);
            return new ResponseEntity<>(noteUpdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(note, HttpStatus.NOT_FOUND);
        }
    }
    @JsonView(NotesView.class)
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
    public ResponseEntity<Note> borraItem(@PathVariable int id) {
        Note note = noteService.getNote(id);
        if (note != null) {
            if (!noteService.isOwner(note)){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            noteService.deleteNote(note);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(ScoreView.class)
    @PostMapping("/{id}/scores")
    public ResponseEntity<Score> scoreController(@PathVariable int id,@RequestBody Score score) {
    	if(noteService.createScore(id, score)) {
    		return new ResponseEntity<>(score, HttpStatus.OK);
    	}else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
}
