package tests1.working_files;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.FileUtils.readXlsFromFile;
import static utils.FileUtils.readXlsxFromFile;

public class XlsTests {
    @Test
    void checkXlsTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.xls";
        String expectedData = "hello qa.guru";

        // read text
        XLS actualXls = readXlsFromFile(dataPath);

        // assert data
        assertThat(actualXls, XLS.containsText(expectedData));
    }

    @Test
    void negativeCheckXlsTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.xls";
        String expectedData = "no hello qa.guru";

        // read text
        XLS actualXls = readXlsFromFile(dataPath);

        // assert data
        assertThat(actualXls, XLS.containsText(expectedData));
        /*
        Expected: a XLS containing text "no hello qa.guru"
        but: was "C:\Users\anton.rodin\Downloads\Lesson\.\src\test\resources\data\1.xls"
        hello qa.guru students!
        some text
         */
    }

    @Test
    void checkXlsxTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.xlsx";
        String expectedData = "hello qa.guru";

        // read text
        String actualXls = readXlsxFromFile(dataPath);

        // assert data
        assertThat(actualXls, containsString(expectedData));
    }
}
