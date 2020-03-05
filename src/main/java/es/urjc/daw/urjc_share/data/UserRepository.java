package es.urjc.daw.urjc_share.data;


import org.springframework.data.repository.CrudRepository;

import es.urjc.daw.urjc_share.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>  {
	User findByName(String name);
	User findById(long id);
	User findByNickname(String nickname);
	List<User> findAll();
}
