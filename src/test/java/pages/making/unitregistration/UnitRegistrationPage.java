package pages.making.unitregistration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class UnitRegistrationPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddUnitRegistration;

    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[1]")
    public WebElement unitRegistrationWorkShopDropDown;

    @FindBy(xpath = "(//input[@class='p-dropdown-filter p-inputtext p-component'])[1]")
    public WebElement dropDownInputForm;

    @FindBy(xpath = "//li[@aria-label='Taller para Test E2E']")
    public WebElement dropDownSelect;

    @FindBy(xpath = "//p-calendar/span/input")
    public WebElement dateInputForm;

    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[2]")
    public WebElement unitRegistrationReferenceDropDown;

    @FindBy(xpath = "//p-dropdownitem/li")
    public WebElement unitRegistrationReferenceDropDownData;
    @FindBy(xpath = "(//p-inputnumber[@type='number'])[1]/span/input")
    public WebElement unitRegistrationSAMInputForm;
    @FindBy(xpath = "(//p-inputnumber[@type='number'])[2]/span/input")
    public WebElement unitRegistrationUnitsProducedInputForm;
    @FindBy(xpath = "(//p-inputnumber[@type='number'])[3]/span/input")
    public WebElement unitRegistrationTurnMinuteInputForm;
    @FindBy(xpath = "(//p-inputnumber[@type='number'])[4]/span/input")
    public WebElement unitRegistrationExtraMinuteInputForm;
    @FindBy(xpath = "(//p-inputnumber[@type='number'])[5]/span/input")
    public WebElement unitRegistrationNPersonsMODInputForm;

    @FindBy(xpath = "//button[normalize-space()='Agregar']")
    public WebElement addNewUnit;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;

    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;

    public WebElement getSpecifiedDateOnCalendar(String dayOfTheMonth) {
        return driver.findElement(By.xpath("//td[not(contains(@class, 'p-datepicker-other-month')) and span[text()='" + dayOfTheMonth + "']]"));
    }

    public WebElement getEditButtonForUnitRegistration(String unitRegistrationCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + unitRegistrationCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForUnitRegistration(String unitRegistrationCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + unitRegistrationCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForUnitRegistration() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void addNewUnitRegister(String dayOfMonth, String producedUnits, String turnMin, String extraMin, String nPersons) {
        waitAndClick(addButton);
        waitAndClick(unitRegistrationWorkShopDropDown);
        waitAndClick(dropDownSelect);
        waitAndClick(dateInputForm);
        waitAndClick(getSpecifiedDateOnCalendar(dayOfMonth));
        waitAndClick(unitRegistrationReferenceDropDown);
        waitAndClick(unitRegistrationReferenceDropDownData);
        waitAndSendKeys(unitRegistrationUnitsProducedInputForm, producedUnits);
        waitAndSendKeys(unitRegistrationTurnMinuteInputForm, turnMin);
        waitAndSendKeys(unitRegistrationExtraMinuteInputForm, extraMin);
        waitAndSendKeys(unitRegistrationNPersonsMODInputForm, nPersons);
        implicitWait();
        waitAndClick(addNewUnit);
        implicitWait();
    }

    public void editRegisteredUnit(String producedUnits, String turnMin, String extraMin, String nPersons) {
        searchForUnit();
        waitAndClick(getEditButtonForUnitRegistration("Taller para Test E2E"));
        implicitWait();
        waitAndSendKeys(unitRegistrationUnitsProducedInputForm, producedUnits);
        waitAndSendKeys(unitRegistrationTurnMinuteInputForm, turnMin);
        waitAndSendKeys(unitRegistrationExtraMinuteInputForm, extraMin);
        waitAndSendKeys(unitRegistrationNPersonsMODInputForm, nPersons);
        waitAndClick(addNewUnit);
        implicitWait();
    }

    public void validateUnitInformation(String producedUnits, String turnMin, String extraMin, String nPersons) {
        searchForUnit();
        waitAndClick(getDetailsButtonForUnitRegistration("Taller para Test E2E"));
        implicitWait();
        Assert.assertEquals(unitRegistrationUnitsProducedInputForm.getAttribute("value"), producedUnits);
        Assert.assertEquals(unitRegistrationTurnMinuteInputForm.getAttribute("value"), turnMin);
        Assert.assertEquals(unitRegistrationExtraMinuteInputForm.getAttribute("value"), extraMin);
        Assert.assertEquals(unitRegistrationNPersonsMODInputForm.getAttribute("value"), nPersons);
        waitAndClick(cancelButton);
        implicitWait();
    }

    public void deleteUnit() {
        searchForUnit();
        waitAndClick(getDeleteButtonForUnitRegistration());
        waitAndClick(confirmButtonDelete);
        implicitWait();
    }

    public void searchForUnit() {
        waitAndSendKeys(searchInputField, "Taller para Test E2E" + Keys.ENTER);
        implicitWait();
    }
}
