module com.example.humansvsgoblinsgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.gamegui to javafx.fxml;
    exports com.example.gamegui;
    exports misc;
    opens misc to javafx.fxml;
}