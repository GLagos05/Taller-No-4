package dominio;

public class Persona {
    protected String nombre;
    protected String rut;

    public Persona(String rut, String nombre) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }
}
