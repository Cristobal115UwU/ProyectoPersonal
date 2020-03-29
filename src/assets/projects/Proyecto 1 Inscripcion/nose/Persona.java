package nose;
import java.util.Scanner;
public class Persona {
    Scanner sc = new Scanner(System.in);
    private String Nombre;
    private int Edad;
    private float Estatura;
    private String Genero;
    public Persona (String Nombre, int Edad, float Estatura, String Genero){
        setNombre(Nombre);
        setEdad(Edad);
        setEstatura(Estatura);
        this.Genero=Genero;
    }
    public int getEdad() {
        return Edad;
    }
    public String getNombre(){
        return Nombre;
    }
    public float getEstatura(){
        return Estatura;
    }
    public String getGenero(){
        return Genero;
    }
    public void setEdad(int Edad) {
        while (Edad<0||Edad>100){
            System.out.println("Usted ingreso "+Edad+" a esta persona, ingrese una edad valida (no negativa ni mayor a 100)");
            Edad = sc.nextInt();       
        }
        this.Edad=Edad;
    }
    public void setNombre(String Nombre){
        char[] caracteres = Nombre.toCharArray();
        int contador=0;
        for (char x : caracteres){
            if(x==' ')
                contador++;
        }
        while(Nombre.length()-contador<=3||Nombre.length()-contador>=20){
            System.out.println("Ingrese un nombre que por lo menos tenga 3 caracteres y por maximo 20 caracteres (incluyendo espacios)");
            Nombre=sc.nextLine();
        }
        this.Nombre=Nombre;

    }
    public void setEstatura(float Estatura){
        while (Estatura<1.4||Estatura>2.6){
            System.out.println("Ingreso "+Estatura+", ingrese una estatura valida (no menor a 1.40 ni mayor a 2.60)");
            Estatura=sc.nextFloat();;
        }
        this.Estatura=Estatura;
    }
    public void setGenero(String Genero){
        this.Genero=Genero;
    }
    public static Persona crearPersona(){
        Scanner read = new Scanner(System.in);
        System.out.println("\nIngrese el nombre de la persona");
        String Nombre= read.nextLine();
        System.out.println("Ingrese la edad de "+Nombre);
        int Edad=read.nextInt();
        System.out.println("Ingrese la estura de "+Nombre);
        float Estura= read.nextFloat();
        read.nextLine();
        System.out.println("Ingrese el genero "+Nombre);
        String Genero= read.nextLine();
        Persona persona = new Persona(Nombre,Edad,Estura,Genero);
        return persona;
    }
}
