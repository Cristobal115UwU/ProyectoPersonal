
package Usuario;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Empleado extends Trabajador implements Serializable{

    private String sucursalID;
    
    public Empleado(){

    }

    public Empleado(boolean prioridad, String idEmpleado, String password, String nombre, String sucursal) {
        super(prioridad, idEmpleado, password, nombre);
        setSucursal(sucursal);
    }    

    public void setSucursal(String sucursal) {
        this.sucursalID = sucursal;
    }

    public String getSucursalID() {
        return sucursalID;
    }
    
    
    public static Empleado formulEmpleado(){
        Scanner sc = new Scanner(System.in);
        String nombre, usuario, psw, sucursal, pswV;
        System.out.println("\tIngrese el nombre del empleado");
        do{
            System.out.print("\t-->");
            nombre = sc.nextLine();
            if(nombre.length() < 4)
                System.out.println("\tIntroduzca el nombre completo, alias no validos.");
        }while(nombre.length() < 4);
        System.out.println("\tIngrese el nombre de usuario que se le asignara al empleado");
        do{
            System.out.print("\t-->");
            usuario = sc.nextLine();
            if(usuario.length() < 6)
                System.out.println("\tEl nombre de usuario debe contener al menos 6 carácteres.");
        }while(usuario.length() < 6);
        
        System.out.println("\tIngrese la contraseña para el empleado");
        do{
            do {
                System.out.print("\t-->");
                psw = sc.nextLine();
                if (psw.length() < 6)
                    System.out.println("\tLa contraseña de usuario debe contener al menos 6 carácteres.");
            } while (psw.length() < 6);
            System.out.println("\tVerifique la contraseña introducida anteriormente: ");
             System.out.print("\t-->");
            pswV = sc.nextLine();
            if(!pswV.equals(psw))
                System.out.println("\tLas contraseñas no coinciden. Vuelva a intentarlo.");
        }while(!pswV.equals(psw));
        
        System.out.println("\tIngrese la sucursal en la que trabajará el usuario.");
        do{
            System.out.print("\t-->");
            sucursal = sc.nextLine();
            sucursal = sucursal.toUpperCase();
            if(!sucursal.equals("ACOXPA") && !sucursal.equals("AJUSCO") && !sucursal.equals("TLAHUAC"))
                System.out.println("Introduzca el nombre de una de las sucursales existentes.");
        }while(!sucursal.equals("ACOXPA") && !sucursal.equals("AJUSCO") && !sucursal.equals("TLAHUAC"));
        Empleado emp = new Empleado(false,usuario,pswV,nombre,sucursal);
        return emp;
    }
}
