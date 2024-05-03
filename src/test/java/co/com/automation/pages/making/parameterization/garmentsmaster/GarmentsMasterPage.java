package co.com.automation.pages.making.parameterization.garmentsmaster;

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

public class GarmentsMasterPage extends BasePage {
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement masterClothingAdd;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement masterClothingCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement masterClothingDescriptionInputForm;

    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[1]")
    public WebElement masterClothingDropDownStyle;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement masterClothingDropDownStyleInputForm;

    @FindBy(xpath = "//p-dropdownitem[1]/li[1]")
    public WebElement masterClothingDropDownStyleSelect;
    @FindBy(xpath = "(//div[@class='group-input flex justify-content-center'])[3]/seress-ui-dropdown-field")
    public WebElement masterClothingDropDownStyleDataInputForm;

    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[2]")
    public WebElement masterClothingDropDownGender;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement masterClothingDropDownGenderInputForm;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement masterClothingDropDownTypeMovementsSelect;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[2]")
    public WebElement masterClothingDropDownGenderDataInputForm;

    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[3]")
    public WebElement masterClothingDropDownWeave;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement masterClothingDropDownWeaveInputForm;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement masterClothingDropDownWeaveSelect;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[3]")
    public WebElement masterClothingDropDownWeaveDataInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForMasterClothing(String levelDifficultyCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + levelDifficultyCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForMasterClothing(String levelDifficultyCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + levelDifficultyCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForMasterClothing() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }


    public void findMasterClothing(String masterClothingCode) {
        waitAndSendKeys(searchInputField, masterClothingCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + masterClothingCode + "']")));
    }

    public void setMasterClothingData(String masterClothingCode, String masterClothingDescription, String masterClothingDropDownDataStyle, String masterClothingDropDownDataGender, String masterClothingDataDropDownWeave) {
        scrollToElement(masterClothingCodeInputForm);
        waitAndSendKeys(masterClothingCodeInputForm, masterClothingCode);
        waitAndSendKeys(masterClothingDescriptionInputForm, masterClothingDescription);
        customDropdown(masterClothingDropDownStyle, masterClothingDropDownStyleInputForm, masterClothingDropDownStyleSelect, masterClothingDropDownDataStyle);
        customDropdown(masterClothingDropDownGender, masterClothingDropDownGenderInputForm, masterClothingDropDownTypeMovementsSelect, masterClothingDropDownDataGender);
        customDropdown(masterClothingDropDownWeave, masterClothingDropDownWeaveInputForm, masterClothingDropDownWeaveSelect, masterClothingDataDropDownWeave);
        scrollToElement(masterClothingAdd);
        clickWithJavaScript(masterClothingAdd);
    }


    public void validateMasterClothingInfo(String masterClothingCode, String masterClothingDescription, String masterClothingStyle, String masterClothingGender, String masterClothingWeave) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(masterClothingCodeInputForm, "value", masterClothingCode));
        String currentMasterClothingCode = masterClothingCodeInputForm.getAttribute("value");
        String currentnMasterClothingDescription = masterClothingDescriptionInputForm.getAttribute("value");
        String currentnMasterClothingGroupMovements = masterClothingDropDownStyleDataInputForm.getText();
        String currentnMasterClothingTypeGender = masterClothingDropDownGenderDataInputForm.getText();
        String currentnMasterClothingWeave = masterClothingDropDownWeaveDataInputForm.getText();
        Assert.assertEquals("The current code value  matches the expected value", masterClothingCode, currentMasterClothingCode);
        Assert.assertEquals("The current description value  matches the expected value", masterClothingDescription, currentnMasterClothingDescription);
        Assert.assertTrue("The current style value  contain the expected value", currentnMasterClothingGroupMovements.contains(masterClothingStyle));
        Assert.assertTrue("The current gender value  contain the expected value", currentnMasterClothingTypeGender.contains(masterClothingGender));
        Assert.assertTrue("The current weave value  contain the expected value", currentnMasterClothingWeave.contains(masterClothingWeave));

    }

    public void addMasterClothing(String masterClothingCode, String masterClothingDescription, String masterClothingDropDownStyle, String masterClothingDropDownGender, String masterClothingDropDownWeave) {
        implicitWait();
        scrollToElement(addButton);
        waitAndClick(addButton);
        setMasterClothingData(masterClothingCode, masterClothingDescription, masterClothingDropDownStyle, masterClothingDropDownGender, masterClothingDropDownWeave);
    }

    public void editMasterClothing(String masterClothingCode, String newMasterClothingCode, String newMasterClothingDescription, String newMasterClothingStyle, String newMasterClothingGender, String newMasterClothingWeave) {
        findMasterClothing(masterClothingCode);
        waitAndClick(getEditButtonForMasterClothing(masterClothingCode));
        setMasterClothingData(newMasterClothingCode, newMasterClothingDescription, newMasterClothingStyle, newMasterClothingGender, newMasterClothingWeave);
    }

    public void validateMasterClothing(String expectMasterClothingCode, String expectMasterClothingDescription, String expectMasterClothingStyle, String expectMasterClothingGender, String expectMasterClothingWeave) {
        findMasterClothing(expectMasterClothingCode);
        waitAndClick(getDetailsButtonForMasterClothing(expectMasterClothingCode));
        validateMasterClothingInfo(expectMasterClothingCode, expectMasterClothingDescription, expectMasterClothingStyle, expectMasterClothingGender, expectMasterClothingWeave);
        clickWithJavaScript(cancelButton);
    }

    public void deleteMasterClothing(String masterClothingCode) {
        findMasterClothing(masterClothingCode);
        scrollToElement(getDeleteButtonForMasterClothing());
        waitAndClick(getDeleteButtonForMasterClothing());
        waitAndClick(confirmButtonDelete);
    }
    public void customDropdown(WebElement masterClothingDocumentType, WebElement masterClothingDocumentTypeInputForm, WebElement masterClothingDocumentTypeSelect, String data) {
        scrollToElement(masterClothingDocumentType);
        waitAndClick(masterClothingDocumentType);
        waitAndSendKeys(masterClothingDocumentTypeInputForm, data);
        waitAndClick(masterClothingDocumentTypeSelect);
    }
}

