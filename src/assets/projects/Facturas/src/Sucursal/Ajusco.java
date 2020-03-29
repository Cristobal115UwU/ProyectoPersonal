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
public class Ajusco extends Sucursal{
    public Ajusco(){
        setPrecios();
        setID("AJUSCO");
        setClientesFile();
    }
    private final void setPrecios(){
        costos.put("Saco    ",50);
        costos.put("Pantalón",50);
        costos.put("Abrigo  ",80);
        costos.put("Camisa  ",50);
        costos.put("Playera ",50);
        costos.put("Corbata ",50);
        costos.put("Chamarra",70);
    }
}
