package tests1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class Alpha {

    @Test
    void testAlpha() {
        open("https://alfabank.ru/");
        $x("//a[text() = 'Вклады']").click();
        $x("//h1[text() = 'Накопительные продукты']").shouldHave(text("Накопительные продукты"));
        $x("//p[text() = 'Депозиты']/parent::button").click();
        $x("//*[text() = 'Вклад на ваших условиях']").shouldHave(visible);




    }

}
