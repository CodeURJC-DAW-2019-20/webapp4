package es.urjc.daw.urjc_share.data;


import es.urjc.daw.urjc_share.model.Degree;
import es.urjc.daw.urjc_share.model.Subject;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long>  {
	List<Subject> findAllByName(String name);
	Page<Subject> findAllByName(String name, Pageable page);
	List<Subject> findAllByDegree(Degree degree);
	Page<Subject> findAllByDegree(Degree degree, Pageable page);
	Subject findById(long id);
	List<Subject> deleteByDegree(Degree degree);
}
