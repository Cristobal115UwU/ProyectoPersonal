/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouno;

import java.util.Scanner;

/**
 *
 * @author alber
 */
public class ProyectoUno {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        boolean meSalgo = false;
        int opc;
        Inscripcion inscribir = new Inscripcion();
        do{
            opc = menu();
            switch (opc){
                case 1://Crear alumno  
                    inscribir.agregarAlumno(Alumno.crearAlumno(inscribir));
                    break;
                case 2://Crear profesores.
                    inscribir.agregarProf(Profesor.crearProfesor());
                    break;
                case 3://Crear materias.
                    inscribir.agregarMateria();
                    break;
                case 4: //Crear grupo
                    //imprimir materias y cachar la materia a crear grupo
                    if(inscribir.ListaMaterias.isEmpty() || inscribir.ListaProf.isEmpty()){
                        System.out.println("\tAsegurate de tener por lo menos un profesor");
                        System.out.println("\ty una materia dados de alta en el sistema.");
                    }
                    else{
                        Materia laMateria = inscribir.cachaMaterias();
                        //imprimir profes y cachar el profe
                        Profesor profe = inscribir.cachaProfe();
                        Grupo aux = Grupo.crearGrupo(profe);
                        //Se agregan los elementos a los hashMap utilizando las funciones.
                        inscribir.mapear(laMateria, aux);
                        inscribir.map(laMateria, aux);
                        profe.setGruposProfe(aux);
                        inscribir.agregarGrupo(aux);
                    }
                    break;
                case 5: //Asignar alumno a grupo.
                    if (inscribir.ListaGrupo.isEmpty())
                        System.out.println("\tAun no hay grupos en los que inscribir a los alumnos.");
                    else{    
                        Alumno alu = inscribir.cachaAlumnos();
                        Grupo gpi = inscribir.cachaGrupo(); 
                        if(!inscribir.yaEstaInscrito(alu, gpi)){
                            if(alu.setGrupo(gpi))
                                gpi.setAlumnos(alu);
                        }
                    }
                    break;
                case 6: //Imprimir alumnos.
                    inscribir.imprimirAlumno();
                    break;
                 case 7: //Imprimir profesores.
                     inscribir.imprimirProfesores();
                    break;
                case 8: //Imprimir materias.
                    inscribir.imprimirMaterias();
                    break;
                case 9: //Imprimir grupos.
                    inscribir.imprimirGrupo();
                    break;
                case 10: //Salir.
                    meSalgo = true;
                    System.out.println("SE HA CERRADO EL SISTEMA DE INSCRIPCIONES.");
                    break;                            
            }
        }while(!meSalgo);
        /*
        TODO:
            -Verificar diferencia entre números de cuenta.
        */
        
    }

    static int menu(){
        Scanner sc = new Scanner(System.in);
        int opc;
        System.out.println("  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*-*");
        System.out.println("\tBienvenido al Sistema de inscripciones 2020-2");
        System.out.println("\t---MENU---");
        System.out.println("\tSeleccione una opción: ");
        System.out.println("\t1.-Crear Alumno.");
        System.out.println("\t2.-Crear Profesor.");
        System.out.println("\t3.-Crear Materia.");
        System.out.println("\t4.-Asignar grupos a las materias creadas");
        System.out.println("\t5.-Asignar Alumno a Grupo.");
        System.out.println("\t6.-Imprimir Alumnos.");
        System.out.println("\t7.-Imprimir Profesores.");
        System.out.println("\t8.-Imprimir Materias.");
        System.out.println("\t9.- Imprimir Grupos");
        System.out.println("\t10.- Salir. ");
        System.out.print("\t---> ");
        do{
            opc = sc.nextInt();
            if(opc < 1 || opc > 10)
                System.out.println("\tOpción incorrecta, asegurate de terminar la primaria antes de ejecutar el programa");
        }while(opc < 1 || opc > 10);
        System.out.println("  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*-*");
        return opc;
    }
}
