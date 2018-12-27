package com.titan;

import java.util.ArrayList;

/**
 * Интерфейс <b>генератора</b> HTML страницы
 */
public interface IGeneratorHTMLPage {

    // Функционал

    /**
     * Функция получения значения поля {@link GeneratorHTMLPage#genericStringArrayListHTMLFile}
     * @return возвращает заготовленный шаблон страницы HTML (не результат)
     */
    ArrayList<String> getGenericStringArrayListHTMLFile();

    /**
     * Функция получения значения поля {@link GeneratorHTMLPage#resultStringArrayListHTMLFile}
     * @return возвращает готовый сгенерированный шаблон HTML на основе данных пользователя
     */
    ArrayList<String> getResultStringArrayListHTMLFile();

    /**
     * Функция получения значения поля {@link GeneratorHTMLPage#aspirationsNeeds}
     * @return возвращает ссылку на объект, который может записать требования от пользователя
     */
    AspirationsNeeds getAspirationsNeeds();

    /**
     * Функция генерирования HTML файла по требованиям пользователя
     */
    void generateHTMLFileResult();

}
