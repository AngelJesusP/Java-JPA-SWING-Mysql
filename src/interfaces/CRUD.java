/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author angel
 */
import entity.Empleado;
import java.util.List;
public interface CRUD {
    
    public boolean setAgregarEmpleado(int cedula, String nombre, String apellido, double sueldo);
    public List<Empleado> getListarEmpleado();
    public boolean setActualizarEmpleado(int cedula, String nombre, String apellido, double sueldo);
    public boolean setEliminarEmpleado(int cedula);
    public Empleado getBuscarEmpleado(int cedula);
}
