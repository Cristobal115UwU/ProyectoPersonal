/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouno;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author alber
 */
public class Profesor {
    private String nombre;
    private long numEmpleado;
    private LinkedList<Grupo> gruposProfe = new LinkedList<>();
    static HashMap<Long, String> nomYNum = new HashMap<>();
    public Profesor(String nombre, long numEmpleado){
        setNombre(nombre);
        setNumEmpleado(numEmpleado);
    }
    
    public String getNombre(){
        return nombre;
    }
    public long getNumEmpleado(){
        return numEmpleado;
    }
    public LinkedList<Grupo> getGruposProfe() {
        return gruposProfe;
    }

    public void setGruposProfe(Grupo gr) {
        this.gruposProfe.add(gr);
    }
    private void setNombre(String nombre){
        //Validaremos la entrada de un nombre correcto desde el formulario.
        this.nombre = nombre;
    }
    private void setNumEmpleado(long numEmpleado){
        Scanner sc = new Scanner(System.in);
        String auxNumEmp = Long.toString(numEmpleado);
        while(auxNumEmp.length() != 9 || nomYNum.containsKey(numEmpleado)){
            if(nomYNum.containsKey(numEmpleado)){
                System.out.println("\tEl número de empleado se encuentra asociado a otro profesor");
                System.out.println("\tAsegurece de introducir su número de empleado correctamente.");
            }
            else
                System.out.println("\tNumero de cuenta inválido - Ingrese de nuevo (tu cuenta debe tener 9 digitos)");
            System.out.print("\t-->");
            numEmpleado = sc.nextInt();
            auxNumEmp =  Long.toString(numEmpleado);
        }
        this.numEmpleado = numEmpleado;
    }
    public static Profesor crearProfesor(){
        Scanner sc = new Scanner(System.in);
        long numero;
        System.out.println("\tIntroduzca el nombre del profesor");
        System.out.print("\t-->");
        String nombre=sc.nextLine();
        nombre= nombre.toUpperCase();
        System.out.println("\tIntroduzca su número de empleado (9 digitos)");
        System.out.print("\t-->");
        numero = sc.nextLong();
        Profesor culero = new Profesor(nombre,numero);
        nomYNum.put(numero, nombre);
        return culero;   
    }
}

