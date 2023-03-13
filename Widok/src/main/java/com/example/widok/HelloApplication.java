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
import java.math.BigInteger;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        byte[] asciiArray = new byte [16];
        for(int i =0; i<16; i++){
            asciiArray[i]= (byte)97;
        }
        Key key = new Key();
        byte [] klucz =key.keyGenerator();
        AES aes = new AES(asciiArray);
        byte [] arr = "ab".getBytes();
        System.out.println("tablica bajtow przed zakodowaniem");
        String str = new String(arr, StandardCharsets.UTF_8);
        System.out.println(str);
        System.out.println(arr[0]);
        byte[] zakodowane = aes.divideBytesOn128bitsAndEncode(arr);
        String kod = new String(zakodowane, StandardCharsets.UTF_8);
        System.out.println("Zakodowana czesc");
        System.out.println(kod);
        System.out.println(zakodowane[0]);
        System.out.println(zakodowane[1]);
        System.out.println(zakodowane[15]);
        System.out.println("Wynik w tablicy bajtow jaki powinien wyjsc przy kodowaniu");
        String hexString = "5322bb7ff70dc0d6a5a14a5331da93cf";
        byte[] byteArray = new BigInteger(hexString, 16).toByteArray();
        String kod3 = new String(byteArray, StandardCharsets.UTF_8);
        System.out.println(kod3);
        byte[] tab = aes.decode(zakodowane);
        System.out.println("odkodowane");
        String kod4 = new String(tab, StandardCharsets.UTF_8);
        System.out.println(kod4);



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