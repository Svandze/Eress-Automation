package pages.confeccion.parametrizacion.conceptocostosgastos;


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

public class ConceptosCostosGastosPage extends BasePage {
    @FindBy(xpath = "(//seress-ui-button[@value='Agregar'])[1]")
    public WebElement conceptCostsExpensesAdd;

    @FindBy(xpath = "//button[@tooltipposition='bottom']/i ")
    public WebElement conceptCostsExpensesIconDelete;
    @FindBy(xpath = "(//div[@class='p-dropdown-trigger'])[1]")
    public WebElement conceptCostsExpensesDropDownButtonGroup;

    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    public WebElement conceptCostsExpensesDropDownGroupInputForm;

    @FindBy(xpath = "//p-dropdownitem[1]/li[1]")
    public WebElement conceptCostsExpensesDropDownGroupSelect;
    @FindBy(xpath = "(//td[@class='min-w-250 max-w-300 ng-star-inserted'])[1]/seress-ui-dropdown-field")
    public WebElement conceptCostsExpensesDropDownGroupDataInputForm;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement conceptCostsExpensesCodeInputForm;
    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement conceptCostsExpensesConceptInputForm;

    @FindBy(xpath = "//button[normalize-space()='Agregar Concepto']")
    public WebElement addConcept;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForConceptCostsExpenses(String conceptCostsExpensesyCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + conceptCostsExpensesyCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForConceptCostsExpenses(String conceptCostsExpensesCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + conceptCostsExpensesCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForConceptCostsExpenses() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }


    public void findConceptCostsExpenses(String conceptCostsExpensesCode) {
        waitAndSendKeys(searchInputField, conceptCostsExpensesCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + conceptCostsExpensesCode + "']")));
    }

    public void setConceptCostsExpensesData(String conceptCostsExpensesDropDownGroup, String conceptCostsExpensesCod, String conceptCostsExpensesConcept) {
        implicitWait();
        scrollToElement(conceptCostsExpensesDropDownButtonGroup);
        customDropdown(conceptCostsExpensesDropDownButtonGroup, conceptCostsExpensesDropDownGroupInputForm, conceptCostsExpensesDropDownGroupSelect, conceptCostsExpensesDropDownGroup);
        waitAndSendKeys(conceptCostsExpensesCodeInputForm, conceptCostsExpensesCod);
        waitAndSendKeys(conceptCostsExpensesConceptInputForm, conceptCostsExpensesConcept);
        scrollToElement(conceptCostsExpensesAdd);
        clickWithJavaScript(conceptCostsExpensesAdd);
    }


    public void validateConceptCostsExpensesInfo(String conceptCostsExpensesDropDownGroup, String conceptCostsExpensesCod, String conceptCostsExpensesConcept) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(conceptCostsExpensesCodeInputForm, "value", conceptCostsExpensesCod));
        String currentConceptCostsExpensesCode = conceptCostsExpensesCodeInputForm.getAttribute("value");
        String currentConceptCostsExpensesConcept = conceptCostsExpensesConceptInputForm.getAttribute("value");
        String currentConceptCostsExpensesGroup = conceptCostsExpensesDropDownGroupDataInputForm.getText();
        System.out.println(currentConceptCostsExpensesGroup);
        System.out.println(conceptCostsExpensesDropDownGroup);
        Assert.assertEquals("El valor actual del código del grupo de movimientos coincide con el esperado", conceptCostsExpensesCod, currentConceptCostsExpensesCode);
        Assert.assertEquals("El valor actual de la descripción coincide con el esperado", conceptCostsExpensesConcept, currentConceptCostsExpensesConcept);
        Assert.assertTrue("El valor actual del estilo coincide con el esperado",currentConceptCostsExpensesGroup.contains(conceptCostsExpensesDropDownGroup));

    }

    public void addConceptCostsExpenses(String conceptCostsExpensesDropDownGroup, String conceptCostsExpensesCod, String conceptCostsExpensesConcept) {
        implicitWait();
        scrollToElement(addButton);
        waitAndClick(addButton);
        waitAndClick(conceptCostsExpensesIconDelete);
        waitAndClick(confirmButtonDelete);
        waitAndClick(addConcept);
        setConceptCostsExpensesData(conceptCostsExpensesDropDownGroup, conceptCostsExpensesCod, conceptCostsExpensesConcept);
    }

    public void editConceptCostsExpenses(String costsExpensesConceptCode, String newConceptCostsExpensesConceptCostsExpensesDropDownGroup, String newConceptCostsExpensesCod, String newConceptCostsExpensesConcept) {
        findConceptCostsExpenses(costsExpensesConceptCode);
        waitAndClick(getEditButtonForConceptCostsExpenses(costsExpensesConceptCode));
        setConceptCostsExpensesData(newConceptCostsExpensesConceptCostsExpensesDropDownGroup, newConceptCostsExpensesCod, newConceptCostsExpensesConcept);
    }

    public void validateConceptCostsExpenses(String expectConceptCostsExpensesDropDownGroup, String expectConceptCostsExpensesCod, String expectConceptCostsExpensesConcept) {
        findConceptCostsExpenses(expectConceptCostsExpensesCod);
        waitAndClick(getDetailsButtonForConceptCostsExpenses(expectConceptCostsExpensesCod));
        validateConceptCostsExpensesInfo(expectConceptCostsExpensesDropDownGroup, expectConceptCostsExpensesCod, expectConceptCostsExpensesConcept);
        clickWithJavaScript(cancelButton);
    }

    public void deleteConceptCostsExpenses(String conceptCostsExpensesCode) {
        findConceptCostsExpenses(conceptCostsExpensesCode);
        scrollToElement(getDeleteButtonForConceptCostsExpenses());
        waitAndClick(getDeleteButtonForConceptCostsExpenses());
        waitAndClick(confirmButtonDelete);
    }
    public void customDropdown(WebElement dropDown, WebElement inputForm, WebElement select, String data) {
        scrollToElement(dropDown);
        waitAndClick(dropDown);
        waitAndSendKeys(inputForm, data);
        waitAndClick(select);
    }
}
