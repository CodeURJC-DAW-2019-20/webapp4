package es.urjc.daw.urjc_share.model;

import java.util.List;

public class Degree {
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
