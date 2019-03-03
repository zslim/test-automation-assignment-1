package hu.zsofi.test.SeleniumOne;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private  User user;

    @BeforeAll
    private static void setDriverProperty() {
        System.setProperty("webdriver.gecko.driver", "/home/zsofi/Codecool/04_Test/geckodriver-v0.24.0-linux64/geckodriver");
    }

    @BeforeEach
    private void createUserClass() {
        this.user = new User(new FirefoxDriver(), "https://seleniumeasy.com/test/");
    }

    @AfterEach
    private void closeDriver() {
        user.closeDriver();
    }

    @Test
    void useSingleFieldButton() {
        String testMessage = "Nice to meet you Karen";
        String actualResult = user.useSingleFieldButton(testMessage);
        assertEquals(testMessage, actualResult);
    }
}