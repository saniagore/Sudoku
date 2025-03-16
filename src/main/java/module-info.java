module com.example.sesion4 {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.sesion4 to javafx.graphics;
    exports com.example.sesion4.controller to javafx.fxml;
    exports com.example.sesion4.view;
    exports com.example.sesion4.model;

    // Abrir el paquete del controlador a javafx.fxml
    opens com.example.sesion4.controller to javafx.fxml;
}