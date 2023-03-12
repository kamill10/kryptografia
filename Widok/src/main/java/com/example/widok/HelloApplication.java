package com.example.widok;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.krypto.AES;
import org.example.krypto.Key;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Key key = new Key();
      AES aes = new AES(key.keyGenerator());
      aes.divideBytesOn128bits("dsadas".getBytes());


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ZADANIE 1 KRYPTOGRAFIA");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}