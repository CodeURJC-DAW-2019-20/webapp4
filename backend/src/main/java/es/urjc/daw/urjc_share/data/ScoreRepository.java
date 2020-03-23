package es.urjc.daw.urjc_share.data;

import es.urjc.daw.urjc_share.model.Note;
import es.urjc.daw.urjc_share.model.Score;
import es.urjc.daw.urjc_share.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findAllByUser(User user);
    List<Score> findAllByNote(Note note);

    @Query(value = "SELECT * FROM Score s WHERE s.user_id = user_id and s.note_id = note_id", nativeQuery = true)
    Score findScoreByUserNote(@Param("user_id") long userId, @Param("note_id") long noteId);

}
