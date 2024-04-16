package pages.confeccion.parametrizacion.gradodificultad;

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

public class GradoDificultadPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement levelDifficultyGroup;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement levelDifficultyCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement levelDifficultyDescriptionInputForm;

    @FindBy(xpath = "//p-inputnumber[@type='number']/span/input")
    public WebElement levelDifficultyCheckInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForLevelDifficulty(String levelDifficultyCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + levelDifficultyCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForLevelDifficulty(String levelDifficultyCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + levelDifficultyCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForLevelDifficulty() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findLevelDifficulty(String levelDifficultyCode) {
        waitAndSendKeys(searchInputField, levelDifficultyCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + levelDifficultyCode + "']")));
    }

    public void setLevelDifficultyData(String levelDifficultyCode, String levelDifficultyDescription, String levelDifficultyValue) {
        scrollToElement(levelDifficultyCodeInputForm);
        waitAndSendKeys(levelDifficultyCodeInputForm, levelDifficultyCode);
        waitAndSendKeys(levelDifficultyDescriptionInputForm, levelDifficultyDescription);
        waitAndSendKeys(levelDifficultyCheckInputForm, levelDifficultyValue);
        scrollToElement(levelDifficultyGroup);
        clickWithJavaScript(levelDifficultyGroup);
    }


    public void validateLevelDifficultyInfo(String levelDifficultyCode, String levelDifficultyDescription, String levelDifficultyValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(levelDifficultyCodeInputForm, "value", levelDifficultyCode));
        String currentMovementGroupCode = levelDifficultyCodeInputForm.getAttribute("value");
        String currentDescriptionMovementGroup = levelDifficultyDescriptionInputForm.getAttribute("value");
        String currentLevelDifficultyValue = levelDifficultyCheckInputForm.getAttribute("value");
        Assert.assertEquals("El valor actual del código del grupo de movimientos coincide con el esperado", levelDifficultyCode, currentMovementGroupCode);
        Assert.assertEquals("El valor actual de la descripción coincide con el esperado", levelDifficultyDescription, currentDescriptionMovementGroup);
        Assert.assertEquals("El valor actual del valor coincide con el esperado", levelDifficultyValue, currentLevelDifficultyValue);
    }

    public void addLevelDifficulty(String levelDifficultyCode, String levelDifficultyDescription, String levelDifficultyValue) {
        implicitWait();
        scrollToElement(addButton);
        waitAndClick(addButton);
        waitAndSendKeys(levelDifficultyCodeInputForm, levelDifficultyCode);
        setLevelDifficultyData(levelDifficultyCode, levelDifficultyDescription, levelDifficultyValue);
    }

    public void editLevelDifficulty(String levelDifficultyCode, String newLevelDifficultyCode, String newLevelDifficultyDescription, String newLevelDifficultyValue) {
        findLevelDifficulty(levelDifficultyCode);
        waitAndClick(getEditButtonForLevelDifficulty(levelDifficultyCode));
        setLevelDifficultyData(newLevelDifficultyCode, newLevelDifficultyDescription, newLevelDifficultyValue);
    }

    public void validateLevelDifficulty(String levelDifficultyCode, String expectLevelDifficultyCode, String expectLevelDifficultyDescription, String expectLevelDifficultyValue) {
        findLevelDifficulty(levelDifficultyCode);
        waitAndClick(getDetailsButtonForLevelDifficulty(levelDifficultyCode));
        validateLevelDifficultyInfo(expectLevelDifficultyCode, expectLevelDifficultyDescription, expectLevelDifficultyValue);
        clickWithJavaScript(cancelButton);
    }

    public void deleteLevelDifficulty(String levelDifficultyCode) {
        findLevelDifficulty(levelDifficultyCode);
        scrollToElement(getDeleteButtonForLevelDifficulty());
        waitAndClick(getDeleteButtonForLevelDifficulty());
        waitAndClick(confirmButtonDelete);
    }
}
