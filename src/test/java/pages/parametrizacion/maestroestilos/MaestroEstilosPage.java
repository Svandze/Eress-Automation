package pages.parametrizacion.maestroestilos;

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

public class MaestroEstilosPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddMasterStyles;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement masterStylesCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement masterStylesDescriptionInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForMasterStyles(String masterStylesCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + masterStylesCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForMasterStyles(String masterStylesCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + masterStylesCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForMasterStyles() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findMasterStyles(String masterStylesCode) {
        waitAndSendKeys(searchInputField, masterStylesCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + masterStylesCode + "']")));
    }

    public void setMasterStyles(String masterStylespCode, String masterStylesDescription) {
        waitAndSendKeys(masterStylesCodeInputForm, masterStylespCode);
        waitAndSendKeys(masterStylesDescriptionInputForm, masterStylesDescription);
        ScrollToElement(confirmAddMasterStyles);
        clickWithJavaScript(confirmAddMasterStyles);
    }

    public void validateMasterStylesInfo(String masterStylesCode, String masterStylesDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(masterStylesCodeInputForm, "value", masterStylesCode));
        String currentMovementGroupCode = masterStylesCodeInputForm.getAttribute("value");
        String currentDescriptionMovementGroup = masterStylesDescriptionInputForm.getAttribute("value");
        Assert.assertEquals("El valor actual del código del grupo de movimientos coincide con el esperado", masterStylesCode, currentMovementGroupCode);
        Assert.assertEquals("El valor actual de la descripción coincide con el esperado", masterStylesDescription, currentDescriptionMovementGroup);
    }

    public void addMasterStyles(String masterStylesCode, String masterStylesDescription) throws InterruptedException {
        Thread.sleep(1000);
        ScrollToElement(addButton);
        Thread.sleep(1000);
        waitAndClick(addButton);
        waitAndSendKeys(masterStylesCodeInputForm, masterStylesCode);
        setMasterStyles(masterStylesCode, masterStylesDescription);
    }

    public void editMasterStyles(String masterStylesCode, String newMasterStylesCode, String NewMasterStylesDescription) {
        findMasterStyles(masterStylesCode);
        waitAndClick(getEditButtonForMasterStyles(masterStylesCode));
        setMasterStyles(newMasterStylesCode, NewMasterStylesDescription);
    }

    public void validateMasterStyles(String masterStylesCode, String expectMasterStylesCode, String expectMasterStylesDescription) {
        findMasterStyles(masterStylesCode);
        waitAndClick(getDetailsButtonForMasterStyles(masterStylesCode));
        validateMasterStylesInfo(expectMasterStylesCode, expectMasterStylesDescription);
        clickWithJavaScript(cancelButton);
    }

    public void deleteMasterStyles(String masterStylesCode) throws InterruptedException {
        findMasterStyles(masterStylesCode);
        Thread.sleep(500);
        waitAndClick(getDeleteButtonForMasterStyles());
        Thread.sleep(500);
        waitAndClick(confirmButtonDelete);
        Thread.sleep(500);
    }
}
