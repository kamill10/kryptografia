package com.example.widok;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.krypto.AES;
import org.example.krypto.Key;


public class HelloController {
    public Button keyGenerator;
    public TextField key;
    public TextArea tekst_zaszyfrowany;
    public TextArea tekst_jawny;
    Key generator = new Key();
    private byte [] arr;

    public String converter(byte [] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }

    public String getKey() {
        return key.getText();
    }

    public void setKey() {
        key.setText(converter(generator.keyGenerator()));
    }

    public String getTekst_jawny() {
        return tekst_jawny.getText();
    }
    public void setEncrypt() {
        AES aes = new AES(getKey().getBytes());
        arr = aes.divideBytesOn128bitsAndEncode(getTekst_jawny().getBytes());
        tekst_zaszyfrowany.setText(converter(arr));
    }
    public void setDecrypt() {
        AES aes = new AES(getKey().getBytes());
        byte[] decrypt = aes.decode(arr);
        tekst_jawny.clear();
        tekst_jawny.setText(new String(decrypt));
    }
}