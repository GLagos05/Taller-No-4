package launcher;

import dominio.Curso;
import guis.Ventana_CursoICC264;

public class ClasePrincipal {
    public static void main(String[] args) {
        Curso curso = new Curso();
        Ventana_CursoICC264.abrirVentana(curso);
    }
}
