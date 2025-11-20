package actividad1;

public class Alumno {
    private String nombre;
    private String apellidos;
    private String email;
    private int edad;
    private String telefono;

    public Alumno() {
    }

    public Alumno(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Alumno(String nombre, String apellidos, String email, int edad, String telefono) {
        this(nombre, apellidos, edad);
        this.telefono = telefono;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}