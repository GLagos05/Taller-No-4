import java.util.ArrayList;
import java.util.List;

public class DatosEstudiante {
    private List<Estudiante> estudiantes;
    private List<String> listaRuts;

    public DatosEstudiante() {
        this.estudiantes = new ArrayList<>();
        this.listaRuts = new ArrayList<>();
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<String> getListaRut() {
        return listaRuts;
    }

    public List<String> getListaRuts() {
        return listaRuts;
    }

    public String[] extraerRut(){
        String[] rutEstudiantes = new String[this.estudiantes.size()];
        for (int i = 0; i < this.estudiantes.size(); i++) {
            rutEstudiantes[i] = this.estudiantes.get(i).getRut();
        }
        return rutEstudiantes;
    }

    public void agregarEstudiantes(String nombre, String rut, String email){
        Estudiante estudiante = new Estudiante(nombre,rut,email);
        if (ValidadorRut.validarRut(estudiante.getRut())){
            this.estudiantes.add(estudiante);
        }
    }
}
