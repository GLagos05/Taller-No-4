import java.util.ArrayList;
import java.util.List;

public class Curso {
    private List<Estudiante> estudiantes;

    public Curso() {
        this.estudiantes = new ArrayList<>();
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public boolean agregarEstudiantes(String rut, String nombre, String email){
        Estudiante estudiante = new Estudiante(rut,nombre,email);
        if (ValidadorRut.validarRut(estudiante.getRut()) && email.contains("@ufromail.cl")){
            DatosEstudiante.registrarDato(estudiante,"target/ICC264.txt");
            this.estudiantes.add(estudiante);
            return true;
        }else{
            System.out.println("Ingrese datos de nuevo");
            return false;
        }
    }

    public String[] obtenerListaRuts(Curso curso){
        DatosEstudiante.leerArchivoEstudiantes(curso,"target/ICC264.txt");
        String[] rutEstudiantes = new String[this.estudiantes.size()];
        for (int i = 0; i < this.estudiantes.size(); i++) {
            rutEstudiantes[i] = this.estudiantes.get(i).getRut();
        }
        return rutEstudiantes;
    }

    public String buscarNombreEstudiante(String rut){
        Estudiante buscarEstudiante = null;
        for (Estudiante estudiante : this.estudiantes) {
            if (rut.equals(estudiante.getRut())) {
                buscarEstudiante = estudiante;
            }
        }
        return buscarEstudiante.getNombre();
    }

    public String buscarEmailEstudiante(String rut){
        Estudiante buscarEstudiante = null;
        for (Estudiante estudiante : this.estudiantes) {
            if (rut.equals(estudiante.getRut())) {
                buscarEstudiante = estudiante;
            }
        }
        return buscarEstudiante.getEmail();
    }
}
