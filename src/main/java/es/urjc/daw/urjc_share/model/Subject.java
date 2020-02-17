package es.urjc.daw.urjc_share.model;

public class Subject {
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
