package pages;

import core.CustomPageFactory;
import core.DriverManager;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        CustomPageFactory.initElements(driver, this);
    }
}
