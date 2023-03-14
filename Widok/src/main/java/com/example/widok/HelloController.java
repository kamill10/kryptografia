package com.example.widok;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.example.krypto.AES;
import org.example.krypto.Key;

import java.io.*;


public class HelloController {
    public Button keyGenerator;
    public TextField key;
    public TextField text;
    public TextField tekst_zaszyfrowany;
    public TextField tekst_jawny;
    public Button jawny;
    public Button szyfr;
    public Button klucz;
    Key generator = new Key();
    private byte [] arr;

    public String converter(byte [] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }
    public void setText(TextField text) {
        this.text = text;
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
        fileChooser.setTitle("Zapis do pliku");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.*"));
        File fileToSave = fileChooser.showSaveDialog(Scene.getStage());
        if (fileToSave != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave));
                writer.write(text.getText());
                writer.close();
                System.out.println("Zapisano pomyślnie!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Zapis został przerwany");
        }
    }
    public StringBuilder odczyt_z_pliku() {
        StringBuilder fileContents = new StringBuilder();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Odczyt z pliku");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.*"));
        File loadFile = fileChooser.showOpenDialog(Scene.getStage());
        if (loadFile != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(loadFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContents.append(line);
                    fileContents.append(System.lineSeparator());
                }
                reader.close();

                System.out.println("Odczytano pomyślnie!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Odczyt został przerwany");
        }
        return fileContents;
    }
    public void saveKey() {
        setText(key);
        zapis_do_pliku();
    }
    public void saveTextJ() {
        setText(tekst_jawny);
        zapis_do_pliku();
    }
    public void saveTextZ() {
        setText(tekst_zaszyfrowany);
        zapis_do_pliku();
    }
    public void loadKey() {
        key.setText(odczyt_z_pliku().toString());
    }
    public void loadTextJ() {
        tekst_jawny.setText(odczyt_z_pliku().toString());
    }
    public void loadTextZ() {
        tekst_zaszyfrowany.setText(odczyt_z_pliku().toString());
    }
}