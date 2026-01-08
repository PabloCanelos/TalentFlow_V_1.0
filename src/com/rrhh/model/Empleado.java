
package com.rrhh.model;

/**
 *
 * @author Pavilion X360
 */
public abstract class Empleado {
    private int id;
    private String rut;
    private String nombreCompleto;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(int id, String rut, String nombreCompleto, double sueldo) {
        this.id = id;
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    //METODO ABSTRACTO PARA CALCULAR SUELDO
    public abstract double calcularSueldo();
    
}
