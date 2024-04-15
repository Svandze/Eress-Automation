package pages.confeccion.parametrizacion.maestroclientes;

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

public class MaestroClientesPage extends BasePage {

    @FindBy(xpath = "//seress-ui-button[@value='Agregar']")
    public WebElement confirmAddMasterCustomer;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement masterCustomerCodeInputForm;

    @FindBy(xpath = "//seress-ui-dropdown-field[@label='labelDocumentTypes']//div[@aria-label='dropdown trigger']")
    public WebElement dropDownDocumentTypeMasterCustomer;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[1]")
    public WebElement dropDownDocumentTypeDataMasterCustomer;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownDocumentTypeInputFormMasterCustomer;
    @FindBy(xpath = "//body//app-root//p-dropdownitem[1]")
    public WebElement dropDownDocumentSelectMasterCustomer;

    @FindBy(xpath = "//input[@formcontrolname='document']")
    public WebElement masterCustomerDocumentInputForm;

    @FindBy(xpath = "//input[@formcontrolname='fullname']")
    public WebElement masterCustomerBusinessNameInputForm;

    @FindBy(xpath = "//input[@formcontrolname='first_name']")
    public WebElement masterCustomerFirstNameInputForm;

    @FindBy(xpath = "//input[@formcontrolname='second_name']")
    public WebElement masterCustomerSecondNameInputForm;

    @FindBy(xpath = "//input[@formcontrolname='surname']")
    public WebElement masterCustomerLastNameInputForm;
    @FindBy(xpath = "//input[@formcontrolname='second_surname']")
    public WebElement masterCustomerSecondLastNameInputForm;
    @FindBy(xpath = "//input[@formcontrolname='address']")
    public WebElement masterCustomerAddressOneInputForm;
    @FindBy(xpath = "//input[@formcontrolname='second_address']")
    public WebElement masterCustomerAddressTwoInputForm;
    @FindBy(xpath = "//input[@formcontrolname='phone']")
    public WebElement masterCustomerPhoneOneinputForm;

    @FindBy(xpath = "//input[@formcontrolname='second_phone']")
    public WebElement masterCustomerPhoneTwoInputForm;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    public WebElement masterCustomerEmailInputForm;


    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[2]")
    public WebElement dropDownRegionTypeMasterCustomer;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownRegionTypeInputFormMasterCustomer;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[2]")
    public WebElement dropDownRegionTypeDataInputFormMasterCustomer;

    @FindBy(xpath = "//div[@class='p-dropdown-items-wrapper']")
    public WebElement dropDownRegionSelectMasterCustomer;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForMasterCustomer(String masterCustomerCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + masterCustomerCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForMasterCustomer(String masterCustomerCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + masterCustomerCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForMasterCustomer() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findMasterCustomer(String masterCustomerCode) {
        waitAndSendKeys(searchInputField, masterCustomerCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + masterCustomerCode + "']")));
    }

    public void setMasterCustomer(String masterCustomerCod, String masterCustomerDocumentType, String masterCustomerDocument, String masterCustomerBusinessName, String masterCustomerFirstName, String masterCustomerSecondName, String masterCustomerLastName, String masterCustomerSecondLastName, String masterCustomerAddressnOne, String masterCustomerAddressnTwo, String masterCustomerPhoneOne, String masterCustomerPhoneTwo, String masterCustomerEmail, String masterCustomerRegion) {
        waitAndSendKeys(masterCustomerCodeInputForm, masterCustomerCod);
        customDropdown(dropDownDocumentTypeMasterCustomer, dropDownDocumentTypeInputFormMasterCustomer, dropDownDocumentSelectMasterCustomer, masterCustomerDocumentType);
        waitAndSendKeys(masterCustomerDocumentInputForm, masterCustomerDocument);
        waitAndSendKeys(masterCustomerBusinessNameInputForm, masterCustomerBusinessName);
        waitAndSendKeys(masterCustomerFirstNameInputForm, masterCustomerFirstName);
        waitAndSendKeys(masterCustomerSecondNameInputForm, masterCustomerSecondName);
        waitAndSendKeys(masterCustomerLastNameInputForm, masterCustomerLastName);
        waitAndSendKeys(masterCustomerSecondLastNameInputForm, masterCustomerSecondLastName);
        waitAndSendKeys(masterCustomerAddressOneInputForm, masterCustomerAddressnOne);
        waitAndSendKeys(masterCustomerAddressTwoInputForm, masterCustomerAddressnTwo);
        waitAndSendKeys(masterCustomerPhoneOneinputForm, masterCustomerPhoneOne);
        waitAndSendKeys(masterCustomerPhoneTwoInputForm, masterCustomerPhoneTwo);
        waitAndSendKeys(masterCustomerEmailInputForm, masterCustomerEmail);
        customDropdown(dropDownRegionTypeMasterCustomer, dropDownRegionTypeInputFormMasterCustomer, dropDownRegionSelectMasterCustomer, masterCustomerRegion);
        scrollToElement(confirmAddMasterCustomer);
        clickWithJavaScript(confirmAddMasterCustomer);

    }

