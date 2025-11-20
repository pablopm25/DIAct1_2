package actividad1;

import java.awt.EventQueue;

public class Principal {

    public static Alumno[] listaAlumnos = new Alumno[5];

    public static int contadorAlumnos = 0;

    public static Alumno alumnoMasJoven = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormularioAlumno frame = new FormularioAlumno();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}