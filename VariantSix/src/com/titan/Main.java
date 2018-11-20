package com.titan;

/**
 * Лабораторная работа №1 по <b>Технологии виртуализации</b>
 * Условие задания:
 * <i>Реализуйте систему генерации шаблона html страницы по описанию:
 *  <ol>
 *      <li>Состава разделов (header, section1, ..., section_n, footer)</li>
 *      <li>Структуры каждой секции (количество блоков "div")</li>
 *  </ol>
 *  Добавьте опциональную возможность выделять определенный раздел, блок рамкой.
 *  Сгенерированный html код выводите в консоль.
 * </i>
 */
public class Main {
    public static void main(String[] args) {
        // Создаём наш генератор HTML страницы (класс одиночка)
        GeneratorHTMLPage generatorHTMLPage = GeneratorHTMLPage.getInstance();
        // Передаём требования от пользователя
        // Используется относительный путь к файлу
        generatorHTMLPage.getAspirationsNeeds().generateAspirationsNeeds("src/com/titan/myFileAspirationsNeeds.txt");
        // Вызов генерации файла HTML
        generatorHTMLPage.generateHTMLFileResult();

        // Вывод результата генерации HTML страницы куда либо

        // Вывод на консоль
        UniversalOutput.getInstance().outputData(UniversalOutput.TypeOutput.CONSOLE, generatorHTMLPage.getResultStringArrayListHTMLFile());

        // Вывод в файл (имя, которого заранее определено)
        UniversalOutput.getInstance().outputData(UniversalOutput.TypeOutput.FILE, generatorHTMLPage.getResultStringArrayListHTMLFile());

    }
}
