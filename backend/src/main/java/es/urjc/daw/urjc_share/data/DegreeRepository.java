package es.urjc.daw.urjc_share.data;

import java.util.List;

import es.urjc.daw.urjc_share.model.Degree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DegreeRepository extends JpaRepository<Degree, Long>  {
    Degree findByName(String name);
    Degree findById(long id);
    List<Degree> findAllById(long id);
    Page<Degree> findAllByName(String name, Pageable page);
    List<Degree> findAllByName(String name);
}
