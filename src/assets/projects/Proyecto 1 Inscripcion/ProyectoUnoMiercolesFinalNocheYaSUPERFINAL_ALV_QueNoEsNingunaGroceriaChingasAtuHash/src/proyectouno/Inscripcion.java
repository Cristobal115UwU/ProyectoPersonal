/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. Puto el que lo lea.
 */
package proyectouno;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
/**
 *
 * @author alber
 */
public class Inscripcion {
    //Cambiar nombre a las listas para ser concistente con la notacion utilizada.
    List <Alumno> ListaAlumnos = new LinkedList<>();
    List <Profesor> ListaProf = new LinkedList<>();
    List <Materia> ListaMaterias = new LinkedList<>();
    List <Grupo> ListaGrupo = new LinkedList<>();
    HashMap <Integer, Materia> relacionGrupoMaterias = new HashMap<>();
    HashMap <Materia, List<Grupo>> mYG = new HashMap<>(); // De regreso prros
    //Numero del grupo, Nombre de la materia.
    //AGREGAR
    public void agregarMateria(){
        Materia mat = Materia.crearMateria();
        boolean des=false;
        for(Materia verif : ListaMaterias){
            if(verif.getNombre().equals(mat.getNombre())){
                System.out.println("\tLa materia " + mat.getNombre() + " ya se encuentra dada de alta en el sistema.");
                des=true;
                break;
            }
        }
        if(des==false){
            ListaMaterias.add(mat);
            System.out.println("\tLa materira " + mat.getNombre() + " ha sido dada de alta exitosamente.");
        }    
    }
    
    public void agregarProf(Profesor prof){
        ListaProf.add(prof);
    }
    public void agregarAlumno(Alumno alu){
        ListaAlumnos.add(alu);
    }
    public void agregarGrupo(Grupo gr){
        ListaGrupo.add(gr);//modificar
    }
    //IMPRIMIR
    public void imprimirAlumno(){
        if(ListaAlumnos.isEmpty())
            System.out.println("\tNingún alumno ha sido dado de alta en el sistema de inscripción.");
        else{
            for(Alumno alu : ListaAlumnos){
                System.out.println("\t- - - - - - - - - - - - - - - - - - ");
                System.out.println("\tNombre: "+alu.getNombre());
                System.out.println("\t# de cuenta: "+alu.getCuenta());
                if (alu.getGruposAlu().isEmpty())
                    System.out.println("\tActualmente el alumno no esta inscrito en ninguna materia.");
                else{
                    System.out.println("\t+ + + + + + + + + + + + + + + + + + ");   
                    System.out.println("\t\t-GRUPOS- ");
                    for(Grupo gr : alu.getGruposAlu() ){
                        int aux= gr.getNumGrupo(); //Grupo no tiene clave, tiene numGrupo.
                        Materia mat = relacionGrupoMaterias.get(aux);
                        System.out.println("\t\tNombre de la materia: "+mat.getNombre());
                        System.out.println("\t\tClave: " +mat.getClave());
                        System.out.println("\t\tGrupo: "+gr.getNumGrupo());
                    }
                    System.out.println("\t+ + + + + + + + + + + + + + + + + + ");
                }
                System.out.println("\t- - - - - - - - - - - - - - - - - - ");
            }
        }
    }
    
    public void imprimirProfesores(){
        if(ListaProf.isEmpty())
            System.out.println("\tNingún profesor ha sido dado de alta en el sistema de inscripción.");
        else{
            for(Profesor prof : ListaProf){
                System.out.println("\t- - - - - - - - - - - - - - - - - - ");
                System.out.println("\tNombre: " + prof.getNombre());
                System.out.println("\tNúmero de empleado: " +prof.getNumEmpleado() );
                if(prof.getGruposProfe().isEmpty())
                    System.out.println("\tPor el momento el profesor no tiene ningún grupo asignado");
                else{
                    System.out.println("\t\t-GRUPOS-");
                    for(Grupo gpi : prof.getGruposProfe()){
                        System.out.println("\t+ + + + + + + + + + + + + + + + + + ");
                        int numG = gpi.getNumGrupo();
                        Materia materiaProf = relacionGrupoMaterias.get(numG);
                        System.out.println("\t\tMateria: " + materiaProf.getNombre());
                        System.out.println("\t\tClave: " + materiaProf.getClave());
                        System.out.println("\t\tGrupo: " + numG);
                    }
                    System.out.println("\t+ + + + + + + + + + + + + + + + + + ");    
                }
            }
            System.out.println("\t- - - - - - - - - - - - - - - - - - ");
        }
    }
    
