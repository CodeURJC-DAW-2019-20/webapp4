package es.urjc.daw.urjc_share.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import es.urjc.daw.urjc_share.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByName(String name);
	User findById(long id);
	User findByNickname(String nickname);
}
