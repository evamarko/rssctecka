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
        String text;
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("scifi.txt")));
            text = scanner.nextLine();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException ("Nepodařilo se nalézt soubor scifi.txt");
        }
        return text;
    }

    @GetMapping("/romantic")
    public String getRomantic() throws FileNotFoundException {
        String text;
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("romantic.txt")));
            text = scanner.nextLine();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException ("Nepodařilo se nalézt soubor romantic.txt");
        }
        return text;
    }

    @GetMapping("/historic")
    public String getHisotoric() throws FileNotFoundException {
        String text;
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("historic.txt")));
            text = scanner.nextLine();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException ("Nepodařilo se nalézt soubor historic.txt");
        }
        return text;
    }
}
