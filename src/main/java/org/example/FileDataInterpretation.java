package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileDataInterpretation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Files.readAllLines(Path.of(scanner.nextLine()))
                    .forEach(s -> System.out.println(s.replaceAll("[ ,.]", "")));
        } catch (NullPointerException nullPointerException) {
            System.out.println("Error due to file path reading!");
        } catch (IOException ioException) {
            System.out.println("Error due to file reading!");
        }
    }
}
