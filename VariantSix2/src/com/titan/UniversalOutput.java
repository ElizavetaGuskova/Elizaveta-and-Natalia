package com.titan;

import java.util.ArrayList;

/**
 * Класс реализации <b>универсального</b> вывода:
 * <ol>
 *     <li>Вывод на консоль</li>
 *     <li>Вывод в файл</li>
 * </ol>
 */
public class UniversalOutput implements IUniversalOutput {

    // Данные

    // Функционал

    /**
     * Конструктор по-умолчанию
     */
    public UniversalOutput(){}

    /**
     * Универсальная функция вывода
     * @param selection - тип вывода
     * @param data - данные для вывода
     * @return - булевское значение обозначающий успех
     * или провал сделанной операции
     */
    @Override
    public boolean outputData(TypeOutput selection, ArrayList<String> data, String resultGenerateHTML) {

        switch (selection) {

            case CONSOLE:

                return (new ConsoleOutput().consoleOutput(data));

            case FILE:

                return (new FileOutput().fileOutput(data, resultGenerateHTML));

            default:

                System.err.println("Ошибка выбора типа вывода");
                return false;

        }

    }

}
