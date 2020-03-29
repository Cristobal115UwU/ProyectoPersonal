/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nose;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Ejercicio1{
static List <Automovil> ListaAutos= new ArrayList<>();
    static List <Libro> ListaLibros = new ArrayList<>();
    static List <Persona> ListaPersonas = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Salir;
        do{
            System.out.println("Bienvenido, que desea hacer?");
            System.out.print("1 .- Crear objetos de los tipos definidos\n2 .- Editar objetos ya creados\n3 .- Consultar los atributos de los objetos creados\n4 .- Salir del Programa\n--->");
            int des = sc.nextInt();
            switch(des){
                case 1:
                    CrearObjetos();
                break;
                case 2:
                    EditarObjetos();
                break;
                case 3:
                    Imprimir();
                break;
                case 4:
                break;
            } 
            System.out.println("Desea realizar otra operacion?      1.- SI      2.- NO");
            Salir=sc.nextInt();
        }while(Salir==1);
        System.out.println("Hasta pronto");
    }
    public static void CrearObjetos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQue desea crear?");
        System.out.print("1.- Persona\n2.- Libro\n3.- Automovil\n--->");
        int des=sc.nextInt();
        switch(des){
            case 1:
            ListaPersonas.add(Persona.crearPersona());
            System.out.println("Persona creada");
            break;
            case 2:
            ListaLibros.add(Libro.crearLibro());
            System.out.println("Libro creado");
            break;
            case 3:
            ListaAutos.add(Automovil.crearAutomovil());
            System.out.println("Automovil creado");
            break;
        }
    }
    public static void EditarObjetos(){
        Scanner sc = new Scanner(System.in);
        int editar;
        int Salir;
        System.out.println("\nQue desea editar?");
        System.out.print("1.- Persona\n2.- Libro\n3.- Automovil\n--->");
        int des=sc.nextInt();
        switch(des){
            case 1:
                if (ListaPersonas.isEmpty()){
                    System.out.println("\nNo hay personas creadas");
                    break;
                }
                System.out.println("\nCual de los siguientes personas desea editar");
                int i =0;
                for (Persona x:ListaPersonas){
                    System.out.println("Tecla "+i+" si desea editar a "+x.getNombre());
                    i++;
                }
                int persona =sc.nextInt();
                Persona a=ListaPersonas.get(persona);
                do{
                    System.out.println("Que atributo desea editar?");
                    System.out.print("1 .- Nombre\n2 .- Edad\n3 .- Estatura\n4.- Genero\n --->");
                    editar=sc.nextInt();
                    switch(editar){
                        case 1:
                            sc.nextLine();
                            System.out.println("Ingrese el nuevo nombre");
                            String Nombre= sc.nextLine();
                            a.setNombre(Nombre);
                        break;
                        case 2:
                            sc.nextLine();
                            System.out.println("Ingrese la nueva edad");
                            int Edad= sc.nextInt();
                            a.setEdad(Edad);
                        break;
                        case 3:
                            sc.nextLine();
                            System.out.println("Ingrese la nueva estatura");
                            float Estatura=sc.nextFloat();
                            a.setEstatura(Estatura);
                        break;
                        case 4:
                            sc.nextLine();
                            System.out.println("Ingrese el nuevo genero");
                            String Genero = sc.nextLine();
                            a.setGenero(Genero);
                        break;
                    }
                    System.out.println("Desea editar otro atributo?       1.- SI       2.- NO");
                    Salir= sc.nextInt();
                }while(Salir==1);
            break;
            case 2:
                if (ListaLibros.isEmpty()){
                    System.out.println("\nNo hay libros creados");
                    break;
                }
                System.out.println("\nCual de los siguientes libros desea editar");
                int j=0;
                for (Libro x:ListaLibros){
                    System.out.println("Tecla "+j+" si desea editar a "+x.getTitulo());
                    j++;
                }
                int libro =sc.nextInt();
                Libro e=ListaLibros.get(libro);
                do{
                    System.out.println("Que atributo desea editar?");
                    System.out.print("1 .- Titulo\n2 .- Autor\n3 .- Estrellas\n4.- Paginas\n --->");
                    editar=sc.nextInt();
                    switch(editar){
                        case 1:
                            System.out.println("Ingrese el nuevo Titulo");
                            String Titulo= sc.nextLine();
                            e.setTitulo(Titulo);
                        break;
                        case 2:
                            System.out.println("Ingrese el nuevo autor");
                            String Autor= sc.nextLine();
                            e.setAutor(Autor);
                        break;
                        case 3:
                            System.out.println("Ingrese las nuevas estrellas");
                            float Estrellas=sc.nextFloat();
                            e.setEstrellas(Estrellas);
                        break;
                        case 4:
                            System.out.println("Ingrese las nuevas paginas");
                            int Paginas = sc.nextInt();
                            e.setPaginas(Paginas);
                        break;
                    }
                    System.out.println("Desea editar otro atributo?       1.- SI       2.- NO");
                    Salir= sc.nextInt();
                }while(Salir==1);
            break;
            case 3:
                if (ListaAutos.isEmpty()){
                    System.out.println("\nNo hay autos creados");
                    break;
                }
                System.out.println("\nCual de los siguientes autos desea editar");
                int k=0;
                for (Automovil x:ListaAutos){
                    System.out.println("Tecla "+k+" si desea editar a "+x.getModelo());
                    k++;
                }
                int auto =sc.nextInt();
                Automovil c=ListaAutos.get(auto);
                do{
                    System.out.println("Que atributo desea editar?");
                    System.out.print("1 .- Modelo\n2 .- Color\n3 .- Gasolina\n4.- Transmision\n --->");
                    editar=sc.nextInt();
                    switch(editar){
                        case 1:
                            System.out.println("\nIngrese el nuevo Modelo");
                            String Modelo= sc.nextLine();
                            c.setModelo(Modelo);
                        break;
                        case 2:
                            System.out.println("\nIngrese el nuevo Color");
                            String Color= sc.nextLine();
                            c.setColor(Color);
                        break;
                        case 3:
                            System.out.println("\nIngrese la gasolina del auto");
                            float Gasolina=sc.nextFloat();
                            c.setGasolina(Gasolina);
                        break;
                        case 4:
                            System.out.println("\nQue tipo de transmision?    1.- Automatica         2.- Estandar");
                            int Transmision = sc.nextInt();
                            c.setTransmision(Transmision);
                        break;
                    }
                    System.out.println("Desea editar otro atributo?       1.- SI       2.- NO");
                    Salir= sc.nextInt();
                }while(Salir==1);
            break;
        }
    }
   public static void Imprimir(){
        Scanner sc = new Scanner(System.in);
        int editar;
        int Salir;
        do{
        System.out.println("\nQue desea imprimir?");
        System.out.print("1.- Persona\n2.- Libro\n3.- Automovil\n--->");
        int des=sc.nextInt();
        switch(des){
            case 1:
            System.out.println("\nCual de los siguientes personas desea imprimir");
                int i =0;
                for (Persona x:ListaPersonas){
                    System.out.println("Tecla "+i+" si desea editar a "+x.getNombre());
                    i++;
                }
                int persona =sc.nextInt();
                Persona a=ListaPersonas.get(persona);
                System.out.println("Nombre: "+a.getNombre());
                System.out.println("Edad: "+a.getEdad());
                System.out.println("Estatura: "+a.getEstatura());
                System.out.println("Genero: "+a.getGenero());
            break;
            case 2:
                System.out.println("\nCual de los siguientes libros desea imprimir?");
                    int j =0;
                    for(Libro x:ListaLibros){
                        System.out.println("Tecla "+j+" si desea editar a "+x.getTitulo());
                        j++;
                    }
                    int libro =sc.nextInt();
                    Libro e=ListaLibros.get(libro);
                    System.out.println("Titulo: "+e.getTitulo());
                    System.out.println("Autor: "+e.getAutor());
                    System.out.println("Estrellas: "+e.getEstrellas());
                    System.out.println("Paginas: "+e.getPaginas());
            break;
            case 3:
                System.out.println("\nCual de los siguientes autos desea imprimir?");
                int k =0;
                for(Automovil x:ListaAutos){
                    System.out.println("Tecla "+k+" si desea editar a "+x.getModelo());
                    k++;
                }
                int auto =sc.nextInt();
                Automovil c=ListaAutos.get(auto);
                System.out.println("Modelo:< "+c.getModelo());
                System.out.println("Color: "+c.getColor());
                System.out.println("Transmision: "+c.getTransmision());
                System.out.println("Gasolina: "+c.getGasolina());
            break;
        }
        System.out.println("Desea imprimir otro objeto?        1.- SI             2.- NO");
        Salir=sc.nextInt();    
    }while(Salir==1);
    }     
}
