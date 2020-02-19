package es.urjc.daw.urjc_share.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Degree {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private String name;
    
    @OneToMany(mappedBy="degree")
	private List<Note> notes =new ArrayList<>() ;
    
    @OneToMany(mappedBy="degree")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy="degree")
    private List<Subject> subjects = new ArrayList<>();
    


    public Degree() {

    }

    public Degree(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }
    
    public Degree(String name) {
    	this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(List<Subject> notes) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getNotes() {
        return subjects;
    }

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
    
    
}
