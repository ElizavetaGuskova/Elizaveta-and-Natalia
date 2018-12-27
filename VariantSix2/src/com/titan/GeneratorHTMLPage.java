package com.titan;

import java.util.ArrayList;

/**
 * Класс <b>генератора</b> HTML страницы
 */
public class GeneratorHTMLPage implements IGeneratorHTMLPage {

    // Данные

    // Константа пути файла шаблона
    final static private String filePathGeneric = "src/com/titan/index.html";

    /** Поле списка строк заготовленного шаблона html страницы */
    private ArrayList<String> genericStringArrayListHTMLFile;

    /** Поле результата сгенерированного файла на основе данных пользователя */
    private ArrayList<String> resultStringArrayListHTMLFile;

    /** Поле принимающий объект чтения описания требований */
    private AspirationsNeeds aspirationsNeeds;

    // Функционал

    /**
     * Конструктор по-умолчанию
     */
    public GeneratorHTMLPage() {

        // Создаём все нужные поля экземпляра класса GeneratorHTMLPage
        genericStringArrayListHTMLFile = new ArrayList<String>();
        resultStringArrayListHTMLFile = new ArrayList<String>();
        aspirationsNeeds = new AspirationsNeeds();

        // Вызываем нужные функции для полной инициализации экземпляра

        // Чтение файла шаблона для страницы
        readFileGenericHTML();

    }

    /**
     * Функция получения значения поля {@link GeneratorHTMLPage#genericStringArrayListHTMLFile}
     * @return возвращает заготовленный шаблон страницы HTML (не результат)
     */
    @Override
    public ArrayList<String> getGenericStringArrayListHTMLFile() {
        return genericStringArrayListHTMLFile;
    }

    /**
     * Функция получения значения поля {@link GeneratorHTMLPage#resultStringArrayListHTMLFile}
     * @return возвращает готовый сгенерированный шаблон HTML на основе данных пользователя
     */
    @Override
    public ArrayList<String> getResultStringArrayListHTMLFile() {
        return resultStringArrayListHTMLFile;
    }

    /**
     * Функция получения значения поля {@link GeneratorHTMLPage#aspirationsNeeds}
     * @return возвращает ссылку на объект, который может записать требования от пользователя
     */
    @Override
    public AspirationsNeeds getAspirationsNeeds() {
        return aspirationsNeeds;
    }

    /**
     * Функция чтения содержимого файла заготовленного шаблона genericStringArrayListHTMLFile
     */
    private void readFileGenericHTML() {

        // Читаем файл шаблона HTML страницы
        this.genericStringArrayListHTMLFile = new ReaderFile().getArrayListFile(filePathGeneric);

    }

    /**
     * Функция генерирования HTML файла по требованиям пользователя
     */
    @Override
    public void generateHTMLFileResult() {

        // Получаем объектную модель пользователя
        IDocumentObjectModel documentObjectModel = this.aspirationsNeeds.getDocumentObjectModel();

        // Проходим по строкам заготовленного шаблона
        for (String lineCode : genericStringArrayListHTMLFile) {

            if (lineCode.startsWith("#")) {

                // Проходим по объектам модели
                for (IElementDOM elementDOM : documentObjectModel.getElementDOMArrayList()) {

                    // Результирующая строка для вывода в генерирумый HTML документ
                    StringBuilder resultLine = new StringBuilder();

                    resultLine.append("<");
                    resultLine.append(elementDOM.getNameElement());
                    resultLine.append(" style = \"");

                    /*
                    * Пока что добавляем только рамку, остальное лишь гипотеза расширения!!!
                    */
                    for (String parametr : elementDOM.getParamets()) {

                        // Это лишь условность, дальнейшее расшение по желанию
                        if (parametr.equalsIgnoreCase("рамка")) {

                            resultLine.append("border: 3px solid #C1FF0A");

                        }

                    }

                    resultLine.append("\">\n");

                    // Добавление контента элемента DOM
                    for (String lineContent : elementDOM.getContents()) {

                        resultLine.append(lineContent);
                        resultLine.append("\n");

                    }

                    resultLine.append("</");
                    resultLine.append(elementDOM.getNameElement());
                    resultLine.append(">\n");

                    this.resultStringArrayListHTMLFile.add(resultLine.toString());

                }


            } else {

                this.resultStringArrayListHTMLFile.add(lineCode + "\n");

            }

        }



    }

}
