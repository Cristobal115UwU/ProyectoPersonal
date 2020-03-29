
package Principal;

import java.util.Scanner;
import java.util.InputMismatchException;
import Sucursal.*;
import Usuario.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List; 

public class EntranceTerminal {
    public static void main(final String args[]) {
        int opc;
        Sucursal laSucursal;
        Administrador elAdmin;
        LinkedList<Empleado> listaEmpl;
        if (adminExists()) {
            elAdmin = readAdminInFile();
        } else {
            elAdmin = instanceOfAdmin();
            writeAdminInFile(elAdmin);
        }
        listaEmpl = readEmplInFile();
        if(listaEmpl == null)
            listaEmpl = new LinkedList();
        do {
            opc = menu();
            switch (opc) {
            case 1:
                laSucursal = new Acoxpa();
                laSucursal.Acceder(listaEmpl);
                break;
            case 2:
                laSucursal = new Ajusco();
                laSucursal.Acceder(listaEmpl);
                break;
            case 3:
                laSucursal = new Tlahuac();
                laSucursal.Acceder(listaEmpl);
                break;
            case 4:
                menuAdmin(elAdmin, listaEmpl);
                break;
            case 5:
                System.out.println("\tHasta pronto! :)");
                break;
            }

        } while (opc != 5);
    }

    public static int menu() {
        int opc = 0;
        final Scanner sc = new Scanner(System.in);
        
        System.out.println("=== NOMBRE DE LA PRRA TINTORERIA ===");
        System.out.println("Seleccione la sucursal en la que se encuentra: ");
        System.out.println("\t1) Acoxpa. ");
        System.out.println("\t2) Ajusco. ");
        System.out.println("\t3) Tlahuac. ");
        System.out.println("\t4) Menu Admin.");
        System.out.println("\t5) Salir del sistema.");
        do {
            try {
                System.out.print("\t--> ");
                opc = sc.nextInt();
            } catch (final InputMismatchException ex) {
                sc.nextLine();
                opc = 0;
            } finally {
                if (opc < 1 || opc > 5)
                    System.out.println("\tOpción no valida. Asegurece de seleccionar una opción correcta.");
            }
        } while (opc < 1 || opc > 5);
        return opc;
    }

    public static void menuAdmin(Administrador admin, LinkedList<Empleado> listaE) {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        System.out.println(admin.getPassword());
        System.out.println("\tIngrese la contraseña del Admin  "+ admin.getIdUser());
        System.out.print("\t-->");
        String pass = sc.nextLine();
        if (!pass.equals(admin.getPassword())) {
            System.out.println("\tContraseña inválida");
            return;
        }
        do{
            System.out.println("*-*-*-*-*-*-*-*-*--*-*-*-*-*-*");
            System.out.println("QUE ACCION DESEA REALIZAR");
            System.out.println("\t1.-Crear Empleado");
            System.out.println("\t2.-Mostrar Empleados");
            System.out.println("\t3.-Borrar Empleado");
            System.out.println("\t4.-Salir");
            
            do {
                try {
                    System.out.print("\t-->");
                    opc = sc.nextInt();
                } catch (final InputMismatchException ex) {
                    sc.nextLine();
                    opc = 0;
                } finally {
                    if (opc < 1 || opc > 4)
                        System.out.println("\tOpción no valida. Asegurece de seleccionar una opción correcta.");
                }
            } while (opc < 1 || opc > 4);
            switch(opc){
                case 1:
                    Empleado emp = admin.crearEmpleado();
                    listaE.add(emp);
                    writeEmpleados(listaE);
                    break;
                case 2:
                    showEmp(listaE);
                    break;
                case 3:
                    showEmp(listaE);
                    System.out.println("\t¿Qué empleado desea eliminar?");
                    System.out.print("\t-->");
                    int delateE = sc.nextInt();
                    listaE.remove(delateE - 1);
                    writeEmpleados(listaE);
                    System.out.println("\tEmpleado eliminado");
                    break;
                case 4:
                    System.out.println("\tCerrando sesión admin");
                    break;    
                default:
                    System.out.println("\tComando inválido");
            }
        }while(opc != 4);
    }

