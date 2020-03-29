


package Sucursal;

import Prenda.Prenda;
import Usuario.*;
import java.util.*;
import java.io.*;
import facturas.*;

public abstract class Sucursal {
    private String ID;
    private double numOP;
    protected  HashMap<String, Integer> costos = new HashMap<>();
    protected static LinkedList<Clientes> clientes = new LinkedList<>();
    protected  LinkedList<Facturas> fact = new LinkedList<>();
    protected  LinkedList<Facturas> factS = new LinkedList<>();
    
    //Usuario cajero;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    //a prro me ganaste,
    public double getNumOP() {
        return numOP;
    }

    public void setNumOP(double numOP) {
        this.numOP = numOP;
    }
    
    public void Acceder(LinkedList<Empleado> listaE){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t Ingrese su ID de empleado");
        System.out.print("\t-->");
        String nombre=sc.nextLine();
        System.out.println("\t Ingrese su contraseña");
        System.out.print("\t-->");
        String pass = sc.nextLine();
        if(searchInEmp(listaE,nombre,pass)){
            Menu();
        }else{
            System.out.println("\tAcceso no permitido");
        }
        
    }
    public boolean searchInEmp(LinkedList<Empleado> listaE,String idEmp, String pass){
        for(Empleado emp : listaE){
            if((emp.getIdUser().equals(idEmp)) && (emp.getPassword().equals(pass))&& (emp.getSucursalID().equals(ID))){
                return true;
            }
        }
        return false;
    }
    
