public class Estudiante extends Persona{
    private String email;

    public Estudiante(String nombre, String rut, String email) {
        super(nombre, rut);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
