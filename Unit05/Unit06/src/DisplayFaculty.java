/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2017
 * Instructor: Dave Busse
 * Description: Unit 06 Lab
 * Date: 11/15/2017
 * @author Boobin Choi
 * @version 1.0
 *
 * By turning in this code, I Pledge:
 *  1. That I have completed the programming assignment independently.
 *  2. I have not copied the code from a student or any source.
 *  3. I have not given my code to any student.
 *
 */

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class DisplayFaculty extends Application {
       
    private BorderPane pane = new BorderPane();
    private BorderPane pane2 = new BorderPane();
    private TextArea tArea = new TextArea();
    private Label cLabel = new Label();
    private Label nsLabel = new Label();
    
    private int numFaculty = 0;    
    private String databaseName = null;
    
    private Statement queryStatement;
    
    @Override
    public void start(Stage primaryStage) {        
        
        Scene scene = new Scene(new VBox(), 400, 260);
        
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane2.setPadding(new Insets(20, 10, 10, 10));
        
        cLabel.setText("Not Connected");
        nsLabel.setText("Number of Faculty = " + numFaculty);        
     
        pane2.setLeft(cLabel);
        pane2.setRight(nsLabel);
        
        pane.setTop(tArea);
        pane.setBottom(pane2);
        
        MenuBar menuBar = new MenuBar();        
        Menu menuFile = new Menu("File");        
        
        MenuItem connect = new MenuItem("Connect");
        connect.setOnAction((ActionEvent t) -> {
            try {
                initializeDB(cLabel);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        });                
        
        MenuItem close = new MenuItem("Close");
        close.setOnAction((ActionEvent t) -> {
            try {
                userConfirmsClose(cLabel);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }           
        });
        
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> {
            System.exit(0);
        });
        menuFile.getItems().addAll(connect, close, exit);        
        
        Menu menuEdit = new Menu("Edit");
        
        MenuItem search = new MenuItem("Search");
        search.setOnAction((ActionEvent t) -> {
            try{
                searchDB(tArea);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        });
        
        MenuItem clear = new MenuItem("Clear");
        clear.setOnAction((ActionEvent t) -> {
            tArea.clear();
            numFaculty = 0;
            nsLabel.setText("Number of Faculty = " + numFaculty);
        });
        menuEdit.getItems().addAll(search, clear);        
        menuBar.getMenus().addAll(menuFile, menuEdit);
        
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, pane);
        
        primaryStage.setTitle("Display Faculty");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void initializeDB(Label label) throws SQLException, ClassNotFoundException {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Database Input Dialog");
        dialog.setContentText("Please enter the database name:");
        
        Optional<String> result = dialog.showAndWait();
        try {
            databaseName = result.get();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" +result.get()+ "?autoReconnect=true&useSSL=false", "scott", "tiger");
            label.setText("Connected to " + databaseName);           
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Database not found");
            databaseName = null;
            alert.showAndWait();
            ex.printStackTrace();           
        }                 
    }
    
    public void userConfirmsClose(Label label){
        
        try {                      
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" +databaseName+ "?autoReconnect=true&useSSL=false", "scott", "tiger");
            label.setText("Not connected");
            databaseName = null;
            System.out.print("Connection close");           
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("You are not connected");            
            alert.showAndWait();
            ex.printStackTrace();            
        }
    }
    
    public void searchDB(TextArea tArea) throws SQLException, ClassNotFoundException {
        if (databaseName != null) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Faculty");
            dialog.setHeaderText("Faculty Members");
            dialog.setContentText("Please enter Faculty ssn number follwing by %");
            
            Optional<String> search_id = dialog.showAndWait();
            
            try {                
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" +databaseName+ "?autoReconnect=true&useSSL=false", "scott", "tiger");
                queryStatement = connection.createStatement();
                String queryString = "select ssn, firstName, lastName, phone from Faculty where ssn like '" +search_id.get()+ "';";
                ResultSet resultSet = queryStatement.executeQuery(queryString);
                ResultSetMetaData rsmData = resultSet.getMetaData();
                for (int i=1; i<=rsmData.getColumnCount(); i++) {
                    tArea.appendText(rsmData.getColumnName(i) +"              ");
                }
                tArea.appendText("\n");
                while (resultSet.next()) {
                    for (int i=1; i<=rsmData.getColumnCount(); i++) {
                        tArea.appendText(resultSet.getObject(i) +"    ");
                    }
                    tArea.appendText("\n");
                }
                resultSet.last();
                nsLabel.setText("Number of Faculty = " + resultSet.getRow());
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
