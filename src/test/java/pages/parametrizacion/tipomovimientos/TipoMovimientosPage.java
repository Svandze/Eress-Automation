package pages.parametrizacion.tipomovimientos;

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

public class TipoMovimientosPage extends BasePage {
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddTypesMovements;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement typesMovementsCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement typesMovementsDescriptionInputForm;

    @FindBy(xpath = "//p-checkbox[@class='p-element ng-valid ng-dirty ng-touched']/div/div")
    public WebElement typesMovementsCheckInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;

    @FindBy(xpath = "//p-checkbox[@inputid='is_machine'][1]")
    public WebElement typesMovementsElementsCheckSewing;

    @FindBy(xpath = "//input[@id='is_machine']")
    public WebElement typesMovementsBooleanElementsCheckSewing;



    public WebElement getEditButtonForTypesMovements(String typesMovementsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + typesMovementsCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForTypesMovements(String typesMovementsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + typesMovementsCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForTypesMovements() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findTypesMovements(String typesMovementsCode) {
        waitAndSendKeys(searchInputField, typesMovementsCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + typesMovementsCode + "']")));
    }

    public void setLevelTypesMovements(String typesMovementsCode, String typesMovementsDescription, Boolean typesMovementsCheck) {
        waitAndSendKeys(typesMovementsCodeInputForm, typesMovementsCode);
        waitAndSendKeys(typesMovementsDescriptionInputForm, typesMovementsDescription);
        verifyCheck(typesMovementsElementsCheckSewing, typesMovementsCheck);
        ScrollToElement(confirmAddTypesMovements);
        clickWithJavaScript(confirmAddTypesMovements);
    }

    public void validateTypesMovementsInfo(String typesMovementsCode, String typesMovementsDescription, Boolean typesMovementsCheck) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(typesMovementsCodeInputForm, "value", typesMovementsCode));
        String currentMovementGroupCode = typesMovementsCodeInputForm.getAttribute("value");
        String currentDescriptionMovementGroup = typesMovementsDescriptionInputForm.getAttribute("value");
        String currentnMasterElementsCheck = typesMovementsBooleanElementsCheckSewing.getAttribute("aria-checked");;
        Assert.assertEquals("El valor actual del código del grupo de movimientos coincide con el esperado", typesMovementsCode, currentMovementGroupCode);
        Assert.assertEquals("El valor actual de la descripción coincide con el esperado", typesMovementsDescription, currentDescriptionMovementGroup);
        Assert.assertEquals("El valor actual del check coincide con el esperado",(typesMovementsCheck).toString(),  currentnMasterElementsCheck);

    }

    public void addTypesMovements(String typesMovementsCode, String typesMovementsDescription, Boolean typesMovementsCheck) {
        implicitWait();
        clickWithJavaScript(addButton);
        waitAndSendKeys(typesMovementsCodeInputForm, typesMovementsCode);
        setLevelTypesMovements(typesMovementsCode, typesMovementsDescription, typesMovementsCheck);
    }

    public void editTypesMovements(String typesMovementsCode, String newTypesMovementsCode, String newTypesMovementsDescription, Boolean newTypesMovementsCheck) {
        findTypesMovements(typesMovementsCode);
        waitAndClick(getEditButtonForTypesMovements(typesMovementsCode));
        setLevelTypesMovements(newTypesMovementsCode, newTypesMovementsDescription, newTypesMovementsCheck);
    }

    public void validateTypesMovements(String typesMovementsCode, String expectTypesMovementsCode, String expectTypesMovementsDescription, Boolean expectTypesMovementsCheck) {
        findTypesMovements(typesMovementsCode);
        implicitWait();
        waitAndClick(getDetailsButtonForTypesMovements(typesMovementsCode));
        validateTypesMovementsInfo(expectTypesMovementsCode, expectTypesMovementsDescription, expectTypesMovementsCheck);
        clickWithJavaScript(cancelButton);
    }

    public void deleteTypesMovements(String typesMovementsCode) {
        findTypesMovements(typesMovementsCode);
        ScrollToElement(getDeleteButtonForTypesMovements());
        waitAndClick(getDeleteButtonForTypesMovements());
        waitAndClick(confirmButtonDelete);
    }

    public void verifyCheck(WebElement Check, Boolean checkSewing){
        try {
            if (checkSewing) {
                ScrollToElement(typesMovementsElementsCheckSewing);
                waitAndClick(typesMovementsElementsCheckSewing);
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error específico durante la espera o el clic: " + e.getMessage());
        }
    }
}
