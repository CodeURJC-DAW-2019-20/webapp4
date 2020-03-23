package es.urjc.daw.urjc_share.services;

import es.urjc.daw.urjc_share.data.DegreeRepository;
import es.urjc.daw.urjc_share.data.NoteRepository;
import es.urjc.daw.urjc_share.data.SubjectRepository;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Subject;
import es.urjc.daw.urjc_share.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configuration
public class DegreeService {

    @Autowired
    private DegreeRepository degreeRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private NoteRepository noteRepository;

    public Page<Degree> findDegrees(Pageable page){
        return degreeRepository.findAll(page);
    }

    public List<Degree> findDegrees(){
        return degreeRepository.findAll();
    }

    public Page<Degree> findDegreesByName(String name, Pageable page){
        return degreeRepository.findAllByName(name, page);
    }
    public boolean checkDegreeDispo(Degree degree){
        return degreeRepository.findByName(degree.getName())==null;
    }
    public List<Degree> findDegreesByName(String name){
        return degreeRepository.findAllByName(name);
    }
    
    public Degree findDegreesByID(long id){
        return degreeRepository.findById(id);
    }

    public void saveDegree(Degree newDegree){
        degreeRepository.save(newDegree);
    }

    public Degree findDegreeById(long id){
        return degreeRepository.findById(id);
    }

    public Degree updateDegree(Degree degree){
        degreeRepository.saveAndFlush(degree);
        return degree;
    }

    public Degree deleteDegree(Degree degree){
        List<Note> notes;
        List<Subject> subjects = subjectRepository.findAllByDegree(degree);
            for (Subject subject : subjects){
                notes = noteRepository.findAllBySubject(subject);
                noteRepository.deleteInBatch(notes);
            }
            subjectRepository.deleteInBatch(subjects);
        degreeRepository.delete(degree);
        return degree;
    }
}
