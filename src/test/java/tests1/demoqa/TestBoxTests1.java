package tests1.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static utils.RandomUtils.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests1 {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dataAppearsInOutputBlockTest() {
        String firstname = getRandomString(10);
        String lastname = getRandomString(10);
        String userEmail = getRandomEmail();
        String phone = getRandomPhone();
        String gender = "Female";
        String currentAddress = getRandomMessage(20, 35);
        String month = "March";
        String year = "1982";
        String day = "25";
        String state = "NCR";
        String city = "Gurgaon";
        String hobbieSport = "Sports";
        String hobbieReading = "Reading";
        String hobbieMusic = "Music";


        //arrange
        open("https://demoqa.com/automation-practice-form");
        //проверка элемента что сайт открылся
        $(".main-header").shouldHave(text("Practice Form"));

        //act
        //$("#firstName").setValue(firstname);
        $x("//input[@id = 'firstName']").setValue(firstname);

        //$("#lastName").setValue(lastname);
        $x("//input[@id = 'lastName']").setValue(lastname);

        $("#userEmail").setValue(userEmail);
        $x("//input[@id='userEmail']").setValue(userEmail);

        //$("#gender-radio-1").isSelected();
        $x("//input[@value = '" + gender + "']/parent::div/label").click();


        //$("#userNumber").setValue(phone);
        $x("//input[@id='userNumber']").setValue(phone);

        //выбрать дату в календаре
        $x("//input[@id = 'dateOfBirthInput']").click();
        // $x("//select[@class = 'react-datepicker__month-select']").click();
        $x("//select[@class = 'react-datepicker__month-select']/option[text() = '"+ month +"']").click();
        $x("//select[@class = 'react-datepicker__year-select']/option[@value = '"+ year +"']").click();
        $x("//div[contains(@class, 'react-datepicker__day') and text() = '"+ day +"']").click();

        //клик в чекбокс Sport
        //$x("//label[text() = 'Sports']/parent::div/input").click();
        //клик на название чекбокса
        $x("//label[text() = '"+ hobbieSport +"']").click();
        $x("//label[text() = '"+ hobbieReading +"']").click();
        $x("//label[text() = '"+ hobbieMusic +"']").click();

        //загрузка файла
        $x("//input[@id = 'uploadPicture']").uploadFromClasspath("img/order.jpg");


        $x("//textarea[@id='currentAddress']").setValue(currentAddress);

        $x("//div[@id = 'state']").scrollTo().click();
        $x("//div[@class = ' css-11unzgr']/div[text() = '"+ state +"']").click();
        $x("//div[@id = 'city']").click();
        $x("//div[@class= ' css-11unzgr']/div[text() = '"+ city +"']").click();

        $x("//button[@id = 'submit']").click();

        //assert
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text() = 'Student Name']").parent().shouldHave(text(firstname + " " + lastname));
        $x("//td[text() = 'Student Email']").parent().shouldHave(text(userEmail));
        $x("//td[text() = 'Gender']").parent().shouldHave(text(gender));
        $x("//td[text() = 'Mobile']").parent().shouldHave(text(phone));
        $x("//td[text() = 'Date of Birth']").parent().shouldHave(text(day + " " + month + "," + year));
        $x("//td[text() = 'Hobbies']").parent().shouldHave(text(hobbieSport + ", " + hobbieReading + ", " + hobbieMusic));
        $x("//td[text() = 'Picture']").parent().shouldHave(text("order.jpg"));
        $x("//td[text() = 'Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text() = 'State and City']").parent().shouldHave(text(state + " " + city));
    }
}
