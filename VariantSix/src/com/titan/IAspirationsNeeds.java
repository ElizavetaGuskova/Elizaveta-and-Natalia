package com.titan;

import java.util.ArrayList;

/**
 * Интерфейс требований от пользователя для генерации HTML страниц
 */
public interface IAspirationsNeeds {

    // Функционал

    /**
     * Функция получения требований от пользователя
     *
     * @param useFileName - путь до файла, в котором лежат требования в нужном формате
     */
    void generateAspirationsNeeds(String useFileName);

}
