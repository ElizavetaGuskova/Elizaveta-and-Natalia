package com.titan;

import java.util.ArrayList;

/**
 * Интерфейс элемента нашего DOM
 */
public interface IElementDOM {

    /**
     * Функция получения имени элемента DOM {@link ElementDOM#nameElement}
     * @return - получение имени элемента DOM
     */
    String getNameElement();

    /**
     * Функция получения содержимого DOM {@link ElementDOM#contents}
     * @return  - получение содержимого элемента DOM
     */
    ArrayList<String> getContents();

    /**
     * Функция получения параметров DOM {@link ElementDOM#paramets}
     * @return - получение параметров элемента DOM
     */
    ArrayList<String> getParamets();

    /**
     * Функция проверки существования содержимого элемента DOM
     */
    boolean isContents();

    /**
     * Функция проверки существования параметров элемента DOM
     */
    boolean isParamets();

}
