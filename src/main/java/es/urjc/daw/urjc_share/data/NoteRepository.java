package es.urjc.daw.urjc_share.data;

import java.util.List;

import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Subject;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.daw.urjc_share.model.User;

public interface NoteRepository extends JpaRepository<Note, Long>  {
	List<Note> findAllBySubject(Subject subject);
	List<Note> findAllByUser(User user);
	Note findById(long id);
}
