package co.com.automation.pages;

import base.BasePage;
import core.CustomPageFactory;
import core.DriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.ElementUtils.clickWithJavaScript;
import static utils.ElementUtils.scrollToElement;

@Slf4j
public class BasePageEress extends BasePage {

    protected WebDriver driver;

    public BasePageEress() {
        this.driver = super.driver;
    }


    public void verifyAndClickCheck(WebElement webElement, Boolean checkSewing) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String isCheckedStr = (String) js.executeScript("return arguments[0].getAttribute('aria-checked');", webElement);
            Boolean isChecked = Boolean.parseBoolean(isCheckedStr);
            if (checkSewing != isChecked) {
                scrollToElement(webElement);
                clickWithJavaScript(webElement);
            }
        } catch (Exception e) {
            log.error("Ocurrió un error específico durante la espera o el click: " + e.getMessage());
        }
    }
}
