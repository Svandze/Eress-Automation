package co.com.automation.pages.making.parameterization.weave;

import co.com.automation.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class WeavePage extends BasePage {


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddWeave;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement weaveCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement weaveDescriptionInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForWeave(String weaveCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + weaveCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForWeave(String weaveCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + weaveCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForWeave() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findWeave(String weaveCode) {
        waitAndSendKeys(searchInputField, weaveCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + weaveCode + "']")));
    }

    public void setWeave(String weaveCode, String weaveDescription) {
        scrollToElement(weaveCodeInputForm);
        waitAndSendKeys(weaveCodeInputForm, weaveCode);
        waitAndSendKeys(weaveDescriptionInputForm, weaveDescription);
        scrollToElement(confirmAddWeave);
        clickWithJavaScript(confirmAddWeave);
    }

    public void validateWeaveInfo(String weaveCode, String weaveDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(weaveCodeInputForm, "value", weaveCode));
        String currentMovementGroupCode = weaveCodeInputForm.getAttribute("value");
        String currentDescriptionMovementGroup = weaveDescriptionInputForm.getAttribute("value");
        Assert.assertEquals("The current code value of the movement group  matches the expected value", weaveCode, currentMovementGroupCode);
        Assert.assertEquals("The current description value  matches the expected value", weaveDescription, currentDescriptionMovementGroup);
    }

    public void addWeave(String weaveCode, String weaveDescription) {
        implicitWait();
        waitAndClick(addButton);
        waitAndSendKeys(weaveCodeInputForm, weaveCode);
        setWeave(weaveCode, weaveDescription);
    }

    public void editWeave(String weaveCode, String newWeaveCode, String NewWeaveDescription) {
        findWeave(weaveCode);
        waitAndClick(getEditButtonForWeave(weaveCode));
        setWeave(newWeaveCode, NewWeaveDescription);
    }

    public void validateWeave(String weaveCode, String expectWeaveCode, String expectWeaveDescription) {
        findWeave(weaveCode);
        waitAndClick(getDetailsButtonForWeave(weaveCode));
        validateWeaveInfo(expectWeaveCode, expectWeaveDescription);
        clickWithJavaScript(cancelButton);
    }

    public void deleteWeave(String weaveCode) {
        findWeave(weaveCode);
        scrollToElement(getDeleteButtonForWeave());
        waitAndClick(getDeleteButtonForWeave());
        waitAndClick(confirmButtonDelete);
        implicitWait();
    }
}
