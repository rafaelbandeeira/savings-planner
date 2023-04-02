package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsPage {
    private final WebDriver driver;
    @FindBy(css = "[data-testid=\"input\"]")
    private WebElement amountField;
    @FindBy(css = "[data-testid=\"reachDateIncrement\"]")
    private WebElement incrementDate;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[3]/div/div[1]/div/div[2]")
    private WebElement monthlyDeposit;

    private static String totalAmount;
    private static int months;

    public SavingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SavingsPage insertAmount(String totalAmount) {
        SavingsPage.totalAmount = totalAmount;
        amountField.sendKeys(totalAmount);

        return new SavingsPage(driver);
    }

    private BigDecimal getTotalAmount() {
        String intNumber = totalAmount.substring(0, totalAmount.length() -2);
        String decNumber = totalAmount.substring(totalAmount.length() - 2);
        String fullNumber = intNumber + "." + decNumber;

        return new BigDecimal(fullNumber);
    }

    public SavingsPage setEndDate(int months) {
        SavingsPage.months = months;
        int count = 1;
        while (count < months) {
            incrementDate.click();
            count++;
        }

        return new SavingsPage(driver);
    }

    public BigDecimal getMonthlyDeposit() {
        String value = monthlyDeposit.getText().replace(Character.toString(','), "");
        value = value.replace(Character.toString('$'), "");
        return new BigDecimal(value);
    }

    public BigDecimal divideByMonth() {
        return getTotalAmount().divide(new BigDecimal(months), 2, RoundingMode.HALF_UP);
    }
}
