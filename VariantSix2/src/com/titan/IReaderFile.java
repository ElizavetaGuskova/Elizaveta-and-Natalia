package com.titan;

import java.util.ArrayList;

/**
 * Интерфейс читалки файла по строкам
 */
public interface IReaderFile {

    // Функционал

    /**
     * Функция чтения файла в массив
     *
     * @param useFileName - путь до файла, который нужно прочитать
     * @return - возвращает массив строк файла
     */
    ArrayList<String> getArrayListFile(String useFileName);

}
