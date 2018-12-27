package com.titan;

public class Runchik implements Runnable {

    private String myFileAspirationsNeeds;

    public void setMyFileAspirationsNeeds(String myFileAspirationsNeeds) {
        this.myFileAspirationsNeeds = myFileAspirationsNeeds;
    }

    private String resultGenerateHTML;

    public void setResultGenerateHTML(String resultGenerateHTML) {
        this.resultGenerateHTML = resultGenerateHTML;
    }

    @Override
    public void run() {
        // Создаём наш генератор HTML страницы (класс одиночка)
        GeneratorHTMLPage generatorHTMLPage = new GeneratorHTMLPage();

        // Передаём требования от пользователя
        // Если хотим то можем передать путь к файлу с помощью аргумента командной строки, но для упрощения делаем это в коде (не слишком правильно)
        // Используется относительный путь к файлу (можо использовать абсолютный путь к файлу, но это не обязательно)
        generatorHTMLPage.getAspirationsNeeds().generateAspirationsNeeds("src/com/titan/" + myFileAspirationsNeeds + ".txt");

        // Вызов генерации файла HTML
        generatorHTMLPage.generateHTMLFileResult();

        // Вывод результата генерации HTML страницы куда либо

        // Универсальный вывод
        IUniversalOutput universalOutput =  new UniversalOutput();

        // Вывод на консоль
        universalOutput.outputData(UniversalOutput.TypeOutput.CONSOLE, generatorHTMLPage.getResultStringArrayListHTMLFile(), resultGenerateHTML);

        // Вывод в файл (имя, которого заранее определено)
        universalOutput.outputData(UniversalOutput.TypeOutput.FILE, generatorHTMLPage.getResultStringArrayListHTMLFile(), resultGenerateHTML);
    }

}
