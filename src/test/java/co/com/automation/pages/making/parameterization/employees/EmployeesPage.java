package co.com.automation.pages.making.parameterization.employees;

import co.com.automation.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.ElementUtils.implicitWait;
import static utils.ElementUtils.scrollToElement;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.waitAndSendKeys;

public class EmployeesPage extends BasePage {

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addNewEmployee;

    @FindBy(css = "p-dropdown div")
    public WebElement idDropdown;

    @FindBy(xpath = "//input[@formcontrolname='document']")
    public WebElement documentInput;

    @FindBy(xpath = "//input[@formcontrolname='names']")
    public WebElement namesInput;

    @FindBy(xpath = "//input[@formcontrolname='surnames']")
    public WebElement surnameInput;

    @FindBy(xpath = "(//p-checkbox/div/div[@class='p-checkbox-box'])[1]")
    public WebElement isEmployee;

    @FindBy(xpath = "(//p-checkbox/div/div[@class='p-checkbox-box'])[2]")
    public WebElement isOperator;

    @FindBy(xpath = "//input[@formcontrolname='phone1']")
    public WebElement firstPhoneNumberInput;

    @FindBy(xpath = "//input[@formcontrolname='phone2']")
    public WebElement secondPhoneNumberInput;

    @FindBy(xpath = "//input[@formcontrolname='adress1']")
    public WebElement firstAddressInput;

    @FindBy(xpath = "//input[@formcontrolname='adress2']")
    public WebElement secondAddressInput;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//span[contains(text(),'Seleccionar Cargo')]")
    public WebElement selectPositionDropdown;

    @FindBy(xpath = "//span[contains(text(),'Seleccionar Sexo')]")
    public WebElement selectSexDropdown;

    @FindBy(xpath = "//span[contains(text(),'Seleccionar Turno')]")
    public WebElement selectShiftDropdown;

    @FindBy(xpath = "//p-calendar[@formcontrolname='admission_date']/span/input")
    public WebElement admissionDateCalendar;

    @FindBy(xpath = "//p-calendar[@formcontrolname='birthdate']/span/input")
    public WebElement birthDateCalendar;

    @FindBy(xpath = "//span[contains(text(),'Seleccionar Región')]")
    public WebElement selectBirthPlaceDropdown;

    @FindBy(xpath = "//span[contains(text(),'Seleccionar Estado Civil')]")
    public WebElement selectMaritalStatusDropdown;

    @FindBy(xpath = "(//p-dropdownitem)[1]")
    public WebElement getFirstDropdownOption;

    @FindBy(xpath = "//seress-ui-button[@type='submit']")
    public WebElement confirmNewEmployeeButton;

    @FindBy(css = ".p-datepicker-year")
    public WebElement yearButton;

    @FindBy(xpath = "//span[contains(@class,'p-ripple')]")
    public WebElement monthButton;

    @FindBy(xpath = "//tbody/tr[3]/td[4]")
    public WebElement dayButton;

    @FindBy(xpath = "(//input[@placeholder='Buscar'])[2]")
    public WebElement searchBar;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement okDeleteButton;

    public WebElement getSpecifiedYear(int year) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + year + "') and contains(@class, 'p-yearpicker-year')]"));
    }

    public WebElement getEditButtonForEmployee(String document) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + document + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForEmployee(String document) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + document + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForEmployee(String document) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + document + "')]/following-sibling::td/div/seress-ui-button)[3]"));
    }

    public void setCalendarDate(WebElement element, int year) {
        element.click();
        yearButton.click();
        getSpecifiedYear(year).click();
        monthButton.click();
        dayButton.click();
    }

    public void createEmployee(String id, String name, String surname, String firstPhoneNumber, String secondPhoneNumber, String firstAddress, String secondAddress, String email) {
        waitAndClick(addNewEmployee);
        implicitWait();
        waitAndClick(idDropdown);
        waitAndClick(getFirstDropdownOption);
        waitAndSendKeys(documentInput, id);
        waitAndSendKeys(namesInput, name);
        waitAndSendKeys(surnameInput, surname);
        waitAndClick(isEmployee);
        waitAndSendKeys(firstPhoneNumberInput, firstPhoneNumber);
        waitAndSendKeys(secondPhoneNumberInput, secondPhoneNumber);
        waitAndSendKeys(firstAddressInput, firstAddress);
        waitAndSendKeys(secondAddressInput, secondAddress);
        waitAndSendKeys(emailInput, email);
        scrollToElement(selectPositionDropdown);
        waitAndClick(selectPositionDropdown);
        waitAndClick(getFirstDropdownOption);
        waitAndClick(selectSexDropdown);
        waitAndClick(getFirstDropdownOption);
        waitAndClick(selectShiftDropdown);
        waitAndClick(getFirstDropdownOption);
        setCalendarDate(admissionDateCalendar, 2024);
        setCalendarDate(birthDateCalendar, 2021);
        waitAndClick(selectBirthPlaceDropdown);
        waitAndClick(getFirstDropdownOption);
        waitAndClick(selectMaritalStatusDropdown);
        waitAndClick(getFirstDropdownOption);
        scrollToElement(confirmNewEmployeeButton);
        waitAndClick(confirmNewEmployeeButton);
    }

    public void editEmployee(String idToSearch, String id, String name, String surname, String firstPhoneNumber, String secondPhoneNumber, String firstAddress, String secondAddress, String email) {
        waitAndSendKeys(searchBar, idToSearch + Keys.ENTER);
        implicitWait();
        waitAndClick(getEditButtonForEmployee(idToSearch));
        implicitWait();
        waitAndSendKeys(documentInput, id);
        waitAndSendKeys(namesInput, name);
        waitAndSendKeys(surnameInput, surname);
        waitAndClick(isEmployee);
        waitAndSendKeys(firstPhoneNumberInput, firstPhoneNumber);
        waitAndSendKeys(secondPhoneNumberInput, secondPhoneNumber);
        waitAndSendKeys(firstAddressInput, firstAddress);
        waitAndSendKeys(secondAddressInput, secondAddress);
        waitAndSendKeys(emailInput, email);
        scrollToElement(confirmNewEmployeeButton);
        waitAndClick(confirmNewEmployeeButton);
    }

    public void validateEmployeeDetails(String expectedId, String expectedName) {
        waitAndSendKeys(searchBar, expectedId + Keys.ENTER);
        implicitWait();
        waitAndClick(getDetailsButtonForEmployee(expectedId));
        implicitWait();
        String currentDocument = documentInput.getAttribute("value");
        String currentName = namesInput.getAttribute("value");
        Assert.assertEquals(currentDocument, expectedId);
        Assert.assertEquals(currentName, expectedName);
        scrollToElement(cancelButton);
        waitAndClick(cancelButton);
    }

    public void deleteEmployee(String id) {
        waitAndSendKeys(searchBar, id + Keys.ENTER);
        implicitWait();
        waitAndClick(getDeleteButtonForEmployee(id));
        waitAndClick(okDeleteButton);
        implicitWait();
    }

}
