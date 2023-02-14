package com.profesor.listpeliculas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DetallePeliController {

    public ListView genresListView;
    @FXML
    private ImageView inputImagen;

    @FXML
    private TextArea inputPlot;

    @FXML
    private TextField inputTitulo;

    @FXML
    private TextField inputYear;

    @FXML
    void handlerCerrar(ActionEvent event) {
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();

    }

    public void setDatos (Pelicula peli) {
        inputTitulo.setText(peli.getTitle());
        inputPlot.setText(peli.getPlot());
        inputYear.setText(Integer.toString(peli.getYear()));
        inputImagen.setImage(peli.getImagen().getImage());



        this.genresListView.setItems(FXCollections.observableArrayList(peli.getGenres()));
    }

}