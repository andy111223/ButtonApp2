module com.example.buttonapp2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buttonapp2 to javafx.fxml;
    exports com.example.buttonapp2;
}