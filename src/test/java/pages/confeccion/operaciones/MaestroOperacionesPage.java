package pages.confeccion.operaciones;

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

public class MaestroOperacionesPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddOperations;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement operationsCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement operationsDescriptionInputForm;

    //Dropdown maquinas
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[1]")
    public WebElement operationsMachineDropDown;

    @FindBy(xpath = "(//input[@class='p-dropdown-filter p-inputtext p-component'])[1]")
    public WebElement operationsDropDownInputForm;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement operationsDropDownSelect;

    @FindBy(xpath = "")
    public WebElement operationsMachineDropDownData;

    @FindBy(xpath = "//p-inputnumber[@formcontrolname='ppp']/span/input")
    public WebElement operationsStitchesInchInputForm;

    @FindBy(xpath = "//p-inputnumber[@formcontrolname='suplement']/span/input")
    public WebElement operationsSupplementInputForm;

    //Dropdown grado de dificultad
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[2]")
    public WebElement operationsDifficultDropDown;


    @FindBy(xpath = "")
    public WebElement operationsDifficultDropDownData;

    //Dropdown elaborado
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[3]")
    public WebElement operationsElaborateDropDown;


    @FindBy(xpath = "")
    public WebElement operationsElaborateDropDownData;

    //Dropdown elaborado
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[4]")
    public WebElement operationsAprobateDropDown;

    @FindBy(xpath = "")
    public WebElement operationsAprobateDropDownData;

    //Dropdown elemento
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[5]")
    public WebElement operationsElementDropDown;

    @FindBy(xpath = "")
    public WebElement operationsElementDropDownData;

    //Dropdown distancia
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[6]")
    public WebElement operationsDistanceDropDown;

    @FindBy(xpath = "")
    public WebElement operationsDistanceDropDownData;

    @FindBy(xpath = "(//input[@name='sewing'])[1]")
    public WebElement operationsSewingInputForm;


    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForOperations(String operationsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + operationsCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForOperations(String operationsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + operationsCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForOperations() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findOperations(String operationsCode) {
        waitAndSendKeys(searchInputField, operationsCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + operationsCode + "']")));
    }

    public void setOperationsData(String operationsCode, String operationsDescription, String operationsMachine, String operationsStitchesInch, String operationsSuplement, String operationsDifficult, String operationsElaborate, String operationsAprobate, String operationsElement, String operationsDistance, String operationsSewing) {
        scrollToElement(operationsCodeInputForm);
        waitAndSendKeys(operationsCodeInputForm, operationsCode);
        waitAndSendKeys(operationsDescriptionInputForm, operationsDescription);
        customDropdown(operationsMachineDropDown, operationsDropDownInputForm, operationsDropDownSelect, operationsMachine);
        waitAndSendKeys(operationsStitchesInchInputForm, operationsStitchesInch);
        waitAndSendKeys(operationsSupplementInputForm, operationsSuplement);
        customDropdown(operationsDifficultDropDown, operationsDropDownInputForm, operationsDropDownSelect, operationsDifficult);
        customDropdown(operationsElaborateDropDown, operationsDropDownInputForm, operationsDropDownSelect, operationsElaborate);
        customDropdown(operationsAprobateDropDown, operationsDropDownInputForm, operationsDropDownSelect, operationsAprobate);
        customDropdown(operationsElementDropDown, operationsDropDownInputForm, operationsDropDownSelect, operationsElement);
        customDropdown(operationsDistanceDropDown, operationsDropDownInputForm, operationsDropDownSelect, operationsDistance);
        //waitAndSendKeys(operationsSewingInputForm, operationsSewing);
        scrollToElement(confirmAddOperations);
        clickWithJavaScript(confirmAddOperations);
    }

    public void validateOperationsInfo(String operationsCode, String operationsDescription, String operationsMachine, String operationsStitchesInch, String operationsSuplement, String operationsDifficult, String operationsElaborate, String operationsAprobate, String operationsElement, String operationsDistance, String operationsSewing) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(operationsCodeInputForm, "value", operationsCode));
        String currentMasterGenresCode = operationsCodeInputForm.getAttribute("value");
        String currentMasterGenresDescription = operationsDescriptionInputForm.getAttribute("value");
        Assert.assertEquals("El valor actual del código coincide con el esperado", operationsCode, currentMasterGenresCode);
        Assert.assertEquals("La descripción actual coincide con el esperado", operationsDescription, currentMasterGenresDescription);
    }

    public void addOperations(String operationsCode, String operationsDescription, String operationsMachine, String operationsStitchesInch, String operationsSuplement, String operationsDifficult, String operationsElaborate, String operationsAprobate, String operationsElement, String operationsDistance, String operationsSewing) {
        waitAndClick(addButton);
        setOperationsData(operationsCode,operationsDescription,operationsMachine,operationsStitchesInch,operationsSuplement,operationsDifficult, operationsElaborate,operationsAprobate,operationsElement,operationsDistance,operationsSewing);
    }

    public void editOperations(String operationsCode, String newOperationsCode, String newOperationsDescription, String newOperationsMachine, String newOperationsStitchesInch, String newOperationsSuplement, String newOperationsDifficult, String newOperationsElaborate, String newOperationsAprobate, String newOperationsElement, String newOperationsDistance, String newOperationsSewing ) {
        findOperations(operationsCode);
        waitAndClick(getEditButtonForOperations(operationsCode));
        setOperationsData(newOperationsCode, newOperationsDescription, newOperationsMachine, newOperationsStitchesInch, newOperationsSuplement,newOperationsDifficult,newOperationsElaborate,newOperationsAprobate, newOperationsElement,newOperationsDistance,newOperationsSewing);
    }

    public void validateOperations(String expectOperationsCode, String expectOperationsDescription, String expectOperationsMachine, String expectOperationsStitchesInch, String expectOperationsSuplement, String expectOperationsDifficult, String expectOperationsElaborate, String expectOperationsAprobate, String expectOperationsElement, String expectOperationsDistance, String expectOperationsSewing) {
        findOperations(expectOperationsCode);
        waitAndClick(getDetailsButtonForOperations(expectOperationsCode));
        validateOperationsInfo(expectOperationsCode, expectOperationsDescription, expectOperationsMachine, expectOperationsStitchesInch, expectOperationsSuplement,expectOperationsDifficult,expectOperationsElaborate,expectOperationsAprobate, expectOperationsElement,expectOperationsDistance,expectOperationsSewing);
        clickWithJavaScript(cancelButton);
    }

    public void deleteOperations(String operationsCode) {
        findOperations(operationsCode);
        scrollToElement(getDeleteButtonForOperations());
        waitAndClick(getDeleteButtonForOperations());
        waitAndClick(confirmButtonDelete);

    }

    public void customDropdown(WebElement dropDown, WebElement inputForm, WebElement select, String data) {
        scrollToElement(dropDown);
        waitAndClick(dropDown);
        waitAndSendKeys(inputForm, data);
        waitAndClick(select);
    }
}
