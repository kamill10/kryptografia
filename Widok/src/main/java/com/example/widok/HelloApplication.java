package com.example.widok;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.krypto.AES;
import org.example.krypto.Key;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Key key = new Key();
        byte [] klucz =key.keyGenerator();
      AES aes = new AES(klucz);
      byte [] arr = "dsadasdsa".getBytes();
      byte[] zakodowane = aes.divideBytesOn128bitsAndEncode(arr);
      byte[] tab = aes.divideOnBlocksAndDecode(aes.divideBytesOn128bitsAndEncode(arr));
        System.out.println(arr[1]);
        System.out.println(tab[1]);


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