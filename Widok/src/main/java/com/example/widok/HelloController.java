package com.example.widok;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.example.krypto.AES;
import org.example.krypto.Key;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


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
    public void zapis_do_pliku() {
        FileChooser fileChooser = new FileChooser();

        // Set the title of the file chooser dialog
        fileChooser.setTitle("Save File");

        // Set the initial directory of the file chooser dialog
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // Set the file extension filters for the file chooser dialog
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));

        // Show the save dialog to the user
        File fileToSave = fileChooser.showSaveDialog(Scene.getStage());

        if (fileToSave != null) {
            try {
                // Create a BufferedWriter object to write data to the file
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave));

                // Write some data to the file
                writer.write(tekst_zaszyfrowany.getText());

                // Close the writer
                writer.close();

                System.out.println("File saved successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Save command cancelled by user.");
        }
    }
}