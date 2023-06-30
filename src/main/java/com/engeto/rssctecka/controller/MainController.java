package com.engeto.rssctecka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@RestController
public class MainController {

    @GetMapping("/scifi")
    public String getScifi() throws FileNotFoundException {
        return importFromFile("scifi.txt");
    }

    @GetMapping("/romantic")
    public String getRomantic() throws FileNotFoundException {
        return importFromFile("romantic.txt");
    }

    @GetMapping("/historic")
    public String getHistoric() throws FileNotFoundException {
        return importFromFile("historic.txt");
    }

    //Metoda pro načtení textu ze souboru
    public String importFromFile(String fileName) throws FileNotFoundException {
        String text = "";
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()) {
                text = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException ("Nepodařilo se nalézt soubor " + fileName);
        }
        return text;
    }
}
