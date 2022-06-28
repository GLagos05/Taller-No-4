import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_CursoICC264 extends Ventana{
    JComboBox listaRut;
    JLabel etiquetaNombre;
    JLabel etiquetaEmail;
    JTextField textoNombre;
    JTextField textoEmail;
    DatosEstudiante datosEstudiante;

    public Ventana_CursoICC264(String nombre, int largoX, int largoY, DatosEstudiante datosEstudiante) {
        super(nombre, largoX, largoY);
        iniciarComponentes();
        this.datosEstudiante = datosEstudiante;
    }

    private void iniciarComponentes() {
        panelVentana();
        listaDesplegable();
        etiquetas();
        cajasTexto();
        botones();
    }

    private void panelVentana() {
        JPanel panel = new JPanel();
        this.add(panel);
    }

    private void etiquetas() {
        generarJLabel(etiquetaNombre,"Nombre: ",20,100,100,20);
        generarJLabel(etiquetaEmail,"Email: ", 20,140,100,20);
    }

    private void cajasTexto() {
        textoNombre = generarJTextField(140,100,100,20);
        this.add(textoNombre);
        textoEmail = generarJTextField(140,140,100,20);
        this.add(textoEmail);
    }

    private void listaDesplegable() {
        listaRut = generarListaDesplegable(datosEstudiante.obtenerRutEstudiantes(),20,40,100,20);
        this.add(listaRut);
    }

    private void botones() {
        JButton botonNuevoEstudiante = generarBoton("Nuevo Estudiante",20,200,100,20);
        this.add(botonNuevoEstudiante);

        botonNuevoEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana_AgregarEstudianteICC264 ventana_agregarEstudianteICC264 = new Ventana_AgregarEstudianteICC264("Agregar Estudiante ICC264",500,500);
            }
        });
    }
}
