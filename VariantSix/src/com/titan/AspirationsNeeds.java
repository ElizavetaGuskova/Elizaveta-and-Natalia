package com.titan;

import java.util.ArrayList;


/**
 * Класс реализации получение требований от пользователя для генерации HTML страниц
 * Класс типа одиночки (Singleton)
 */
public class AspirationsNeeds implements IAspirationsNeeds {
    // Экземпляр класса одиночки
    private static AspirationsNeeds instance;

    /**  Поле объектной модели требований */
    private IDocumentObjectModel documentObjectModel;

    /**
     * Конструктор по-умолчанию
     */
    private AspirationsNeeds() {

        documentObjectModel = new DocumentObjectModel();
    }

    /**
     * Получение экзмепляра класса одиночки {@link AspirationsNeeds#instance}
     * @return - получение экземпляра одиночки
     */
    public static AspirationsNeeds getInstance() {
        if (instance == null) {
            instance = new AspirationsNeeds();
        }
        return instance;
    }

    /**
     * Функция получения объектной модели требований пользователя {@link AspirationsNeeds#documentObjectModel}
     * @return - получение объектной модели пользователя
     */
    public IDocumentObjectModel getDocumentObjectModel() {
        return documentObjectModel;
    }
    /**
     * Функция получения требований от пользователя
     *
     * @param useFileName - путь до файла, в котором лежат требования в нужном формате
     */
    @Override
    public void generateAspirationsNeeds(String useFileName) {
        // Читаем файл по строкам и сохраняем в массив строк
        ArrayList<String> tmpAspirationsArrayList = ReaderFile.getInstance().getArrayListFile(useFileName);

        for (String line : tmpAspirationsArrayList) {  // Преобразование требований в DOM
            line = line.trim();  // Удаляем начальные и конечные пробелы
            if (line.startsWith("//")) {  // Если присутствуют символы комментариев, то текущую строку не учитываем
                continue;
            }
            else if (line.startsWith("#")) {   // Если встретился символ нашего начала строки (это договоренный символ)
                line = line.replace("#", ""); // Удаляем специальной символ для дальнейшей обработки строки

                line = line.trim();  // Удаляем пробелы, которые могли быть в начале после специального символа

                String nameElement = line.split(" ")[0];  // Вынимаем имя элемента DOM (оно у нас одно)

                // Проверка на то, что в строке не одно слово
                /**
                 * Возможен случай, когда идет сначало ключевое слово элемента DOM, а потом его параметр, а далее содержимое
                 * Например, #div рамка "Контент. Контент.", где # - специальный символ означающий начало строки обработки,
                 * далее может идти параметр "рамка" - который даёт разрешение на включение свойства рамки для тега div,
                 * далее идёт содержимое элемента div в кавычках, что сигнализирует о начале контента
                 */
                if (line.indexOf(" ") != -1) {
                    // Временное содержимое контента элемента DOM
                    ArrayList<String> tmpContent = (line.indexOf("\"") != -1) ? (new ArrayList<String>()) : (null);
                    if (tmpContent != null) { // В случае существование контента на этой строке
                        String tmpStringContent = line.substring(line.indexOf("\""), (line.lastIndexOf("\"") != -1) ? (line.lastIndexOf("\"")) : (line.length() - 1));
                        tmpStringContent = tmpStringContent.replace("\"", "");
                        tmpContent.add(tmpStringContent);
                    }

                    // Выяснение существования параметров
                    ArrayList<String> parametrs = (line.indexOf("\"") - line.indexOf(" ") > 0) ? (new ArrayList<String>()) : (null);
                    // Если параметры существуют
                    if (parametrs != null) {
                        for (String parametr : line.substring(line.indexOf(" "), line.indexOf("\"")).split(" ")) {
                            parametrs.add(parametr);
                        }
                    }

                    // Добавление элемента DOM в объектную модель для дальнейшнего рассмотрения
                    this.documentObjectModel.appendElement(nameElement, tmpContent, parametrs);
                }
            }
            else {
                try {
                    // Добавление контента к последнему элементу
                    this.documentObjectModel.getElementDOMArrayList().get(this.documentObjectModel.getElementDOMArrayList().size() - 1).getContents().add(line);
                } catch (IndexOutOfBoundsException error) {
                    System.err.println("Выход за пределы массива");
                } catch (NullPointerException error) {
                    System.err.println("Обращение к нулевой ссылке");
                }
            }
        }
    }
}
