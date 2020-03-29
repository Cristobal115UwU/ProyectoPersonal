/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouno;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Calendar;
/**
 *
 * @author alber
 */
public class Grupo {
    private List<Alumno> alumnos = new ArrayList<>();
    private Profesor profe;
    private static int contadorGrupo=0;
    private Date hora; //EXTRA
    private int numGrupo;

    public Grupo(Profesor profe){
        setNumGrupo();
        setProfesor(profe);
    }
    
    private void setProfesor(Profesor elProfe){
        this.profe = elProfe;
    }
    
    public void setAlumnos(Alumno elAlumno){
        this.alumnos.add(elAlumno);
        System.out.println("\tHay "+this.alumnos.size()+" alumnos inscritos en el grupo");
    }
    private void setNumGrupo(){
        contadorGrupo++;
        this.numGrupo= contadorGrupo;
    }
    public Profesor getProfesor(){
        return this.profe;
    }

    public List<Alumno> getAlumnos(){
        return this.alumnos;
    }

    public int getNumGrupo(){
        return this.numGrupo;
    }
    public static Grupo crearGrupo(Profesor profe){
        Grupo gr = new Grupo(profe);
        return gr;
    }
}
