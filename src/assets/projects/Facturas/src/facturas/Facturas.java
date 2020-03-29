
package facturas;
import Prenda.*;
import Usuario.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Facturas implements Serializable {
    public static int numFact = 2048;

    public static void printFact(LinkedList<Facturas> fact) {
        int total = 0;
        for(Facturas f : fact){
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("\tNúmero de telefono del Cliente: " + f.getNumTel());
            System.out.println("\tCantidad de prendas: " + f.getLasPrendas().size());
            System.out.println("\tTotal: $" + f.getTotal() + ".00");
            total+=f.getTotal();
        }
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("\tTotal esperado: $" + total + ".00");
    }
    private LinkedList<Prenda> lasPrendas;
    private int total;
    private String numTel;

    public Facturas(LinkedList<Prenda> lasPrendas, int total, String numTel) {
        this.lasPrendas = lasPrendas;
        this.total = total;
        this.numTel = numTel;
    }

    
    
    public LinkedList<Prenda> getLasPrendas() {
        return lasPrendas;
    }

    public int getTotal() {
        return total;
    }

    public String getNumTel() {
        return numTel;
    }
    
    public static void crearFactura(LinkedList<Prenda> prendas, String id, String numTel){
        int cantidadGlobal=0;
        FileWriter Factura;
        BufferedWriter bf;
        id = id.toUpperCase();
        String finalIdentifier = "./archivos/Carpeta/" + id + "/FacNo" + Integer.toString(randomNumerGenerator()) + "_" + numTel + ".txt";
        try {
            Factura = new FileWriter(finalIdentifier);
            bf = new BufferedWriter(Factura);
        } catch (IOException ex) {
            System.out.println("\tSistema de facturación no disponible, intente más tarde.");
            return;
        }
        double total = 0;
        int num = 1;
        try {
            bf.write("-----NOMBRE  PRRA TINTORERIA----SUC "+id+"------------------------------\n");
            bf.write("-----------NUM CLIENTE "+numTel+"-----------------------------------------\n");
            bf.write("|CANTIDAD\t | \tPRENDA \t | \t PRECIO \t | COLOR \t|\n");
            bf.write("-------------------------------------------------------------------------\n");
            for(Prenda p: prendas){
                bf.write("|"+num+"-" + "    \t \t |" + p.getNombre() + "\t |  "+ Double.toString(p.getCosto())+ " \t\t |" + p.getColor() + "\t"
                        + "\t|\n");
                total+= p.getCosto();
                cantidadGlobal++;
                num++;
            }
            bf.write("-------------------------------------------------------------------------\n");
            bf.write("\t\t CANTIDAD: : " + cantidadGlobal+"\n"); 
            bf.write("\t\t TOTAL: " + Double.toString(total)+"\n");
            bf.close();
            Factura.close();
        } catch (IOException ex) {
            System.out.println("Error 404, File not Found.");
        }
    }
    public static LinkedList<Clientes> readClient(){
        FileInputStream iFile = null;
        ObjectInputStream o;
        LinkedList<Clientes> listCli = null;
        try {
           File file = new File("./archivos/clientes/baseCl.obj");
            if(file.exists()){
                iFile = new FileInputStream(file);
            }
            else{
                return null;
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archiii");
        }
        try {
            o = new ObjectInputStream(iFile);
            listCli = (LinkedList<Clientes>) o.readObject();
            o.close();
            iFile.close();
            return listCli;
        } catch (FileNotFoundException e) {
                System.out.println("File not found");
        }catch (IOException e) {
                System.out.println("Error initializing stream");
        } catch (ClassNotFoundException ex) {
            System.out.println("--");
        }
        return listCli;
    }
    public static void writeClient(LinkedList<Clientes> listaCl){
        if(listaCl == null)
            return;
        File file;
        FileOutputStream oFile = null;
        ObjectOutputStream o = null;
        try {
            file = new File("./archivos/clientes/baseCl.obj");
            if(!file.exists()){
                file.createNewFile(); 
                
            }
            oFile = new FileOutputStream(file);
        } catch (IOException ex) {
            System.out.println("No se pudo crear el emp");
        }
        try {    
            o = new ObjectOutputStream(oFile);
            o.writeObject(listaCl);
            o.close();
            oFile.close();
        } catch (FileNotFoundException e) {
                System.out.println("File not found");
        }catch (IOException e) {
                System.out.println("Error initializing stream");
        }
    }
        
        public static boolean confirmNumCliente(String numTel){
            Scanner sc = new Scanner(System.in);
            LinkedList<Clientes> losClientes = readClient();
            boolean estaRegistrado = false;
            if(losClientes == null)
                return estaRegistrado;
            for(Clientes cliente : losClientes){
                if(cliente.getNumCel().equals(numTel))
                    estaRegistrado = true;
            }
            return estaRegistrado;
        }
        
        public static int randomNumerGenerator(){
            Random rand = new Random();
            int dbl= ((rand == null ? new Random() : rand).nextInt()* (99 - 0));
            return dbl;
        }
    }

