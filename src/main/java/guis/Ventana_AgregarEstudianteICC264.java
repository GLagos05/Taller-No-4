package guis;

import dominio.Curso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_AgregarEstudianteICC264 extends Ventana{
    JLabel etiquetaNombre, etiquetaRut, etiquetaEmail;
    JTextField textoNombre, textoRut, textoEmail;
    Curso curso;

    protected Ventana_AgregarEstudianteICC264(String nombre, int largoX, int largoY, Curso curso) {
        super(nombre, largoX, largoY);
        this.curso = curso;
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
        generarJLabel(etiquetaRut,"Rut: ",20,40,80,20);
        generarJLabel(etiquetaNombre,"Nombre: ",20,80,80,20);
        generarJLabel(etiquetaEmail,"Email: ",20,120,80,20);
    }

    private void cajasTexto() {
        textoRut = generarJTextField(90,40,230,20);
        this.add(textoRut);
        textoNombre = generarJTextField(90,80,230,20);
        this.add(textoNombre);
        textoEmail = generarJTextField(90,120,230,20);
        this.add(textoEmail);

    }

    private void botones() {
        JButton botonAgregar = generarBoton("Agregar",20,180,100,20);
        this.add(botonAgregar);
        JButton botonCancelar = generarBoton("Cancelar",160,180,100,20);
        this.add(botonCancelar);

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (curso.agregarEstudiantes(textoRut.getText(),textoNombre.getText(),textoEmail.getText())){
                        JOptionPane.showMessageDialog(botonAgregar,"dominio.Estudiante registrado correctamente","Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
                        Ventana_CursoICC264.abrirVentana(curso);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(botonAgregar,"Ingrese datos válidos","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(botonAgregar,"Ingrese datos válidos","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana_CursoICC264.abrirVentana(curso);
                dispose();
            }
        });
    }

    public static void abrirVentana(Curso curso){
        Ventana_AgregarEstudianteICC264 ventana_agregarEstudianteICC264 = new Ventana_AgregarEstudianteICC264("Agregar Estudiante ICC264", 350,260,curso);
    }
}
