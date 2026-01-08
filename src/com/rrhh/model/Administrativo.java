/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rrhh.model;

/**
 *
 * @author Pavilion X360
 */
public class Administrativo extends Empleado{
    private String area;
    private int horasExtras;
    private double VALOR_HORA_EXTRA = 15000;

    public Administrativo() {
        super();
    }

    public Administrativo(String area, int horasExtras) {
        this.area = area;
        this.horasExtras = horasExtras;
    }

    public Administrativo(String area, int horasExtras, int id, String rut, String nombreCompleto, double sueldo) {
        super(id, rut, nombreCompleto, sueldo);
        this.area = area;
        this.horasExtras = horasExtras;
    }

    
    
    
       
    
    @Override
    public double calcularSueldo(){
        return this.getSueldo();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getVALOR_HORA_EXTRA() {
        return VALOR_HORA_EXTRA;
    }

    public void setVALOR_HORA_EXTRA(double VALOR_HORA_EXTRA) {
        this.VALOR_HORA_EXTRA = VALOR_HORA_EXTRA;
    }
    
    
    
    
    
    
}
