
package com.rrhh.test;
import com.rrhh.model.Operario;
import com.rrhh.persistencia.EmpleadoDAO;
import com.rrhh.model.Empleado;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Pavilion X360
 */
public class TestSistema {
    public static void main(String[] args) {
    // 1. Crear el objeto y el DAO
    Operario op = new Operario(0, 20, "11555665-9", "pablo canelos", 450000); // Cambié el RUT para que no te dé error de duplicado
    EmpleadoDAO dao = new EmpleadoDAO();
    
    // 2. Intentar guardar
    System.out.println("Intentando guardar empleado...");
    boolean resultado = dao.guardarEmpleado(op);
    
    if(resultado){
        System.out.println("TEST exitoso: El operario se guardó en MySQL");
    } else {
        System.out.println("Test fallido: El empleado ya existe o hubo un error de conexión");
    }

    System.out.println("\n--- RECUPERANDO DATOS ---");

    // 3. Pedir la LISTA (aquí usamos el método que te costó armar)
    java.util.List<Empleado> lista = dao.listaEmpleados(); 

    // 4. Mostrar la lista
    if (lista.isEmpty()) {
        System.out.println("La lista está vacía.");
    } else {
        System.out.println("=== LISTA DE EMPLEADOS DESDE LA BASE DE DATOS ===");
        for (Empleado e : lista) {
            String tipo = (e instanceof Operario) ? "Operario" : "Administrativo";
            System.out.println("----------------------------------------------");
            System.out.println("RUT: " + e.getRut() + " | Nombre: " + e.getNombreCompleto());
            System.out.println("Tipo: " + tipo + " | Sueldo Líquido: $" + e.calcularSueldo());
        }
        System.out.println("----------------------------------------------");
        System.out.println("Total en sistema: " + lista.size());
    }
}

    
    
}
