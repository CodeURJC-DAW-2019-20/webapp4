package es.urjc.daw.urjc_share.services;

import es.urjc.daw.urjc_share.data.NoteRepository;
import es.urjc.daw.urjc_share.data.ScoreRepository;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Score;
import es.urjc.daw.urjc_share.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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


    public List<Note> notes() {
        return noteRepository.findAll();
    }

    public boolean createNote(Note note) {

        return true;
    }

    public Note getNote(long id) {
        return noteRepository.findById(id);
    }

    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }

    public void updateNote(long id, Note noteUpdated) {
        noteUpdated.setId(id);
        noteRepository.save(noteUpdated);
    }
    public void scoreNote(long noteID,User user, int value) {
        scoreRepository.save(new Score(value,user,noteRepository.findById(noteID)));
    }
}
