package es.urjc.daw.urjc_share.data;

import java.util.List;

import es.urjc.daw.urjc_share.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.daw.urjc_share.model.User;

public interface NoteRepository extends JpaRepository<Note, Long>  {

}
