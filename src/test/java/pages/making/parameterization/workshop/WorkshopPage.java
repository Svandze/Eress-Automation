package pages.making.parameterization.workshop;

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

public class WorkshopPage extends BasePage {

    @FindBy(xpath = "//seress-ui-button[@value='Agregar']")
    public WebElement confirmAddWorkShop;

    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[1]")
    public WebElement dropDownCustomerWorkshop;
    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownCustomerWorkshopInputForm;

    @FindBy(xpath = "//p-dropdownitem[@class='p-element ng-star-inserted']/li")
    public WebElement dropDownCustomerWorkshopSelect;
    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[1]")
    public WebElement dropDownCustomerWorkshopDataInputForm;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement workshopCodeInputForm;
    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement workshopDescriptionInputForm;
    @FindBy(xpath = "//p-inputnumber[@formcontrolname='OTIF']/span/input")
    public WebElement workshopOTIF0to100InputForm;
    @FindBy(xpath = "//p-inputnumber[@formcontrolname='people']/span/input")
    public WebElement workshopPersonsInputForm;
    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[2]")
    public WebElement dropDownStyleWorkshop;
    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownStyleInputFormWorkshop;
    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement dropDownStyleSelectWorkshop;
    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[2]")
    public WebElement dropDownStyleDataWorkshop;

    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[3]")
    public WebElement dropDownMachineWorkshop;
    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement dropDownMachineInputFormWorkshop;
    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement dropDownMachineSelectWorkshop;
    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[3]")
    public WebElement dropDownMachineDataWorkshop;

    @FindBy(xpath = "//tr/td/p-inputnumber[@type='number']//span//input")
    public WebElement workshopAmountInputForm;

    @FindBy(xpath = "//button[normalize-space()='Agregar Estilo']")
    public WebElement workshopAddStyletButton;
    @FindBy(xpath = "//button[normalize-space()='Agregar Máquina']")
    public WebElement workshopAddMachinetButton;

    @FindBy(xpath = "(//i)[15]")
    public WebElement workshopIconDeleteStyle;

    @FindBy(xpath = "(//i)[16]")
    public WebElement workshopIconDeleteMachine;


    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForWorkshop(String workshopCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + workshopCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForWorkshop(String workshopCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + workshopCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForWorkshop() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findWorkshop(String workshopCode) {
        waitAndSendKeys(searchInputField, workshopCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + workshopCode + "']")));
    }

    public void setWorkshop(String workshopCustomer, String workshopCod, String workshopDescription, String workshopOTIF, String workshopPersons, String workshopStyle, String workshopMachine, String workshopAmount) {
        customDropdown(dropDownCustomerWorkshop, dropDownCustomerWorkshopInputForm, dropDownCustomerWorkshopSelect, workshopCustomer);
        waitAndSendKeys(workshopCodeInputForm, workshopCod);
        waitAndSendKeys(workshopDescriptionInputForm, workshopDescription);
        waitAndSendKeys(workshopOTIF0to100InputForm, workshopOTIF);
        waitAndSendKeys(workshopPersonsInputForm, workshopPersons);
        customDropdown(dropDownStyleWorkshop, dropDownStyleInputFormWorkshop, dropDownStyleSelectWorkshop,workshopStyle );
        customDropdown(dropDownMachineWorkshop, dropDownMachineInputFormWorkshop, dropDownMachineSelectWorkshop, workshopMachine);
        waitAndSendKeys(workshopAmountInputForm,workshopAmount );
        waitAndClick(workshopAddStyletButton);
        waitAndClick(workshopAddMachinetButton);
        waitAndClick(workshopIconDeleteStyle);
        clickWithJavaScript(confirmButtonDelete);
        clickWithJavaScript(workshopIconDeleteMachine);
        clickWithJavaScript(confirmButtonDelete);
        waitAndClick(confirmAddWorkShop);
    }

