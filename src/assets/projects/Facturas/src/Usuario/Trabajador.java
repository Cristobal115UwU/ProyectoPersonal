
package Usuario;

import java.io.Serializable;

public abstract class Trabajador extends Persona implements Serializable{
    public boolean prioridad;
    public String idUser;
    public String password;

    public Trabajador(){
        super();
    }

    public Trabajador(boolean prioridad, String idUser, String password, String nombre) {
        super(nombre);
        setPrioridad(prioridad);
        setIdUser(idUser);
        setPassword(password);
    }
    
    
    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
