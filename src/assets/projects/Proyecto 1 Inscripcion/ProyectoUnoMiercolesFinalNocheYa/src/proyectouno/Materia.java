/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouno;

import java.util.Scanner;
/**
 *
 * @author alber
 */
public class Materia {
    private static int contadorClave = 1120;
    private  int clave;
    private String nombre;
    //private LinkedList<Grupo> grupo = new LinkedList<>();
    
    
    public Materia(String nombre){
        setClave();
        setNombre(nombre);
        
    }
    
    public int getClave(){
        return clave;
    }

    public String getNombre(){
       return nombre;
    }
    
    
    private void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    private void setClave(){
        contadorClave++;
        this.clave= contadorClave;
    }


    public static Materia crearMateria(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la materia");
        String nombre= sc.nextLine();
        Materia mat = new Materia(nombre);
        return mat;  
    }
}