    public void setClientesFile(){
        FileInputStream iFile = null;
        File file;
        ObjectInputStream o = null;
        LinkedList<Clientes> listCl = null;
        try {
            file = new File("./archivos/clientes/baseCl.obj");
            if (file.exists()) {
                iFile = new FileInputStream(file);
                o = new ObjectInputStream(iFile);
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el arch");
        }
        try {
            listCl = (LinkedList<Clientes>) o.readObject();
            o.close();
            iFile.close();
            
        }catch(NullPointerException e){
        
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException ex) {
            System.out.println("");
        }
        this.clientes = listCl;
    }
    protected LinkedList Pedidos(){
        Scanner sc = new Scanner(System.in);
        Integer total = 0;
        int prenda = 0;
        int cantidad = 0;
        String color;
        LinkedList<Prenda> pedidos = new LinkedList<>();
        do{
            System.out.println("===================================================");
            System.out.println("\tTotal hasta el momento: $" + total + ".00");
            System.out.println("\tSeleccione la prenda");
            System.out.println("\t\t1.- SACO\n\t\t2.- PANTALON\n\t\t3.- ABRIGO\n\t\t4.- CAMISA\n\t\t5.- PLAYERA\n\t\t6.- CORBATA\n\t\t7.- CHAMARRA\n\t\t8.-Terminar la la generación de Factura. ");
            do{   
                try{
                    System.out.print("\t---> ");
                    prenda = sc.nextInt();
                }catch(InputMismatchException ex){
                    prenda = 0;
                    sc.nextLine();
                } finally{
                    if(prenda < 1 || prenda > 8)
                        System.out.println("Opción no valida, vuelva a intentarlo.");
                }
            } while(prenda < 1 || prenda > 8);
            
            if(prenda != 8){
                System.out.println("\n\tCANTIDAD: ");
                
                do{
                    try{
                        System.out.print("\t---> ");
                        cantidad = sc.nextInt();
                    } catch(InputMismatchException ex){
                        cantidad = 0;
                        sc.nextLine();
                    } finally{
                        if(cantidad < 1 || cantidad > 10)
                            System.out.println("El número máximo de prendas son diez y el mínimo es una. Vuelva a intentarlo.");
                    }
                }while(cantidad < 1 || cantidad > 10);
            }
            switch(prenda){
                case 1: //Saco.
                    for(int i = 0; i < cantidad; i++){
                        color = Color();
                        pedidos.add(new Prenda("Saco    ", costos.get("Saco    "), color));
                        total += costos.get("Saco    ");
                    } 
                    break;
                case 2: //Pantalón.
                    for (int i = 0; i < cantidad; i++) {
                    color = Color();
                    pedidos.add(new Prenda("Pantalon", costos.get("Pantalon"), color));
                    total += costos.get("Pantalon");
                }
                    break;
                case 3: //Abrigo.
                for (int i = 0; i < cantidad; i++) {
                    color = Color();
                    pedidos.add(new Prenda("Abrigo  ", costos.get("Abrigo  "), color));
                    total += costos.get("Abrigo  ");
                }
                    break;
                case 4: //Camisa.
                for (int i = 0; i < cantidad; i++) {
                    color = Color();
                    pedidos.add(new Prenda("Camisa  ", costos.get("Camisa  "), color));
                    total += costos.get("Camisa  ");
                }
                    break;
                case 5: //Playera.
                for (int i = 0; i < cantidad; i++) {
                    color = Color();
                    pedidos.add(new Prenda("Playera ", costos.get("Playera "), color));
                    total += costos.get("Playera ");
                }
                    break;
                case 6: //Corbata.
                for (int i = 0; i < cantidad; i++) {
                    color = Color();
                    pedidos.add(new Prenda("Corbata ", costos.get("Corbata "), color));
                    total += costos.get("Corbata ");
                }
                    break;
                case 7: //Chamarra.
                for (int i = 0; i < cantidad; i++) {
                    color = Color();
                    pedidos.add(new Prenda("Chamarra", costos.get("Chamarra"), color));
                    total += costos.get("Chamarra");
                }
                    break;
                case 8: //Salir.
                    if(total == 0){
                        System.out.println("\tOperación cancelada exitosamente!");
                        return null;
                    }
                    else{
                        System.out.println("\tSolicitud procesada de manera exitosa.");
                    }
                    break;
            }

        }while(prenda != 8);
        
        return pedidos;
    }
    public void Menu(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int total = 0;
        String numTel;
        LinkedList<Prenda> pedido;
        this.clientes = readClientes();
        if(this.clientes == null)
            this.clientes = new LinkedList<>();
        System.out.println("Bienvenido a la sucursal "+ ID +" que desea realizar?");
        do{
            System.out.print("\t1.- Registro de Cliente\n\t2.- Recepcion de Ropa\n\t3.- Entregar Servicio\n\t4.- Mostrar notas por entregar\n\t5.- Mostrar Clientes\n\t6.- Finanzas\n\t7.-Salir----> ");
            try{
                opcion = sc.nextInt();
            }catch(InputMismatchException ex){
                opcion = 0;
                sc.nextLine();
            } finally{
                if(opcion < 1 || opcion > 7)
                    System.out.println("\tOpción no valida, vuelva a intentarlo.");
            }
            switch(opcion){
                case 1: //Registro.
                    System.out.println("\t======================");
                    Clientes cl = resgistroCliente();
                    boolean permisoCrear = validarNumCliente(cl.getNumCel());
                    if(permisoCrear == true){
                        clientes.add(cl);
                        writeClients(clientes);
                        System.out.println("\tCliente creado de manera exitosa");
                    }else{
                        System.out.println("\tYa esta registrado ese numero");
                    }System.out.println("\t======================");
                    break;
                case 2: //Recepción.
                    System.out.println("\t=========================");
                    if(clientes.size() != 0){
                        numTel = getNumTel();
                        if(Facturas.confirmNumCliente(numTel)){
                            LinkedList<Prenda> ordenActual = Pedidos();
                            if(ordenActual != null){
                                Facturas.crearFactura(ordenActual, ID, numTel);
                                total = totalCalculator(ordenActual);
                                fact.add(new Facturas(ordenActual, total, numTel));
                                writeFacturas(fact, false);
                            }
                        } else{
                            System.out.println("\tAntes de proceder con la recepción de ropa, realice el registro del cliente en el sistema.");
                        }
                    } else{
                        System.out.println("\t¡No hay níngun cliente registrado en el sistema!");
                    }
                    System.out.println("\t=========================");
                    break;
                case 3: //Entrega.
                    System.out.println("\t======================");
                    numTel = getNumTel();
                    if(Facturas.confirmNumCliente(numTel)){
                        LinkedList<Facturas> facturas = readFacturas(true);
                        if(facturas != null){
                            for(int i = 0; i < facturas.size(); i++){
                                if(facturas.get(i).getNumTel().equals(numTel)){
                                    total = facturas.get(i).getTotal();
                                    factS.add(facturas.remove(i));
                                    break;
                                }
                            }
                            writeFacturas(factS, true);
                            writeFacturas(facturas, false);
                            if(total != 0){
                                System.out.println("\tOrden recolectada de manera exitosa.");
                                System.out.println("\tTotal: $" + total + ".00");
                            } else{
                                System.out.println("\tNo hay ninguna factura asociada al número de telefono. Verifique la información proporcionada por el cliente.");
                            }
                        }
                    }else
                        System.out.println("\tLa persona no es un cliente registrado. Llame a la policia.");
                    System.out.println("\t======================");
                    break;
                case 4: //Mostrar Notas del dia.
                    System.out.println("\t======================");
                    fact = readFacturas(true);
                    if(fact != null && fact.size() != 0){
                        System.out.println(fact.size());
                        Facturas.printFact(fact);
                    } else{
                        System.out.println("\tNo hay ninguna recolección programada.");
                    }
                    System.out.println("\t======================");
                    break;
                case 5://Mostrar clientes 
                    System.out.println("\t======================");
                    mostrarClientes(this.clientes);
                    System.out.println("\t======================");
                    break;
                case 6: //Finanzas.
                    System.out.println("\t======================");
                    LinkedList<Facturas> facturasEnS = readFacturas(false);
                    LinkedList<Facturas> facturasEnt = readFacturas(true);
                    int totalEsp = tCalculatorFact(facturasEnS);
                    int totalPond = tCalculatorFact(facturasEnt);
                    System.out.println("\tGanancias esperadas: $" + totalPond + ".00");
                    System.out.println("\tGanacias de la sucursal: $" + totalEsp + ".00");
                    System.out.println("\t======================");
                    break;
                case 7: // Salir.
                    System.out.println("\t======================");
                    System.out.println("Terminando operaciones de la sucursal.");
                    System.out.println("Adiós :)");
                    System.out.println("\t======================");
                    break;
            }
        }while(opcion != 7);
    }
    private String Color(){
        String color;
        Scanner sc = new Scanner(System.in);
        System.out.println("\tIntroduzca el color de su prenda");
        
        do{
            System.out.print("\t-----> ");
            color = sc.nextLine();
            if(color.length() < 3)
                System.out.println("\tPor favor, vuelva a introducir el color de la ropa.");
        }while(color.length() < 3);
        return color;    
    }

    private Clientes resgistroCliente(){
        Scanner sc = new Scanner(System.in);
        String nombre;
        String numP = null;
        do{
            System.out.println("\tIntroduzca el nombre del Cliente: ");
            System.out.print("\t-->");
            nombre = sc.nextLine();
            if(nombre.length() < 3)
                System.out.println("\tVuelva a introducir el nombre del usuario.");
        }while(nombre.length() < 3);

        do{
            System.out.println("\tIntroduzca el número de telefono del cliente (9 digitos).");
            System.out.print("\t-->");
            try{
                numP = sc.nextLine();
            }catch(InputMismatchException ex){
                sc.nextLine();
            } finally{
                if(numP.length() != 9)
                    System.out.println("\tVuelva a introducir el número de telefono del cliente.");
            }
        }while(numP.length() < 9);
         
        return (new Clientes(nombre, numP));
        
    }
    public static void mostrarClientes(LinkedList<Clientes> client){
        if(client == null || client.isEmpty())
            System.out.println("\tNo hay clientes registrados");
        System.out.println("\t--------------------------------------");
        for(Clientes cl : client){
            System.out.println("\tNombre Cliente:"+cl.getNombre());
            System.out.println("\tNumero Cel:"+cl.getNumCel());
            System.out.println("\t-----------------------------------");            
        }
        System.out.println();
    }
    public static void writeClients(LinkedList<Clientes> cl){
        File file;
        FileOutputStream oFile = null;
        ObjectOutputStream o;
        try {
            file = new File("./archivos/clientes/baseCl.obj");
            if (!file.exists()) {
                file.createNewFile();
             }
            oFile = new FileOutputStream(file);
        } catch (IOException ex) {
            System.out.println("\tNo se pudo actualizar");
        }
        try {
            o = new ObjectOutputStream(oFile);
            o.writeObject(cl);
            o.close();
            oFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("\tFile not found");
        } catch (IOException e) {
            System.out.println("\tError initializing stream");
        }
    }
    
    public void writeFacturas(LinkedList<Facturas> lasFacturas, boolean entrega){
        File file;
        FileOutputStream outFile = null;
        ObjectOutputStream out;
        String entrada = "./archivos/carpeta/"+ getID() + "/gFact/FactEspera.obj";
        String salida = "./archivos/carpeta/"+ getID() + "/gFact/FactEnt.obj";
        try{
            if(!entrega){
                file = new File(entrada);
            }else{
                file = new File(salida);
            }
            
            if(!file.exists())
                file.createNewFile();
            outFile = new FileOutputStream(file);
        }catch(IOException ex){
            System.out.println("\tNo es posible conectar a la base de datos, intente más tarde.");
        }
        
        try{
            out = new ObjectOutputStream(outFile);
            out.writeObject(lasFacturas);
            out.close();
            outFile.close();
        } catch (IOException ex) {
            System.out.println("\tNo es posible conectar a la base de datos, intente más tarde. 3");
        }
    }
    
    public LinkedList<Facturas> readFacturas(boolean entrega){
        FileInputStream inFile = null;
        File file;
        ObjectInputStream in;
        String recibido = "./archivos/carpeta/"+ getID() + "/gFact/FactEspera.obj";
        String entregado = "./archivos/carpeta/"+ getID() + "/gFact/FactEnt.obj";
        LinkedList<Facturas> lasFacturas = null;
        try{
            if(entrega)
                file = new File(recibido);
            else
                file = new File(entregado);
            if(file.exists())
                inFile = new FileInputStream(file);
            else
                return lasFacturas;
        }catch(IOException ex){
            System.out.println("\tError al conectarse a la base de datos. Intente más tarde.");
        }
        
        try{
            in = new ObjectInputStream(inFile);
            lasFacturas = (LinkedList<Facturas>) in.readObject();
            in.close();
            inFile.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("\tError al conectarse a la base de datos. Intente más tarde.");
        }
        return lasFacturas;
    }
    
    
    public boolean validarNumCliente(String numCelClN){
        for(Clientes cl : clientes){
            if(cl.getNumCel().equals(numCelClN)){
                return false;
            }
        }
        return true;
    }
    public static LinkedList<Clientes> readClientes() {
        FileInputStream iFile = null;
        File file;
        ObjectInputStream oi;
        LinkedList<Clientes> listClient = null;
        try {
            file = new File("./archivos/clientes/baseCl.obj");
            if (file.exists()) {
                iFile = new FileInputStream(file);
            } else{
                return null;
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el arch");
        }
        try {
            oi = new ObjectInputStream(iFile);
            listClient = (LinkedList<Clientes>) oi.readObject();
            oi.close();
            iFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException ex) {
            System.out.println("");
        }
        return listClient;
    }
    public static void clienteDefault(){
        Clientes cl = new Clientes("PRUEBA","0000000000");
        LinkedList<Clientes> clL = new LinkedList<Clientes>();
        clL.add(cl);
        writeClients(clL);
    }
    
    public static String getNumTel(){
        Scanner sc = new Scanner(System.in);
        String numC;
        System.out.println("\tIntroduzca el número del cliente.");
        System.out.print("\t----> ");
        do{
            numC = sc.nextLine();
            if(numC.length() != 9)
                System.out.println("\tConfirme el número de telefono del usuario.");
        }while(numC.length() != 9);
        return numC;
    }
    
    public static int totalCalculator(LinkedList<Prenda> lasPrendas){
        int total = 0;
        for(Prenda p : lasPrendas)
            total += p.getCosto();
        return total;
    }
    
    public static int tCalculatorFact(LinkedList<Facturas> lasFacturas){
        int total = 0;
        if(lasFacturas != null && lasFacturas.size() != 0){
            for(Facturas fact : lasFacturas)
                total += fact.getTotal();
        }
        return total;
    }
}
 