package guis;

import dominio.Curso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_CursoICC264 extends Ventana{
    JLabel etiquetaNombre, etiquetaEmail;
    JTextField textoNombre, textoEmail;
    Curso curso;

    public Ventana_CursoICC264(String nombre, int largoX, int largoY, Curso curso) {
        super(nombre, largoX, largoY);
        this.curso = new Curso();
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panelVentana();
        etiquetas();
        listaDesplegable();
        cajasTexto();
        botones();
    }

    private void panelVentana() {
        JPanel panel = new JPanel();
        this.add(panel);
    }

    private void etiquetas() {
        generarJLabel(etiquetaNombre,"Nombre: ",20,100,70,20);
        generarJLabel(etiquetaEmail,"Email: ", 20,140,70,20);
    }

    private void listaDesplegable() {
        JComboBox listaRut = generarListaDesplegable(curso.obtenerListaRuts(curso),20,40,150,20);
        this.add(listaRut);

        listaRut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoNombre.setText(curso.buscarEstudiante(listaRut.getSelectedItem().toString()).getNombre());
                textoEmail.setText(curso.buscarEstudiante(listaRut.getSelectedItem().toString()).getEmail());
            }
        });
    }

    private void cajasTexto() {
        textoNombre = generarJTextField(90,100,230,20);
        textoNombre.setEnabled(false);
        textoNombre.setText("Nombre Estudiante");
        this.add(textoNombre);
        textoEmail = generarJTextField(90,140,230,20);
        textoEmail.setEnabled(false);
        textoEmail.setText("Email Estudiante");
        this.add(textoEmail);
    }

    private void botones() {
        JButton botonNuevoEstudiante = generarBoton("Nuevo Estudiante",140,180,150,20);
        this.add(botonNuevoEstudiante);

        botonNuevoEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana_AgregarEstudianteICC264.abrirVentana(curso);
                dispose();
            }
        });
    }

    public static void abrirVentana(Curso curso){
        Ventana_CursoICC264 ventana_cursoICC264 = new Ventana_CursoICC264("Curso ICC264", 350,260,curso);
    }
}
