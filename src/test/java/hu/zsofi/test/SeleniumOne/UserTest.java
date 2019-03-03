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
    static void setDriverProperty() {
        System.setProperty("webdriver.gecko.driver", "/home/zsofi/Codecool/04_Test/geckodriver-v0.24.0-linux64/geckodriver");
    }

    @BeforeEach
    void createUserClass() {
        this.user = new User(new FirefoxDriver(), "https://seleniumeasy.com/test/");
    }

    @AfterEach
    void closeDriver() {
        user.closeDriver();
    }

    @Test
    void useSingleFieldButton() {
        String testMessage = "Nice to meet you Karen";
        String actualResult = user.useSingleFieldButton(testMessage);
        assertEquals(testMessage, actualResult);
    }

    @Test
    void useSumFieldsWithTwoInts() {
        String a = "3";
        String b = "8";
        String expectedResult = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
        assertEquals(expectedResult, user.useSumFields(a, b));
    }

    @Test
    void useSumFieldsWithInvalidInput() {
        String a = "hey";
        String b = "O";
        String expectedResult = "NaN";
        assertEquals(expectedResult, user.useSumFields(a, b));
    }
}