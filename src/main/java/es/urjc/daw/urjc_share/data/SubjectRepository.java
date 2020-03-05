package es.urjc.daw.urjc_share.data;


import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long>  {
	List<Subject> findAllByName(String name);
	List<Subject> findAllByDegree(Degree degree);
	Subject findById(long id);
	List<Subject> deleteByDegree(Degree degree);
}
