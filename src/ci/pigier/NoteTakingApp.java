package ci.pigier;

import java.sql.Connection;
import java.sql.SQLException;

import ci.pigier.ui.FXMLPage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class NoteTakingApp extends Application {

    private static Connection connection;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(FXMLPage.LIST.getPage());
        
        Scene scene = new Scene(root);
     
        stage.setScene(scene);
        stage.setTitle("P'Note-Taking Application v1.0.0");
        stage.setResizable(false);
        stage.show();
    }
    
    @Override
    public void init() throws Exception {
        connection = DatabaseConnection.getConnection();
        if (connection == null) {
            throw new RuntimeException("Unable to establish a database connection.");
        }
    }
    
    @Override
    public void stop() throws Exception {
        if (connection != null) {
            connection.close();
            System.out.println("Connexion fermée avec succès.");
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
