package pages.parametrizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static utils.ElementUtils.ScrollToElement;
import static utils.ElementUtils.clickWithJavaScript;
import static utils.ElementUtils.waitAndSendKeys;

public class MaestroDeMaquinasPage extends BasePage {
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

    public WebElement getEditButtonForMachine(String machineCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + machineCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForMachine(String machineCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + machineCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForMachine(String machineCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + machineCode + "')]/following-sibling::td/div/seress-ui-button)[3]"));
    }

    public void findMachine(String machineCode) {
        waitAndSendKeys(searchInputField, machineCode);
        searchInputField.sendKeys(Keys.ENTER);
    }

    public void setMachineData(String description, String distance0To5cm, String distance6To10cm, String distanceGreatherThan11Cm) throws InterruptedException {
        waitAndSendKeys(machineTypeInputForm, description);
        waitAndSendKeys(distance0To5InputForm, distance0To5cm);
        waitAndSendKeys(distance6To10InputForm, distance6To10cm);
        waitAndSendKeys(distanceGreatherThan11InputForm, distanceGreatherThan11Cm);
        ScrollToElement(confirmAddMachineButton);
        clickWithJavaScript(confirmAddMachineButton);
    }
}
