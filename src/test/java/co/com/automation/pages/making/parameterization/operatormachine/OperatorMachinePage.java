package co.com.automation.pages.making.parameterization.operatormachine;
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

public class OperatorMachinePage extends BasePage {

    @FindBy(xpath = "//seress-ui-button[@value='Agregar']")
    public WebElement confirmAddMachinesOperator;

    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[1]")
    public WebElement dropDownEmployeeMachinesOperator;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownEmployeeInputFormMachinesOperator;

    @FindBy(xpath = "(//div[@class='p-dropdown-items-wrapper'])[1]/ul/p-dropdownitem[1]/li")
    public WebElement dropDownEmployeeMachinesOperatorSelect;
    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[1]")
    public WebElement dropDownEmployeeMachinesOperatorData;

    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[2]")
    public WebElement dropDownMachineMachinesOperator;
    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownMachineInputFormMachinesOperator;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement dropDownMachineSelectMachinesOperator;
    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[2]")
    public WebElement dropDownMachineDataMachinesOperator;

    @FindBy(xpath = "//button[normalize-space()='Agregar Máquina']")
    public WebElement buttonAddMachineMachinesOperator;

    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[3]")
    public WebElement dropDownAssignmentMachinesOperator;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownAssignmentInputFormMachinesOperator;


    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement dropDownAssignmentSelectMachinesOperator;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[2]")
    public WebElement dropDownAssignmentDataMachineOperator;

    //aqui

    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[4]")
    public WebElement dropDownMachinesMachinesOperator;
    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownMachinesInputFormMachinesOperator;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement dropDownMachinesSelectMachinesOperator;
    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[3]")
    public WebElement dropDownMachinesDataMachinesOperator;

    @FindBy(xpath = "(//i[@class='pi pi-bg pi-custom pi-delete btn-bg-gray m-0 ng-star-inserted'])[1]")
    public WebElement iconDelete;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForMachinesOperator(String machineOperatorCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + machineOperatorCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForMachinesOperator(String machineOperatorCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + machineOperatorCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForMachinesOperator() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findMachinesOperator(String workshopCode) {
        waitAndSendKeys(searchInputField, workshopCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + workshopCode + "']")));
    }

    public void setMachinesOperator(String machinesOperatorEmployee, String machinesOperatorMachine, String machinesOperatorAssignment, String machinesOperatorMachines) {
        customDropdown(dropDownEmployeeMachinesOperator, dropDownEmployeeInputFormMachinesOperator, dropDownEmployeeMachinesOperatorSelect, machinesOperatorEmployee);
        customDropdown(dropDownMachineMachinesOperator, dropDownMachineInputFormMachinesOperator, dropDownMachineSelectMachinesOperator,machinesOperatorMachine );
        waitAndClick(buttonAddMachineMachinesOperator);
        customDropdown(dropDownAssignmentMachinesOperator, dropDownAssignmentInputFormMachinesOperator, dropDownAssignmentSelectMachinesOperator, machinesOperatorAssignment);
        customDropdown(dropDownMachinesMachinesOperator, dropDownMachinesInputFormMachinesOperator, dropDownMachinesSelectMachinesOperator,machinesOperatorMachines);

        waitAndClick(confirmAddMachinesOperator);
    }

    public void validateMachinesOperatorInfo(String  machinesOperatorEmployee, String  machinesOperatorMachine, String  machinesOperatorAssignment, String  machinesOperatorMachines) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        String currentWorkshopCustomer = dropDownEmployeeMachinesOperatorData.getText();
        String currentWorkshopMachine = dropDownAssignmentDataMachineOperator.getText();
        String currentWorkshopMachines = dropDownMachinesDataMachinesOperator.getText();
        Assert.assertTrue("The current employee value  contain the expected value", currentWorkshopCustomer.contains(machinesOperatorEmployee));
        Assert.assertTrue("The current workshop assignment value  contain the expected value", currentWorkshopMachine.contains(machinesOperatorAssignment));
        Assert.assertTrue("The current workshop machines value  contain the expected value", currentWorkshopMachines.contains(machinesOperatorMachines));

    }

    public void addMachinesOperator(String machinesOperatorEmployee, String machinesOperatorMachine, String machinesOperatorAssignment, String machinesOperatorMachines) {
        clickWithJavaScript(addButton);
        setMachinesOperator(machinesOperatorEmployee, machinesOperatorMachine, machinesOperatorAssignment, machinesOperatorMachines);
    }

    public void editMachinesOperator(String employeeDocument, String newMachinesOperatorEmployee , String newMachinesOperatorMachine, String newMachinesOperatorAssignment, String newMachinesOperatorMachines) {
        findMachinesOperator(employeeDocument);
        waitAndClick(getEditButtonForMachinesOperator(employeeDocument));
        waitAndClick(iconDelete);
        implicitWait();
        waitAndClick(confirmButtonDelete);
        setMachinesOperator(newMachinesOperatorEmployee, newMachinesOperatorMachine,newMachinesOperatorAssignment, newMachinesOperatorMachines);
    }

    public void validateMachinesOperator(String employeeDocument, String machinesOperatorEmployee, String machinesOperatorMachine, String machinesOperatorAssignment, String machinesOperatorMachines) {
        findMachinesOperator(employeeDocument);
        waitAndClick(getDetailsButtonForMachinesOperator(employeeDocument));
        validateMachinesOperatorInfo(machinesOperatorEmployee, machinesOperatorMachine, machinesOperatorAssignment, machinesOperatorMachines);
        clickWithJavaScript(cancelButton);
    }

    public void deleteMachinesOperator(String employeeDocument) {
        findMachinesOperator(employeeDocument);
        implicitWait();
        clickWithJavaScript(getDeleteButtonForMachinesOperator());
        implicitWait();
        clickWithJavaScript(confirmButtonDelete);
    }

    public void customDropdown(WebElement machinesOperatorUpArrow, WebElement machinesOperatorInputForm, WebElement machinesOperatorSelect, String data) {
        scrollToElement(machinesOperatorUpArrow);
        waitAndClick(machinesOperatorUpArrow);
        waitAndSendKeys(machinesOperatorInputForm, data);
        waitAndClick(machinesOperatorSelect);
        implicitWait();
    }


}