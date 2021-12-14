import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KongaWebLoginTest {

    //Import the Selenium WebDriver
    private WebDriver driver;

    @Test
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome  browser
        driver = new ChromeDriver();
        //2. Input konga Page URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();

        //4. Get the page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //5. Click on the Login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/nav/div[2]/div/div/div[4]/a")).click();
        Thread.sleep(5000);

        //6. Input your Email address
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("ay.bunmi@gmail.com");
        //7. Input your password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Gracious@2000");
        //8. Click on the Login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);

        //9. Logout from the account
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/nav/div[2]/div/div/div[4]/div/a/span")).click();

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/nav/div[2]/div/div/div[4]/div/ul/li[7]/a")).click();

    }

    @AfterTest
    public void closeBrowser(){
        //10. Quit the browser
        driver.quit();

    }


}
