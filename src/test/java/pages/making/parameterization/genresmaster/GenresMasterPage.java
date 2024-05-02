package pages.making.parameterization.genresmaster;

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

public class GenresMasterPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddMasterGenres;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement masterGenresCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement masterGenresDescriptionInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForMasterGenres(String movementGroupCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + movementGroupCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForMasterGenres(String movementGroupCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + movementGroupCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForMasterGenres() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findMasterGenres(String masterGenresCode) {
        waitAndSendKeys(searchInputField, masterGenresCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + masterGenresCode + "']")));
    }

    public void setMasterGenresData(String masterGenresCode, String masterGenresDescription) {
        scrollToElement(masterGenresCodeInputForm);
        waitAndSendKeys(masterGenresCodeInputForm, masterGenresCode);
        waitAndSendKeys(masterGenresDescriptionInputForm, masterGenresDescription);
        scrollToElement(confirmAddMasterGenres);
        clickWithJavaScript(confirmAddMasterGenres);
    }

    public void validateMasterGenresInfo(String masterGenresCode,  String masterGenresDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(masterGenresCodeInputForm, "value", masterGenresCode));
        String currentMasterGenresCode = masterGenresCodeInputForm.getAttribute("value");
        String currentMasterGenresDescription = masterGenresDescriptionInputForm.getAttribute("value");
        Assert.assertNotEquals("The current code value does not match the expected value", masterGenresCode, currentMasterGenresCode);
        Assert.assertNotEquals("The current description value does not match the expected value", masterGenresDescription, currentMasterGenresDescription);
    }

    public void addMasterGenresCode(String masterGenresCode, String masterGenresDescription) {
        waitAndClick(addButton);
        waitAndSendKeys(masterGenresCodeInputForm, masterGenresCode);
        setMasterGenresData(masterGenresCode, masterGenresDescription);
    }

    public void editMasterGenres(String masterGenresCode, String newMasterGenresCode,String newMasterGenresDescriptionString ) {
        findMasterGenres(masterGenresCode);
        waitAndClick(getEditButtonForMasterGenres(masterGenresCode));
        setMasterGenresData(newMasterGenresCode, newMasterGenresDescriptionString);
    }

    public void validateMasterGenres(String masterGenresCode, String expectMasterGenresCode,String expectMasterGenresDescription) {
        findMasterGenres(masterGenresCode);
        waitAndClick(getDetailsButtonForMasterGenres(masterGenresCode));
        validateMasterGenresInfo(expectMasterGenresCode, expectMasterGenresDescription);
        clickWithJavaScript(cancelButton);
    }

    public void deleteMasterGenres(String masterGenresCode) {
        findMasterGenres(masterGenresCode);
        scrollToElement(getDeleteButtonForMasterGenres());
        waitAndClick(getDeleteButtonForMasterGenres());
        waitAndClick(confirmButtonDelete);

    }


}
