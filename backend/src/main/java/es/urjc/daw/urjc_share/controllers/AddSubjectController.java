package es.urjc.daw.urjc_share.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.daw.urjc_share.data.DegreeRepository;
import es.urjc.daw.urjc_share.data.SubjectRepository;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Subject;

@Controller
public class AddSubjectController {
	
	@Autowired
	private SubjectRepository subjectrepository;
	
	@Autowired
	private DegreeRepository degreeRepository;
	

	
	@PostMapping("/addSubject")
	private  String newSubject(Model model, @RequestParam String nameSubject, @RequestParam long idDegree) {
		Degree degree = degreeRepository.findById(idDegree);
		subjectrepository.save(new Subject(nameSubject, degree));
		return "redirect:/";
		
	}
}
