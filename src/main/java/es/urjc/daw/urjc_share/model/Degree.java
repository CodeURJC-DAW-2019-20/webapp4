package es.urjc.daw.urjc_share.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Degree {

    public interface BasicView {}
    public interface BasicViewSubject{}

    @JsonView(BasicView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonView({BasicView.class, BasicViewSubject.class})
    private String name;

    @JsonView(BasicView.class)
    @OneToMany(mappedBy = "degree", fetch=FetchType.EAGER)
    private List<Subject> subjects = new ArrayList<>();


    public Degree() {

    }

    public Degree(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }
    
    
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Degree(String name) {
    	this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    
}
