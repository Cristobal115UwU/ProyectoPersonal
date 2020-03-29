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
    List<Grupo> gruposAlu = new ArrayList<>();
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
            System.out.println("Numero de cuenta inválido - Ingrese de nuevo (tu cuenta debe tener 9 digitos)");
            cuenta = sc.nextLong();
            auxCuenta =  Long.toString(cuenta);
        }
        this.cuenta = cuenta;
    }
    
    public boolean setGrupo(Grupo gr){
        if(this.gruposAlu.size()>=3){
            System.out.println("Ya tienes 3 materias creadas compa, te quieres morir?");//#######
            return false;
        }
        else{
            this.gruposAlu.add(gr);
            System.out.println("El alumno "+ this.getNombre() + " ha sido inscrito a la materia correctamente");
            return true;
        }
    }

    public static Alumno crearAlumno(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido, ingrese sus datos");
        System.out.println("Introduzca su nombre competo (nombre y apellidos)");
        String nombre = sc.nextLine();
        System.out.println("Introduzca su numero de cuenta (9 digitos)");
        Long cuenta= sc.nextLong();
        Alumno wey = new Alumno(nombre,cuenta);
        return wey;
    }
}
/*
⣿⣿⣿⣿⣿⣿⠟⠋⠁⣀⣤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿
⣿⣿⣿⣿⠋⠁⠀⠀⠺⠿⢿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠻⣿
⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣤⣤⣤⠀⠀⠀⠀⠀⣤⣦⣄⠀⠀
⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣿⠏⣿⣿⣿⣿⣿⣁⠀⠀⠀⠛⠙⠛⠋⠀⠀
⡿⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⣰⣿⣿⣿⣿⡄⠘⣿⣿⣿⣿⣷⠄⠀⠀⠀⠀⠀⠀⠀⠀
⡇⠀⠀⠀⠀⠀⠀⠀⠸⠇⣼⣿⣿⣿⣿⣿⣷⣄⠘⢿⣿⣿⣿⣅⠀⠀⠀⠀⠀⠀⠀⠀
⠁⠀⠀⠀⣴⣿⠀⣐⣣⣸⣿⣿⣿⣿⣿⠟⠛⠛⠀⠌⠻⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⣶⣮⣽⣰⣿⡿⢿⣿⣿⣿⣿⣿⡀⢿⣤⠄⢠⣄⢹⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀
⠀⠀⠀⣿⣿⣿⣿⣿⡘⣿⣿⣿⣿⣿⣿⠿⣶⣶⣾⣿⣿⡆⢻⣿⣿⠃⢠⠖⠛⣛⣷⠀
⠀⠀⢸⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣮⣝⡻⠿⠿⢃⣄⣭⡟⢀⡎⣰⡶⣪⣿⠀
⠀⠀⠘⣿⣿⣿⠟⣛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⡿⢁⣾⣿⢿⣿⣿⠏⠀
⠀⠀⠀⣻⣿⡟⠘⠿⠿⠎⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣵⣿⣿⠧⣷⠟⠁⠀⠀
⡇⠀⠀⢹⣿⡧⠀⡀⠀⣀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⢰⣿⠀⠀⠀⠀
⡇⠀⠀⠀⢻⢰⣿⣶⣿⡿⠿⢂⣿⣿⣿⣿⣿⣿⣿⢿⣻⣿⣿⣿⡏⠀⠀⠁⠀⠀⠀⠀
⣷⠀⠀⠀⠀⠈⠿⠟⣁⣴⣾⣿⣿⠿⠿⣛⣋⣥⣶⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀ ⣿⡀
*/
