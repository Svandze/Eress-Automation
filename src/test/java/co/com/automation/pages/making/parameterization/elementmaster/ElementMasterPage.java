package co.com.automation.pages.making.parameterization.elementmaster;

import co.com.automation.pages.BasePage;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class ElementMasterPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement masterElementsAdd;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement masterElementsCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement masterElementsDescriptionInputForm;

    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[1]")
    public WebElement dropDownGruopMovementsMasterElements;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownGroupMovementsInputFormMasterElements;

    @FindBy(xpath = "//p-dropdownitem[1]/li[1]")
    public WebElement dropDownGroupMovementsSelectMasterElements;
    @FindBy(xpath = "(//div[@class='group-input flex justify-content-center'])[3]/seress-ui-dropdown-field")
    public WebElement dropDownGroupMovementsDataInputFormMasterElement;


    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[2]")
    public WebElement dropDownTypeMovementsMasterElements;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownTypeMovementsInputFormMasterElements;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement dropDownTypeMovementsSelectMasterElements;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[2]")
    public WebElement dropDownTypeMovementsDataInputFormMasterElements;


    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[3]")
    public WebElement dropDownDistanceMasterElements;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownDistanceInputFormMasterElements;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement dropDownDistanceSelectMasterElements;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[3]")
    public WebElement dropDownDistanceDataInputFormMasterElements;
    //AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII

    @FindBy(xpath = "(//td[@class='ng-star-inserted'])[2]/p-inputnumber/span/input")
    public WebElement masterElementsTimeInputForm;

    @FindBy(xpath = "//button[normalize-space()='Agregar Distancia']")
    public WebElement masterElementsAddDistancebutton;

    @FindBy(xpath = "(//i[@class='pi pi-bg pi-custom pi-delete btn-bg-gray m-0 ng-star-inserted'])[2]")
    public WebElement masterElementsDeleteDistanceIcon;

    @FindBy(xpath = "//p-checkbox[@inputid='is_sewing'][1]")
    public WebElement masterElementscheckSewing;
    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;

    @FindBy(xpath = "//input[@id='is_sewing']")
    public WebElement checkBooleanMasterElements;


    public WebElement getEditButtonForMasterElements(String levelDifficultyCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + levelDifficultyCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForMasterElements(String levelDifficultyCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + levelDifficultyCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForMasterElements() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }


    public void findMasterElements(String masterElementsCode) {
        waitAndSendKeys(searchInputField, masterElementsCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + masterElementsCode + "']")));
    }

    public void setMasterElementsData(String masterElementsCode, String masterElementsDescription, String masterElementsDropDownDataGroupMovements, String masterElementsDropDownDataTypeMovements, String masterElementsDataDropDownDistance, String masterElementsTimeData, Boolean checkSewingMasterElements) {
        scrollToElement(masterElementsCodeInputForm);
        waitAndSendKeys(masterElementsCodeInputForm, masterElementsCode);
        waitAndSendKeys(masterElementsDescriptionInputForm, masterElementsDescription);
        customDropdown(dropDownGruopMovementsMasterElements, dropDownGroupMovementsInputFormMasterElements, dropDownGroupMovementsSelectMasterElements, masterElementsDropDownDataGroupMovements);
        customDropdown(dropDownTypeMovementsMasterElements, dropDownTypeMovementsInputFormMasterElements, dropDownTypeMovementsSelectMasterElements, masterElementsDropDownDataTypeMovements);
        verifyCheck(masterElementscheckSewing, checkSewingMasterElements);
        customDropdown(dropDownDistanceMasterElements, dropDownDistanceInputFormMasterElements, dropDownDistanceSelectMasterElements, masterElementsDataDropDownDistance);
        waitAndSendKeys(masterElementsTimeInputForm, masterElementsTimeData);
        scrollToElement(masterElementsAdd);
        clickWithJavaScript(masterElementsAdd);
    }


    public void validateMasterElementsInfo(String masterElementsCode, String masterElementsDescription, String masterElementsGroupMovements, String masterElementsTypeMovements, String masterElementsDistance, String masterElementsTime, Boolean masterElementsCheck) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(masterElementsCodeInputForm, "value", masterElementsCode));
        String currentMasterElementsCode = masterElementsCodeInputForm.getAttribute("value");
        String currentnMasterElementsDescription = masterElementsDescriptionInputForm.getAttribute("value");
        String currentnMasterElementsGroupMovements = dropDownGroupMovementsDataInputFormMasterElement.getText();
        String currentnMasterElementsTypeMovement = dropDownTypeMovementsDataInputFormMasterElements.getText();
        String currentnMasterElementsCheck = checkBooleanMasterElements.getAttribute("aria-checked");
        String currentnMasterElementsDistance = dropDownDistanceDataInputFormMasterElements.getText();
        String currentnMasterElementsTime = masterElementsTimeInputForm.getAttribute("value");
        assertEquals(masterElementsCode, currentMasterElementsCode, "The current code value of the movement group  matches the expected value");
        assertEquals(masterElementsDescription, currentnMasterElementsDescription, "The current description value  matches the expected value");
        assertTrue(currentnMasterElementsGroupMovements.contains(masterElementsGroupMovements), "The current group movements value  contain the expected value" );
        assertTrue(currentnMasterElementsTypeMovement.contains(masterElementsTypeMovements), "The current type movements value  contain the expected value");
        assertEquals(currentnMasterElementsCheck, (masterElementsCheck).toString(), "The current check value  matches the expected value");
        assertEquals((masterElementsCheck).toString(), currentnMasterElementsCheck, "The current code value of the movement group  matches the expected value");
        assertTrue(currentnMasterElementsDistance.contains(masterElementsDistance), "The current distance value  contain the expected value");
        assertEquals(masterElementsTime, currentnMasterElementsTime, "The current time movements value  matches the expected value");

    }

    public void addMasterElements(String masterElementsCode, String masterElementsDescription, String masterElementsDropDownGroupMovements, String masterElementsDropDownTypeMovements, String masterElementsDropDownDistance, String masterElementsTime, Boolean masterElementsCheck) {
        implicitWait();
        scrollToElement(addButton);
        waitAndClick(addButton);
        setMasterElementsData(masterElementsCode, masterElementsDescription, masterElementsDropDownGroupMovements, masterElementsDropDownTypeMovements, masterElementsDropDownDistance, masterElementsTime, masterElementsCheck);
    }

    public void editMasterElements(String masterElementsCode, String newMasterElementsCode, String newMasterElementsDescription, String newMasterElementsMovementsGroup, String newMasterElementsTypeMovement, String newMasterElementsDistance, String newMasterElementsTime, Boolean masterElementsCheck) {
        findMasterElements(masterElementsCode);
        waitAndClick(getEditButtonForMasterElements(masterElementsCode));
        setMasterElementsData(newMasterElementsCode, newMasterElementsDescription, newMasterElementsMovementsGroup, newMasterElementsTypeMovement, newMasterElementsDistance, newMasterElementsTime, masterElementsCheck);
    }

    public void validateMasterElements(String expectMasterElementsCode, String expectMasterElementsDescription, String expectMasterElementsGroupMovements, String expectMasterElementsTypeMovements, String expectMasterElementsDistance, String expectMasterElementsTime, Boolean masterElementsCheck) {
        findMasterElements(expectMasterElementsCode);
        waitAndClick(getDetailsButtonForMasterElements(expectMasterElementsCode));
        validateMasterElementsInfo(expectMasterElementsCode, expectMasterElementsDescription, expectMasterElementsGroupMovements, expectMasterElementsTypeMovements, expectMasterElementsDistance, expectMasterElementsTime, masterElementsCheck);
        clickWithJavaScript(cancelButton);
    }

    public void deleteMasterElements(String masterElementsCode) {
        findMasterElements(masterElementsCode);
        scrollToElement(getDeleteButtonForMasterElements());
        waitAndClick(getDeleteButtonForMasterElements());
        waitAndClick(confirmButtonDelete);
        implicitWait();
    }

    public void customDropdown(WebElement masterCustomeDocumentType, WebElement masterCustomerDocumentTypeInputForm, WebElement masterCustomerDocumentTypeSelect, String data) {
        scrollToElement(masterCustomeDocumentType);
        waitAndClick(masterCustomeDocumentType);
        waitAndSendKeys(masterCustomerDocumentTypeInputForm, data);
        waitAndClick(masterCustomerDocumentTypeSelect);
    }

    public void verifyCheck(WebElement Check, Boolean checkSewing) {
        try {
            if (checkSewing && masterElementscheckSewing.isDisplayed()) {
                scrollToElement(masterElementscheckSewing);
                waitAndClick(masterElementscheckSewing);
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error específico durante la espera o el clic: " + e.getMessage());
        }
    }

}

