package es.urjc.daw.urjc_share.model;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
public class Subject {

	public interface BasicViewDegree {}
	public interface BasicViewSubject {}
	public interface BasicViewSubjectForNotes {}
	public interface BasicViewUser{}

	@JsonView({BasicViewDegree.class, BasicViewSubject.class, BasicViewUser.class})
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonView({BasicViewDegree.class, BasicViewSubject.class, BasicViewUser.class, BasicViewSubjectForNotes.class})
	private String name;

	@ManyToOne
	@JsonView({BasicViewSubject.class, BasicViewUser.class, BasicViewSubjectForNotes.class})
	private Degree degree;

    @OneToMany(mappedBy="subject", fetch=FetchType.EAGER)
	@JsonView({BasicViewSubject.class, BasicViewUser.class})
	private List<Note> notes=new ArrayList<>() ;
    
	
    public Subject() {

    }

    public Subject(String name, Degree degree) {
        this.name = name;
        this.degree = degree; 
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
