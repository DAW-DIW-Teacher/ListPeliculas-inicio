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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public TableView<Pelicula> tablaPeliculas;
    public TableColumn <Pelicula, ImageView> colPoster;
    public TableColumn<Pelicula,String> colTitulo;
    public TableColumn<Pelicula,Integer> colYear;
    public TableColumn<Pelicula,String> colType;
    public TableColumn colGenre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colPoster.setCellValueFactory(new PropertyValueFactory<>("imagen"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));


        tablaPeliculas.setItems(Main.listaPeliculas);


    }

    public void handlerSelect(MouseEvent mouseEvent) throws IOException {
        int numeroFila  = tablaPeliculas.getSelectionModel().getSelectedIndex();

        if (numeroFila >= 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("DetallePeli.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            DetallePeliController controlador = fxmlLoader.getController();
            controlador.setDatos(tablaPeliculas.getSelectionModel().getSelectedItem());
            Stage st = new Stage();
            st.setTitle("Detalle de peliculas");
            st.setScene(scene);
            st.showAndWait();
        }


    }
}
