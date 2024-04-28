package pages.confeccion.registrounidades;

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

public class RegistroUnidadesPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddUnitRegistration;

    //Dropdown taller
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[1]")
    public WebElement unitRegistrationWorkShopDropDown;

    @FindBy(xpath = "(//input[@class='p-dropdown-filter p-inputtext p-component'])[1]")
    public WebElement dropDownInputForm;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement dropDownSelect;

    @FindBy(xpath = "")
    public WebElement unitRegistrationWorkShopDropDownData;


    //Dropdown referencia
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[2]")
    public WebElement unitRegistrationReferenceDropDown;

    @FindBy(xpath = "")
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

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForUnitRegistration(String unitRegistrationCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + unitRegistrationCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForUnitRegistration(String unitRegistrationCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + unitRegistrationCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForUnitRegistration() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findUnitRegistration(String unitRegistrationCode) {
        waitAndSendKeys(searchInputField, unitRegistrationCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + unitRegistrationCode + "']")));
    }

    public void setUnitRegistrationData(String unitRegistrationWorkShop, String unitRegistrationReference, String unitRegistrationSAM, String unitRegistrationUnitsProduced, String unitRegistrationTurnMinute, String unitRegistrationExtraMinute, String unitRegistrationNPersonsMOD) {
        customDropdown(unitRegistrationWorkShopDropDown, dropDownInputForm, dropDownSelect, unitRegistrationWorkShop);
        customDropdown(unitRegistrationReferenceDropDown, dropDownInputForm, dropDownSelect,unitRegistrationReference);
        waitAndSendKeys(unitRegistrationSAMInputForm,unitRegistrationSAM);
        waitAndSendKeys(unitRegistrationUnitsProducedInputForm, unitRegistrationUnitsProduced);
        waitAndSendKeys(unitRegistrationTurnMinuteInputForm, unitRegistrationTurnMinute);
        waitAndSendKeys(unitRegistrationExtraMinuteInputForm, unitRegistrationExtraMinute);
        waitAndSendKeys(unitRegistrationNPersonsMODInputForm,unitRegistrationNPersonsMOD);
        scrollToElement(confirmAddUnitRegistration);
        clickWithJavaScript(confirmAddUnitRegistration);
    }

    public void validateUnitRegistrationInfo(String unitRegistrationWorkShop, String unitRegistrationReference, String unitRegistrationSAM, String unitRegistrationUnitsProduced, String unitRegistrationTurnMinute, String unitRegistrationExtraMinute, String unitRegistrationNPersonsMOD) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        /*wait.until(ExpectedConditions.attributeToBe(UnitRegistrationCodeInputForm, "value", operationsCode));
        String currentMasterGenresCode = UnitRegistrationCodeInputForm.getAttribute("value");
        String currentMasterGenresDescription = operationsDescriptionInputForm.getAttribute("value");
        Assert.assertEquals("El valor actual del código coincide con el esperado", operationsCode, currentMasterGenresCode);
        Assert.assertEquals("La descripción actual coincide con el esperado", operationsDescription, currentMasterGenresDescription);*/
    }

    public void addUnitRegistration(String unitRegistrationWorkShop, String unitRegistrationReference, String unitRegistrationSAM, String unitRegistrationUnitsProduced, String unitRegistrationTurnMinute, String unitRegistrationExtraMinute, String unitRegistrationNPersonsMOD) {
        waitAndClick(addButton);
        setUnitRegistrationData(unitRegistrationWorkShop, unitRegistrationReference,  unitRegistrationSAM,  unitRegistrationUnitsProduced,  unitRegistrationTurnMinute,   unitRegistrationExtraMinute,   unitRegistrationNPersonsMOD);
    }

    public void editUnitRegistration(String newUnitRegistrationWorkShop, String newUnitRegistrationReference, String newUnitRegistrationSAM, String newUnitRegistrationProduced, String newUnitRegistrationTurnMinute, String newUnitRegistrationExtraMinute, String newUnitRegistrationNPersonsMOD) {
        findUnitRegistration(newUnitRegistrationWorkShop);
        waitAndClick(getEditButtonForUnitRegistration(newUnitRegistrationWorkShop));
        setUnitRegistrationData(newUnitRegistrationWorkShop,   newUnitRegistrationReference,   newUnitRegistrationSAM,   newUnitRegistrationProduced,   newUnitRegistrationTurnMinute,   newUnitRegistrationExtraMinute,   newUnitRegistrationNPersonsMOD);
    }

    public void validateUnitRegistration(String expectUnitRegistrationWorkShop, String expectUnitRegistrationReference, String expectUnitRegistrationSAM, String expectUnitRegistrationProduced, String expectUnitRegistrationTurnMinute, String expectUnitRegistrationExtraMinute, String expectUnitRegistrationNPersonsMOD) {
        findUnitRegistration(expectUnitRegistrationWorkShop);
        waitAndClick(getDetailsButtonForUnitRegistration(expectUnitRegistrationWorkShop));
        validateUnitRegistrationInfo( expectUnitRegistrationWorkShop,  expectUnitRegistrationReference,  expectUnitRegistrationSAM,  expectUnitRegistrationProduced,  expectUnitRegistrationTurnMinute,  expectUnitRegistrationExtraMinute,  expectUnitRegistrationNPersonsMOD);
        clickWithJavaScript(cancelButton);
    }

    public void deleteUnitRegistration(String unitRegistrationCode) {
        findUnitRegistration(unitRegistrationCode);
        scrollToElement(getDeleteButtonForUnitRegistration());
        waitAndClick(getDeleteButtonForUnitRegistration());
        waitAndClick(confirmButtonDelete);

    }

    public void customDropdown(WebElement dropDown, WebElement inputForm, WebElement select, String data) {
        scrollToElement(dropDown);
        waitAndClick(dropDown);
        waitAndSendKeys(inputForm, data);
        waitAndClick(select);
    }
}
