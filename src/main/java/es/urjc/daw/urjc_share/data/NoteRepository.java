package es.urjc.daw.urjc_share.data;

import java.util.List;

import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Subject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.daw.urjc_share.model.User;

public interface NoteRepository extends JpaRepository<Note, Long>  {
	List<Note> findAllBySubject(Subject subject);
	Page<Note> findAllBySubject(Subject subject, Pageable page);
	List<Note> findAllByUser(User user);
	Page<Note> findAllByName(String name, Pageable page);
	Note findById(long id);
}
