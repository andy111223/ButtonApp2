package com.example.buttonappka;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();

    }

    private Parent createContent() {
        var root = new VBox();
        root.setPrefSize(800, 600);

        var textField = new TextField();
        textField.setFont(Font.font(36));

        var btn = new Button("Click");
        btn.disableProperty().bind(
                Bindings.createBooleanBinding(() -> !isValid(textField.getText()), textField.textProperty())
        );
        btn.setOnAction(e -> {
            System.out.println("Clicked!");
        });



        root.getChildren().addAll(textField, btn);

        return root;
    }

    private boolean isValid(String input) {
        return input.length() >= 5;
    }

    public static void main(String[] args) {
        launch(args);
    }
}