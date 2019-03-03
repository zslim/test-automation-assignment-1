package hu.zsofi.test.SeleniumOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User {
    private String baseURL;
    private WebDriver driver;

    public void closeDriver() {
        driver.close();
    }

    public User(WebDriver driver, String baseURL) {
        this.driver = driver;
        this.baseURL = baseURL;
    }

    private void navigateToPageUnderTesting() {
        driver.get(baseURL);
        WebElement inputFormsToggle = driver.findElement(By.linkText("Input Forms"));
        inputFormsToggle.click();
        WebElement simpleFormDemoLink = driver.findElement(By.linkText("Simple Form Demo"));
        simpleFormDemoLink.click();
    }

    public String useSingleFieldButton(String message) {
        navigateToPageUnderTesting();

        WebElement inputField = driver.findElement(By.cssSelector("#user-message"));
        inputField.sendKeys(message);

        WebElement showButton = driver.findElement(By.xpath("//button[text()=\"Show Message\"]"));
        showButton.click();

        WebElement messageSpan = driver.findElement(By.cssSelector("#display"));
        String messageWeGet = messageSpan.getText();

        return messageWeGet;
    }
}
