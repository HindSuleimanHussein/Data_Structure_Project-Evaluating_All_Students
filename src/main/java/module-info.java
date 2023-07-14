module com.example.firstdatastructureproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.firstdatastructureproject to javafx.fxml;
    exports com.example.firstdatastructureproject;
}