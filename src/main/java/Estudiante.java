public class Estudiante extends Persona{
    private String email;

    public Estudiante(String rut, String nombre, String email) {
        super(rut,nombre);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  rut + "," +nombre + "," + email;
    }
}
