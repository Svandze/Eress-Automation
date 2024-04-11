package pages.confeccion.parametrizacion.tipocompetencia;

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
import static utils.ElementUtils.clickWithJavaScript;

public class TipoCompetenciaPage extends BasePage {
    @FindBy(xpath = "(//div[@class='p-checkbox-box'])[1]")
    public WebElement competitionTypeCheckSewing;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement competitionTypeBooleanElementsCheckSewing;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddCompetitionType;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement competitionTypeCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement competitionTypeDescriptionInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForCompetitionType(String competitionTypeCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + competitionTypeCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForCompetitionType(String competitionTypeCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + competitionTypeCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForCompetitionType() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findCompetitionType(String competitionTypeCode) {
        waitAndSendKeys(searchInputField, competitionTypeCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + competitionTypeCode + "']")));
    }

    public void setCompetitionTypeData(String competitionTypeCode, String competitionTypeDescription, boolean competitionType) {
        ScrollToElement(competitionTypeCodeInputForm);
        waitAndSendKeys(competitionTypeCodeInputForm, competitionTypeCode);
        waitAndSendKeys(competitionTypeDescriptionInputForm, competitionTypeDescription);
        verifyAndClickCheck(competitionTypeCheckSewing,  competitionType);
        ScrollToElement(confirmAddCompetitionType);
        clickWithJavaScript(confirmAddCompetitionType);
    }

    public void validateCompetitionTypeInfo(String competitionTypeCode, String competitionTypeDescription, boolean competitionTypeCheck) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(competitionTypeCodeInputForm, "value", competitionTypeCode));
        String currentMasterGenresCode = competitionTypeCodeInputForm.getAttribute("value");
        String currentMasterGenresDescription = competitionTypeDescriptionInputForm.getAttribute("value");
        String currentnMasterElementsCheck = competitionTypeBooleanElementsCheckSewing.getAttribute("aria-checked");
        Assert.assertEquals("El valor actual del código coincide con el esperado", competitionTypeCode, currentMasterGenresCode);
        Assert.assertEquals("La descripción actual coincide con el esperado", competitionTypeDescription, currentMasterGenresDescription);
        Assert.assertEquals("El valor actual del check coincide con el esperado",competitionTypeCheck, Boolean.parseBoolean(currentnMasterElementsCheck));

    }

    public void addCompetitionType(String competitionTypeCode, String competitionTypeDescription, Boolean checkCompetition) {
        clickWithJavaScript(addButton);
        setCompetitionTypeData(competitionTypeCode, competitionTypeDescription, checkCompetition);
    }

    public void editCompetitionType(String competitionTypeCode, String newCompetitionTypeCode, String newCompetitionTypeDescription, boolean newCompetitionTypeCheck ) {
        findCompetitionType(competitionTypeCode);
        waitAndClick(getEditButtonForCompetitionType(competitionTypeCode));
        setCompetitionTypeData(newCompetitionTypeCode, newCompetitionTypeDescription, newCompetitionTypeCheck);
    }

    public void validateCompetitionType(String competitionTypeCode, String expectCompetitionTypeCode, String expectCompetitionTypeDescription, boolean expectCompetitionTypeCheck) {
        findCompetitionType(competitionTypeCode);
        waitAndClick(getDetailsButtonForCompetitionType(competitionTypeCode));
        validateCompetitionTypeInfo(expectCompetitionTypeCode, expectCompetitionTypeDescription, expectCompetitionTypeCheck);
        clickWithJavaScript(cancelButton);
    }

    public void deleteCompetitionType(String competitionTypeCode) {
        findCompetitionType(competitionTypeCode);
        ScrollToElement(getDeleteButtonForCompetitionType());
        waitAndClick(getDeleteButtonForCompetitionType());
        waitAndClick(confirmButtonDelete);

    }

}
