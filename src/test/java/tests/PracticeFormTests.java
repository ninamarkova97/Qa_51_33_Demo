package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;


public class PracticeFormTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();


    @Test(groups = "smoke")
    public void practiceFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.MUSIC);

        Student student = new Student("Viki",
                "Stroyan",
                "viki123@gmail.com",
                Gender.FEMALE,
                "2589635478",
                "21 Apr 1996",
                "Maths,Chemistry,English",
                hobbies,
                "",
                "avenue 4",
                StateCity.RAJASTHAN.getState(),
                StateCity.RAJASTHAN.getCity()[0]);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);

        //Assert.assertTrue(practiceFormPage.validateMessageNegative());
        System.out.println("test failed");
        Assert.assertTrue(practiceFormPage.validateMessage());

    }

    @Test(groups = "smoke")
    public void practiceFormPositiveTestWithSoftAssert() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.MUSIC);

        Student student = new Student("Viki",
                "Stroyan",
                "viki123@gmail.com",
                Gender.FEMALE,
                "2589635478",
                "21 Apr 1996",
                "Maths,Chemistry,English",
                hobbies,
                "",
                "avenue 4",
                StateCity.RAJASTHAN.getState(),
                StateCity.RAJASTHAN.getCity()[0]);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);

        //softAssert.assertTrue(practiceFormPage.validateMessageNegative(), "validateMessageNegative");

        softAssert.assertTrue(getDriver().findElement
                                (By.xpath("//tbody/tr/td[2]"))
                        .getText().contains(student.getLastName()),
                "validate lastName");
        //System.out.println("test failed");
        softAssert.assertTrue(getDriver().findElement
                        (By.xpath("//tbody/tr[2]/td[2]")).getText()
                .contains(student.getEmail()), "validate email");
        softAssert.assertTrue(practiceFormPage.validateMessage(), "positive");
        softAssert.assertAll();

    }

}
