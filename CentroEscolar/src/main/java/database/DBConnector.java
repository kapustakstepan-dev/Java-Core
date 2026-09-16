package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    //BDConnector.conection
    private static Connection connection;


    //DBConection.getConnection -> connection
    public static Connection getConnection(){
        if (connection==null){
            createConnection();
        }
        return connection;
    }
    private static void createConnection(){
        String user = "root";
        String pass = "foximiliano";
        String host = "127.0.0.1";
        String dbname = "alumnos_ces";
        String urlConnection = String.format("jdbc:mysql://%s/%s",host, dbname);
        try {
            connection = DriverManager.getConnection(urlConnection, user, pass);
        } catch (SQLException e) {
            System.out.println("Error en SQL");
            System.out.println(e.getMessage());
        }
    }
    public static void closeConnection(){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error en el cerrado de SQL");
            }
        }
    }
}
