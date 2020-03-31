package es.urjc.daw.urjc_share.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
	
	
    @JsonView({BasicView.class, UserLogin.class})
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonView({BasicView.class, BasicViewUserForNote.class, UserLogin.class})
    private String name;
    private String passwordHash;
    @JsonView({BasicView.class, BasicViewUserForNote.class})
    private String degree;
    @JsonView({BasicView.class, BasicViewUserForNote.class, UserLogin.class})
    private String nickname;
    @JsonView({BasicView.class, BasicViewUserForNote.class,  UserLogin.class})
    private String email;
    @JsonView({BasicView.class, BasicViewUserForNote.class, UserLogin.class})
    private Integer number;
    @JsonView({BasicView.class})
    private boolean image;
    private float media;

    public interface BasicView {}
    public interface BasicViewSubject{}
    public interface BasicViewUserForNote {}
    public interface UserLogin{}

    @JsonView({BasicView.class})
    @OneToMany(mappedBy = "user")
    private List<Note> notes = new ArrayList<>();

    @JsonView({BasicView.class, UserLogin.class})
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;
    
    @OneToMany(mappedBy = "user")
    private List<Score> scores = new ArrayList<>();

    public User() {

    }


    public User(String name, String password, String degree, String nickname, String email, Integer number, List<Note> notes, boolean image,String... roles ) {
        this.name = name;
        this.passwordHash = new BCryptPasswordEncoder().encode(password);
        this.degree = degree;
        this.nickname = nickname;
        this.email = email;
        this.number = number;
        this.notes = notes;
        this.image=image;
        this.roles = new ArrayList<>(Arrays.asList(roles));
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
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


    public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String password) {
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
	}

	public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }



    public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
