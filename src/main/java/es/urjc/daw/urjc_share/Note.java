package es.urjc.daw.urjc_share;

public class Note {
    private String name;
    private String subject;
    private String professor;
    private String degree;

    public Note() {
    }

    public Note(String name, String subject, String professor, String degree) {
        this.name = name;
        this.subject = subject;
        this.professor = professor;
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getProfessor() {
        return professor;
    }
}
