package tests1.demoqa.pageObject.steps;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StudentFormSteps {
   SelenideElement pageHeader =  $(".main-header"),
           firstNameInput = $x("//input[@id = 'firstName']");

   public void checkPageHeader (String value){
       pageHeader.shouldHave(text(value));
   }

   public void setFirstName(String value) {
       firstNameInput.setValue(value);
    }

    public void setBirthDate(String year, String month, String day){
        //выбрать дату в календаре
        $x("//input[@id = 'dateOfBirthInput']").click();
        // $x("//select[@class = 'react-datepicker__month-select']").click();
        $x("//select[@class = 'react-datepicker__month-select']/option[text() = '"+ month +"']").click();
        $x("//select[@class = 'react-datepicker__year-select']/option[@value = '"+ year +"']").click();
        $x("//div[contains(@class, 'react-datepicker__day') and text() = '"+ day +"']").click();
    }
}
