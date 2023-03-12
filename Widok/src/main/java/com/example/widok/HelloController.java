package com.example.widok;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.krypto.Key;

import java.util.Arrays;


public class HelloController {
    public Button keyGenerator;
    public TextField key;
    public TextArea plainText;
    public TextArea encryptedText;

    Key generator = new Key();

    public void setKey() {
        System.out.println(key.getText());
        String convert = Arrays.toString(generator.keyGenerator());
        key.setText(convert);
    }
}