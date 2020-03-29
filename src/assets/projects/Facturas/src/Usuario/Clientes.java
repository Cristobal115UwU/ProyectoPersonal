/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public class Clientes extends Persona implements Serializable{
    private List<Integer> listaFacturas;
    private String numCel;
    public Clientes(String nombre, String numCel) {
        super(nombre);
        this.numCel=numCel;
        //addtListaFacturas(listaFacturas);
    }

    public List<Integer> getListaFacturas() {
        return listaFacturas;
    }

    public void addtListaFacturas(Integer ID) {
        listaFacturas.add(ID);
    }
    
    public String getNumCel() {
        return numCel;
    }

    public void setNumCel(String numCel) {
        this.numCel = numCel;
    }
    

}
