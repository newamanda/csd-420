//Amanda New
//CSD420-A311
//Module 1.2: Card Shuffler

package com.example;

//import java packages
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CardShuffle extends Application {

    //create hbox for dispaying cards 
    private void displayRandomCards(HBox hBox) {

        //create list of card files
        List<String> cardFiles = new ArrayList<>();
        for (int i = 1; i <=51; i++) {
            cardFiles.add(i + ".png");
        }

        //shuffle card files for random number
        Collections.shuffle(cardFiles);

        //clear hbox 
        hBox.getChildren().clear();

        //create list of images
        for (int i=0; i < 4; i++) {
            String cardFile = cardFiles.get(i);
            Image image = new Image("file:cards/" + cardFile);
            ImageView imageView = new ImageView(image);
            hBox.getChildren().add(imageView);
        }
    }

    @Override
    //stage scene styling
    public void start(Stage primaryStage) {
        HBox cardDisplay = new HBox(10);

        VBox root = new VBox(20);
        root.setStyle("-fx-padding: 30;");

        //refresh button
        Button refreshButton = new Button ("Refresh");
        //lamda expression for button action
        refreshButton.setOnAction((event -> displayRandomCards(cardDisplay)));
        
        //display items
        displayRandomCards(cardDisplay);
        root.getChildren().add(cardDisplay);
        root.getChildren().add(refreshButton);

        //set scene parameters
        Scene scene = new Scene(root, 500, 300);

        //scene title and display
        primaryStage.setTitle("Card Shuffle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //main method
    public static void main(String[] args) {
        launch(args);
    }
}