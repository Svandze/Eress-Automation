package co.com.automation.steps;

import base.BaseTest;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeEach;
import co.com.automation.pages.HomePage;
import co.com.automation.pages.LoginPage;

import static utils.ElementUtils.waitAndClick;

@Epic("Eress")
public class BaseTestEress extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeEach
    public void setup() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage.openPage();
        loginPage.doLogin();
        waitAndClick(homePage.confeccionesButton);
    }
}
