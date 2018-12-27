package com.titan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс реализации вывода в файл
 */
public class FileOutput implements IFileOutput {

    // Данные

    private String resultGenerateHTML;

    // Функционал

    /**
     * Конструктор по-умолчанию
     */
    public FileOutput(){}

    public void setResultGenerateHTML(String resultGenerateHTML) {
        this.resultGenerateHTML = resultGenerateHTML;
    }

    /**
     * Функция вывода данных в файл
     * @param data - выводимые данные
     * @return - вывод булевского значения успеха
     * или провала операции
     */
    @Override
    public boolean fileOutput(ArrayList<String> data, String resultGenerateHTML) {

        try (FileOutputStream fileOutputStream = new FileOutputStream("src/com/titan/" + resultGenerateHTML + ".html")) {

            // Вывод в файл построчно
            for (String line : data) {

                fileOutputStream.write(line.getBytes());

            }

        } catch (FileNotFoundException error) {

            System.err.println("Ошибка вывода файла");
            return false;

        } catch (IOException error) {

            System.err.println("Ошибка вывода файла");
            return false;

        }

        return true;

    }

}
