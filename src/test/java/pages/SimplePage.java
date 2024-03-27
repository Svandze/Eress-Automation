package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.example.constants.SeressConstants.BASE_URL;

public class SimplePage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Correo de Acceso']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Ingresa tu contraseña']")
    public WebElement passwordInput;

    @FindBy(xpath = "//p-button")
    public WebElement loginButton;

    @FindBy(xpath = "(//a[@target=\"_blank\"])[1]")
    public WebElement confeccionesButton;

    public void openPage() {
        driver.get(BASE_URL);
    }

}
