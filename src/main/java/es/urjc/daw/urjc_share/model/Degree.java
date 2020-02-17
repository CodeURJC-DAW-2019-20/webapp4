package es.urjc.daw.urjc_share.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Degree {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private String name;
    private List<Note> notes;

    public Degree() {

    }

    public Degree(String name, List<Note> notes) {
        this.name = name;
        this.notes = notes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public List<Note> getNotes() {
        return notes;
    }
}
