package ci.pigier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() { 
        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "sakila";
        String password = "p_ssW0rd";
        
        Connection connection = null; 
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion à la base de données établie avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            
        }
        return connection;
    }
}