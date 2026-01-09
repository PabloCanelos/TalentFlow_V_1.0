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

    private int horasExtras;
    private double VALOR_HORA_EXTRA = 15000;

    public Administrativo() {
        super();
    }

    public Administrativo( int horasExtras) {
            this.horasExtras = horasExtras;
    }

    public Administrativo( int horasExtras, int id, String rut, String nombreCompleto, double sueldo) {
        super(id, rut, nombreCompleto, sueldo);

        this.horasExtras = horasExtras;
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
         
    
    //METODO calcularHOraextra INTERNOS DE LA CLASE
    public double calcularMontoHorasExtra(){
        return this.horasExtras * VALOR_HORA_EXTRA;
             
    }
    
    //METODO HEREDADO
    @Override
    public double calcularSueldo(){
       double sueldo_bruto = this.getSueldo()+ calcularMontoHorasExtra();
        //descuento previsional y/o legal(salud,prevision) 20%
       double descuentos=sueldo_bruto *0.20;
       double sueldo_liquido = sueldo_bruto-descuentos;
       return sueldo_liquido;
    }
    
    
    
    
}
