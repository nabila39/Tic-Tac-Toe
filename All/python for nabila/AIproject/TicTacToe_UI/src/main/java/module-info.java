module com.example.tictactoe_ui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.tictactoe_ui to javafx.fxml;
    exports com.example.tictactoe_ui;
}