    public void validateMovementGroupInfo(String masterCustomerCod, String masterCustomerDocumentType, String masterCustomerDocument, String masterCustomerBusinessName, String masterCustomerFirstName, String masterCustomerSecondName, String masterCustomerLastName, String masterCustomerSecondLastName, String masterCustomerAddressnOne, String masterCustomerAddressnTwo, String masterCustomerPhoneOne, String masterCustomerPhoneTwo, String masterCustomerEmail, String masterCustomerRegion) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(masterCustomerCodeInputForm, "value", masterCustomerCod));
        String currentMasterCustomerCod = masterCustomerCodeInputForm.getAttribute("value");
        String currentMasterCustomerDataDocumentType = dropDownDocumentTypeDataMasterCustomer.getText();
        String currentMasterCustomerDocument = masterCustomerDocumentInputForm.getAttribute("value");
        String currentMasterCustomerBussinessName = masterCustomerBusinessNameInputForm.getAttribute("value");
        String currentMasterCustomerFirstName = masterCustomerFirstNameInputForm.getAttribute("value");
        String currentMasterCustomerSecondName = masterCustomerSecondNameInputForm.getAttribute("value");
        String currentMasterCustomerLastName = masterCustomerLastNameInputForm.getAttribute("value");
        String currentMasterCustomerSecondLastName = masterCustomerSecondLastNameInputForm.getAttribute("value");
        String currentMasterCustomerAddressnOne = masterCustomerAddressOneInputForm.getAttribute("value");
        String currentMasterCustomerAddressnTwo = masterCustomerAddressTwoInputForm.getAttribute("value");
        String currentMasterCustomerPhoneOne = masterCustomerPhoneOneinputForm.getAttribute("value");
        String currentMasterCustomerPhoneTwo = masterCustomerPhoneTwoInputForm.getAttribute("value");
        String currentMasterCustomerEmail = masterCustomerEmailInputForm.getAttribute("value");
        String currentMasterCustomerDataRegion = dropDownRegionTypeDataInputFormMasterCustomer.getText();

        Assert.assertEquals("El valor actual del código del grupo del maestro cliente con el esperado", masterCustomerCod, currentMasterCustomerCod);
        Assert.assertTrue("El valor actual del tipo de documento del maestro cliente contiene el esperado", currentMasterCustomerDataDocumentType.contains(masterCustomerDocumentType));
        Assert.assertEquals("El valor actual del documento del maestro cliente coincide con el esperado", masterCustomerDocument, currentMasterCustomerDocument);
        Assert.assertEquals("El valor actual de la labor social del maestro cliente con el esperado", masterCustomerBusinessName, currentMasterCustomerBussinessName);
        Assert.assertEquals("El valor actual del primer nombre del maestro cliente coincide con el esperado", masterCustomerFirstName, currentMasterCustomerFirstName);
        Assert.assertEquals("El valor actual del segundo nombre del maestro cliente con el esperado", masterCustomerSecondName, currentMasterCustomerSecondName);
        Assert.assertEquals("El valor actual del Primer apellido del maestro cliente coincide con el esperado", masterCustomerLastName, currentMasterCustomerLastName);
        Assert.assertEquals("El valor actual del segundo apellido del maestro cliente con el esperado", masterCustomerSecondLastName, currentMasterCustomerSecondLastName);
        Assert.assertEquals("El valor actual del dirección 1 del maestro cliente coincide con el esperado", masterCustomerAddressnOne, currentMasterCustomerAddressnOne);
        Assert.assertEquals("El valor actual del dirección 2 del maestro cliente con el esperado", masterCustomerAddressnTwo, currentMasterCustomerAddressnTwo);
        Assert.assertEquals("El valor actual del teléfono 1  del maestro cliente coincide con el esperado", masterCustomerPhoneOne, currentMasterCustomerPhoneOne);
        Assert.assertEquals("El valor actual del teléfono 2 del maestro cliente con el esperado", masterCustomerPhoneTwo, currentMasterCustomerPhoneTwo);
        Assert.assertEquals("El valor actual del email del maestro cliente coincide con el esperado", masterCustomerEmail, currentMasterCustomerEmail);
        Assert.assertTrue("El valor actual de las region del maestro cliente con el esperado", currentMasterCustomerDataRegion.contains(masterCustomerRegion));
    }

    public void addMasterCustomer(String masterCustomerCod, String masterCustomerDocumentType, String masterCustomerDocument, String masterCustomerBusinessName, String masterCustomerFirstName, String masterCustomerSecondName, String masterCustomerLastName, String masterCustomerSecondLastName, String masterCustomerAddressnOne, String masterCustomerAddressnTwo, String masterCustomerPhoneOne, String masterCustomerPhoneTwo, String masterCustomerEmail, String masterCustomerRegion) {
        waitAndClick(addButton);
        waitAndSendKeys(masterCustomerCodeInputForm, masterCustomerCod);
        setMasterCustomer(masterCustomerCod, masterCustomerDocumentType, masterCustomerDocument, masterCustomerBusinessName, masterCustomerFirstName, masterCustomerSecondName, masterCustomerLastName, masterCustomerSecondLastName, masterCustomerAddressnOne, masterCustomerAddressnTwo, masterCustomerPhoneOne, masterCustomerPhoneTwo, masterCustomerEmail, masterCustomerRegion);
    }

    public void customDropdown(WebElement masterCustomeDocumentType, WebElement masterCustomerDocumentTypeInputForm, WebElement masterCustomerDocumentTypeSelect, String data) {
        scrollToElement(masterCustomeDocumentType);
        waitAndClick(masterCustomeDocumentType);
        waitAndSendKeys(masterCustomerDocumentTypeInputForm, data);
        waitAndClick(masterCustomerDocumentTypeSelect);
    }

    public void editMasterCustomerName(String masterCustomerCode, String newMasterCustomerCod, String newMasterCustomerDocumentType, String newMasterCustomerDocument, String newMasterCustomerBusinessName, String newMasterCustomerFirstName, String newMasterCustomerSecondName, String newMasterCustomerLastName, String newMasterCustomerSecondLastName, String newMasterCustomerAddressnOne, String newMasterCustomerAddressnTwo, String newMasterCustomerPhoneOne, String newMasterCustomerPhoneTwo, String newMasterCustomerEmail, String newMasterCustomerRegion) {
        findMasterCustomer(masterCustomerCode);
        waitAndClick(getEditButtonForMasterCustomer(masterCustomerCode));
        setMasterCustomer(newMasterCustomerCod, newMasterCustomerDocumentType, newMasterCustomerDocument, newMasterCustomerBusinessName, newMasterCustomerFirstName, newMasterCustomerSecondName, newMasterCustomerLastName, newMasterCustomerSecondLastName, newMasterCustomerAddressnOne, newMasterCustomerAddressnTwo, newMasterCustomerPhoneOne, newMasterCustomerPhoneTwo, newMasterCustomerEmail, newMasterCustomerRegion);

    }

    public void validateMovementGroup(String masterCustomerCod, String masterCustomerDocumentType, String masterCustomerDocument, String masterCustomerBusinessName, String masterCustomerFirstName, String masterCustomerSecondName, String masterCustomerLastName, String masterCustomerSecondLastName, String masterCustomerAddressnOne, String masterCustomerAddressnTwo, String masterCustomerPhoneOne, String masterCustomerPhoneTwo, String masterCustomerEmail, String masterCustomerRegion) {
        findMasterCustomer(masterCustomerCod);
        waitAndClick(getDetailsButtonForMasterCustomer(masterCustomerCod));
        validateMovementGroupInfo(masterCustomerCod, masterCustomerDocumentType, masterCustomerDocument, masterCustomerBusinessName, masterCustomerFirstName, masterCustomerSecondName, masterCustomerLastName, masterCustomerSecondLastName, masterCustomerAddressnOne, masterCustomerAddressnTwo, masterCustomerPhoneOne, masterCustomerPhoneTwo, masterCustomerEmail, masterCustomerRegion);
        clickWithJavaScript(cancelButton);
    }

    public void deleteMasterCustomer(String masterCustomerCode) {
        findMasterCustomer(masterCustomerCode);
        implicitWait();
        clickWithJavaScript(getDeleteButtonForMasterCustomer());
        clickWithJavaScript(confirmButtonDelete);
    }
}
