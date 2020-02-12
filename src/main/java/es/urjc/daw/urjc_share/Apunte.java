package es.urjc.daw.urjc_share;

public class Apunte {
    private String nombre;
    private String asignatura;
    private String comentario;

    public Apunte(){

    }
    public Apunte(String nombre, String asignatura, String comentario){
        this.nombre=nombre;
        this.asignatura=asignatura;
        this.comentario=comentario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public String getComentario() {
        return comentario;
    }
}
