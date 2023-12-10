package com.example.chat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ScrollPane chat;
    @FXML
    private TextField textMessage;
    @FXML
    private VBox vBox;
    @FXML private ImageView pictureWhite, pictureGreen, sendWhite, sendGreen;

    public void clickSendGreen() {
        String text = textMessage.getText();
        if(text.isEmpty()) return;
        addMyMessage(text);
        addOtherMessage("Hello");
        textMessage.setText("");
        chat.setVvalue(1.0);
    }

    private void addOtherMessage(String text){
        Label label = new Label(text);
        label.setFont(new Font(18));
        label.setWrapText(true);
        label.setMaxWidth(195);
        label.setMinWidth(195);
        label.setAlignment(Pos.CENTER_LEFT);
        label.setTextFill(Paint.valueOf("#FFFFFF"));
        AnchorPane anchorPane = new AnchorPane(label);
        anchorPane.setStyle("-fx-border-radius: 0 8 8 8;" +
                "-fx-background-radius: 0 8 8 8;" +
                "-fx-background-color: #EC407A;");
        anchorPane.setPrefWidth(195);
        anchorPane.setMaxWidth(195);
        AnchorPane anchorPane1 = new AnchorPane(anchorPane);
        vBox.getChildren().add(anchorPane1);
        chat.setContent(vBox);
        chat.setVvalue(1.0);
    }

    private void addMyMessage(String text) {
        Label label = new Label(text);
        label.setFont(new Font(18));
        label.setWrapText(true);
        label.setMaxWidth(195);
        label.setMinWidth(195);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setTextFill(Paint.valueOf("#FFFFFF"));
        AnchorPane anchorPane = new AnchorPane(label);
        anchorPane.setStyle("-fx-border-radius: 8 0 8 8;" +
                "-fx-background-radius: 8 0 8 8;" +
                "-fx-background-color: #AB47BC;");
        anchorPane.setPrefWidth(195);
        anchorPane.setMaxWidth(195);
        anchorPane.setLayoutX(125);
        AnchorPane anchorPane1 = new AnchorPane(anchorPane);
        vBox.getChildren().add(anchorPane1);
        chat.setContent(vBox);
        chat.setVvalue(1.0);
    }

    public void displayPictureGreen(){
        pictureGreen.setVisible(true);
        pictureWhite.setVisible(false);
    }
    public void displayPictureWhite(){
        pictureWhite.setVisible(true);
        pictureGreen.setVisible(false);
    }

    public void displaySendGreen(){
        sendGreen.setVisible(true);
        sendWhite.setVisible(false);
    }

    public void displaySendWhite(){
        sendWhite.setVisible(true);
        sendGreen.setVisible(false);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pictureWhite.setVisible(true);
        pictureGreen.setVisible(false);
        sendWhite.setVisible(true);
        sendGreen.setVisible(false);
        vBox.heightProperty().addListener((ChangeListener) (observable, oldvalue, newValue) -> chat.setVvalue((Double)newValue ));
        vBox.setSpacing(8);
    }
}
