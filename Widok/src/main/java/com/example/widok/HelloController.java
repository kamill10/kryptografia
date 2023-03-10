package com.example.widok;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.krypto.Key;

import java.math.BigInteger;
import java.security.SecureRandom;


public class HelloController {
    public Button keyGenerator;
    public TextField key;
    Key generator = new Key();

    public void setKey() {
        String convert = String.valueOf(new BigInteger(generator.keyGenerator()));
        key.setText(convert);
    }
}