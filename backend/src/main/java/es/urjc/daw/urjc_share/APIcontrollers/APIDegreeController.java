package es.urjc.daw.urjc_share.APIcontrollers;

import com.fasterxml.jackson.annotation.JsonView;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Subject;
import es.urjc.daw.urjc_share.services.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/degrees")
public class APIDegreeController {

    @Autowired
    private DegreeService service;

    interface DegreesView extends Degree.BasicView, Subject.BasicViewDegree { }

    @JsonView(DegreesView.class)
    @GetMapping("")
    public ResponseEntity<List<Degree>>  getDegree(@RequestParam Optional<String> name, Pageable page){
        Page<Degree> degreesPage;

        if(name.isPresent()){
             degreesPage = service.findDegreesByName(name.get().replace("+"," "), page);
            if(!degreesPage.isEmpty()){
                return new ResponseEntity<>(degreesPage.getContent(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else{
             degreesPage = service.findDegrees(page);
            if(!degreesPage.isEmpty()){
                return new ResponseEntity<>(degreesPage.getContent(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    }

    @JsonView(DegreesView.class)
    @GetMapping("/{id}")
    public ResponseEntity<Degree>  getDegree(@PathVariable long id){
        Degree degree = service.findDegreeById(id);
        if(degree != null){
            return new ResponseEntity<>(degree, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(DegreesView.class)
    @PostMapping("")
    public ResponseEntity<Degree> postDegree(@RequestBody Degree degree){
        if(service.checkDegreeDispo(degree)) {
            service.saveDegree(degree);
            return new ResponseEntity<>(degree, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @JsonView(DegreesView.class)
    @PutMapping("/{id}")
    public ResponseEntity<Degree> putDegree(@PathVariable long id, @RequestBody Degree newDegree){
        if(service.findDegreeById(id) != null){
            newDegree.setId(id);
            service.updateDegree(newDegree);
            return new ResponseEntity<>(newDegree, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(DegreesView.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Degree> deleteDegree(@PathVariable long id){
        Degree degree = service.findDegreeById(id);
        if(degree != null){
            service.deleteDegree(degree);
            return new ResponseEntity<>(degree, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
