// ClickerTest.java
// allows users to click a button that creates
// colored squares and keeps count of the squares
// can also reset the squares

package clickertest;

import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Grace
 */
public class ClickerTest extends Application {
    
    private int i;
    Label pointsLabel;
    Alert alert;
    
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    
    @Override
    public void start(Stage primaryStage) {
                
        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Button clicker = new Button();
        clicker.setText("Click me");
        clicker.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                drawSquare(gc);
                i++;
                pointsLabel.setText("Squares: " + i);
                
                if(i == 50){
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Stahp");
                    alert.setHeaderText(null);
                    alert.setContentText("Stahp clicking.");
           
                    alert.showAndWait();
                }
                
                if(i == 100){
                
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Stahp");
                    alert.setHeaderText(null);
                    alert.setContentText("Really. Stahp.");
                    
                    alert.showAndWait();   
                }
                
                if(i == 150){
                
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Stahp");
                    alert.setHeaderText(null);
                    alert.setContentText("You're wasting your life");
                    
                    alert.showAndWait();
                }
                
                if(i == 200){
                
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Stahp");
                    alert.setHeaderText(null);
                    alert.setContentText("Fine don't listen to me I give up");
                    
                    alert.showAndWait();
                }
            }
        });
        
        Button resetButton = new Button();
        resetButton.setText("reset");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                repaintCanvas(gc);
                i = 0; // to reset the square count
            }
        });
        
        pointsLabel = new Label("Squares: " + i);
        pointsLabel.setTranslateY(50);
        pointsLabel.setFont(new Font("Cambria", 15));
        
        StackPane root = new StackPane();
        Group group = new Group();
        
        Scene scene = new Scene(root);
        root.getChildren().add(canvas);
        root.getChildren().add(group);
        group.getChildren().add(clicker);
        group.getChildren().add(pointsLabel);
        resetButton.setLayoutX(250);
        resetButton.setLayoutY(5);
        group.getChildren().add(resetButton);
     
        primaryStage.setTitle("Clicking Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public int randomNumber(int max, int min){
            Random rnd = new Random();
            int randNum = rnd.nextInt(max - min) + min;
            return randNum;
    }
    
    public void drawSquare(GraphicsContext gc){
        Random rand = new Random();
        int r = randomNumber(590, 10);
        int r2 = randomNumber(590, 10);
        int rCol1 = rand.nextInt(256);
        int rCol2 = rand.nextInt(256);
        int rCol3 = rand.nextInt(256);
        gc.setFill(Color.rgb(rCol1, rCol2, rCol3));
        gc.fillRect(r, r2, 15, 15);
    }
    
    public void repaintCanvas(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 600, 600);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}
