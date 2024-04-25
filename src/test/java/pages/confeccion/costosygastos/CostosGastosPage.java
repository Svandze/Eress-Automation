package pages.confeccion.costosygastos;

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

public class CostosGastosPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddCostExpenses;


    //Dropdown taller
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[1]")
    public WebElement costExpensesWorkShopDropDown;

    @FindBy(xpath = "(//input[@class='p-dropdown-filter p-inputtext p-component'])[1]")
    public WebElement dropDownInputForm;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement dropDownSelect;

    @FindBy(xpath = "")
    public WebElement costExpensesWorkShopDropDownData;


    //Dropdown grupo costos
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[2]")
    public WebElement costExpensesCostGroupDropDown;

    @FindBy(xpath = "")
    public WebElement costExpensesCostGroupDropDownData;


    //Dropdown concepto
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[2]")
    public WebElement costExpensesConceptDropDown;

    @FindBy(xpath = "")
    public WebElement costExpensesConceptDropDownData;

    @FindBy(xpath = "//p-inputnumber[@type='number']/span/input")
    public WebElement costExpensesValueInputForm;


    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForCostExpenses(String costExpensesCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + costExpensesCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForCostExpenses(String costExpensesCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + costExpensesCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForCostExpenses() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findCostExpenses(String costExpensesCode) {
        waitAndSendKeys(searchInputField, costExpensesCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + costExpensesCode + "']")));
    }

    public void setCostExpensesData(String costExpensesWorkShop, String costExpensesGroupCost, String costExpensesConcept, String costExpensesValue) {
        customDropdown(costExpensesWorkShopDropDown, dropDownInputForm, dropDownSelect, costExpensesWorkShop);
        customDropdown(costExpensesCostGroupDropDown, dropDownInputForm, dropDownSelect, costExpensesGroupCost);
        customDropdown(costExpensesConceptDropDown, dropDownInputForm, dropDownSelect, costExpensesConcept);
        waitAndSendKeys(costExpensesValueInputForm, costExpensesValue);
        scrollToElement(confirmAddCostExpenses);
        clickWithJavaScript(confirmAddCostExpenses);
    }

    public void validateCostExpensesInfo(String costExpensesWorkShop, String costExpensesGroupCost, String costExpensesConcept, String costExpensesValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        /*wait.until(ExpectedConditions.attributeToBe(costExpensesCodeInputForm, "value", operationsCode));
        String currentMasterGenresCode = costExpensesCodeInputForm.getAttribute("value");
        String currentMasterGenresDescription = operationsDescriptionInputForm.getAttribute("value");
        Assert.assertEquals("El valor actual del código coincide con el esperado", operationsCode, currentMasterGenresCode);
        Assert.assertEquals("La descripción actual coincide con el esperado", operationsDescription, currentMasterGenresDescription);*/
    }

    public void addCostExpenses(String costExpensesWorkShop, String costExpensesGroupCost, String costExpensesConcept, String costExpensesValue) {
        waitAndClick(addButton);
        setCostExpensesData(costExpensesWorkShop,costExpensesGroupCost,costExpensesConcept,costExpensesValue);
    }

    public void editCostExpenses(String newCostExpensesWorkShop, String newCostExpensesGroupCost, String newCostExpensesConcept, String newCostExpensesValue) {
        findCostExpenses(newCostExpensesWorkShop);
        waitAndClick(getEditButtonForCostExpenses(newCostExpensesWorkShop));
        setCostExpensesData(newCostExpensesWorkShop, newCostExpensesGroupCost, newCostExpensesConcept, newCostExpensesValue);
    }

    public void validateCostExpenses(String expectCostExpensesWorkShop, String expectCostExpensesGroupCost, String expectCostExpensesConcept, String expectCostExpensesValue) {
        findCostExpenses(expectCostExpensesWorkShop);
        waitAndClick(getDetailsButtonForCostExpenses(expectCostExpensesWorkShop));
        validateCostExpensesInfo(expectCostExpensesWorkShop,   expectCostExpensesGroupCost,   expectCostExpensesConcept,   expectCostExpensesValue);
        clickWithJavaScript(cancelButton);
    }

    public void deleteCostExpenses(String costExpensesCode) {
        findCostExpenses(costExpensesCode);
        scrollToElement(getDeleteButtonForCostExpenses());
        waitAndClick(getDeleteButtonForCostExpenses());
        waitAndClick(confirmButtonDelete);

    }

    public void customDropdown(WebElement dropDown, WebElement inputForm, WebElement select, String data) {
        scrollToElement(dropDown);
        waitAndClick(dropDown);
        waitAndSendKeys(inputForm, data);
        waitAndClick(select);
    }
}
