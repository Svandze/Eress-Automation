package pages.confeccion.parametrizacion.turnoslaborales;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class TurnosLaboralesPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement workShiftsGroup;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement workShiftsCodeInputForm;

    @FindBy(xpath = "//input[@class='ng-tns-c3918063748-1 p-inputtext p-component ng-star-inserted']")
    public WebElement workShiftsInitialHourInputForm;

    @FindBy(xpath = "")
    public WebElement workShiftsInitialIncreaseHH;

    @FindBy(xpath = "")
    public WebElement workShiftsInitiaDecreacreaseHH;

    @FindBy(xpath = "//p-inputnumber[@type='number']/span/input")
    public WebElement workShiftsCheckInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForWorkShifts(String workShiftsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + workShiftsCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForWorkShifts(String workShiftsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + workShiftsCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForWorkShifts() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findWorkShifts(String workShiftsCode) {
        waitAndSendKeys(searchInputField, workShiftsCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + workShiftsCode + "']")));
    }

    public void setWorkShiftsData(String workShiftsCode, String workShiftsDescription, String workShiftsValue) {
        ScrollToElement(workShiftsCodeInputForm);
        waitAndSendKeys(workShiftsCodeInputForm, workShiftsCode);
        waitAndSendKeys(workShiftsDescriptionInputForm, workShiftsDescription);
        waitAndSendKeys(workShiftsCheckInputForm, workShiftsValue);
        ScrollToElement(workShiftsGroup);
        clickWithJavaScript(workShiftsGroup);
    }


    public void validateWorkShiftsInfo(String workShiftsCode, String workShiftsDescription, String workShiftsValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(workShiftsCodeInputForm, "value", workShiftsCode));
        String currentMovementGroupCode = workShiftsCodeInputForm.getAttribute("value");
        String currentDescriptionMovementGroup = workShiftsDescriptionInputForm.getAttribute("value");
        String currentLevelDifficultyValue = workShiftsCheckInputForm.getAttribute("value");
        Assert.assertEquals("El valor actual del código del grupo de movimientos coincide con el esperado", workShiftsCode, currentMovementGroupCode);
        Assert.assertEquals("El valor actual de la descripción coincide con el esperado", workShiftsDescription, currentDescriptionMovementGroup);
        Assert.assertEquals("El valor actual del valor coincide con el esperado", workShiftsValue, currentLevelDifficultyValue);
    }

    public void addWorkShifts(String workShiftsCode, String workShiftsDescription, String workShiftsValue) {
        implicitWait();
        ScrollToElement(addButton);
        waitAndClick(addButton);
        waitAndSendKeys(workShiftsCodeInputForm, workShiftsCode);
        setWorkShiftsData(workShiftsCode, workShiftsDescription, workShiftsValue);
    }

    public void editWorkShifts(String workShiftsCode, String newWorkShiftsCode, String newWorkShiftsDescription, String newWorkShiftsValue) {
        findWorkShifts(workShiftsCode);
        waitAndClick(getEditButtonForWorkShifts(workShiftsCode));
        setWorkShiftsData(newWorkShiftsCode, newWorkShiftsDescription, newWorkShiftsValue);
    }

    public void validateWorkShifts(String workShiftsCode, String expectWorkShiftsCode, String expectWorkShiftsDescription, String expectWorkShiftsValue) {
        findWorkShifts(workShiftsCode);
        waitAndClick(getDetailsButtonForWorkShifts(workShiftsCode));
        validateWorkShiftsInfo(expectWorkShiftsCode, expectWorkShiftsDescription, expectWorkShiftsValue);
        clickWithJavaScript(cancelButton);
    }

    public void deleteWorkShifts(String workShiftsCode) {
        findWorkShifts(workShiftsCode);
        ScrollToElement(getDeleteButtonForWorkShifts());
        waitAndClick(getDeleteButtonForWorkShifts());
        waitAndClick(confirmButtonDelete);

    }
}