    public void validateWorkshopInfo(String workshopCustomer, String workshopCod, String workshopDescription, String workshopOTIF, String workshopPersons, String workshopStyle, String workshopMachine, String workshopAmount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(workshopCodeInputForm, "value", workshopCod));
        String currentWorkshopCustomer = dropDownCustomerWorkshopDataInputForm.getText();
        String currentWorkshopCustomerCod = workshopCodeInputForm.getAttribute("value");
        String currentWorkshopDataDescription = workshopDescriptionInputForm.getAttribute("value");
        String currentWorkshopDataOTIF = workshopOTIF0to100InputForm.getAttribute("value");
        String currentWorkshopDataPersons = workshopPersonsInputForm.getAttribute("value");
        String currentWorkshopStyle = dropDownStyleDataWorkshop.getText();
        String currentWorkshopMachine = dropDownMachineDataWorkshop.getText();
        String currentWorkshopMachineAmount = workshopAmountInputForm.getAttribute("value");
        Assert.assertFalse("The current workshop customer value does not contain the expected value", currentWorkshopCustomer.contains(workshopCustomer));
        Assert.assertNotEquals("The current workshop code value does not match the expected value", workshopCod, currentWorkshopCustomerCod);
        Assert.assertNotEquals("The current workshop description value does not match the expected value", workshopDescription, currentWorkshopDataDescription);
        Assert.assertNotEquals("The current workshop OTIF value does not match the expected value", workshopOTIF, currentWorkshopDataOTIF);
        Assert.assertNotEquals("The current workshop persons value does not match the expected value", workshopPersons, currentWorkshopDataPersons);
        Assert.assertFalse("The current workshop style value does not contain the expected value", currentWorkshopStyle.contains(workshopStyle));
        Assert.assertFalse("The current workshop machine value does not contain the expected value", currentWorkshopMachine.contains(workshopMachine));
        Assert.assertNotEquals("The current workshop amount value does not match the expected value", workshopAmount, currentWorkshopMachineAmount);
    }

    public void addWorkshop(String workshopCustomer, String workshopCod, String workshopDescription, String workshopOTIF, String workshopPersons, String workshopStyle, String workshopMachine, String workshopAmount) {
        clickWithJavaScript(addButton);
        setWorkshop(workshopCustomer, workshopCod, workshopDescription, workshopOTIF, workshopPersons, workshopStyle,  workshopMachine,workshopAmount);
    }

    public void customDropdown(WebElement masterCustomeDocumentType, WebElement masterCustomerDocumentTypeInputForm, WebElement masterCustomerDocumentTypeSelect, String data) {
        scrollToElement(masterCustomeDocumentType);
        waitAndClick(masterCustomeDocumentType);
        waitAndSendKeys(masterCustomerDocumentTypeInputForm, data);
        waitAndClick(masterCustomerDocumentTypeSelect);
    }

    public void editWorkshop(String workshopCod, String newWorkshpCustomer ,String newWorkshopCod, String newWorkshopDescription, String newWorkshopOTIF, String newWorkshopPersons, String newWorkshopStyle, String newWorkshopMachine, String newWorkshopAmountMachine) {
        findWorkshop(workshopCod);
        waitAndClick(getEditButtonForWorkshop(workshopCod));
        setWorkshop(newWorkshpCustomer, newWorkshopCod,newWorkshopDescription, newWorkshopOTIF, newWorkshopPersons, newWorkshopStyle, newWorkshopMachine, newWorkshopAmountMachine);
    }

    public void validateWorkshop(String workshopCustomer, String workshopCod, String workshopDescription, String workshopOTIF, String workshopPersons, String workshopStyle, String workshopMachine, String workshopAmount) {
        findWorkshop(workshopCod);
        waitAndClick(getDetailsButtonForWorkshop(workshopCod));
        validateWorkshopInfo(workshopCustomer, workshopCod, workshopDescription, workshopOTIF, workshopPersons, workshopStyle, workshopMachine, workshopAmount);
        clickWithJavaScript(cancelButton);
    }

    public void deleteWorkshop(String workshopCode) {
        findWorkshop(workshopCode);
        implicitWait();
        clickWithJavaScript(getDeleteButtonForWorkshop());
        clickWithJavaScript(confirmButtonDelete);
    }
}
