package com.ucv.lab12;

import com.ucv.lab12.config.AppContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AppContext context = AppContext.getInstance();

        // Cambiamos la ruta para que cargue la interfaz de videojuegos
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/ucv/lab12/videojuego-view.fxml")
        );
        loader.setControllerFactory(context::getController);

        Scene scene = new Scene(loader.load(), 1150, 650);
        stage.setTitle("Mantenimiento de Videojuegos - Laboratorio 12 UCV");
        stage.setScene(scene);
        stage.setMinWidth(950);
        stage.setMinHeight(500);
        stage.show();
    }

    @Override
    public void stop() {
        AppContext.getInstance().destroy();
    }
}