package es.urjc.daw.urjc_share.APIcontrollers;

import com.fasterxml.jackson.annotation.JsonView;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Subject;
import es.urjc.daw.urjc_share.services.DegreeService;
import es.urjc.daw.urjc_share.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class APISubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private DegreeService degreeService;

    interface SubjectsView extends Subject.BasicViewSubject, Degree.BasicViewSubject, Note.BasicViewSubject { }

    @JsonView(SubjectsView.class)
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getSubject(@RequestParam Optional<String> name, Pageable page){
        Page<Subject> subjectsPage;

        if(name.isPresent()){
            subjectsPage = subjectService.getSubject(name.get().replace("+"," "), page);
            if(!subjectsPage.isEmpty()){
                return new ResponseEntity<>(subjectsPage.getContent(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else{
            subjectsPage = subjectService.getSubject(page);
            if(!subjectsPage.isEmpty()){
                return new ResponseEntity<>(subjectsPage.getContent(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    }

    @JsonView(SubjectsView.class)
    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject>  getSubject(@PathVariable long id){
        Subject subject = subjectService.getSubject(id);
        if(subject != null){
            return new ResponseEntity<>(subject, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(SubjectsView.class)
    @GetMapping("degrees/{degreeId}/subjects")
    public ResponseEntity<List<Subject>>  getSubjectsFromDegree(@PathVariable long degreeId, Pageable page){
        Degree degree = degreeService.findDegreeById(degreeId);
        if(degree != null){
            Page<Subject> subjectsPage = subjectService.getSubjects(degree,page);
            if(!subjectsPage.isEmpty()){
                return new ResponseEntity<>(subjectsPage.getContent(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @JsonView(SubjectsView.class)
    @PostMapping("/subjects")
    public ResponseEntity<Subject> postSubject(@RequestBody Subject subject){
        Degree degree = degreeService.findDegreesByID(subject.getDegree().getId());
        if(degree != null){
            subject.setDegree(degree);
            degree.getSubjects().add(subject);
            subjectService.saveSubject(subject);
            degreeService.updateDegree(degree);
            return new ResponseEntity<>(subject, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @JsonView(SubjectsView.class)
    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable long id){
        Subject subject = subjectService.findSubjectById(id);
        if(subject != null){
            subjectService.deleteSubject(subject);
            return new ResponseEntity<>(subject, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(SubjectsView.class)
    @PutMapping("/subjects/{id}")
    public ResponseEntity<Subject> putDegree(@PathVariable long id, @RequestBody Subject newSubject){
        if(subjectService.findSubjectById(id) != null){
            Degree degree = degreeService.findDegreesByID(newSubject.getDegree().getId());
            if(degree != null){
                newSubject.setDegree(degree);
                newSubject.setId(id);
                degree.getSubjects().add(newSubject);
                subjectService.updateSubject(newSubject);
                degreeService.updateDegree(degree);
                return new ResponseEntity<>(newSubject, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
