package com.titan;

import java.util.ArrayList;

/**
 * Интерфейс нашей объектной модели документа
 */
public interface IDocumentObjectModel {

    /**
     * Функция добавления нового элемента без содержимого
     * @param nameElement - имя элемента
     */
    void appendElement(String nameElement);

    /**
     * Функция добавления новго элемента с содержимым, но без параметров
     * @param nameElement - имя элемента
     * @param contents - содержимое элемента
     */
    void appendElement(String nameElement, ArrayList<String> contents);

    /**
     * Функция добавления новго элемента с содержимым и параметрами
     * @param nameElement - имя элемента
     * @param contents - содержимое элемента
     * @param paramets - параметры элемента
     */
    void appendElement(String nameElement, ArrayList<String> contents, ArrayList<String> paramets);

    /**
     * Функция получения массива элементов DOM {@link DocumentObjectModel#elementDOMArrayList}
     * @return - получение массива элементов DOM
     */
    ArrayList<IElementDOM> getElementDOMArrayList();

}
