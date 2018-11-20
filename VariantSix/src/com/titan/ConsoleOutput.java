package com.titan;

import java.util.ArrayList;

/**
 * Класс реализации консольного вывода
 * Класс типа одиночки (Singleton)
 */
public class ConsoleOutput implements IConsoleOutput {
    // Экземпляр класса одиночки
    private static ConsoleOutput instance;

    /**
     * Конструктор по-умолчанию
     */
    private ConsoleOutput(){}

    /**
     * Получение экзмепляра класса одиночки
     * @return - получение экземпляра одиночки
     */
    public static ConsoleOutput getInstance() {
        if (instance == null) {
            instance = new ConsoleOutput();
        }
        return instance;
    }

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
