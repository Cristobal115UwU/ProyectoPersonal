
package Usuario;
import java.io.Serializable;

public abstract class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(){

    }
    public Persona(String nombre) {
        setNombre(nombre);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
