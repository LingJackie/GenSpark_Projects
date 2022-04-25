module com.example.humansvsgoblinsgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.humansvsgoblinsgui to javafx.fxml;
    exports com.example.humansvsgoblinsgui;
}