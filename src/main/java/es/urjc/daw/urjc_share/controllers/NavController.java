package es.urjc.daw.urjc_share.controllers;

import es.urjc.daw.urjc_share.data.DegreeRepository;
import es.urjc.daw.urjc_share.data.NoteRepository;
import es.urjc.daw.urjc_share.data.SubjectRepository;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Subject;

import es.urjc.daw.urjc_share.services.sendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;

@Controller
public class NavController {
	@Autowired
	private DegreeRepository degreeRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private NoteRepository noteRepository;

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
	public String goToMySignup(Model model) {
		List<Degree> degrees = degreeRepository.findAll();
		model.addAttribute("alldegrees", degrees);
		List<Subject> subjects = subjectRepository.findAll();
		model.addAttribute("allsubjects", subjects);
		return "register";
	}

	@GetMapping("/search")
	public String searchFromIndex(Model model, @RequestParam String searchType, @RequestParam String textSearched) {
		model.addAttribute("textTittle", textSearched);
		if (searchType.equals("Grado")) {
			List<Degree> degrees = degreeRepository.findAllByName(textSearched);
			model.addAttribute("degreeSearched", degrees);
			return "listDegrees";
		} else {
			List<Subject> subjects = subjectRepository.findAllByName(textSearched);
			model.addAttribute("subjectSearched", subjects);
			return "listsubjects";
		}
	}

	@GetMapping("/search/degree/{degreeID}")
	public String searchSubjectsFromDegree(Model model, @PathVariable long degreeID) {
		Optional<Degree> degree = degreeRepository.findById(degreeID);
		if (degree.isPresent()) {
			model.addAttribute("textTittle", degree.get().getName());
		}
		Optional<List<Subject>> subjects = subjectRepository.findAllByDegree(degree.get());
		model.addAttribute("subjectSearched", subjects.get());
		return "listsubjects";
	}

	@GetMapping("/search/subject/{subjectID}")
	public String searchNotesFromSubject(Model model, @PathVariable long subjectID) {
		Subject subject = subjectRepository.findById(subjectID);
		model.addAttribute("textTittle", subject.getName());

		List<Note> notes = noteRepository.findAllBySubject(subject);
		model.addAttribute("notesSearched", notes);
		return "allNotes";
	}

	@GetMapping("/notes/{noteID}")
	public String selectNote(Model model, @PathVariable long noteID) {
		Note note = noteRepository.findById(noteID);
		model.addAttribute("noteSelected", note);
		return "selectNote";
	}

}
