package com.titan;

import java.util.ArrayList;

/**
 * Класс реализации нашей объектной модели документа
 * Это класс обёртка
 */
public class DocumentObjectModel implements IDocumentObjectModel {

    // Данные

    /** Поле массива элементов DOM */
    private ArrayList<IElementDOM> elementDOMArrayList;

    // Функционал

    /**
     * Конструктор по-умолчанию
     */
    public DocumentObjectModel() {

        elementDOMArrayList = new ArrayList<IElementDOM>();

    }

    /**
     * Функция добавления нового элемента без содержимого
     *
     * @param nameElement - имя элемента
     */
    @Override
    public void appendElement(String nameElement) {

        this.elementDOMArrayList.add(new ElementDOM(nameElement));

    }

    /**
     * Функция добавления новго элемента с содержимым, но без параметров
     *
     * @param nameElement - имя элемента
     * @param contents    - содержимое элемента
     */
    @Override
    public void appendElement(String nameElement, ArrayList<String> contents) {

        this.elementDOMArrayList.add(new ElementDOM(nameElement, contents));

    }

    /**
     * Функция добавления новго элемента с содержимым и параметрами
     *
     * @param nameElement - имя элемента
     * @param contents    - содержимое элемента
     * @param paramets    - параметры элемента
     */
    @Override
    public void appendElement(String nameElement, ArrayList<String> contents, ArrayList<String> paramets) {

        this.elementDOMArrayList.add(new ElementDOM(nameElement, contents, paramets));

    }

    /**
     * Функция получения массива элементов DOM {@link DocumentObjectModel#elementDOMArrayList}
     * @return - получение массива элементов DOM
     */
    @Override
    public ArrayList<IElementDOM> getElementDOMArrayList() {
        return elementDOMArrayList;
    }

}
