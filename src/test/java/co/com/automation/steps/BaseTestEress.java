package co.com.automation.steps;

import base.BaseTest;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeEach;
import co.com.automation.pages.HomePageEress;
import co.com.automation.pages.LoginPageEress;

import static utils.ElementUtils.waitAndClick;

@Epic("Eress")
public class BaseTestEress extends BaseTest {
    private LoginPageEress loginPage;
    private HomePageEress homePage;

    @BeforeEach
    public void setup() {
        loginPage = new LoginPageEress();
        homePage = new HomePageEress();
        homePage.openPage();
        loginPage.doLogin();
        waitAndClick(homePage.confeccionesButton);
    }
}
