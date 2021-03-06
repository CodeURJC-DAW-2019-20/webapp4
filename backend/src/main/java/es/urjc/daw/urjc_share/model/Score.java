package es.urjc.daw.urjc_share.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Score {
	public interface BasicViewScore {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonView({BasicViewScore.class})
	private int score;

	@ManyToOne
    @JsonView({BasicViewScore.class})
    private User user;
	
	@ManyToOne
    private Note note;

	public Score() {
	}

	public Score(int score, User user, Note note) {
		super();
		this.score = score;
		this.user = user;
		this.note = note;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Note getNote() {
		return note;
	}


	public void setNote(Note note) {
		this.note = note;
	}
	
}
