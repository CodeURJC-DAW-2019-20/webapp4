package es.urjc.daw.urjc_share.controllers;


import java.util.List;

import es.urjc.daw.urjc_share.data.*;
import es.urjc.daw.urjc_share.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DataBaseController implements CommandLineRunner {

    @Autowired
    private UserRepository userrepository;
    @Autowired
    private DegreeRepository degreeRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public void run(String... args) throws Exception {
//
//		// save a couple of users
//		User useraux = new User("paco", "1234", "Matematicas", "pacomer", "pacopacon@gmail.com", 56789, null,
//				false, "ROLE_USER");
//		userrepository.save(useraux);
//		userrepository.save(new User("Marcos", "5677", "Software", "MArcos01", "marcosos@gmail.com", 4567, null, false,
//				"ROLE_USER"));
		userrepository.save(new User("David", "passdaw", "Ingenieria del Software", "DavidDaw",
				"d.tejero.207@alumnos.urjc.es", 0, null, false, "ROLE_ADMIN"));
//		userrepository.save(new User("Miguel", "passdaw", "Ingenieria del Software", "MiguelDaw",
//				"m.rodrigez@alumnos.urjc.es", 0, null, false, "ROLE_ADMIN"));
//		userrepository.save(new User("Alex", "passdaw", "Ingenieria del Software", "AlexDaw",
//				"a.domingoc.2017@alumnos.urjc.es", 0, null, false, "ROLE_ADMIN"));
//		userrepository.save(new User("Diego", "passdaw", "Ingenieria del Software", "DiegoDaw",
//				"d.almansa.2017@alumnos.urjc.es", 0, null, false, "ROLE_ADMIN"));
//		userrepository.save(new User("Alvaro", "passdaw", "Ingenieria del Software", "AlvaroDaw",
//				"a.garciav.2017@alumnos.urjc.es", 0, null, false, "ROLE_ADMIN"));
//
//		// save a couple of degrees
//		Degree software = new Degree("Ingeniería del Software", null);
//		degreeRepository.save(software);
//		Degree magisterio = new Degree("Magisterio", null);
//		degreeRepository.save(magisterio);
//
//		// save a couple of subjects
//		Subject calidad = new Subject("Calidad", software);
//		subjectRepository.save(calidad);
//		subjectRepository.save(new Subject("Seguridad informática", software));
//
//		// save a couple of notes
//		Note noteaux = new Note("Tema 1", calidad, "Garzás", "jancojnd.pdf", ".pdf",useraux);
//		noteRepository.save(noteaux);
//		noteRepository.save(new Note("Tema 2", calidad, "Garzás", "jancojnd.pdf", ".pdf",useraux));
//		noteRepository.save(new Note("Tema 3", calidad, "Garzás", "jancojnd.pdf", ".pdf",useraux));
//		noteRepository.save(new Note("Tema 4", calidad, "Garzás", "jancojnd.pdf", ".pdf",useraux));
//
//		scoreRepository.save(new Score(3,useraux,noteaux));
//		scoreRepository.save(new Score(3,userrepository.findById(2),noteaux));
//		scoreRepository.save(new Score(4,userrepository.findById(3),noteaux));
//		scoreRepository.save(new Score(2,userrepository.findById(4),noteaux));
//		scoreRepository.save(new Score(1,userrepository.findById(5),noteaux));
//
//		List<User> users = (List<User>) userrepository.findAll();
//		System.out.println("User found with findAll():");
//		System.out.println("-------------------------------");
//		for (User user : users) {
//			System.out.println(users);
//		}
//
    }
}