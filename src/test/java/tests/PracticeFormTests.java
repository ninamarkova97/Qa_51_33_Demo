package tests;
import dto.Student;
import enums.Gender;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;


public class PracticeFormTests extends AppManager {

    @Test
    public void practiceFormPositiveTest(){
        Student student = new Student("Viki","Stroyan","viki123@gmail.com", Gender.FEMALE, "2589635478","21 Apr 1986","Maths,Chemistry,English","sports","","avenue 4","NSR","Delhi");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);

    }

}
