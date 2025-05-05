//Amanda New
//CSD420-A311
//Module 7
//Circles

package com.example;

//javafx imports
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * JavaFX App
 */

public class New_Circle extends Application {

    @Override

    public void start(Stage primaryStage) {

        //setup rectangle border for first circle
        Rectangle border = new Rectangle(20,20,40,200);
        border.setId("border");

        //1st circle
        Circle circle1 = new Circle(25);
        circle1.setId("circle1");

        //align circle with rectangle border
        StackPane circleBorder = new StackPane();
        circleBorder.getChildren().addAll(border, circle1);

        //circle 2
        Circle circle2 = new Circle(25);
        circle2.setId("blank-circle");
        
        //circle 3
        Circle circle3 = new Circle(25);
        circle3.setId("red");

        //circle 4
        Circle circle4 = new Circle(25);
        circle4.setId("green");

        //layout circles horizonally
        HBox layout = new HBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(circleBorder, circle2, circle3, circle4);

        //get scenes.css file data to display 
        Scene scene = new Scene(layout, 300, 250);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        //pop-up results
        primaryStage.setTitle("Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // main method 
    public static void main(String[] args) {
        launch(args);
    }
}