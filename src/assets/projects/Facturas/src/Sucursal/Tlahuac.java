/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursal;

/**
 *
 * @author Lenovo
 */
public class Tlahuac extends Sucursal{
    public Tlahuac (){
        setPrecios();
        setClientesFile();
        setID("TLAHUAC");
    
    }
    
    public final void setPrecios(){
        costos.put("Saco    ",40);
        costos.put("Pantalon",40);
        costos.put("Abrigo  ",70);
        costos.put("Camisa  ",40);
        costos.put("Playera ",40);
        costos.put("Corbata ",35);
        costos.put("Chamarra",60);
    }
    public void GenerarNota(){
        
    }
}
