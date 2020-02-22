package es.urjc.daw.urjc_share.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import es.urjc.daw.urjc_share.model.User;

public interface UserRepository extends CrudRepository<User, Long>  {
	User findByName(String name);
	User findByNickname(String nickname);
}
