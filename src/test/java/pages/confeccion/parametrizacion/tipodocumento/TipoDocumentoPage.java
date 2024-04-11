package pages.confeccion.parametrizacion.tipodocumento;

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

public class TipoDocumentoPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddDocumentType;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement documentTypeCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement documentTypeDescriptionInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForDocumentType(String documentTypeCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + documentTypeCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForDocumentType(String documentTypeCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + documentTypeCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForDocumentType() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findDocumentType(String documentTypeCode) {
        waitAndSendKeys(searchInputField, documentTypeCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + documentTypeCode + "']")));
    }

    public void setDocumentTypeData(String documentTypeCode, String documentTypeDescription) {
        ScrollToElement(documentTypeCodeInputForm);
        waitAndSendKeys(documentTypeCodeInputForm, documentTypeCode);
        waitAndSendKeys(documentTypeDescriptionInputForm, documentTypeDescription);
        ScrollToElement(confirmAddDocumentType);
        clickWithJavaScript(confirmAddDocumentType);
    }

    public void validateDocumentTypeInfo(String documentTypeCode, String documentTypeDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(documentTypeCodeInputForm, "value", documentTypeCode));
        String currentMasterGenresCode = documentTypeCodeInputForm.getAttribute("value");
        String currentMasterGenresDescription = documentTypeDescriptionInputForm.getAttribute("value");
        Assert.assertEquals("El valor actual del código coincide con el esperado", documentTypeCode, currentMasterGenresCode);
        Assert.assertEquals("La descripción actual coincide con el esperado", documentTypeDescription, currentMasterGenresDescription);
    }

    public void addDocumentType(String documentTypeCode, String documentTypeDescription) {
        clickWithJavaScript(addButton);
        waitAndSendKeys(documentTypeCodeInputForm, documentTypeCode);
        setDocumentTypeData(documentTypeCode, documentTypeDescription);
    }

    public void editDocumentType(String documentTypeCode, String newDocumentTypeCode, String newDocumentTypeDescription ) {
        findDocumentType(documentTypeCode);
        waitAndClick(getEditButtonForDocumentType(documentTypeCode));
        setDocumentTypeData(newDocumentTypeCode, newDocumentTypeDescription);
    }

    public void validateDocumentType(String documentTypeCode, String expectDocumentTypeCode, String expectDocumentTypeDescription) {
        findDocumentType(documentTypeCode);
        waitAndClick(getDetailsButtonForDocumentType(documentTypeCode));
        validateDocumentTypeInfo(expectDocumentTypeCode, expectDocumentTypeDescription);
        clickWithJavaScript(cancelButton);
    }

    public void deleteDocumentType(String documentTypeCode) {
        findDocumentType(documentTypeCode);
        ScrollToElement(getDeleteButtonForDocumentType());
        waitAndClick(getDeleteButtonForDocumentType());
        waitAndClick(confirmButtonDelete);

    }
}
