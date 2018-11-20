package com.titan;

import java.util.ArrayList;

/**
 * Интерфейс консольного вывода
 */
public interface IConsoleOutput {
    /**
     * Функция консольного вывода данных
     * @param data - выводимые данные
     * @return - вывод булевского значения успеха
     * или провала операции
     */
    boolean consoleOutput(ArrayList<String> data);

}
