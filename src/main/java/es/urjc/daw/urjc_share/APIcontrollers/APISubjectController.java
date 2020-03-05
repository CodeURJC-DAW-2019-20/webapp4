package es.urjc.daw.urjc_share.APIcontrollers;

import es.urjc.daw.urjc_share.model.Subject;
import es.urjc.daw.urjc_share.model.Subject;
import es.urjc.daw.urjc_share.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subjects")
public class APISubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("")
    public ResponseEntity<List<Subject>> getSubject(@RequestParam String name){

        List<Subject> subjects = subjectService.getSubject(name);
        if(!subjects.isEmpty()){
            return new ResponseEntity<>(subjects, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Subject postSubject(@RequestBody Subject subject){
        subjectService.saveSubject(subject);
        return subject;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable long id){
        Subject subject = subjectService.findSubjectById(id);
        if(subject != null){
            subjectService.deleteSubject(subject);
            return new ResponseEntity<>(subject, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