    public static Administrador instanceOfAdmin() {
        Scanner sc = new Scanner(System.in);
        String masterUser;
        String masterPsw;
        String cMasterPsw;
        Administrador elAdmin;
        System.out.println("\tBienvenido al sistema de administración de Usuarios.");
        System.out.println("\tPor favor, realice el registr+o de Administrador para continuar.");
        System.out.println("\tIntroduzca su nombre de usuario: ");
        System.out.print("\t-->");
        masterUser = sc.nextLine();
        System.out.println("\tIntroduzca su contraseña (al menos 4 carácteres):");
        do {
            do {
                System.out.print("\t-->");
                masterPsw = sc.nextLine();
                if (masterPsw.length() < 4)
                    System.out.println("\tLongitud incorrecta, vuelva a intentarlo.");
            } while (masterPsw.length() < 4);

            System.out.println("\tConfirme la contraseña introducida: ");
            System.out.print("\t-->");
            cMasterPsw = sc.nextLine();
            if (!masterPsw.equals(cMasterPsw))
                System.out.println("\tLas contraseñas no coinciden, intentelo de nuevo la contraseña que quiere asignar.");
        } while (!masterPsw.equals(cMasterPsw));
        elAdmin = new Administrador(masterUser, masterPsw);
        return elAdmin;
    }

    public static boolean adminExists() {
        File file = new File("./archivos/admin/baseAdmin.obj");
        if (file.exists())
            return true;
        else
            return false;
    }

    public static void writeAdminInFile(Administrador admin) {
        File file;
        FileOutputStream oFile = null;
        ObjectOutputStream o;
        try {
            file = new File("./archivos/admin/baseAdmin.obj");
            if (!file.exists()) {
                file.createNewFile();
                oFile = new FileOutputStream(file);
            }
        } catch (IOException ex) {
            System.out.println("No se pudo crear el Admin");
        }
        try {
            o = new ObjectOutputStream(oFile);
            o.writeObject(admin);
            o.close();
            oFile.close();
            System.out.println("\tSe creó exitosamente el archivo");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public static Administrador readAdminInFile() {
        FileInputStream iFile = null;
        File file;
        ObjectInputStream o;
        Administrador admin = null;
        try {
            file = new File("./archivos/admin/baseAdmin.obj");
            if (file.exists()) {
                iFile = new FileInputStream(file);
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el arch");
        }
        try {
            o = new ObjectInputStream(iFile);
            admin = (Administrador) o.readObject();
            o.close();
            iFile.close();
            return admin;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException ex) {
            System.out.println("");
        }
        return admin;

    }

    public static LinkedList<Empleado> readEmplInFile() {
        FileInputStream iFile = null;
        File file;
        ObjectInputStream oi;
        LinkedList<Empleado> listEmp = null;
        try {
            file = new File("./archivos/empleados/baseEmp.obj");
            if (file.exists()) {
                iFile = new FileInputStream(file);
            }else{
                System.out.println("\tNo hay ningún empleado en el sistema.");
                return null;
            }
        } catch (IOException ex) {
            System.out.println("\tNo se pudo leer el arch");
        }
        try {
            oi = new ObjectInputStream(iFile);
            listEmp = (LinkedList<Empleado>) oi.readObject();
            oi.close();
            iFile.close();
            return listEmp;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException ex) {
            System.out.println("");
        }
        return listEmp;
    }

    public static void writeEmpleados(LinkedList<Empleado> listaEmpl) {
        if (listaEmpl == null)
            return;
        File file;
        FileOutputStream oFile = null;
        ObjectOutputStream o;
        try {
            file = new File("./archivos/empleados/baseEmp.obj");
            if (!file.exists()) {
                file.createNewFile();
            }
            oFile = new FileOutputStream(file);
        } catch (IOException ex) {
            System.out.println("No se pudo crear el emp");
        }
        try {
            o = new ObjectOutputStream(oFile);
            o.writeObject(listaEmpl);
            o.close();
            oFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
    public static void showEmp(LinkedList<Empleado> listaEmpl){
        int conta = 1;
        if(listaEmpl.size() == 0)
            System.out.println("\tNo hay empleados");
        for(Empleado e : listaEmpl){
            System.out.println("\t-------------"+conta+"------------");
            System.out.println("\tNombre: "+e.getNombre() );
            System.out.println("\tUsuario: "+e.getIdUser());
            System.out.println("\tPassword: "+e.getPassword());
            System.out.println("\tSucursal: "+e.getSucursalID());
            conta ++;
        }
        System.out.println("\t--------------------------");
        
    }
    
}