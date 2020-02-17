package es.urjc.daw.urjc_share.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.daw.urjc_share.model.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	
	List<User> findByName(String name);
	List<User> findByUser(String user);
	
	
}
