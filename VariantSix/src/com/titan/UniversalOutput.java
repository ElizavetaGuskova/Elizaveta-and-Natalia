package com.titan;

import java.util.ArrayList;

/**
 * Класс реализации <b>универсального</b> вывода:
 * <ol>
 *     <li>Вывод на консоль</li>
 *     <li>Вывод в файл</li>
 * </ol>
 * Класс типа одиночки (Singleton)
 */
public class UniversalOutput implements IUniversalOutput {

    // Экземпляр класса одиночки
    private static UniversalOutput instance;

    /**
     * Конструктор по-умолчанию
     */
    private UniversalOutput(){}

    /**
     * Получение экзмепляра класса одиночки {@link UniversalOutput#instance}
     * @return - получение экземпляра одиночки
     */
    public static UniversalOutput getInstance() {
        if (instance == null) {
            instance = new UniversalOutput();
        }
        return instance;
    }

    /**
     * Универсальная функция вывода
     * @param selection - тип вывода
     * @param data - данные для вывода
     * @return - булевское значение обозначающий успех
     * или провал сделанной операции
     */
    @Override
    public boolean outputData(TypeOutput selection, ArrayList<String> data) {
        switch (selection) {
            case CONSOLE:
                return (ConsoleOutput.getInstance().consoleOutput(data));
            case FILE:
                return (FileOutput.getInstance().fileOutput(data));
            default:
                System.err.println("Ошибка выбора типа вывода");
                return false;
        }
    }
}
