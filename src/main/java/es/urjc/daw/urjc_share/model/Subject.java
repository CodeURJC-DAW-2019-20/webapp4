package es.urjc.daw.urjc_share.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	private String name;
    private String degree;

    public Subject() {

    }

    public Subject(String name, String degree) {
        this.name = name;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public String getDegree() {
        return degree;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
