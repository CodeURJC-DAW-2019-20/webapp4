package es.urjc.daw.urjc_share.services;

import es.urjc.daw.urjc_share.data.DegreeRepository;
import es.urjc.daw.urjc_share.data.NoteRepository;
import es.urjc.daw.urjc_share.data.SubjectRepository;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Subject> getSubject(Pageable page){

        return subjectRepository.findAll(page);
    }

    public Page<Subject> getSubject(String name, Pageable page){

        return subjectRepository.findAllByName(name, page);
    }

    public Subject getSubject(long id){
        return subjectRepository.findById(id);
    }

    public Page<Subject> getSubjects(Degree degree, Pageable page){
        return subjectRepository.findAllByDegree(degree,page);
    }
    
    public List<Subject> getSubjects(Degree degree){
        return subjectRepository.findAllByDegree(degree);
    }

    public void saveSubject(Subject subject){
        subjectRepository.save(subject);
    }
    public boolean checkSubjectDispo(Subject subject){
        List<Subject> lista = subjectRepository.findAllByName(subject.getName());
        for (Subject sub:lista){
            if(subject.getName().equals(sub.getName()) && subject.getDegree().getId()==sub.getDegree().getId()){
                return false;
            }
        }
        return true;
    }
    public Subject findSubjectById(long id){
        return subjectRepository.findById(id);
    }

    public Subject deleteSubject(Subject subject){
        List<Note> notes = noteRepository.findAllBySubject(subject);
        noteRepository.deleteInBatch(notes);
        subjectRepository.delete(subject);
        return subject;
    }

    public Subject updateSubject(Subject subject){
        subjectRepository.saveAndFlush(subject);
        return subject;
    }
}
