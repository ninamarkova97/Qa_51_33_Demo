package tests;
import dto.Student;
import enums.Gender;
import enums.Hobbies;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;


public class PracticeFormTests extends AppManager {

    @Test
    public void practiceFormPositiveTest(){
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.MUSIC);

        Student student = new Student("Viki","Stroyan","viki123@gmail.com", Gender.FEMALE, "2589635478","21 Apr 1996","Maths,Chemistry,English",hobbies,"","avenue 4","NSR","Delhi");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);

    }

}
