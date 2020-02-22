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
    private Subject subjects;
    
    
    @ManyToOne
    private User user;

    private String ruta;

    public Note() {}
    public Note(String name, Subject subject, String professor, String ruta){
        this.name = name;
        this.subjects = subject;
        this.professor = professor;
        this.ruta=ruta;
    }
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
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
		return subjects;
	}

	public void setSubject(Subject subject) {
		this.subjects = subject;
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
