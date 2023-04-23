module com.example.clock {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;


    opens com.example.clock to javafx.fxml;
    exports com.example.clock;
}