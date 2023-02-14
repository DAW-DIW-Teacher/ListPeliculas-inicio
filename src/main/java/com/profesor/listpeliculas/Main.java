package com.profesor.listpeliculas;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.IOException;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Main extends Application {
    private static final String MONGO_URI = "mongodb+srv://alumno:prueba01@cluster0.naobexy.mongodb.net/?retryWrites=true&w=majority";
    public static ObservableList<Pelicula>  listaPeliculas= FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Listado de peliculas");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        cargarDatos();
        launch();
    }

    private static void cargarDatos() {
        System.out.println("Cargando datos desde MongoDB");

        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase mDatabase = mClient.getDatabase("sample_mflix").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Pelicula> mCollection = mDatabase.getCollection("movies",Pelicula.class);

            mCollection.find().limit(10).into(listaPeliculas);

            System.out.println(listaPeliculas.get(0));

        } catch (Exception e) {
            System.out.println("ERROR: No se ha podido descargar la información de la base de datos");
        }
        System.out.println("Datos cargados en memoria");
    }
}