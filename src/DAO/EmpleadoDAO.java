/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controlador.EmpleadoJpaController;
import entity.Empleado;
import interfaces.CRUD;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author angel
 */
public class EmpleadoDAO implements CRUD {

    private Empleado empleado = new Empleado();
    private EmpleadoJpaController controlador = new EmpleadoJpaController();

    @Override
    public boolean setAgregarEmpleado(int cedula, String nombre, String apellido, double sueldo) {
        try {
            this.empleado.setCedula(cedula);
            this.empleado.setNombre(nombre);
            this.empleado.setApellido(apellido);
            this.empleado.setSueldo(sueldo);
            Date fecha = new Date();
            Timestamp timestamp = new Timestamp(fecha.getTime());
            Timestamp myTimeStamp = timestamp;
            this.empleado.setFechaContratacion(myTimeStamp);
            this.controlador.create(empleado);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Empleado> getListarEmpleado() {
        List<Empleado> lista = this.controlador.findEmpleadoEntities();
        return lista;
    }

    @Override
    public boolean setActualizarEmpleado(int cedula, String nombre, String apellido, double sueldo) {
        try {
            this.empleado.setCedula(cedula);
            this.empleado.setNombre(nombre);
            this.empleado.setApellido(apellido);
            this.empleado.setSueldo(sueldo);
            Date fecha = new Date();
            Timestamp timestamp = new Timestamp(fecha.getTime());
            Timestamp myTimeStamp = timestamp;
            this.empleado.setFechaContratacion(myTimeStamp);
            this.controlador.edit(empleado);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean setEliminarEmpleado(int cedula) {
        try {
            this.controlador.destroy(cedula);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Empleado getBuscarEmpleado(int cedula) {
        this.empleado = this.controlador.findEmpleado(cedula);
        return this.empleado;
    }

}
