package com.titan;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс реализации читалки файла по строкам
 */
public class ReaderFile implements IReaderFile {

    // Данные

    // Функционал

    /**
     * Конструктор по-умолчанию
     */
    public ReaderFile(){}

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

            // Считывает текст из символльного потока ввода, буферизируя прочитанные символы,
            // тем самым увеличивает производительность чтения данных из потока
            // (не обращается с физический устройством)
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
