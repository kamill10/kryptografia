module com.example.widok {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.widok to javafx.fxml;
    exports com.example.widok;
}