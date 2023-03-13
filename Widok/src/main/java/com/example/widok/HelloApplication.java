package com.example.widok;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.krypto.AES;
import org.example.krypto.Key;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Key key = new Key();
        byte [] klucz =key.keyGenerator();
        AES aes = new AES(klucz);
        byte [] arr = "dsgbhjkjhaaaa".getBytes();
        String str = new String(arr, StandardCharsets.UTF_8);
        System.out.println(str);
        byte[] zakodowane = aes.divideBytesOn128bitsAndEncode(arr);
        String kod = new String(zakodowane, StandardCharsets.UTF_8);
        System.out.println("Zakodowana czesc");
        System.out.println(kod);
        byte[] tab = aes.decode(zakodowane);
        System.out.println("odkodowana czesc");
        String str2 = new String(tab);
        System.out.println(str2);

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