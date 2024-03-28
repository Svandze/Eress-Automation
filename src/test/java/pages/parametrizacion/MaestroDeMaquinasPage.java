package pages.parametrizacion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaestroDeMaquinasPage {
    @FindBy(xpath = "//i[@class='pi pi-bg pi-custom pi-plus ng-star-inserted']")
    public WebElement AdicionarButton;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement addMachineInputForm;

    @FindBy(xpath = "(//input[@formcontrolname='machine_type'])[1]")
    public WebElement machineTypeInputForm;

    @FindBy(xpath = "(//input[@class='p-inputtext p-component p-element p-inputnumber-input'])[1]")
    public WebElement distance0To5InputForm;

    @FindBy(xpath = "(//input[@class='p-inputtext p-component p-element p-inputnumber-input'])[2]")
    public WebElement distance6To10InputForm;

    @FindBy(xpath = "(//input[@class='p-inputtext p-component p-element p-inputnumber-input'])[3]")
    public WebElement distanceGreatherThan11InputForm;

    @FindBy(xpath = "(//seress-ui-button[@value='Agregar'])[1]")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;
}
