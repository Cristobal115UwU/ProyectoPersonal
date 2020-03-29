package Usuario;

import java.io.Serializable;


public class Administrador extends Empleado implements Serializable{
    private String sucursalJefe;

    public Administrador(String idUser, String password) {
        super();
        this.setPassword(password);
        this.setIdUser(idUser);
    }

    public String getSucursalJefe() {
        return sucursalJefe;
    }

    public void setSucursalJefe(String sucursalJefe) {
        this.sucursalJefe = sucursalJefe;
    }

    public Empleado crearEmpleado(){
        Empleado emp = Empleado.formulEmpleado();
        return emp;
    }
}
