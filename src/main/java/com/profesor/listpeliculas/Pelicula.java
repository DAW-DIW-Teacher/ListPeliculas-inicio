package com.profesor.listpeliculas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class Pelicula {
    private String plot;
    private Integer year;
    private String title;
    private String poster;
    private ImageView imagen = new ImageView();
    private List<String> genres;



    private String type;

    public ImageView getImagen() {
        try {
            this.imagen.setFitWidth(50);
            this.imagen.setFitHeight(70);
            if (!(this.poster == null)) {
                Image img = new Image(this.poster);
                this.imagen.setImage(img);
            } else {
                Image img = new Image(getClass().getResource("img/default.png").toExternalForm());
                this.imagen.setImage(img);
            }

        } catch ( Exception e) {
            System.out.println("Error al cargar la imagen");
        }

        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "plot='" + plot + '\'' +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", genres=" + genres +
                ", type='" + type + '\'' +
                '}';
    }
}
