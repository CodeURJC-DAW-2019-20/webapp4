package es.urjc.daw.urjc_share.controllers;

import es.urjc.daw.urjc_share.data.DegreeRepository;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class NavController {
    @Autowired
    private DegreeRepository degreeRepository;
    @GetMapping("/")
    public String goToIndex(Model model) {
        return "index";
    }
    
    @GetMapping("/ranking")
    public String goToRanking(Model model) {
        return "ranking";
    }
    
    @GetMapping("/profile")
    public String goToMyProfile(Model model) {
        return "myprofile";
    }
    
    @GetMapping("/login")
    public String goToSignin(Model model) {
        return "login";
    }
    
    @GetMapping("/join")
    public String goToMySignup(Model model){
        List<Degree> degrees = degreeRepository.findAll();
        model.addAttribute("alldegrees",degrees);
        return "register";
    }
    
    @PostMapping("/searched")
    public String searchInformation(Model model, @RequestParam String searchType, @RequestParam String textSearched) {
    	model.addAttribute("textSearched",textSearched);
    	if(searchType.equals("Grado")) {
    		return "listsubjects";
    	}else {
    		return "allNotes";
    	}
    }
    
    @PostMapping("/searched/subject")
    public String selectSubject(Model model, @RequestParam String name) {
    	//TO DO
    	//Subject must be searched in the database
    	//and a object must be created and assigned to the model
    	//model.addAttribute("subject",subject);
    	return "allNotes";
    }
    
    @PostMapping("/created")
    public String createDegreeOrSubject(@RequestParam String grados, @RequestParam String asignaturas) {
    	Degree degree = new Degree(grados);
    	if(!asignaturas.equals("")) {
    		Subject subject = new Subject(asignaturas, degree);
    		degree.getSubjects().add(subject);
    	}
    	//TO DO
    	//Degree and subjects must be stored into db
    	return "index";
    }
    
    
}
