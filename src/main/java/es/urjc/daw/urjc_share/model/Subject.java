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
	private String professor;
    public Subject() {

    }

    public Subject(String name, Degree degree, String professor) {
        this.name = name;
        this.degree = degree;
        this.professor=professor;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
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
