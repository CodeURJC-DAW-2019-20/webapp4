package es.urjc.daw.urjc_share.controllers;

import es.urjc.daw.urjc_share.data.DegreeRepository;
import es.urjc.daw.urjc_share.model.Degree;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DegreeController {

	@Autowired
	private DegreeRepository repository;

	@GetMapping("/degrees")
	public String degrees(Model model) {
		List<Degree> degrees = (List<Degree>) repository.findAll();
		model.addAttribute("degrees", degrees);
		return "degrees";
	}

	@GetMapping("/grado/nuevo")
	public String nuevoAnuncioForm() {
		return "newdegree";
	}

	@PostMapping("/createDegree")
	public String newDegree(Degree degree) throws IOException {
		repository.save(degree);
		return "redirect:/";
	}

	@GetMapping("/degree/{id}")
	public String seeDegree(Model model, @PathVariable long id) {
		Degree degree = repository.findById(id);
		model.addAttribute("degree", degree);
		return "myprofile";
	}

}
