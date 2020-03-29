/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nose;
import java.util.Scanner;
public class Libro {
    Scanner sc = new Scanner(System.in);
    private String Autor;
    private int Paginas;
    private float estrellas;
    private String Titulo;
    public Libro (String Autor,String Titulo,int Paginas, float Estrellas){
        this.Autor=Autor;
        setPaginas(Paginas);
        setEstrellas(Estrellas);
        this.Titulo=Titulo;
    } 
    
    public String getAutor() {
        return Autor;
    }
    public String getTitulo(){
        return Titulo;
    }
    public float getEstrellas(){
        return estrellas;
    }
    public int getPaginas(){
        return Paginas;
    }
    public void setAutor(String Autor) {
        this.Autor=Autor;
    }
    public void setTitulo(String Titulo){
        this.Titulo=Titulo;
    }
    public void setEstrellas(float Estrellas){
        while (Estrellas<0||Estrellas>5.0){
            System.out.println("Ingreso "+Estrellas+", ingrese una cantidad de estrellas validas (no menor a 0 ni mayor a 5)");
            Estrellas=sc.nextFloat();
        }
        this.estrellas=Estrellas;
    }
    public void setPaginas(int Paginas){
        while (Paginas<=10||Paginas>5000){
            System.out.println("Ingrese una cantidad de paginas validos(por lo menos 10 paginas y menor a 5000 paginas)");
            Paginas=sc.nextInt();
        }
        this.Paginas=Paginas;
    }    
    public static Libro crearLibro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese el titulo del libro");
        String Titulo=sc.nextLine();
        System.out.println("Ingrese el autor de "+Titulo);
        String Autor = sc.nextLine();
        System.out.println("Ingrese la cantidad de paginas de "+Titulo);
        int Paginas=sc.nextInt();
        System.out.println("Ingrese la cantidad de estrellas que tiene "+Titulo);
        float estrellas = sc.nextFloat();
        Libro libro = new Libro (Autor,Titulo,Paginas,estrellas);
        return libro;
    }
}
