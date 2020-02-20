package es.urjc.daw.urjc_share.data;

import java.util.List;

import es.urjc.daw.urjc_share.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long>  {

}
