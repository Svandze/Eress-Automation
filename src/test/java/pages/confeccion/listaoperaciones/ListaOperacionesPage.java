package pages.confeccion.listaoperaciones;

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

public class ListaOperacionesPage extends BasePage {
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddOperationsListList;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement operationsListListCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='list_operation_name']")
    public WebElement operationsListListNameoperationsListListDescriptionInputForm;

    //Dropdown maquinas
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[1]")
    public WebElement operationsListListCustomerDropDown;

    @FindBy(xpath = "(//input[@class='p-dropdown-filter p-inputtext p-component'])[1]")
    public WebElement operationsListDropDownInputForm;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement operationsListDropDownSelect;

    @FindBy(xpath = "")
    public WebElement operationsListListCustomerDropDownData;



    //Dropdown grado de dificultad
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[2]")
    public WebElement operationsListListReferenceDifficultDropDown;


    @FindBy(xpath = "")
    public WebElement operationsListListReferenceDifficultDropDownData;

    //Dropdown elaborado
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[3]")
    public WebElement operationsListListElaborateDropDown;


    @FindBy(xpath = "")
    public WebElement operationsListListElaborateDropDownData;

    //Dropdown elaborado
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[4]")
    public WebElement operationsListListAprobateDropDown;

    @FindBy(xpath = "")
    public WebElement operationsListListAprobateDropDownData;

    //Dropdown elemento
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[5]")
    public WebElement operationsListListOperationDropDown;

    @FindBy(xpath = "")
    public WebElement operationsListListOperationElementDropDownData;


    @FindBy(xpath = "(//p-inputnumber[@type='number'])[1]/span/input")
    public WebElement operationsListListListSAMInputForm;


    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForOperationsList(String operationsListCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + operationsListCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForOperationsList(String operationsListCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + operationsListCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForOperationsList() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findOperationsList(String operationsListCode) {
        waitAndSendKeys(searchInputField, operationsListCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + operationsListCode + "']")));
    }

    public void setOperationsListData(String operationsListCode, String operationsListName, String operationsListCustomer,  String operationsListReference, String operationsListElaborate, String operationsListAprobate, String operationsListOperation, String operationsListSAM) {
        scrollToElement(operationsListListCodeInputForm);
        waitAndSendKeys(operationsListListCodeInputForm, operationsListCode);
        waitAndSendKeys(operationsListListNameoperationsListListDescriptionInputForm, operationsListName);
        customDropdown(operationsListListCustomerDropDown, operationsListDropDownInputForm, operationsListDropDownSelect, operationsListCustomer);
        customDropdown(operationsListListReferenceDifficultDropDown, operationsListDropDownInputForm, operationsListDropDownSelect, operationsListReference);
        customDropdown(operationsListListElaborateDropDown, operationsListDropDownInputForm, operationsListDropDownSelect, operationsListElaborate);
        customDropdown(operationsListListAprobateDropDown, operationsListDropDownInputForm, operationsListDropDownSelect, operationsListAprobate);
        customDropdown(operationsListListOperationDropDown, operationsListDropDownInputForm, operationsListDropDownSelect, operationsListOperation);
        waitAndSendKeys(operationsListListListSAMInputForm, operationsListSAM);
        scrollToElement(confirmAddOperationsListList);
        clickWithJavaScript(confirmAddOperationsListList);
    }

    public void validateOperationsListInfo(String operationsListCode, String operationsListName, String operationsListCustomer,  String operationsListReference, String operationsListElaborate, String operationsListAprobate, String operationsListOperation, String operationsListSAM) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(operationsListListCodeInputForm, "value", operationsListCode));
       /* String currentMasterGenresCode = operationsListListCodeInputForm.getAttribute("value");
        String currentMasterGenresDescription = operationsListListNameoperationsListListDescriptionInputForm.getAttribute("value");
        Assert.assertEquals("El valor actual del código coincide con el esperado", operationsListCode, currentMasterGenresCode);
        Assert.assertEquals("La descripción actual coincide con el esperado", operationsListDescription, currentMasterGenresDescription);*/
    }

    public void addOperationsList(String operationsListCode, String operationsListName, String operationsListCustomer,  String operationsListReference, String operationsListElaborate, String operationsListAprobate, String operationsListOperation, String operationsListSAM) {
        waitAndClick(addButton);
        setOperationsListData(operationsListCode,  operationsListName,  operationsListCustomer,   operationsListReference,  operationsListElaborate,  operationsListAprobate,  operationsListOperation,  operationsListSAM);
    }

    public void editOperationsList(String newOperationsListCode, String newOperationsListName, String newOperationsListCustomer,  String newOperationsListReference, String newOperationsListElaborate, String newOperationsListAprobate, String newOperationsListnewOperation, String newOperationsListSAM) {
        findOperationsList(newOperationsListCode);
        waitAndClick(getEditButtonForOperationsList(newOperationsListCode));
        setOperationsListData(newOperationsListCode,  newOperationsListName,  newOperationsListCustomer,   newOperationsListReference,  newOperationsListElaborate,  newOperationsListAprobate,  newOperationsListnewOperation,  newOperationsListSAM);
    }

    public void validateOperationsList(String expectOperationsListCode, String expectOperationsListName, String expectOperationsListCustomer,  String expectOperationsListReference, String expectOperationsListElaborate, String expectOperationsListAprobate, String expectOperationsListexpectOperation, String expectOperationsListSAM) {
        findOperationsList(expectOperationsListCode);
        waitAndClick(getDetailsButtonForOperationsList(expectOperationsListCode));
        validateOperationsListInfo(expectOperationsListCode,  expectOperationsListName,  expectOperationsListCustomer,   expectOperationsListReference,  expectOperationsListElaborate,  expectOperationsListAprobate,  expectOperationsListexpectOperation,  expectOperationsListSAM);
        clickWithJavaScript(cancelButton);
    }

    public void deleteOperationsList(String operationsListCode) {
        findOperationsList(operationsListCode);
        scrollToElement(getDeleteButtonForOperationsList());
        waitAndClick(getDeleteButtonForOperationsList());
        waitAndClick(confirmButtonDelete);

    }

    public void customDropdown(WebElement dropDown, WebElement inputForm, WebElement select, String data) {
        scrollToElement(dropDown);
        waitAndClick(dropDown);
        waitAndSendKeys(inputForm, data);
        waitAndClick(select);
    }
}
