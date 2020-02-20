package es.urjc.daw.urjc_share.controllers;

import java.util.ArrayList;
import java.util.List;

import es.urjc.daw.urjc_share.data.DegreeRepository;
import es.urjc.daw.urjc_share.data.NoteRepository;
import es.urjc.daw.urjc_share.data.SubjectRepository;
import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.User;

@Controller
public class DataBaseController implements CommandLineRunner {

	@Autowired
	private UserRepository userrepository;
	@Autowired
	private DegreeRepository degreeRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		 // save a couple of users
		userrepository.save(new User("paco","1234","Matematicas","pacomer","pacopacon@gmail.com",56789,null,false));
		userrepository.save(new User("Marcos","5677","Software","MArcos01","marcosos@gmail.com",4567, null,false));
		userrepository.save(new User("Ramons","0987","Informatica","YoSiOle","RamonHUeleAPelos@gmail.com",45678, null, false));
       //save a couple of subjects
		subjectRepository.save(new Subject("Investigación Operativa",degreeRepository.findByName("Ingeniería del Software"),"Antonio"));
		subjectRepository.save(new Subject("DAW",degreeRepository.findByName("Ingeniería del Software"),"Micael"));
		//save a couple of degrees
		degreeRepository.save(new Degree("Ingeniería del Software",null));
		degreeRepository.save((new Degree("Magisterio",null)));
        // fetch all customers
        List<User> users = userrepository.findAll();
        System.out.println("User found with findAll():");
        System.out.println("-------------------------------");
        for (User user : users) {
            System.out.println(users);
        }
        
        
	}
}