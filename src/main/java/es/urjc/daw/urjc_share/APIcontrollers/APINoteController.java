package es.urjc.daw.urjc_share.APIcontrollers;

import com.fasterxml.jackson.annotation.JsonView;

import es.urjc.daw.urjc_share.APIcontrollers.APISubjectController.SubjectsView;
import es.urjc.daw.urjc_share.model.*;
import es.urjc.daw.urjc_share.services.NoteService;
import es.urjc.daw.urjc_share.services.SubjectService;
import es.urjc.daw.urjc_share.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class APINoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UploadFileService uploadFileService;

    interface NotesView extends Note.BasicViewNote, User.BasicViewUserForNote, Score.BasicViewScore, Subject.BasicViewSubjectForNotes, Degree.BasicViewSubject{ }
    interface ScoreView extends User.BasicViewUserForNote, Score.BasicViewScore { }

    @JsonView(NotesView.class)
    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getNotes(@RequestParam Optional<String> name, Pageable page) {
    	Page<Note> notesPage;
    	if(name.isPresent()){
    		notesPage = noteService.getNotes(name.get().replace("+"," "), page);
           if(!notesPage.isEmpty()){
               return new ResponseEntity<>(notesPage.getContent(), HttpStatus.OK);
           }else{
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
       }else{
    	   Page<Note> notes = noteService.getNotes(page);
           if (!notes.isEmpty()) {
               return new ResponseEntity<>(notes.getContent(), HttpStatus.OK);
           } else {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
       }
        
    }

    @JsonView(NotesView.class)
    @PostMapping("/notes")
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
    @GetMapping("subjects/{subjectId}/notes")
    public ResponseEntity<List<Note>>  getSubjectsFromDegree(@PathVariable long subjectId, Pageable page){
        Subject subject = subjectService.getSubject(subjectId);
        if(subject != null){
            Page<Note> notesPage = noteService.getNotes(subject,page);
            if(!notesPage.isEmpty()){
                return new ResponseEntity<>(notesPage.getContent(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(NotesView.class)
    @PutMapping("/notes/{id}/file")
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
    @PutMapping("/notes/{id}")
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @JsonView(NotesView.class)
    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNote(@PathVariable long id) {
        Note note = noteService.getNote(id);
        if (note != null) {
            return new ResponseEntity<>(note, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/notes/{id}")
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
    @PostMapping("/notes/{id}/scores")
    public ResponseEntity<Score> scoreController(@PathVariable int id,@RequestBody Score score) {
    	if(noteService.createScore(id, score)) {
    		return new ResponseEntity<>(score, HttpStatus.OK);
    	}else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
}
