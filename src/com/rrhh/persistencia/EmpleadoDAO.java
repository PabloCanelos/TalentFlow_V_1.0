
package com.rrhh.persistencia;
import com.rrhh.model.Empleado;
import com.rrhh.model.Operario;
import com.rrhh.model.Administrativo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Pablo Canelos
 */
public class EmpleadoDAO {
    
    public boolean agregarNuevoEmpleado(Empleado emp) throws SQLException{
        String query = "INSERT INTO empleados (rut, nombre_completo, sueldo_base, tipo_empleado, metas_alcanzadas, horas_extra) VALUES(?,?,?,?,?,?)";
        Connection cn = ConexionDAO.getConnection();
        try(PreparedStatement ps= cn.prepareStatement(query);) {
            
            ps.setString(1, emp.getRut() );
            ps.setString(2, emp.getNombreCompleto());
            ps.setDouble(3, emp.getSueldo());
            
            if(emp instanceof Operario op){
                ps.setString(4, "operario");
                ps.setInt(5, ((Operario) emp).getMetasAlcanzadas());
                ps.setNull(6, java.sql.Types.INTEGER);
            } else if(emp instanceof Administrativo admin){
                ps.setString(4, "administrativo");
                ps.setNull(5, java.sql.Types.INTEGER);
                ps.setInt(6, admin.getHorasExtras());
                
            }
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;         
            
        } catch (Exception e) {
            System.out.println("ERROR" + e.getMessage());
            return false;
        }
        
    }
            
                       
            
    public List<Empleado> listaEmpleados()throws Exception{
        List<Empleado> lista = new ArrayList<>();
        String query = "SELECT * FROM empleados";
        Connection cn = ConexionDAO.getConnection();
        
        try(PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            
            while(rs.next()){
                //datos comunes de empleado
                int id = rs.getInt("id");
                String rut = rs.getString("rut");
                String nombre= rs.getString("nombre_completo");
                double sueldo = rs.getDouble("sueldo_base");
                String tipo = rs.getString("tipo_empleado");
                
                Empleado emp = null;
                //segun el string creamos el hjo correcto
                if(tipo.equalsIgnoreCase("operario")){
                    int metas = rs.getInt("metas_alcanzadas");
                    emp = new Operario(id,rut, nombre, sueldo, metas);
                }
                
                
            }
            
            
        } catch (Exception e) {
        }
    
    
    
    
    
    }
    
}