package com.titan;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException; //обработка исключений
import java.util.ArrayList; //автоматически расширяемый массив

/**
 * Класс реализации читалки файла по строкам
 * Класс типа одиночки (Singleton)
 */
public class ReaderFile implements IReaderFile {
    // Экземпляр класса одиночки
    private static ReaderFile instance;
    // Функционал

    //Конструктор по-умолчани
    private ReaderFile(){}

    /**
     * Получение экзмепляра класса одиночки {@link ReaderFile#instance}
     * @return - получение экземпляра одиночки
     */
    public static ReaderFile getInstance() {
        if (instance == null) {
            instance = new ReaderFile();
        }
        return instance;
    }

    /**
     * Функция чтения файла в массив
     *
     * @param useFileName - путь до файла, который нужно прочитать
     * @return - возвращает массив строк файла
     */
    @Override
    public ArrayList<String> getArrayListFile(String useFileName) {
        // Результат чтения файла
        ArrayList<String> resultReadingFile = new ArrayList<String>();
        // Поток предназначенный для считывания байтов из файла
        try (FileInputStream fileInputStream = new FileInputStream(useFileName)){
            // Считывает текст из символльного потока ввода, буферизируя прочитанные символы
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String tmpString;
            while ((tmpString = bufferedReader.readLine()) != null){
                resultReadingFile.add(tmpString);
            }
        } catch (FileNotFoundException error) {
            System.err.println("По переданному пути не найден файл");
            return null;
        } catch (IOException error) {
            System.err.println("Ошибка чтения файла");
            return null;
        }
        return resultReadingFile;
    }
}
