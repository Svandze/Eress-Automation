package pages.making.parametrizacion.grupocostosgastos;

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

public class GrupoCostosGastosPage extends BasePage {
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddCostExpenseGroups;


    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement costExpenseGroupsCodeInputForm;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement costExpenseGroupsDescriptionInputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;

    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;

    public WebElement getEditButtonForCostExpenseGroups(String costExpenseGroupsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + costExpenseGroupsCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForCostExpenseGroups(String costExpenseGroupsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + costExpenseGroupsCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForCostExpenseGroups() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findCostExpenseGroups(String costExpenseGroupsCode) {
        waitAndSendKeys(searchInputField, costExpenseGroupsCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + costExpenseGroupsCode + "']")));
    }

    public void setCostExpenseGroupsData(String costExpenseGroupsCode, String costExpenseGroupsDescription) {
        implicitWait();
        waitAndSendKeys(costExpenseGroupsCodeInputForm, costExpenseGroupsCode);
        waitAndSendKeys(costExpenseGroupsDescriptionInputForm, costExpenseGroupsDescription);
        scrollToElement(confirmAddCostExpenseGroups);
        clickWithJavaScript(confirmAddCostExpenseGroups);
    }

    public void validateCostExpenseGroupsInfo(String costExpenseGroupsCode, String CostExpenseGroupsDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(costExpenseGroupsCodeInputForm, "value", costExpenseGroupsCode));
        String currentCostExpenseGroupsCode = costExpenseGroupsCodeInputForm.getAttribute("value");
        String currentCostExpenseGroupsDescription = costExpenseGroupsDescriptionInputForm.getAttribute("value");
        Assert.assertNotEquals("The current code value does not match the expected value", costExpenseGroupsCode, currentCostExpenseGroupsCode);
        Assert.assertNotEquals("The current description value does not match the expected value", CostExpenseGroupsDescription, currentCostExpenseGroupsDescription);
    }

    public void addCostExpenseGroups(String costExpenseGroupsCode, String costExpenseGroupsDescription) {
        waitAndClick(addButton);
        waitAndSendKeys(costExpenseGroupsCodeInputForm, costExpenseGroupsCode);
        setCostExpenseGroupsData(costExpenseGroupsCode, costExpenseGroupsDescription);
    }

    public void editCostExpenseGroups(String costExpenseGroupsCode, String newCostExpenseGroupsCode, String NewCostExpenseGroupsDescription) {
        findCostExpenseGroups(costExpenseGroupsCode);
        waitAndClick(getEditButtonForCostExpenseGroups(costExpenseGroupsCode));
        setCostExpenseGroupsData(newCostExpenseGroupsCode, NewCostExpenseGroupsDescription);
    }

    public void validateCostExpenseGroups(String costExpenseGroupsCode, String expectCostExpenseGroupsCode, String expectCostExpenseGroupsDescription) {
        findCostExpenseGroups(costExpenseGroupsCode);
        waitAndClick(getDetailsButtonForCostExpenseGroups(costExpenseGroupsCode));
        validateCostExpenseGroupsInfo(expectCostExpenseGroupsCode, expectCostExpenseGroupsDescription);
        clickWithJavaScript(cancelButton);
    }

    public void deleteCostExpenseGroups(String costExpenseGroupsCode) {
        findCostExpenseGroups(costExpenseGroupsCode);
        implicitWait();
        waitAndClick(getDeleteButtonForCostExpenseGroups());
        scrollToElement(confirmButtonDelete);
        clickWithJavaScript(confirmButtonDelete);
    }

}