    public void imprimirMaterias(){
        if (ListaMaterias.isEmpty())
            System.out.println("\tNinguna materia ha sido dada de alta en el sistema.");
        else{ 
            System.out.println("\t-MATERIAS CREADAS-");
            for(Materia mat : ListaMaterias){
                System.out.println("\t- - - - - - - - - - - - - - - - ");
                System.out.println("\tMateria: "+ mat.getNombre());
                System.out.println("\tClave: "+ mat.getClave());
            }
            System.out.println("\t- - - - - - - - - - - - - - - - ");
        }
    }
   
    public void  imprimirGrupo(){
        if(ListaMaterias.isEmpty())
            System.out.println("\tPor el momento no se cuentan con materias y grupos registrados en el sistema.");
        else{
            Materia laMateria = cachaMaterias();
            List<Grupo> losGrupos = mYG.get(laMateria);
            if(losGrupos.isEmpty())
                System.out.println("\tEsta matería aun no tiene grupos abiertos.");
            else{
                for(Grupo gpi : losGrupos){
                    System.out.println("- - - - - - - - - - - - - - - - ");
                    System.out.println("\tClave: " + laMateria.getClave());
                    System.out.println("\tGrupo: " + gpi.getNumGrupo());
                    System.out.println("\tProfesor: " + gpi.getProfesor().getNombre());
                    if(gpi.getAlumnos().isEmpty())
                        System.out.println("\tEl grupo " + gpi.getNumGrupo() + " no tiene alumnos asignados.");
                    else{
                        for(Alumno ElWeyEse : gpi.getAlumnos()){
                            System.out.println("+ + + + + + + + + + + + + + + + + + ");
                            System.out.println("\t\tNúmero de cuenta: " + ElWeyEse.getCuenta() + ".");
                        }
                        System.out.println("\t+ + + + + + + + + + + + + + + + + + ");
                    }
                }
                System.out.println("\t- - - - - - - - - - - - - - - - ");
            }
        }
    }
    //CACHAR
    public Materia cachaMaterias(){
        Scanner sc = new Scanner(System.in);
        int opc;
        System.out.println("\tSeleccione una materia de la lista: ");
        System.out.println("\tMaterias disponibles: ");
        for(int i = 0; i< ListaMaterias.size(); i++)
            System.out.println("\t"+(i+1)+") "+ListaMaterias.get(i).getNombre() +".");
        do{
            System.out.print("\t-->");
            opc = sc.nextInt();
            if(opc < 1 || opc > ListaMaterias.size())
                System.out.println("\tOpción incorrecta, vuelve a intentarlo. Tu puedes campeón!");
        }while(opc < 1 || opc > ListaMaterias.size());
        opc = opc - 1;
        return ListaMaterias.get(opc);
    }
    
    public Profesor cachaProfe(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\tEstos son los profesores disponibles para la materia seleccionada");
        System.out.println("\tA continuación seleccione un profesor: ");
        int j=0;
        for(Profesor x:ListaProf){
            System.out.println("\t\t" + (j + 1)+")"+ x.getNombre() + ".");
            j++;
        }
        System.out.print("\t-->");
        int des = sc.nextInt();
        while((des < 1) || (des > ListaProf.size())){
            System.out.println("\tOpción incorrecta. Vuelve a intentarlo.");
            System.out.print("\t-->");
            des = sc.nextInt();
        }
        return ListaProf.get(des - 1);
    }

