import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GestorDatosEstudiante {
    public static DatosEstudiante leerArchivoEstudiantes(DatosEstudiante datosEstudiante, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            //Lee cada linea del archivo hasta que la linea sea nula
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                datosEstudiante.getEstudiantes().add(new Estudiante(data[0], data[1], data[2]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return datosEstudiante;
    }
}
