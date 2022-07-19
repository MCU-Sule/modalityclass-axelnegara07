module com.example.pt03_2072029 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pt03_2072029 to javafx.fxml;
    exports com.example.pt03_2072029;
    exports com.example.pt03_2072029.Controller;
    exports com.example.pt03_2072029.Model;
    opens com.example.pt03_2072029.Controller to javafx.fxml;
}