package com.titan;

import java.util.ArrayList;

/**
 * Класс реализации консольного вывода
 */
public class ConsoleOutput implements IConsoleOutput {

    // Данные

    // Функционал

    /**
     * Конструктор по-умолчанию
     */
    public ConsoleOutput(){}

    /**
     * Функция консольного вывода данных
     * @param data - выводимые данные
     * @return - вывод булевского значения успеха
     * или провала операции
     */
    @Override
    public boolean consoleOutput(ArrayList<String> data) {

        for (String line : data) {

            System.out.print(line);

        }

        return true;

    }

}
