package com.profesor.listpeliculas;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    public TilePane pane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for(Pelicula pelicula : Main.listaPeliculas){
            ImageView img = pelicula.getImagen();
            img.setFitHeight(170);
            img.setFitWidth(100);

            img.setOnMouseClicked(param->{

                FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("DetallePeli.fxml"));
                DetallePeliController controller =null;
                Scene scene = null;

                try {
                    Parent root = fxmlLoader.load();
                    scene = new Scene(root);
                    controller = fxmlLoader.getController();

                    controller.setDatos(pelicula);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                Stage stage = new Stage();
                stage.setTitle("Titulo de peliculas");
                stage.setScene(scene);
                stage.showAndWait();

            });

            this.pane.getChildren().add(img);
        }
        

    }

    public void handlerSelect(MouseEvent mouseEvent) throws IOException {
    

    }
}
