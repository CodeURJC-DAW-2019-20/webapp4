package es.urjc.daw.urjc_share.controllers;

import java.util.ArrayList;
import java.util.List;

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
	private List<Note>notes = new ArrayList<>();
	
	@Override
	public void run(String... args) throws Exception {
		
		 // save a couple of customers
		userrepository.save(new User("paco","1234","Matematicas","pacomer","pacopacon@gmail.com",56789, 898989));
		userrepository.save(new User("Marcos","5677","Software","MArcos01","marcosos@gmail.com",4567, 234567));
		userrepository.save(new User("Ramons","0987","Informatica","YoSiOle","RamonHUeleAPelos@gmail.com",45678, 2345));
       
        // fetch all customers
        List<User> users = userrepository.findAll();
        System.out.println("User found with findAll():");
        System.out.println("-------------------------------");
        for (User user : users) {
            System.out.println(users);
        }
        
        
	}
}