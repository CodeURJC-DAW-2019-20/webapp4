package es.urjc.daw.urjc_share.security;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.daw.urjc_share.component.UserComponent;
import es.urjc.daw.urjc_share.model.User;

@RestController
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserComponent userComponent;
	
	@RequestMapping("/api/logIn")
	public ResponseEntity<User> logIn(){
		
		if(!userComponent.isEntityUser()) {
			log.info("Usuario no registrado");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else {
			User loggedUser = userComponent.getEntityUser();
			log.info("Registrado como " + loggedUser.getName());
			return new ResponseEntity<>(loggedUser, HttpStatus.OK);
		}
	}
	
	@RequestMapping("/api/logOut")
	public ResponseEntity<Boolean> logOut(HttpSession session){
		
		if(!userComponent.isEntityUser()) {
			log.info("Ningún usuario ha iniciado sesión");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else {
			session.invalidate();
			log.info("Desconectado");
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
