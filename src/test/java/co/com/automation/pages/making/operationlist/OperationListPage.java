package co.com.automation.pages.making.operationlist;

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

public class OperationListPage extends BasePage {
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddOperationsListList;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement operationsListListCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='list_operation_name']")
    public WebElement operationsListListNameInputForm;

    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[1]")
    public WebElement operationsListListCustomerDropDown;

    @FindBy(xpath = "(//input[@class='p-dropdown-filter p-inputtext p-component'])[1]")
    public WebElement operationsListDropDownInputForm;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement operationsListDropDownSelect;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[1]")
    public WebElement operationsListListCustomerDropDownData;


    //Dropdown grado de dificultad
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[2]")
    public WebElement operationsListListReferenceDifficultDropDown;


    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[2]")
    public WebElement operationsListListReferenceDropDownData;

    //Dropdown elaborado
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[3]")
    public WebElement operationsListListElaborateDropDown;


    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[3]")
    public WebElement operationsListListElaborateDropDownData;

    //Dropdown elaborado
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[4]")
    public WebElement operationsListListAprobateDropDown;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[4]")
    public WebElement operationsListListAprobateDropDownData;

    //Dropdown elemento
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[5]")
    public WebElement operationsListOperationDropDown;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[5]")
    public WebElement operationsListOperationElementDropDownData;


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

    public void setOperationsListData(String operationsListCode, String operationsListName, String operationsListCustomer,  String operationsListReference, String operationsListElaborate, String operationsListAprobate, String operationsListOperation) {
        scrollToElement(operationsListListCodeInputForm);
        waitAndSendKeys(operationsListListCodeInputForm, operationsListCode);
        waitAndSendKeys(operationsListListNameInputForm, operationsListName);
        customDropdown(operationsListListCustomerDropDown, operationsListDropDownInputForm, operationsListDropDownSelect, operationsListCustomer);
        customDropdown(operationsListListReferenceDifficultDropDown, operationsListDropDownInputForm, operationsListDropDownSelect, operationsListReference);
        customDropdown(operationsListListElaborateDropDown, operationsListDropDownInputForm, operationsListDropDownSelect, operationsListElaborate);
        customDropdown(operationsListListAprobateDropDown, operationsListDropDownInputForm, operationsListDropDownSelect, operationsListAprobate);
        customDropdown(operationsListOperationDropDown, operationsListDropDownInputForm, operationsListDropDownSelect, operationsListOperation);
        scrollToElement(confirmAddOperationsListList);
        clickWithJavaScript(confirmAddOperationsListList);
    }

    public void validateOperationsListInfo(String operationsListCode, String operationsListName, String operationsListCustomer,  String operationsListReference, String operationsListElaborate, String operationsListAprobate, String operationsListOperation) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(operationsListListCodeInputForm, "value", operationsListCode));
        String currentOperationsListCode = operationsListListCodeInputForm.getAttribute("value");
        String currentOperationsLisName = operationsListListNameInputForm.getAttribute("value");
        String currentOperationsCustomer = operationsListListCustomerDropDownData.getText();
        String currentOperationsReference = operationsListListReferenceDropDownData.getText();
        String currentOperationsElaborate = operationsListListElaborateDropDownData.getText();
        String currentOperationsAprobate = operationsListListAprobateDropDownData.getText();
        String currentOperationsOperation= operationsListOperationElementDropDownData.getText();
        Assert.assertEquals("El valor actual del código coincide con el esperado", operationsListCode, currentOperationsListCode);
        Assert.assertEquals("El nombre actual coincide con el esperado", operationsListName, currentOperationsLisName);
        Assert.assertTrue("El valor actual del cliente coincide con el esperado", currentOperationsCustomer.contains(operationsListCustomer));
        Assert.assertTrue("El valor actual de la referencia coincide con el esperado", currentOperationsReference.contains(operationsListReference));
        Assert.assertTrue("El valor actual del elaborado coincide con el esperado", currentOperationsElaborate.contains(operationsListElaborate));
        Assert.assertTrue("El valor actual del aprobado coincide con el esperado", currentOperationsAprobate.contains(operationsListAprobate));
        Assert.assertTrue("El valor actual de la operación coincide con el esperado", currentOperationsOperation.contains(operationsListOperation));

    }

    public void addOperationsList(String operationsListCode, String operationsListName, String operationsListCustomer,  String operationsListReference, String operationsListElaborate, String operationsListAprobate, String operationsListOperation) {
        waitAndClick(addButton);
        setOperationsListData(operationsListCode,  operationsListName,  operationsListCustomer,   operationsListReference,  operationsListElaborate,  operationsListAprobate,  operationsListOperation);
    }

    public void editOperationsList(String operationListCode, String newOperationsListCode, String newOperationsListName, String newOperationsListCustomer,  String newOperationsListReference, String newOperationsListElaborate, String newOperationsListAprobate, String newOperationsListnewOperation) {
        findOperationsList(operationListCode);
        waitAndClick(getEditButtonForOperationsList(operationListCode));
        setOperationsListData(newOperationsListCode,  newOperationsListName,  newOperationsListCustomer,   newOperationsListReference,  newOperationsListElaborate,  newOperationsListAprobate,  newOperationsListnewOperation);
    }

    public void validateOperationsList(String expectOperationsListCode, String expectOperationsListName, String expectOperationsListCustomer,  String expectOperationsListReference, String expectOperationsListElaborate, String expectOperationsListAprobate, String expectOperationsListexpectOperation) {
        findOperationsList(expectOperationsListCode);
        waitAndClick(getDetailsButtonForOperationsList(expectOperationsListCode));
        validateOperationsListInfo(expectOperationsListCode,  expectOperationsListName,  expectOperationsListCustomer,   expectOperationsListReference,  expectOperationsListElaborate,  expectOperationsListAprobate,  expectOperationsListexpectOperation);
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
        implicitWait();
        waitAndClick(select);
    }
}
