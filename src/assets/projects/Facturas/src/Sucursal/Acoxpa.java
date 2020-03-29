
package Sucursal;

public class Acoxpa extends Sucursal {
    public Acoxpa(){
       setPrecios(); 
       setClientesFile();
       setID("ACOXPA");
    }

    private final void setPrecios(){
        costos.put("Saco    ",45);
        costos.put("Pantalón",45);
        costos.put( "Abrigo ",75);
        costos.put("Camisa  ",45);
        costos.put("Playera ",45);
        costos.put("Corbata ",40);
        costos.put("Chamarra",65);
    }
}
