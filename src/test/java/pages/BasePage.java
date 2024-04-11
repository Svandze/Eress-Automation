package pages;

import core.CustomPageFactory;
import core.DriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.ElementUtils.ScrollToElement;
import static utils.ElementUtils.clickWithJavaScript;
import static utils.ElementUtils.waitAndClick;

@Slf4j
public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        CustomPageFactory.initElements(driver, this);
    }


    public void verifyAndClickCheck(WebElement webElement, Boolean checkSewing) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String isCheckedStr = (String) js.executeScript("return arguments[0].getAttribute('aria-checked');", webElement);
            Boolean isChecked = Boolean.parseBoolean(isCheckedStr);
            if (checkSewing != isChecked) {
                ScrollToElement(webElement);
                clickWithJavaScript(webElement);
            }
        } catch (Exception e) {
            log.error("Ocurrió un error específico durante la espera o el click: " + e.getMessage());
        }
    }
}
