
package Prenda;

import java.io.Serializable;

public class Prenda implements Serializable {
    private String nombre;
    private int costo;
    private String color;

    public Prenda(String nmb, int cost, String color){
        setNombre(nmb);
        setCosto(cost);
        setColor(color);
    }


    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public final void setCosto(int costo) {
        this.costo = costo;
    }

    public String getColor() {
        return color;
    }

    public final void setColor(String color) {
        this.color = color;
    }    
}
