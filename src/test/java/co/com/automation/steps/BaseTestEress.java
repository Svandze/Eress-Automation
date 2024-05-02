package co.com.automation.steps;

import base.BaseTest;
import org.junit.Before;
import co.com.automation.pages.HomePage;
import co.com.automation.pages.LoginPage;

import static utils.ElementUtils.waitAndClick;

public class BaseTestEress extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setup() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage.openPage();
        loginPage.doLogin();
        waitAndClick(homePage.confeccionesButton);
    }
}
