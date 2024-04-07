package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.example.constants.SeressConstants.EMAIL;
import static org.example.constants.SeressConstants.PASSWORD;
import static utils.ElementUtils.implicitWait;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.waitAndSendKeys;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Correo de Acceso']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Ingresa tu contraseña']")
    public WebElement passwordInput;

    @FindBy(xpath = "//p-button")
    public WebElement loginButton;

    public void doLogin() {
        waitAndSendKeys(emailInput, EMAIL);
        waitAndSendKeys(passwordInput, PASSWORD);
        waitAndClick(loginButton);
    }
}
