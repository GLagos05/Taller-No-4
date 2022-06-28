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

    public List<String> extraerRut(DatosEstudiante datosEstudiante, String rutaArchivo){
        GestorDatosEstudiante.leerArchivoEstudiantes(datosEstudiante,rutaArchivo);
        List<String> rutEstudiantes = new ArrayList<>();
        for (Estudiante estudiante : this.estudiantes){
            rutEstudiantes.add(estudiante.getRut());
        }
        return rutEstudiantes;
    }

    public String[] obtenerRutEstudiantes(){
        DatosEstudiante datosEstudiante = new DatosEstudiante();
        String[] rutEstudiantes = (String[]) datosEstudiante.extraerRut(datosEstudiante,"target/"+"ICC264.txt").toArray();
        return rutEstudiantes;
    }

    public void agregarEstudiantes(String nombre, String rut, String email){
        Estudiante estudiante = new Estudiante(nombre,rut,email);
        this.estudiantes.add(estudiante);
    }
}
