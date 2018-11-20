package com.titan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс реализации вывода в файл
 * Класс типа одиночки (Singleton)
 */
public class FileOutput implements IFileOutput {

    // Экземпляр класса одиночки
    private static FileOutput instance;

    /**
     * Конструктор по-умолчанию
     */
    private FileOutput(){}

    /**
     * Получение экзмепляра класса одиночки {@link FileOutput#instance}
     * @return - получение экземпляра одиночки
     */
    public static FileOutput getInstance() {
        if (instance == null) {
            instance = new FileOutput();
        }
        return instance;
    }

    /**
     * Функция вывода данных в файл
     * @param data - выводимые данные
     * @return - вывод булевского значения успеха
     * или провала операции
     */
    @Override
    public boolean fileOutput(ArrayList<String> data) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/com/titan/resultGenerateHTML.html")) {
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
