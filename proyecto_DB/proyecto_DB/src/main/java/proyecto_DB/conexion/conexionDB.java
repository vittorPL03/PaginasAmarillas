package proyecto_DB.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionDB {

    static void main(String[] args) {

        var base = "db_prueba";
        var url= "jdbc:mysql://localhost:3306/"+base;
        var user= "Victor";
        var password = "Ilove110329";

        try {

            System.out.println("Iniciando conexion con base de datos: "+ url);

            Connection miConexion= DriverManager.getConnection(url, user, password);

            System.out.println("Coneccion a la base de datos, exitosa");

        }catch (Exception e){
            System.out.println("Error en la conexion con la base de datos: " + e);
            //e.printStackTrace();
        }
    }
}
