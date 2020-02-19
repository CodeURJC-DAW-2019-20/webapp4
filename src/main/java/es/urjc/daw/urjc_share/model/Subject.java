package es.urjc.daw.urjc_share.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Subject {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	private String name;
	
	@ManyToOne
    private Degree degree;
    
    @OneToMany(mappedBy="subject")
	private List<Note> notes=new ArrayList<>() ;

    public Subject() {

    }

    public Subject(String name, Degree degree) {
        this.name = name;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

  

    public void setName(String name) {
        this.name = name;
    }

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}


}
