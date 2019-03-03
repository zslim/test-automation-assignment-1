package hu.zsofi.test.SeleniumOne;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Run {
    public static void main(String[] args) {
        User user = new User(new FirefoxDriver(), "https://seleniumeasy.com/test/");
    }
}
