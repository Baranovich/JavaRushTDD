package org.example;

/*
* Напиши программу, которая считывает из консоли имя текстового файла, далее
* читает символы из этого файла (используй метод readAllLines(Path) класса Files)
* и выводит на экран все, за исключением точки, запятой и пробела.

Требования:
•	Программа должна считать с консоли путь к файлу.
•	Программа должна вывести в консоль содержимое файла согласно условию.
•	Для чтения строк из файла должен быть использован метод readAllLines(Path) класса Files.
•	Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
* */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileDataInterpreterTest {

    FileDataInterpreter fileDataInterpreter;

    @BeforeEach
    void setUp() {
        fileDataInterpreter = new FileDataInterpreter();
    }

    @Test
    void methodReadFilePathFromConsoleShouldReturnCorrectFilePath() {

        ByteArrayInputStream in = new ByteArrayInputStream("C:\\my\\own\\test\\path\\to\\file".getBytes());
        System.setIn(in);

        String filePath = fileDataInterpreter.readFilePathFromConsole();

        assertEquals("C:\\my\\own\\test\\path\\to\\file", filePath);

    }

    @Test
    void methodReadFilePathFromConsoleShouldThrowNoSuchElementExceptionIfNoDataFromInput() {

        System.setIn(null);

        assertThrows(NullPointerException.class, fileDataInterpreter::readFilePathFromConsole);

    }

    @Test
    void methodFilterFileDataShouldReturnFileDataWithoutParticularSymbols() {

        String stringToFilter = "Ты жива ещё, моя старушка?...";

        String filteredData = fileDataInterpreter.filterFileData(stringToFilter);

        assertThat(filteredData).isEqualTo("Тыживаещёмоястарушка?");
    }

    @Test
    void methodWriteDataToConsoleShouldWorkProperly() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String dataToWrite = "Штирлиц сидел в комнате. С окна - дуло. Штирлиц закрыл окно и дуло исчезло.";

        fileDataInterpreter.writeDataToConsole(dataToWrite);

        assertThat(out.toString()).isEqualTo(dataToWrite + "\r\n");

    }

    @Test
    void methodReadFilePathFromConsoleThenFilterFileDataAndWriteDataToConsoleShouldWorkCorrect() {
        ByteArrayInputStream in = new ByteArrayInputStream("C:\\Users\\ip-oe\\IdeaProjects\\Study\\JavaRushTDD\\src\\main\\resources\\zhivaaaaa.txt".getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        fileDataInterpreter.readFilePathFromConsoleThenFilterFileDataAndWriteDataToConsole();

        String dataToWrite = "-Тыживаещёмоястарушка?\r\n" +
                "\r\n" +
                "-Живааааааааа";

        assertEquals(dataToWrite + "\r\n", out.toString());
    }
}