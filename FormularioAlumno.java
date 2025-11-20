package actividad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioAlumno extends JFrame {

    
    private JTextField txtNombre, txtApellidos, txtEmail, txtEdad, txtTelefono;
    private JLabel lblError, lblInfoJoven;

    public FormularioAlumno() {
        setTitle("Gestión de Alumnos");
        setBounds(100, 100, 450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // --- ETIQUETAS Y CAMPOS DE TEXTO  ---
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 80, 20);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 30, 200, 20);
        getContentPane().add(txtNombre);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(30, 60, 80, 20);
        getContentPane().add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(120, 60, 200, 20);
        getContentPane().add(txtApellidos);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 90, 80, 20);
        getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(120, 90, 200, 20);
        getContentPane().add(txtEmail);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(30, 120, 80, 20);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(120, 120, 50, 20);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(30, 150, 80, 20);
        getContentPane().add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(120, 150, 120, 20);
        getContentPane().add(txtTelefono);

        // --- BOTÓN AÑADIR ---
        JButton btnAnadir = new JButton("Añadir Alumno");
        btnAnadir.setBounds(120, 190, 150, 30);
        getContentPane().add(btnAnadir);

        // --- ETIQUETA DE ERROR ---
        lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        lblError.setBounds(30, 230, 350, 20);
        lblError.setVisible(false);
        getContentPane().add(lblError);

        // --- ETIQUETA AMPLIACIÓN ---
        lblInfoJoven = new JLabel("Alumno más joven: (Ninguno)");
        lblInfoJoven.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblInfoJoven.setForeground(Color.BLUE);
        lblInfoJoven.setBounds(30, 260, 350, 20);
        getContentPane().add(lblInfoJoven);

        // --- LÓGICA DEL BOTÓN ---
        btnAnadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gestionarAlta();
            }
        });
    }

    private void gestionarAlta() {
        if (Principal.contadorAlumnos >= 5) {
            lblError.setText("¡Error! Límite de 5 alumnos alcanzado.");
            lblError.setVisible(true);
            return;
        }

        lblError.setVisible(false);

        try {
            String nom = txtNombre.getText();
            String ape = txtApellidos.getText();
            String mail = txtEmail.getText();
            String tlf = txtTelefono.getText();

            int edad = Integer.parseInt(txtEdad.getText());

            Alumno nuevo = new Alumno(nom, ape, mail, edad, tlf);
            Principal.listaAlumnos[Principal.contadorAlumnos] = nuevo;
            Principal.contadorAlumnos++;

            if (Principal.alumnoMasJoven == null || nuevo.getEdad() < Principal.alumnoMasJoven.getEdad()) {
                Principal.alumnoMasJoven = nuevo;
                lblInfoJoven.setText("Más joven: " + nuevo.getNombre() + " " + nuevo.getApellidos() + " (" + nuevo.getEdad() + " años)");
            }

            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Alumno guardado correctamente.");

        } catch (NumberFormatException ex) {
            lblError.setText("Error: La edad debe ser un número válido.");
            lblError.setVisible(true);
        } catch (Exception ex) {
            lblError.setText("Error inesperado: " + ex.getMessage());
            lblError.setVisible(true);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtEmail.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtNombre.requestFocus();
    }
}