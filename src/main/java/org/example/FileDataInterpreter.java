package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileDataInterpreter {

    public void readFilePathFromConsoleThenFilterFileDataAndWriteDataToConsole() {
        try {
            Files.readAllLines(Path.of(readFilePathFromConsole())).forEach(s -> writeDataToConsole(filterFileData(s)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readFilePathFromConsole() {

        String filePath;

        try(Scanner scanner = new Scanner(System.in)) {
            filePath = scanner.nextLine();
        } catch (NullPointerException nullPointerException) {
            System.out.println("Error due to file path reading!");
            throw nullPointerException;
        }

        return filePath;
    }

    public String filterFileData(String fileData) {
        return fileData.replaceAll("[ ,.]", "");
    }

    public void writeDataToConsole(String data) {
        System.out.println(data);
    }
}
