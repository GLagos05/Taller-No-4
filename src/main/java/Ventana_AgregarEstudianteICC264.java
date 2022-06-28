import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_AgregarEstudianteICC264 extends Ventana{
    JLabel etiquetaNombre;
    JLabel etiquetaRut;
    JLabel etiquetaEmail;
    JTextField textoNombre;
    JTextField textoRut;
    JTextField textoEmail;

    protected Ventana_AgregarEstudianteICC264(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panelVentana();
        etiquetas();
        cajasTexto();
        botones();
    }

    private void panelVentana() {
        JPanel panel = new JPanel();
        this.add(panel);
    }

    private void etiquetas() {
        generarJLabel(etiquetaNombre,"Nombre: ",20,40,100,20);
        generarJLabel(etiquetaRut,"Rut: ",20,80,100,20);
        generarJLabel(etiquetaEmail,"Email: ",20,120,100,20);
    }

    private void cajasTexto() {
        textoNombre = generarJTextField(120,40,100,20);
        this.add(textoNombre);
        textoRut = generarJTextField(120,80,100,20);
        this.add(textoRut);
        textoEmail = generarJTextField(120,120,100,20);
        this.add(textoEmail);
    }

    private void botones() {
        JButton botonAgregar = generarBoton("Agregar",100,200,100,20);
        this.add(botonAgregar);
        JButton botonCancelar = generarBoton("Cancelar",200,200,100,20);
        this.add(botonCancelar);

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
