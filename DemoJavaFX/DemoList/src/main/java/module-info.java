module com.example.demolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demolist to javafx.fxml;
    exports com.example.demolist;
}