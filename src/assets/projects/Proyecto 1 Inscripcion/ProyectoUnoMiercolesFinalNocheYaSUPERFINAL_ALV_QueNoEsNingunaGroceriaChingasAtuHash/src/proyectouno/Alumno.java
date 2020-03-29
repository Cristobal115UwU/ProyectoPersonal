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
public class Alumno {
    private String nombre;
    private long cuenta;
    //private float promedio;
    private List<Grupo> gruposAlu = new ArrayList<>();
    public Alumno(){
    
    }
    public Alumno(String nombre, long cuenta){
        setNombre(nombre);
        setCuenta(cuenta);
        //setMaterias();
    }
    public String getNombre(){
        return nombre;
    }
    public long getCuenta(){
        return cuenta;
    }
    public List<Grupo> getGruposAlu(){
        return gruposAlu;
    }
    private void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    private void setCuenta(long cuenta){
        Scanner sc = new Scanner(System.in);
        String auxCuenta = Long.toString(cuenta);
        while(auxCuenta.length() != 9 ){
            System.out.println("\tNumero de cuenta inválido - Ingrese de nuevo (tu cuenta debe tener 9 digitos)");
            System.out.print("\t-->");
            cuenta = sc.nextLong();
            auxCuenta =  Long.toString(cuenta);
        }
        this.cuenta = cuenta;
    }
    
    public boolean setGrupo(Grupo gr){
        if(this.gruposAlu.size() == 3){
            System.out.println("\tYa tienes 3 materias inscritas compa, te quieres morir?");//#######
            return false;
        }
        else{
            this.gruposAlu.add(gr);
            System.out.println("\tEl alumno "+ this.getNombre() + " ha sido inscrito a la materia correctamente");
            return true;
        }
    }

    public static Alumno crearAlumno(Inscripcion insc){
        Scanner sc = new Scanner(System.in);
        System.out.println("\tBienvenido, ingrese sus datos");
        System.out.println("\tIntroduzca su nombre competo (nombre y apellidos)");
        System.out.print("\t-->");
        String nombre = sc.nextLine();
        nombre = nombre.toUpperCase();
        System.out.println("\tIntroduzca su numero de cuenta (9 digitos)");
        System.out.print("\t-->");
        Long cuenta= sc.nextLong();
        while(validarNumCuRep(insc, cuenta) == false) {
            System.out.println("\tEl número ingresado ya existe\n\tIntroduzca su numero de cuenta (9 digitos)");
            System.out.print("\t-->");
            cuenta= sc.nextLong();
        }
        Alumno wey = new Alumno(nombre,cuenta);
        return wey;
    }
    public static boolean validarNumCuRep(Inscripcion insc, long numC){
        while(!insc.ListaAlumnos.isEmpty()){
            for(int i=0;i<insc.ListaAlumnos.size(); i++){
                if(insc.ListaAlumnos.get(i).getCuenta()== numC)
                    return false;
            }
            return true;
        }
        return true;
    }
}

