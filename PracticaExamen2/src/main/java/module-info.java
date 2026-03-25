module com.example.practicaexamen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicaexamen to javafx.fxml;
    opens com.example.practicaexamen.controllers to javafx.fxml;
    opens com.example.practicaexamen.model to javafx.fxml;
    opens com.example.practicaexamen.services to javafx.fxml;

    exports com.example.practicaexamen;
}