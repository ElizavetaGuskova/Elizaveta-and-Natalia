package com.titan;

import java.util.ArrayList;

/**
 * Интерфейс <b>универсального</b> вывода:
 * <ol>
 *     <li>Вывод на консоль</li>
 *     <li>Вывод в файл</li>
 * </ol>
 */
public interface IUniversalOutput {

    /**
     * Перечисление обозначающий
     * тип конкретного вывода (для выбора пользователем)
     */
    enum TypeOutput {

        CONSOLE,
        FILE

    }

    /**
     * Универсальная функция вывода
     * @param selection - тип вывода
     * @param data - данные для вывода
     * @return - булевское значение обозначающий успех
     * или провал сделанной операции
     */
    boolean outputData(TypeOutput selection, ArrayList<String> data, String resultGenerateHTML);

}
