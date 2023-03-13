package com.example.widok;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.krypto.AES;
import org.example.krypto.Key;

import java.util.Arrays;


public class HelloController {
    public Button keyGenerator;
    public TextField key;
    public TextArea tekst_zaszyfrowany;
    public TextArea tekst_jawny;
    Key generator = new Key();
    StringBuilder sb = new StringBuilder();
    public String converter(byte [] bytes){
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }

    public String getKey() {
        return key.getText();
    }

    public void setKey() {
//        String convert = Arrays.toString(generator.keyGenerator());
//        key.setText(convert);
      key.setText(converter(generator.keyGenerator()));
    }

    public String getTekst_zaszyfrowany() {
        return tekst_zaszyfrowany.getText();
    }

    public String getTekst_jawny() {
        return tekst_jawny.getText();
    }
    public void setEncrypt() {
        AES aes = new AES(getKey().getBytes());
        tekst_zaszyfrowany.setText(Arrays.toString(aes.divideBytesOn128bitsAndEncode(getTekst_jawny().getBytes())));
    }
    public void setDecrypt() {
        AES aes = new AES(getKey().getBytes());
        tekst_jawny.setText(Arrays.toString(aes.decode(getTekst_zaszyfrowany().getBytes())));
    }
}