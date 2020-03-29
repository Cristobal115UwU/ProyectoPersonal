/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouno;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alber
 */
public class Profesor {
    private String nombre;
    private int numEmpleado;
    private List<Grupo> gruposProf = new ArrayList<>();
    
    public Profesor(String nombre, int numEmpleado){
        setNombre(nombre);
        setNumEmpleado(numEmpleado);
    }
    public String getNombre(){
        return nombre;
    }
    public int getNumEmpleado(){
        return numEmpleado;
    }
    private void setNombre(String nombre){
        //Validaremos la entrada de un nombre correcto desde el formulario.
        this.nombre = nombre;
    }
    private void setNumEmpleado(int numEmpleado){
        Scanner sc = new Scanner(System.in);
        String auxNumEmp = Integer.toString(numEmpleado);
        while(auxNumEmp.length() != 9 ){
            System.out.println("Numero de cuenta inválido - Ingrese de nuevo (tu cuenta debe tener 9 digitos)");
            numEmpleado = sc.nextInt();
            auxNumEmp =  Integer.toString(numEmpleado);
        }
        this.numEmpleado = numEmpleado;
    }
    public static Profesor crearProfesor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del profesor");
        String nombre=sc.nextLine();
        System.out.println("Introduzca su numero de empleado");
        int numero = sc.nextInt();
        Profesor culero = new Profesor(nombre,numero);
        return culero;   
    }
}
/*
⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣰⣿⣿⣿⣿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣧⢀⠀⠀⠀⠀
⠀⠀⠀⣿⣿⣿⠋⠀⠀⠀⠀⠀⠙⠀⠙⣿⣿⣿⣷⢳⢀⠀⠀⠀
⠀⠀⣠⣿⣿⣿⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⢀
⠀⠀⣸⣿⣿⣿⠸⠀⠀⠀⠒⠒⠒⠐⠀⠀⢿⣿⣿⣿⣿⣿⠀⠀
⠀⣴⣿⣿⣿⡿⠀⠒⣋⣙⡒⢰⠀⠤⣖⠒⢾⣿⣿⣿⣿⣧⠀⠀
⢺⣿⣿⣿⣿⢀⠀⠀⠉⠉⠉⠸⠀⡇⠉⠉⠀⢿⣿⣿⣿⣄⠀⠀
⠀⠙⣿⣿⣧⢻⠀⠀⠀⠀⠀⠠⠀⠰⠀⠀⠀⣸⠸⣿⣿⠿⠰⠀
⠀⠀⠀⠹⣿⣿⣿⣷⠀⡠⠙⣲⣔⣅⢡⣰⣷⣿⣿⣿⣧⠀⠀⠀
⠀⠀⠀⣼⣿⣿⣿⣿⠀⡿⠭⠭⠭⠭⢿⠀⣿⢻⣿⣿⠃⠀⠀⠀
⠀⠀⠀⠙⠛⣿⢻⠹⣿⠐⠙⠛⠟⠉⢀⣴⡟⢿⣿⡏⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⡟⠀⠀⠻⣦⣤⣶⠾⠋⠀⠀⠁⡦⢄⢀⠀⠀⠀
⠀⠀⠀⠀⡠⠁⡇⠑⢄⠀⠀⠀⠀⠀⠀⠔⠀⠀⠁⠀⠀⠀⠉⠁
⠀⠔⠊⠁⠀⠀⣇⠀⠀⠀⠑⡤⠤⢎⠁⠀⠀⡘⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⢢⠠⠀⡠⢆⠀⠀⡠⠙⢄⠀⡸⠀⠀⠀⠀⠀⠀ You're breathtaking*/
