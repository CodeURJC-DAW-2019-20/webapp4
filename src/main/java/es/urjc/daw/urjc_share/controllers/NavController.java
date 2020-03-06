package es.urjc.daw.urjc_share.controllers;

import es.urjc.daw.urjc_share.component.UserComponent;
import es.urjc.daw.urjc_share.data.*;
import es.urjc.daw.urjc_share.model.*;

import es.urjc.daw.urjc_share.services.DegreeService;
import es.urjc.daw.urjc_share.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Collections;
import java.util.List;

@Controller
public class NavController {
	// Repositorys
	@Autowired
	private DegreeService degreeService;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private NoteRepository noteRepository;
    @Autowired
    private ScoreRepository scoreRepository;
	@Autowired
	private UserService userService;
	// Components
	@Autowired
	private UserComponent currentUser;


	@GetMapping("/")
	public String goToIndex(Model model) {
		this.configNav(model, "ini");
		return "index";
	}

	@GetMapping("/ranking")
	public String goToRanking(Model model) {
        List<Note> noteByUser;
        List<Score> scoreByNote;
        float auxMedia = 0;
        int numScores = 0;
		this.configNav(model,"ranking");
		List <User> listUsers = userService.getUsers();
        for (User userAux:listUsers){
            noteByUser = noteRepository.findAllByUser(userAux);
            for (Note auxNote:noteByUser) {
                scoreByNote = scoreRepository.findAllByNote(auxNote);
                for (Score auxScore:scoreByNote) {
                    auxMedia += auxScore.getScore();
                }
                numScores += scoreByNote.size();
            }
            if(numScores != 0){
				userAux.setMedia(auxMedia/numScores);
			}
            auxMedia = 0;
            numScores = 0;
        }
        model.addAttribute("users",listUsers);
        this.configNav(model, "ranking");
		Collections.sort(listUsers, (o1, o2) -> {
			User u1 = o1;
			User u2 = o2;
			return Float.compare(u2.getMedia(), u1.getMedia());
		});
		return "ranking";
	}

	@GetMapping("/profile")
	public String goToMyProfile(Model model) {
		model.addAttribute("user",currentUser.getEntityUser());
		model.addAttribute("notesUser", noteRepository.findAllByUser(currentUser.getEntityUser()));

		this.configNav(model, "profile");
		return "myprofile";
	}

	@GetMapping("/login")
	public String goToSignin(Model model) {
		this.configNav(model, "login");
		return "login";
	}
	@GetMapping("/logout")
	public String goToSigOut(Model model) {
		this.configNav(model, "ini");
		this.currentUser.setEntityUser(null);
		return "index";
	}


	@GetMapping("/join")
	public String goToMySignup(Model model) {
		this.configNav(model, "join");
		return "register";
	}

	@GetMapping("/search")
	public String searchFromIndex(Model model, @RequestParam String searchType, @RequestParam String textSearched) {
		model.addAttribute("textTittle", textSearched);
		configNav(model, "");
		if (searchType.equals("Degree")) {
			List<Degree> degrees = degreeService.findDegreesByName(textSearched);
			model.addAttribute("degreeSearched", degrees);
			model.addAttribute("emptyResult", degrees.isEmpty());
			return "listDegrees";
		} else {
			List<Subject> subjects = subjectRepository.findAllByName(textSearched);
			model.addAttribute("subjectSearched", subjects);
			model.addAttribute("emptyResult", subjects.isEmpty());
			return "listsubjects";
		}
	}

	@GetMapping("/search/degree/{degreeID}")
	public String searchSubjectsFromDegree(Model model, @PathVariable long degreeID) {
		configNav(model, "");
		Degree degree = degreeService.findDegreeById(degreeID);
		model.addAttribute("textTittle", degree.getName());
		
		List<Subject> subjects = subjectRepository.findAllByDegree(degree);
		model.addAttribute("subjectSearched", subjects);
		model.addAttribute("emptyResult", subjects.isEmpty());
		return "listsubjects";
	}

	@GetMapping("/search/subject/{subjectID}")
	public String searchNotesFromSubject(Model model, @PathVariable long subjectID) {
		configNav(model, "");
		Subject subject = subjectRepository.findById(subjectID);
		model.addAttribute("textTittle", subject.getName());

		List<Note> notes = noteRepository.findAllBySubject(subject);
		model.addAttribute("notesSearched", notes);
		model.addAttribute("emptyResult", notes.isEmpty());
		return "allNotes";
	}

	@GetMapping("/notes/{noteID}")
	public String selectNote(Model model, @PathVariable long noteID) {
		configNav(model, "");
		Note note = noteRepository.findById(noteID);
		String [] image = note.getRuta().split("\\.");
		model.addAttribute("nameImage", image[image.length-1]+".png");
		model.addAttribute("noteSelected", note);
		return "selectNote";
	}

	// Methos
	public void configNav(Model model, String rute) {
		User userEnty = currentUser.getEntityUser();
		// Data ROLE
		if(userEnty != null){
			model.addAttribute("ROLE_ADMIN", userEnty.getRoles().contains("ROLE_ADMIN"));
			model.addAttribute("ROLE_USER", userEnty.getRoles().contains("ROLE_USER"));
			model.addAttribute("ROLE_ANONY", false);
			if(userEnty.getRoles().contains("ROLE_ADMIN") || userEnty.getRoles().contains("ROLE_USER")){
				List<Degree> degrees = degreeService.findDegrees();
				model.addAttribute("alldegrees", degrees);
				List<Subject> subjects = subjectRepository.findAll();
				model.addAttribute("allsubjects", subjects);

			}
		} else {
			model.addAttribute("ROLE_ADMIN", false);
			model.addAttribute("ROLE_USER", false);
			model.addAttribute("ROLE_ANONY", true);
		}

		// Data RUTE
		model.addAttribute("ini", rute == "ini");
		model.addAttribute("profile", rute == "profile");
		model.addAttribute("login", rute == "login");
		model.addAttribute("join", rute == "join");
		model.addAttribute("ranking", rute == "ranking");
	}

}
