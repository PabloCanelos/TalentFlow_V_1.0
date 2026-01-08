/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rrhh.model;

/**
 *
 * @author Pavilion X360
 */
public class Operario extends  Empleado{
    
    private int metasAlcanzadas; // numero de tareas cumplidas
    private final double VALOR_NETO=25000; // lo que gana por cada meta

    public Operario() {
        super();
    }
    

    public Operario(int metasAlcanzadas) {
        this.metasAlcanzadas = metasAlcanzadas;
    }

    public Operario(int metasAlcanzadas, int id, String rut, String nombreCompleto, double sueldo) {
        super(id, rut, nombreCompleto, sueldo);
        this.metasAlcanzadas = metasAlcanzadas;
    }
       

    public int getMetasAlcanzadas() {
        return metasAlcanzadas;
    }

    public void setMetasAlcanzadas(int metasAlcanzadas) {
        this.metasAlcanzadas = metasAlcanzadas;
    }
    
    @Override
    public double calcularSueldo(){
        return this.getSueldo() + calcularBonoProduccion();
    }
    public double calcularBonoProduccion(){
        double total_bono= this.metasAlcanzadas * VALOR_NETO;
        return total_bono;
    }
    
    
}
