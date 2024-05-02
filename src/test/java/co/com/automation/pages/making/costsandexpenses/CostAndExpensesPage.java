package co.com.automation.pages.making.costsandexpenses;

import co.com.automation.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class CostAndExpensesPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddCostExpenses;

    @FindBy(xpath = "//div/p-calendar/span/input")
    public WebElement expensesCostBasicCalendar;
    @FindBy(xpath = "//td/p-calendar/span/input")
    public WebElement expensesCostCalendar;
    @FindBy(css = ".p-datepicker-year")
    public WebElement yearButton;

    @FindBy(xpath = "//span[contains(@class,'p-ripple')]")
    public WebElement monthButton;
    @FindBy(xpath = "//tbody/tr[3]/td[4]")
    public WebElement dayButton;

    //Dropdown taller
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[1]")
    public WebElement costExpensesWorkShopDropDown;

    @FindBy(xpath = "(//input[@class='p-dropdown-filter p-inputtext p-component'])[1]")
    public WebElement dropDownInputForm;

    @FindBy(xpath = "//p-dropdownitem[1]/li")
    public WebElement dropDownSelect;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[1]")
    public WebElement costExpensesWorkShopDropDownData;


    //Dropdown grupo costos
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[2]")
    public WebElement costExpensesCostGroupDropDown;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[2]")
    public WebElement costExpensesCostGroupDropDownData;


    //Dropdown concepto
    @FindBy(xpath = "(//div[@aria-label='dropdown trigger'])[3]")
    public WebElement costExpensesConceptDropDown;

    @FindBy(xpath = "(//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted'])[3]")
    public WebElement costExpensesConceptDropDownData;

    @FindBy(xpath = "//p-inputnumber[@type='number']/span/input")
    public WebElement costExpensesValueInputForm;


    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Agregar']")
    public WebElement addButtonForm;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;
    public WebElement getSpecifiedYear(int year) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + year + "') and contains(@class, 'p-yearpicker-year')]"));
    }

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

    public void setCostExpensesData(String costExpensesWorkShop, int costExpensesBasicCalendarYear, String costExpensesGroupCost, String costExpensesConcept, int costExpensesCalendarYear , String costExpensesValue) {
        customDropdown(costExpensesWorkShopDropDown, dropDownInputForm, dropDownSelect, costExpensesWorkShop);
        if(costExpensesBasicCalendarYear != 0){
            setBasicCalendarDate(expensesCostBasicCalendar, costExpensesBasicCalendarYear);
        }
        customDropdown(costExpensesCostGroupDropDown, dropDownInputForm, dropDownSelect, costExpensesGroupCost);
        customDropdown(costExpensesConceptDropDown, dropDownInputForm, dropDownSelect, costExpensesConcept);
        if(costExpensesBasicCalendarYear != 0){
            setCalendarDate(expensesCostCalendar, costExpensesCalendarYear);
        }
        waitAndSendKeys(costExpensesValueInputForm, costExpensesValue);
        scrollToElement(addButtonForm);
        clickWithJavaScript(addButtonForm);
    }

    public void validateCostExpensesInfo(String costExpensesWorkShop, int costExpensesBasicCalendarYear, String costExpensesGroupCost, String costExpensesConcept,int costExpensesCalendarYear ,String costExpensesValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        implicitWait();
        String currentCostExpensesWorkShop = costExpensesWorkShopDropDownData.getText();
        String currentCostExpensesBasicCalendar = expensesCostBasicCalendar.getAttribute("value");
        String currentCostExpensesGroupCost = costExpensesCostGroupDropDownData.getText();
        String currentCostExpensesConcept = costExpensesConceptDropDownData.getText();
        String currentCostExpensesCalendar = expensesCostCalendar.getAttribute("value");
        String currentCostValue = costExpensesValueInputForm.getAttribute("value");
        Assert.assertFalse("The current workshop value does not contain the expected value", currentCostExpensesWorkShop.contains(costExpensesWorkShop));
        Assert.assertFalse("The current period value does not contain the expected value", currentCostExpensesBasicCalendar.contains(Integer.toString(costExpensesBasicCalendarYear)));
        Assert.assertFalse("The current cost group value does not contain the expected value", currentCostExpensesGroupCost.contains(costExpensesGroupCost));
        Assert.assertFalse("The current concept value does not contain the expected value", currentCostExpensesConcept.contains(costExpensesConcept.toUpperCase()));
        Assert.assertFalse("The current date value does not contain the expected value", currentCostExpensesCalendar.contains(Integer.toString(costExpensesCalendarYear)));
        Assert.assertNotEquals("The current value does not match the expected value", costExpensesValue, currentCostValue);

    }

    public void addCostExpenses(String costExpensesWorkShop, int costExpensesBasicCalendarYear, String costExpensesGroupCost, String costExpensesConcept,int costExpensesCalendarYear ,String costExpensesValue) {
        waitAndClick(addButton);
        setCostExpensesData(costExpensesWorkShop,  costExpensesBasicCalendarYear,  costExpensesGroupCost,  costExpensesConcept, costExpensesCalendarYear , costExpensesValue);
    }

    public void editCostExpenses(String costExpensesWorkShop, String newCostExpensesWorkShop,  int newCostExpensesBasicCalendarYear, String costExpensesGroupCost, String costExpensesConcept,int newCostExpensesCalendarYear ,String costExpensesValue) {
        findCostExpenses(costExpensesWorkShop);
        waitAndClick(getEditButtonForCostExpenses(costExpensesWorkShop));
        setCostExpensesData( newCostExpensesWorkShop,   newCostExpensesBasicCalendarYear,  costExpensesGroupCost,  costExpensesConcept, newCostExpensesCalendarYear , costExpensesValue);
    }

    public void validateCostExpenses(String expectCostExpensesWorkShop,  int expectCostExpensesBasicCalendarYear, String costExpensesGroupCost, String costExpensesConcept,int expectCostExpensesCalendarYear ,String costExpensesValue) {
        findCostExpenses(expectCostExpensesWorkShop);
        waitAndClick(getDetailsButtonForCostExpenses(expectCostExpensesWorkShop));
        validateCostExpensesInfo(expectCostExpensesWorkShop, expectCostExpensesBasicCalendarYear,  costExpensesGroupCost,  costExpensesConcept, expectCostExpensesCalendarYear , costExpensesValue);
        clickWithJavaScript(cancelButton);
    }

    public void deleteCostExpenses(String costExpensesWorkShop) {
        findCostExpenses(costExpensesWorkShop);
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

    public void setBasicCalendarDate(WebElement element, int year) {
        element.click();
        yearButton.click();
        getSpecifiedYear(year).click();
        monthButton.click();
    }

    public void setCalendarDate(WebElement element, int year) {
        element.click();
        yearButton.click();
        getSpecifiedYear(year).click();
        monthButton.click();
        dayButton.click();
    }
}
