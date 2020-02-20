package es.urjc.daw.urjc_share.data;

import java.util.List;

import es.urjc.daw.urjc_share.model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DegreeRepository extends JpaRepository<Degree, Long>  {
    Degree findByName(String name);
    List<Degree> findAllById(long id);
}
