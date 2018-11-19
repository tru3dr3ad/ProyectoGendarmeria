package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String cadena="jdbc:oracle:thin:@localhost:1521:XE";
    private Connection cone;

    public Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cone= DriverManager.getConnection(cadena, "GENDARMERIA","123");
        } catch (Exception e) {
            System.out.println("Error Conexion: "+e.getMessage());
        }
    }
    public Connection ObtenerConexion(){
        return cone;
    }
}
