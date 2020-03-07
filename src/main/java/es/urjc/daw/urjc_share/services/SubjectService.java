package es.urjc.daw.urjc_share.services;

import es.urjc.daw.urjc_share.data.DegreeRepository;
import es.urjc.daw.urjc_share.data.NoteRepository;
import es.urjc.daw.urjc_share.data.SubjectRepository;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configuration
public class SubjectService {
    @Autowired
    private DegreeRepository degreeRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private NoteRepository noteRepository;

    public List<Subject> getSubject(String name){

        return subjectRepository.findAllByName(name);
    }

    public void saveSubject(Subject subject){
        subjectRepository.save(subject);
    }

    public Subject findSubjectById(long id){
        return subjectRepository.findById(id);
    }

    public Subject deleteSubject(Subject subject){
        List<Note> notes = noteRepository.findAllBySubject(subject);
        for (Note note : notes){
            noteRepository.delete(note);
        }
        subjectRepository.delete(subject);
        return subject;
    }

    public Subject updateSubject(Subject subject){
        subjectRepository.saveAndFlush(subject);
        return subject;
    }
}
