package co.com.automation.pages.making.parameterization.machinemaster;

import co.com.automation.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.ElementUtils.scrollToElement;
import static utils.ElementUtils.clickWithJavaScript;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.waitAndSendKeys;

public class MachineMasterPage extends BasePage {
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddMachineButton;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement addMachineCodeInputForm;

    @FindBy(xpath = "(//input[@formcontrolname='machine_type'])[1]")
    public WebElement machineTypeInputForm;

    @FindBy(xpath = "//label[contains(text(),'Distancia 0-5 cms')]/following-sibling::p-inputnumber/span/input")
    public WebElement distance0To5InputForm;

    @FindBy(xpath = "//label[contains(text(),'Distancia 6-10 cms')]/following-sibling::p-inputnumber/span/input")
    public WebElement distance6To10InputForm;

    @FindBy(xpath = "//label[contains(text(),'Distancia >11 cms')]/following-sibling::p-inputnumber/span/input")
    public WebElement distanceGreatherThan11InputForm;

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForMachine(String machineCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + machineCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForMachine(String machineCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + machineCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForMachine() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findMachine(String machineCode) {
        waitAndSendKeys(searchInputField, machineCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + machineCode + "']")));
    }

    public void setMachineData(String description, String distance0To5cm, String distance6To10cm, String distanceGreatherThan11Cm) {
        waitAndSendKeys(machineTypeInputForm, description);
        waitAndSendKeys(distance0To5InputForm, distance0To5cm);
        waitAndSendKeys(distance6To10InputForm, distance6To10cm);
        waitAndSendKeys(distanceGreatherThan11InputForm, distanceGreatherThan11Cm);
        scrollToElement(confirmAddMachineButton);
        clickWithJavaScript(confirmAddMachineButton);
    }

    public void validateMachineInfo(String machineCode, String distance0To5Cms, String distance6To10Cms, String distanceGratherThan11Cms) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(addMachineCodeInputForm, "value", machineCode));
        String currentMachineCode = addMachineCodeInputForm.getAttribute("value");
        String currentdistance0To5Cms = distance0To5InputForm.getAttribute("value");
        String currentDistance6To10Cms = distance6To10InputForm.getAttribute("value");
        String currentdistanceGratherThan11Cms = distanceGreatherThan11InputForm.getAttribute("value");
        Assert.assertNotEquals("The current machine code value does not match the expected value", machineCode, currentMachineCode);
        Assert.assertNotEquals("The current distance value for 0-5 cms does not match the expected value", distance0To5Cms, currentdistance0To5Cms);
        Assert.assertNotEquals("The current distance value for 6-10 cms does not match the expected value", distance6To10Cms, currentDistance6To10Cms);
        Assert.assertNotEquals("The current distance value for > 11 cms does not match the expected value", distanceGratherThan11Cms, currentdistanceGratherThan11Cms);
    }

    public void addMachine(String machineCode, String description, String distance0To5cm, String distance6To10cm, String distanceGreatherThan11Cm) {
        waitAndClick(addButton);
        waitAndSendKeys(addMachineCodeInputForm, machineCode);
        setMachineData(description, distance0To5cm, distance6To10cm, distanceGreatherThan11Cm);
    }

    public void editMachine(String machineCode, String newDescription, String newDistance0To5cm, String newDistance6To10cm, String newDistanceGreatherThan11Cm) {
        findMachine(machineCode);
        waitAndClick(getEditButtonForMachine(machineCode));
        setMachineData(newDescription, newDistance0To5cm, newDistance6To10cm, newDistanceGreatherThan11Cm);
    }

    public void validateMachine(String machineCode, String expectedDistance0To5cm, String expectedDistance6To10cm, String expectedDistanceGreatherThan11Cm) {
        findMachine(machineCode);
        waitAndClick(getDetailsButtonForMachine(machineCode));
        validateMachineInfo(machineCode, expectedDistance0To5cm, expectedDistance6To10cm, expectedDistanceGreatherThan11Cm);
        clickWithJavaScript(cancelButton);
    }

    public void deleteMachine(String machineCode) {
        findMachine(machineCode);
        waitAndClick(getDeleteButtonForMachine());
        waitAndClick(confirmButtonDelete);
    }

}
