package tests1.working_files;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.FileUtils.readPdfFromFile;

public class PdfTests {
    @Test
    void checkPdfTest() {
        // test data
        String dataPath = "./src/test/resources/data/Google.pdf";
        String expectedData = "Россия";

        // read text
        PDF actualPdf = readPdfFromFile(dataPath);

        // assert data
        assertThat(actualPdf, PDF.containsText(expectedData));
    }

    @Test
    void negativeCheckPdfTest() {
        // test data
        String dataPath = "./src/test/resources/data/Google.pdf";
        String expectedData = "Сирия";

        // read text
        PDF actualPdf = readPdfFromFile(dataPath);

        // assert data
        assertThat(actualPdf, PDF.containsText(expectedData));

        /*
        Expected: a PDF containing "Сирия"
        but: was "11.05.2021 Google https://www.google.com 1/1 Россия Всё о Google Реклама Для бизнеса Как работает Google Поиск Нулевой баланс выбросов углекислого газа с 2007 года Конфиденциальность Условия Поиск в Google Мне повезёт! Настройки Почта Картинки"
         */
    }
}
