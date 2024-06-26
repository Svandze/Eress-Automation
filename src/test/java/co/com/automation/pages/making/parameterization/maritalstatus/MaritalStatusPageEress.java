package co.com.automation.pages.making.parameterization.maritalstatus;

import co.com.automation.pages.BasePageEress;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class MaritalStatusPageEress extends BasePageEress {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddMaritalStatus;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement maritalStatusCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement maritalStatusDescriptionInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForMaritalStatus(String maritalStatusCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + maritalStatusCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForMaritalStatus(String maritalStatusCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + maritalStatusCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForMaritalStatus() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findMaritalStatus(String maritalStatusCode) {
        waitAndSendKeys(searchInputField, maritalStatusCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + maritalStatusCode + "']")));
    }

    public void setMaritalStatusData(String maritalStatusCode, String maritalStatusDescription) {
        scrollToElement(maritalStatusCodeInputForm);
        waitAndSendKeys(maritalStatusCodeInputForm, maritalStatusCode);
        waitAndSendKeys(maritalStatusDescriptionInputForm, maritalStatusDescription);
        scrollToElement(confirmAddMaritalStatus);
        clickWithJavaScript(confirmAddMaritalStatus);
    }

    public void validateMaritalStatusInfo(String maritalStatusCode, String maritalStatusDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(maritalStatusCodeInputForm, "value", maritalStatusCode));
        String currentMasterGenresCode = maritalStatusCodeInputForm.getAttribute("value");
        String currentMasterGenresDescription = maritalStatusDescriptionInputForm.getAttribute("value");
        assertEquals(maritalStatusCode, currentMasterGenresCode, "The current code value  matches the expected value");
        assertEquals(maritalStatusDescription, currentMasterGenresDescription, "The current description  matches the expected value");
    }

    public void addMaritalStatus(String maritalStatusCode, String maritalStatusDescription) {
        clickWithJavaScript(addButton);
        waitAndSendKeys(maritalStatusCodeInputForm, maritalStatusCode);
        setMaritalStatusData(maritalStatusCode, maritalStatusDescription);
    }

    public void editMaritalStatus(String maritalStatusCode, String newJMaritalStatusCode, String newMaritalStatusDescription) {
        findMaritalStatus(maritalStatusCode);
        waitAndClick(getEditButtonForMaritalStatus(maritalStatusCode));
        setMaritalStatusData(newJMaritalStatusCode, newMaritalStatusDescription);
    }

    public void validateJobRoles(String maritalStatusCode, String expectMaritalStatusCode, String expectMaritalStatusDescription) {
        findMaritalStatus(maritalStatusCode);
        waitAndClick(getDetailsButtonForMaritalStatus(maritalStatusCode));
        validateMaritalStatusInfo(expectMaritalStatusCode, expectMaritalStatusDescription);
        clickWithJavaScript(cancelButton);
    }

    public void deleteJobRoles(String maritalStatusCode) {
        findMaritalStatus(maritalStatusCode);
        scrollToElement(getDeleteButtonForMaritalStatus());
        waitAndClick(getDeleteButtonForMaritalStatus());
        waitAndClick(confirmButtonDelete);
        implicitWait();
    }
}
