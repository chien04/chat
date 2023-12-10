package com.example.chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane dashboard = FXMLLoader.load(getClass().getResource("Controller.fxml"));
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(dashboard.getChildren());

        root.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            Node node = (Node) event.getTarget();
            node.requestFocus();
        });

//        root.getChildren().addAll(search.getChildren());
        Scene scene = new Scene(root, 350, 600);
        // scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm()).
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}