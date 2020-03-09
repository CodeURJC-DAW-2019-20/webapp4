package es.urjc.daw.urjc_share.services;

import es.urjc.daw.urjc_share.component.UserComponent;
import es.urjc.daw.urjc_share.data.NoteRepository;
import es.urjc.daw.urjc_share.data.ScoreRepository;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Score;
import es.urjc.daw.urjc_share.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Configuration
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserComponent currentUser;

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }
    
    public Page<Note> getNotes(Pageable page) {
        return noteRepository.findAll(page);
    }
    
    public Page<Note> getNotes(String name, Pageable page){
    	return noteRepository.findAllByName(name, page);
    }

    public boolean createNote(Note note) {
        note.setUser(currentUser.getEntityUser());
        noteRepository.saveAndFlush(note);
        return true;
    }

    public Note getNote(long id) {
        return noteRepository.findById(id);
    }

    public boolean deleteNote(Note note) {
        List<Score> scores = scoreRepository.findAllByNote(note);
        if (scores.size() > 0) {
            for (int i = 0; i < scores.size(); i++) {
                scoreRepository.delete(scores.get(i));
            }
        }
        noteRepository.deleteById(note.getId());
        return true;
    }

    public void updateNote(long id, Note noteUpdated) {
        noteUpdated.setId(id);
        noteRepository.save(noteUpdated);
    }

    public boolean isOwner(Note note) {
        return note.getUser().getId() == currentUser.getEntityUser().getId();
    }

    public boolean createScore(int id, Score score) {
        Note note = noteRepository.findById(id);
        if (note != null && currentUser.getEntityUser() != null) {
            score.setNote(note);
            score.setUser(currentUser.getEntityUser());
            scoreRepository.saveAndFlush(score);
            return true;
        } else {
            return false;
        }
    }
}
