
package com.rrhh.persistencia;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author Pavilion X360
 */
public class ConexionDAO {
    //atributo estatico, unica instancia de conexion
    private static Connection conn = null;
    // configuracion MYSQL
    private static final String URL ="jdbc:mysql://localhost:3306/talentflow_db";
    private static final String USER = "root";
    private static final String PASS = "";

    private ConexionDAO() {
    }
    public static Connection getConnection() throws SQLException{
        try {
            if(conn == null || conn.isClosed()){
                //carga driver. Class for name
                // Cargamos dinámicamente el Driver (traductor) de MySQL.
                // Class.forName busca la librería .jar en el proyecto y la registra
                // para que Java sepa cómo comunicarse con el motor de MySQL.
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL,USER,PASS);
                System.out.println("Conexion Singleton exitosa");
            }
        } catch (ClassNotFoundException e) {
            //Este error le pertenece a la línea Class.forName().
            System.out.println("ERROR: No se encontro el DRiver mySQL" + e.getMessage());
        }
        return conn;
    }
    
    //metodo opcional para cerrra conexion
    public static void closeConnection() throws SQLException{
        if(conn != null && !conn.isClosed()){
            conn.close();
            System.out.println("Conexion cerrada");
        }
    }
    
}
