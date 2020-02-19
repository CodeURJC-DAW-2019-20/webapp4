package es.urjc.daw.urjc_share.model;

import javax.persistence.*;

@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private String name;
    private String professor;
    
    @ManyToOne
    private Subject subject;
    
    @ManyToOne
    private Degree degree;
    
    @ManyToOne
    private User user;
   

    public Note() {
    }

    public Note(String name, Subject subject, String professor, Degree degree){
        this.name = name;
        this.subject = subject;
        this.professor = professor;
        this.degree = degree;
    }

   



    public void setName(String name) {
        this.name = name;
    }



    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getName() {
        return name;
    }



    public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProfessor() {
        return professor;
    }
}
