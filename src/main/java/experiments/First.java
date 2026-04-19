package experiments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class First {
    WebDriver driver = new ChromeDriver();

    @Test
    public void firstTest(){
        driver.get("https://demoqa.com/");
        pause(5000);
        driver.manage().window().maximize();
        pause(5000);
        driver.get("https://demoqa.com/elements");
        pause(5000);

        pause(5000);
       //driver.close();
        driver.quit();
    }
    public void pause(int time){
        driver.get("https://demoqa.com/");
        Thread.sleep();

    }
}
