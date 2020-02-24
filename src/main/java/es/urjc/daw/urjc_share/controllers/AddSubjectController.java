package es.urjc.daw.urjc_share.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import es.urjc.daw.urjc_share.data.DegreeRepository;
import es.urjc.daw.urjc_share.data.SubjectRepository;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Subject;

@Controller
public class AddSubjectController {
	
	@Autowired
	private SubjectRepository subjectrepository;
	

	
	@PostMapping("/addSubject")
	private  String newSubject(Model model, Subject subject, Degree degree) {
		
		
		long id = degree.getId();
		subject.setId(id);
		subjectrepository.save(subject);
		return "/";
		
	}
}
