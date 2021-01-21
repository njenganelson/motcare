package com.motcare;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Start extends Application {
    int counter = 1;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Learning FX");

        Label nameLabel = new Label("Loading.....");

        Button loadButton = new Button("CLICK TO LOAD");
        loadButton.setStyle("-fx-background-color:#00ff0080;" +
                "-fx-padding: 10;\n" +
                "-fx-spacing: 10;\n" +
                "-fx-alignment: center;\n" +
                "-fx-font-size: 13;");
        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    nameLabel.setText("Loading......"+counter++);
                    if(counter==6){
                        nameLabel.setText("Unable to Load");
                        loadButton.setText("EXIT..");
                        loadButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                Platform.exit();
                            }
                        });
                    }
                }
        });

        VBox box = new VBox(nameLabel,loadButton);
        box.setAlignment(Pos.CENTER);


        Scene scene = new Scene(box,500,500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
