package es.urjc.daw.urjc_share.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class User {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String pass;
    private String degree;
    private String user;
    private String email;
    private Integer number;
    private boolean image;
    
    @OneToMany(mappedBy = "user")
    private List<Note> notes = new ArrayList<>();

    public User() {

    }


    public User(String name, String pass, String degree, String user, String email, Integer number, List<Note> notes, boolean image) {
        this.name = name;
        this.pass = pass;
        this.degree = degree;
        this.user = user;
        this.email = email;
        this.number = number;
        this.notes = notes;
        this.image=image;
    }


    public List<Note> getNotes() {
        return notes;
    }


    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }


    public boolean getImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }
	public boolean hasImage(){
    	return image;
	}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
