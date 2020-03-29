/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouno;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
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
    //Numero del grupo, Nombre de la materia.
    //AGREGAR
    public void agregarMateria(){
        System.out.println("Estas son las materias que existentes");
        imprimirMaterias();
        Materia mat = Materia.crearMateria(); 
        ListaMaterias.add(mat);
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
        Grupo clave;
        Materia valor;
        for(Alumno alu : ListaAlumnos){
            System.out.println("Nombre: "+alu.getNombre());
            System.out.println("# de cuenta: "+alu.getCuenta());
            System.out.println("Materias: ");
            if (alu.getGruposAlu().isEmpty())
                System.out.println("Actualmente el alumno no esta inscrito en ninguna materia.");
            else{                
                for(Grupo gr : alu.getGruposAlu() ){
                    int aux= gr.getNumGrupo(); //Grupo no tiene clave, tiene numGrupo.
                    Materia mat = relacionGrupoMaterias.get(aux);
                    System.out.println("Nombre de la materia: "+mat.getNombre());
                    System.out.println("Clave: " +mat.getClave());
                }
            }
        }
    }
    
    public void imprimirProfesores(){
        for(Profesor prof : ListaProf){
            System.out.println("Nombre: " + prof.getNombre());
            System.out.println("# de empleado: " +prof.getNumEmpleado() );
        }
    }
    
    public void imprimirMaterias(){
        //ListaMaterias.
        for(Materia mat : ListaMaterias){
            System.out.println("Materia: "+ mat.getNombre());
            System.out.println("Clave: "+ mat.getClave());
        }
    }
   
    public void  imprimirGrupo(){ //Imprimir grupo va a imprimir todos los grupos creados.
        for(Grupo elGrupo : ListaGrupo){
            int aux= elGrupo.getNumGrupo(); //Grupo no tiene clave, tiene numGrupo.
            Materia mat = relacionGrupoMaterias.get(aux);
            System.out.println("Nombre de la materia: "+mat.getNombre());
            System.out.println("Clave: " +mat.getClave());
            System.out.println("Número de grupo: " + elGrupo.getNumGrupo());
            System.out.println("Profesor asignado: " + elGrupo.getProfesor().getNombre());
            if(ListaGrupo.isEmpty())
                System.out.println("Aun no hay alumnos inscritos en este grupo.");
            else{ //No estamos en python alv
                System.out.println("Estos son los alumnos inscritos actualmente a este grupo:");
                for (Alumno alu: elGrupo.getAlumnos()){
                    System.out.println("Nombre:  "+alu.getNombre());
                    System.out.println("Numero de cuenta: "+alu.getCuenta());
                }
            }
        }
    }
    //CACHAR
    public Materia cachaMaterias(){
        Scanner sc = new Scanner(System.in);
        int opc;
        System.out.println("Seleccione una materia de la lista: ");
        System.out.println("Materias disponibles: ");
        for(int i = 0; i< ListaMaterias.size(); i++)
            System.out.println((i+1)+") "+ListaMaterias.get(i).getNombre() +".");
        do{
            opc = sc.nextInt();
            if(opc < 1 || opc > ListaMaterias.size())
                System.out.println("Opción incorrecta, vuelve a intentarlo. Tu puedes campeón!");
        }while(opc < 1 || opc > ListaMaterias.size());
        opc = opc - 1;
        return ListaMaterias.get(opc);
    }
    
    public Profesor cachaProfe(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Estos son los profesores disponibles para la materia seleccionada");
        System.out.println("Seleccione el profesor con la tecla asociada a su nombre");
        int j=0;
        for(Profesor x:ListaProf){
            System.out.println("Presione "+j+" si desea seleccionar a "+x.getNombre());
            j++;
        }
        int des = sc.nextInt();
        while((j<0)||(j>ListaProf.size())){
            System.out.println("Opción incorrecta, seleccione una opcion asociada a la tabla anterior");
            des = sc.nextInt();
        }
        return ListaProf.get(des);
    }

    public Alumno cachaAlumnos(){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Estos son los alumnos registrados");
        for (Alumno x : ListaAlumnos){
            System.out.println("Presione "+i+"para escoger a "+x.getNombre());
        }
        int des = sc.nextInt();
        while((i < 0)||(i > ListaAlumnos.size())){
            System.out.println("Opción incorrecta, seleccione una opcion asociada a la tabla anterior");
            des = sc.nextInt();
        }
        return ListaAlumnos.get(des);
        
    }
    public Grupo cachaGrupo(Alumno alumm){
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione un grupo de la lista: ");
        for(Grupo elGrupo : ListaGrupo){
            int aux= elGrupo.getNumGrupo(); //Grupo no tiene clave, tiene numGrupo.
            Materia mat = relacionGrupoMaterias.get(aux);
            System.out.println("Nombre de la materia: "+mat.getNombre());
            System.out.println("Clave: " +mat.getClave());
            System.out.println("Número de grupo: " + elGrupo.getNumGrupo());
            System.out.println("Profesor asignado: " + elGrupo.getProfesor().getNombre());
        }
        int grMeter=sc.nextInt();
        Grupo gr=ListaGrupo.get(grMeter-1);
        gr.setAlumnos(alumm);
        return gr;
    }
    public void mapear(Materia laMateria, Grupo elGrupo){
        System.out.println("Mi hashtable ES mejor prros");
        Integer numGpo = elGrupo.getNumGrupo();
        relacionGrupoMaterias.put(numGpo, laMateria);
    }
}
/* RIP LISTA HASH DE MARIO 
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
juju
*/ 

