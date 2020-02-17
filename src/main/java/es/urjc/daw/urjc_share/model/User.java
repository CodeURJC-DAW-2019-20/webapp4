package es.urjc.daw.urjc_share.model;
import java.awt.List;

public class User {
	private String name;
	private String pass;
	private String degree;
	private String user;
	private String email;
	private Integer number;
	private List<Note> notes;
	
	public User() {
		
	}
	
	 
	public User(String name, String pass, String degree, String user, String email, Integer number, List<Note> notes) {
		this.name = name;
		this.pass = pass;
		this.degree = degree;
		this.user = user;
		this.email = email;
		this.number = number;
		this.notes=notes;
	}



	public List<Note> getNotes() {
		return notes;
	}


	public void setNotes(List<Note> notes) {
		this.notes = notes;
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
