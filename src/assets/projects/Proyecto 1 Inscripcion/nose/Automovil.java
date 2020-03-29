/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nose;
import java.util.Scanner;

public class Automovil {
     Scanner sc = new Scanner(System.in);
    private String Modelo;
    private String Color;
    private float Gasolina;
    private String Transmision;
    public Automovil(String Modelo,String Color, float Gasolina, int Transmision){
        this.Modelo=Modelo;
        this.Color=Color;
        setGasolina(Gasolina);
        setTransmision(Transmision);
    }
    public String getColor() {
        return Color;
    }
    public String getModelo(){
        return Modelo;
    }
    public float getGasolina(){
        return Gasolina;
    }
    public String getTransmision(){
        return Transmision;
    }
    public void setTransmision(int des) {
        if (des==1)
            Transmision="Automatica";
        else
            Transmision="Estandar";
    }
    public void setModelo(String Modelo){
        this.Modelo=Modelo;
    }
    public void setGasolina(float Gasolina){
        while (Gasolina<0||Gasolina>20.0){
            System.out.println("Ingreso "+Gasolina+" litros de gasolina, ingrese una cantidad de gasolina valida (no menor a 0 ni mayor a 20 litros)");
            Gasolina=sc.nextFloat();
        }
        this.Gasolina=Gasolina;
    }
    public void setColor(String Color){
        this.Color=Color;
    }    
    public static Automovil crearAutomovil(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese el modelo del automovil");
        String Modelo=sc.nextLine();
        System.out.println("Ingrese el color de "+Modelo);
        String Color = sc.nextLine();
        System.out.println("Que transmision es "+Modelo+"?");
        System.out.println("Teclea 1 si es automatico");
        System.out.println("Teclea 2 si es estandar");
        int Transmision=sc.nextInt();
        System.out.println("Ingrese la cantidad de gasolina de "+Modelo);
        float Gasolina= sc.nextFloat();
        Automovil carro = new Automovil(Modelo,Color,Gasolina,Transmision);
        return carro;
    }
}
