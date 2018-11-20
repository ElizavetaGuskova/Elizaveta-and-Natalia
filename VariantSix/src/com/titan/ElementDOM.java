package com.titan;

import java.util.ArrayList;

/**
 * Класс реализации элемента нашего DOM
 */
public class ElementDOM implements IElementDOM {

    /** Поле имени нашего элемента в DOM */
    private String nameElement;

    /** Поле содержимого в нашем элементе DOM */
    private ArrayList<String> contents;

    /** Поле содержимого параметров */
    private ArrayList<String> paramets;

    /**
     * Конструктор без параметров
     * Приватный, так как он не нужен и чтобы его нельзя было бы вызвать
     */
    @Deprecated
    private ElementDOM(){}

    /**
     * Конструктор с одним аргументом
     * @param nameElement - имя элемента DOM
     */
    public ElementDOM(String nameElement) {
        this.nameElement = nameElement;
        this.contents = null;
        this.paramets = null;
    }

    /**
     * Конструктор с двумя аргументами
     * @param nameElement - имя элемента DOM
     * @param contents - содержимое элемента DOM
     */
    public ElementDOM(String nameElement, ArrayList<String> contents) {
        this.nameElement = nameElement;
        this.contents = contents;
        this.paramets = null;
    }

    /**
     * Конструктор с тремя аргументами
     * @param nameElement - имя элемента DOM
     * @param contents - содержимое элемента DOM
     * @param paramets - дополнительные параметры элемента DOM
     */
    public ElementDOM(String nameElement, ArrayList<String> contents, ArrayList<String> paramets) {
        this.nameElement = nameElement;
        this.contents = contents;
        this.paramets = paramets;
    }

    /**
     * Функция получения имени элемента DOM {@link ElementDOM#nameElement}
     * @return - получение имени элемента DOM
     */
    @Override
    public String getNameElement() {
        return nameElement;
    }

    /**
     * Функция получения содержимого DOM {@link ElementDOM#contents}
     * @return  - получение содержимого элемента DOM
     */
    @Override
    public ArrayList<String> getContents() {
        return contents;
    }

    /**
     * Функция получения параметров DOM {@link ElementDOM#paramets}
     * @return - получение параметров элемента DOM
     */
    @Override
    public ArrayList<String> getParamets() {
        return paramets;
    }

    /**
     * Функция проверки существования содержимого элемента DOM
     */
    @Override
    public boolean isContents() {
        return contents != null;
    }

    /**
     * Функция проверки существования параметров элемента DOM
     */
    @Override
    public boolean isParamets() {
        return paramets != null;
    }

}
