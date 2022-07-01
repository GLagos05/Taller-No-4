package dominio;

import datos.DatosEstudiante;
import datos.ValidadorRut;

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
        if (!rutRepetidos(rut)){
            return validarDatosEstudiante(estudiante);
        }else{
            return false;
        }
    }

    private boolean rutRepetidos(String rut){
        int repetidos = 0;
        for (Estudiante estudiante : this.estudiantes) {
            if (rut.equals(estudiante.getRut())) {
                repetidos++;
            }
        }
        if (repetidos != 0){
            System.out.println("Este rut ya se ha registrado anteriormente");
            return true;
        }else{
            return false;
        }
    }

    private boolean validarDatosEstudiante(Estudiante estudiante) {
        if (ValidadorRut.validarRut(estudiante.getRut()) && estudiante.getEmail().contains("@ufromail.cl")){
            DatosEstudiante.registrarDato(estudiante,"target/ICC264.txt");
            this.estudiantes.add(estudiante);
            return true;
        }else{
            System.out.println("Datos de rut/correo no son válidos, inténtelo nuevamente");
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

    public Estudiante buscarEstudiante(String rut){
        Estudiante buscarEstudiante = null;
        for (Estudiante estudiante : this.estudiantes) {
            if (rut.equals(estudiante.getRut())) {
                buscarEstudiante = estudiante;
            }
        }
        return buscarEstudiante;
    }
}
