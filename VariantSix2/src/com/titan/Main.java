package com.titan;

import java.util.ArrayList;

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

        final int NThread = 10;

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= NThread; ++i) {

            Runchik tmpRunchik = new Runchik();
            tmpRunchik.setResultGenerateHTML("myFileAspirationsNeeds" + i);
            tmpRunchik.setMyFileAspirationsNeeds("myFileAspirationsNeeds" + i);

            threads.add(new Thread(tmpRunchik));
        }

        for (Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
