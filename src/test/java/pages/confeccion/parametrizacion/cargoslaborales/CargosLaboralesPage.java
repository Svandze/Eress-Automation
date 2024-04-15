package pages.confeccion.parametrizacion.cargoslaborales;

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

public class CargosLaboralesPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddJobRoles;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement jobRolesCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement jobRolesDescriptionInputForm;

    @FindBy(xpath = "//seress-ui-button[@value='Agregar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForJobRoles(String jobRolesCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + jobRolesCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForJobRoles(String jobRolesCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + jobRolesCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForJobRoles() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findJobRoles(String jobRolesCode) {
        waitAndSendKeys(searchInputField, jobRolesCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + jobRolesCode + "']")));
    }

    public void setJobRolesData(String jobRolesCode, String jobRolesDescription) {
        scrollToElement(jobRolesCodeInputForm);
        waitAndSendKeys(jobRolesCodeInputForm, jobRolesCode);
        waitAndSendKeys(jobRolesDescriptionInputForm, jobRolesDescription);
        scrollToElement(confirmAddJobRoles);
        clickWithJavaScript(confirmAddJobRoles);
    }

    public void validateJobRolesInfo(String jobRolesCode, String jobRolesDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(jobRolesCodeInputForm, "value", jobRolesCode));
        String currentMasterGenresCode = jobRolesCodeInputForm.getAttribute("value");
        String currentMasterGenresDescription = jobRolesDescriptionInputForm.getAttribute("value");
        Assert.assertEquals("El valor actual del código coincide con el esperado", jobRolesCode, currentMasterGenresCode);
        Assert.assertEquals("La descripción actual coincide con el esperado", jobRolesDescription, currentMasterGenresDescription);
    }

    public void addJobRoles(String jobRolesCode, String jobRolesDescription) {
        waitAndClick(addButton);
        waitAndSendKeys(jobRolesCodeInputForm, jobRolesCode);
        setJobRolesData(jobRolesCode, jobRolesDescription);
    }

    public void editJobRoles(String jobRolesCode, String newJobRolesCode, String newJobRolesDescriptionString ) {
        findJobRoles(jobRolesCode);
        waitAndClick(getEditButtonForJobRoles(jobRolesCode));
        setJobRolesData(newJobRolesCode, newJobRolesDescriptionString);
    }

    public void validateJobRoles(String jobRolesCode, String expectJobRolesCode, String expectJobRolesDescription) {
        findJobRoles(jobRolesCode);
        waitAndClick(getDetailsButtonForJobRoles(jobRolesCode));
        validateJobRolesInfo(expectJobRolesCode, expectJobRolesDescription);
        clickWithJavaScript(cancelButton);
    }

    public void deleteJobRoles(String jobRolesCode) {
        findJobRoles(jobRolesCode);
        scrollToElement(getDeleteButtonForJobRoles());
        waitAndClick(getDeleteButtonForJobRoles());
        waitAndClick(confirmButtonDelete);

    }
}
