package es.urjc.daw.urjc_share.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import es.urjc.daw.urjc_share.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Note {
    @Transient
    @Autowired
    private SubjectService subjectService;

    public interface BasicViewSubject {}
    public interface BasicViewUser{}
    public interface BasicViewNote {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({BasicViewSubject.class, BasicViewUser.class, BasicViewNote.class})
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonView({BasicViewSubject.class, BasicViewUser.class, BasicViewNote.class})
    private String name;
    @JsonView(BasicViewNote.class)
    private String professor;

    @JsonView({BasicViewSubject.class, BasicViewUser.class, BasicViewNote.class})
    @ManyToOne
    private Subject subject;

//    @JsonProperty("subject_id")
//    private void setSubject(Integer id) {
//        this.subject = subjecxtService.getSubject(id);
//    }

    @JsonView({BasicViewSubject.class, BasicViewUser.class, BasicViewNote.class})
    @OneToMany(mappedBy = "note")
    private List<Score> scores = new ArrayList<>();


    @ManyToOne
    @JsonView({Note.BasicViewNote.class})
    private User user;

    private String ruta;
    private String extension;

    public Note() {}
    public Note(String name, Subject subject, String professor, String ruta, String extension){
        this.name = name;
        this.subject = subject;
        this.professor = professor;
        this.ruta=ruta;
        this.extension=extension;
    }
    public Note(String name, Subject subject, String professor, String ruta, String extension,User user){
        this.name = name;
        this.subject = subject;
        this.professor = professor;
        this.ruta=ruta;
        this.extension=extension;
        this.user = user;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