    public Alumno cachaAlumnos(){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("\tEstos son los alumnos registrados");
        for (Alumno x : ListaAlumnos){
            System.out.println("\t\t" + (i+1)+")"+x.getNombre()+".");
        }
        System.out.print("\t-->");
        int des = sc.nextInt();
        while((des < 0)||(des > ListaAlumnos.size())){
            System.out.println("\tOpción incorrecta, seleccione una opcion asociada a la tabla anterior");
            System.out.print("\t-->");
            des = sc.nextInt();
        }
        return ListaAlumnos.get(des - 1);
        
    }
    public Grupo cachaGrupo(){
        Scanner sc = new Scanner(System.in);
        Materia laMateria = cachaMaterias();
        List<Grupo> losGrupos = mYG.get(laMateria);
        int opc = 0;
        int aux;
        System.out.println("\tNombre de la materia: " + laMateria.getNombre() + ".");
        System.out.println("\tSeleccione un grupo de la lista: ");
        for(Grupo gpi : losGrupos){
            System.out.println("\t\tGRUPO: \t\t\tPROFESOR:");
            System.out.println("\t\t" + (opc + 1) + ") " + gpi.getNumGrupo() + " " + gpi.getProfesor().getNombre() + ".");
            opc++;
        }
        do{
            System.out.print("\t---> ");
            aux = sc.nextInt();
        }while(aux < 1 || aux > losGrupos.size());
        return losGrupos.get(aux - 1);
    }
    
    public void mapear(Materia laMateria, Grupo elGrupo){
        Integer numGpo = elGrupo.getNumGrupo();
        relacionGrupoMaterias.put(numGpo, laMateria);
    }
    
    public void map(Materia laMateria, Grupo elGrupo){
        if(mYG.containsKey(laMateria))
            mYG.get(laMateria).add(elGrupo);
        else{
            List<Grupo> grupos = new LinkedList<>();
            grupos.add(elGrupo);
            mYG.put(laMateria, grupos);
        }
    }
    
    public boolean yaEstaInscrito(Alumno alu, Grupo elGrupo){
        if(!alu.getGruposAlu().isEmpty()){
            for(Grupo gpi : alu.getGruposAlu()){
                if(relacionGrupoMaterias.get(gpi.getNumGrupo()).getNombre().equals(relacionGrupoMaterias.get(elGrupo.getNumGrupo()).getNombre()))
                   System.out.println("El alumno " + alu.getNombre() + " ya se encuentra inscrito en un grupo de la materia.");
                   return true;
                }
        }
        return false;
    }
}

/* La lista hash de Mario resucitó al tercer dia FeelsAmazingMan 
__________████████_____██████
_________█░░░░░░░░██_██░░░░░░█
________█░░░░░░░░░░░█░░░░░░░░░█
_______█░░░░░░░███░░░█░░░░░░░░░█
_______█░░░░███░░░███░█░░░████░█
______█░░░██░░░░░░░░███░██░░░░██
_____█░░░░░░░░░░░░░░░░█░░░░░░░░███
____█░░░░░░░░░░░░░██████░░░░░████░░█
____█░░░░░░░░░█████░░░████░░██░░██░░█
___██░░░░░░░███░░░░░░░░░░█░░░░░░░░███
__█░░░░░░░░░░░░░░█████████░░█████████
_█░░░░░░░░░░█████_████___████_█████___█
_█░░░░░░░░░░█______█_███__█_____███_█___█
█░░░░░░░░░░░░█___████_████____██_██████
░░░░░░░░░░░░░█████████░░░████████░░░█
░░░░░░░░░░░░░░░░█░░░░░█░░░░░░░░░░░░█
░░░░░░░░░░░░░░░░░░░░██░░░░█░░░░░░██
░░░░░░░░░░░░░░░░░░██░░░░░░░███████
░░░░░░░░░░░░░░░░██░░░░░░░░░░█░░░░░█
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█
░░░░░░░░░░░█████████░░░░░░░░░░░░░░██
░░░░░░░░░░█▒▒▒▒▒▒▒▒███████████████▒▒█
░░░░░░░░░█▒▒███████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█
░░░░░░░░░█▒▒▒▒▒▒▒▒▒█████████████████
░░░░░░░░░░████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█
░░░░░░░░░░░░░░░░░░██████████████████
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█
██░░░░░░░░░░░░░░░░░░░░░░░░░░░██
▓██░░░░░░░░░░░░░░░░░░░░░░░░██
▓▓▓███░░░░░░░░░░░░░░░░░░░░█
▓▓▓▓▓▓███░░░░░░░░░░░░░░░██
▓▓▓▓▓▓▓▓▓███████████████▓▓█
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█
//
jiji4
*/ 

