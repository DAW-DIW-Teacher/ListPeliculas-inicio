module com.profesor.listpeliculas {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;


    opens com.profesor.listpeliculas to javafx.fxml;
    exports com.profesor.listpeliculas;
}