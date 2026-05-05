package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void textBoxSelectors(){
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        hideFooter();
        pause(5000);
        WebElement inputFullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        inputFullName.sendKeys("Monkey");
        WebElement inputEmail = driver.findElement(By.xpath("//form/div[2]/div[2]/input"));
        inputEmail.sendKeys("monkey257@sre.ru");
        WebElement textareaCurAddress = driver.findElement(By.xpath("//label[text()='Current Address']/../..//textarea"));
        textareaCurAddress.sendKeys("monkey str 123");
        WebElement textareaPerAddress = driver.findElement(By.xpath("//*[@id='permanentAddress-wrapper']//textarea"));
        textareaPerAddress.sendKeys("monkey square");
        WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
        btnSubmit.click();
        WebElement output = driver.findElement(By.xpath("//*[@id = 'output']"));
        System.out.println(output.getText());

    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
