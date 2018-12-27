package com.titan;

import java.util.ArrayList;


/**
 * Класс реализации получение требований от пользователя для генерации HTML страниц
 */
public class AspirationsNeeds implements IAspirationsNeeds {

    // Данные

    /**  Поле объектной модели требований */
    private IDocumentObjectModel documentObjectModel;

    // Функционал

    /**
     * Конструктор по-умолчанию
     */
    public AspirationsNeeds() {

        documentObjectModel = new DocumentObjectModel();
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
        ArrayList<String> tmpAspirationsArrayList = new ReaderFile().getArrayListFile(useFileName);

        // Преобразование требований в DOM
        for (String line : tmpAspirationsArrayList) {

            // Удаляем начальные и конечные пробелы
            line = line.trim();

            // Если присутствуют символы комментариев, то текущую строку не учитываем
            if (line.startsWith("//")) {

                continue;

            }

            // Если встретился символ нашего начала строки (это договоренный символ)
            else if (line.startsWith("#")) {

                // Удаляем специальной символ для дальнейшей обработки строки
                line = line.replace("#", "");

                // Удаляем пробелы, которые могли быть в начале после специального символа
                line = line.trim();

                // Вынимаем имя элемента DOM (оно у нас одно)
                String nameElement = line.split(" ")[0];

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

                    // В случае существование контента на этой строке
                    if (tmpContent != null) {

                        String tmpStringContent = line.substring(line.indexOf("\""), (line.lastIndexOf("\"") != -1) ? (line.lastIndexOf("\"")) : (line.length() - 1));

                        tmpStringContent = tmpStringContent.replace("\"","");

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
