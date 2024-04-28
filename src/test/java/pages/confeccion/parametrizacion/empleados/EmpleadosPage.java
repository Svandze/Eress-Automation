package pages.confeccion.parametrizacion.empleados;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.Date;

public class EmpleadosPage extends BasePage {

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

    public WebElement getSpecifiedYear(int year) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + year + "') and contains(@class, 'p-yearpicker-year')]"));
    }

    public void setCalendarDate(WebElement element, int fromDate, int toDate) {
        Date initialDateRange = new Date();
        Date endDateRange = new Date();
        initialDateRange.setYear(fromDate - 1900);
        endDateRange.setYear(toDate - 1900);
        element.click();
        yearButton.click();
        getSpecifiedYear(2024).click();
    }

}
