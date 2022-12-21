package com.example.buttonapp2;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

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
        textField.setFont(Font.font(30));


        var btn = new Button("Hello");
        btn.setFont(Font.font(30));
        btn.disableProperty().bind(
                Bindings.createBooleanBinding(() -> !isValid(textField.getText()), textField.textProperty())
        );
        btn.setOnAction(e -> {
            System.out.println("Success! Translation correct.");
        });

        textField.textProperty().addListener((o, old, newString) -> {
            if ("world".equals(newString)) {
                btn.fire();
            }
            if ("你好".equals(newString)) {
                animate(btn);
            }
        });

        root.getChildren().addAll(textField, btn);

        return root;
    }

    private void animate(Node btn) {
        var st = new ScaleTransition(Duration.seconds(0.66), btn);
        st.setFromX(20);
        st.setFromY(20);
        st.setToX(0);
        st.setToY(0);
        st.setAutoReverse(true);
        st.setCycleCount(3);
        st.play();
    }

    private boolean isValid(String input) {
        return input.length() >= 5;
    }

    public static void main(String[] args) {
        launch(args);
    }
}