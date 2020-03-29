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
                case 1:       
                    inscribir.agregarAlumno(Alumno.crearAlumno());
                    break;
                case 2://Crear profesores.
                    inscribir.agregarProf(Profesor.crearProfesor());
                    break;
                case 3://Crear materias.
                    inscribir.agregarMateria();
                    break;
                case 4: //Crear grupo
                    //imprimir materias y cachar la materia a crear grupo
                    Materia laMateria = inscribir.cachaMaterias();
                    //imprimir profes y cachar el profe
                    Profesor profe = inscribir.cachaProfe();
                    Grupo aux = Grupo.crearGrupo(profe);
                    inscribir.relacionGrupoMaterias.put(aux.getNumGrupo(), laMateria);
                    inscribir.agregarGrupo(aux);
                    break;
                case 5: //Asignar alumno a grupo.
                    Alumno alu = inscribir.cachaAlumnos();
                    Grupo gpi = inscribir.cachaGrupo(alu);
                    alu.setGrupo(gpi);
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
                    System.out.println("HASTA LA PROXIMAA TUNNNNNNN PIN PIN PIN PIN PI TUNNNNNNN! :)");
                    break;                            
            }
        }while(!meSalgo);
        
    }

    static int menu(){
        Scanner sc = new Scanner(System.in);
        int opc;
        System.out.println("Bienvenido al Sistema de inscripciones "+" 2020-2");
        System.out.println("---MENU---");
        System.out.println("Seleccione una opción: ");
        System.out.println("1.-Crear Alumno.");
        System.out.println("2.-Crear Profesor.");
        System.out.println("3.-Crear Materia.");
        System.out.println("4.-Asignar un grupo a las materias creadas");
        System.out.println("5.-Asignar Alumno a Grupo.");
        System.out.println("6.-Imprimir Alumnos.");
        System.out.println("7.-Imprimir Profesores.");
        System.out.println("8.-Imprimir Materias.");
        System.out.println("9.- Imprimir Grupos");
        System.out.println("10.- Salir.");
        do{
            opc = sc.nextInt();
            if(opc < 1 || opc > 10)
                System.out.println("Opción incorrecta, asegurate de terminar la primaria antes de ejecutar el programa");
        }while(opc < 1 || opc > 10);
    return opc;
    }
    /*CUANDO ESTA MADRRE COMPILE
░░░░░▓▓▓▓▓▓▓▓▓▓▓░░░░░░░░
░░░▓▓▓▓▓▓▒▒▒▒▒▒▓▓░░░░░░░
░░▓▓▓▓▒░░▒▒▓▓▒▒▓▓▓▓░░░░░
░▓▓▓▓▒░░▓▓▓▒▄▓░▒▄▄▄▓░░░░
▓▓▓▓▓▒░░▒▀▀▀▀▒░▄░▄▒▓▓░░░
▓▓▓▓▓▒░░▒▒▒▒▒▓▒▀▒▀▒▓▒▓░░
▓▓▓▓▓▒▒░░░▒▒▒░░▄▀▀▀▄▓▒▓░
▓▓▓▓▓▓▒▒░░░▒▒▓▀▄▄▄▄▓▒▒▒▓
░▓█▀▄▒▓▒▒░░░▒▒░░▀▀▀▒▒▒▒░
░░▓█▒▒▄▒▒▒▒▒▒▒░░▒▒▒▒▒▒▓░
░░░▓▓▓▓▒▒▒▒▒▒▒▒░░░▒▒▒▓▓░
░░░░░▓▓▒░░▒▒▒▒▒▒▒▒▒▒▒▓▓░
░░░░░░▓▒▒░░░░▒▒▒▒▒▒▒▓▓░░
*/
}
