package Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.config.App;
import org.data.Numbers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pages.SavingsPage;

import java.time.Duration;

public class SavingsTest {
    private WebDriver browser;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");

        browser = new ChromeDriver(options);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        browser.get(App.getAppUrl());
    }

    @AfterEach
    void teardown() {
        browser.quit();
    }

    @Test
    @DisplayName("Check the accuracy of the suggested monthly deposit")
    void TestMonthlyDepositAccuracy() {
        SavingsPage savings = new SavingsPage(browser)
                .insertAmount(Numbers.getRandomInt(1000000, 6000000))
                .setEndDate(25);

        Assertions.assertEquals(
                savings.divideByMonth(),
                savings.getMonthlyDeposit()
        );
    }
}
