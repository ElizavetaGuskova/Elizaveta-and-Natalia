package com.titan;

import java.util.ArrayList;

/**
 * Класс реализации вывода в файл
 */
public interface IFileOutput {

    // Функционал

    /**
     * Функция вывода данных в файл {@link FileOutput}
     * @param data - выводимые данные
     * @return - вывод булевского значения успеха
     * или провала операции
     */
    boolean fileOutput(ArrayList<String> data, String resultGenerateHTML);

}
