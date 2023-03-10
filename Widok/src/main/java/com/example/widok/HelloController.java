package com.example.widok;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;


public class HelloController {
    public Button keyGenerator;
    public TextField key;

    public byte[] keyGenerator() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);
        return key;
    }
    public void setKey() {
        String convert = String.valueOf(new BigInteger(keyGenerator()));
        key.setText(convert);
    }
}