package steps;


import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SimplePage;

import static utils.ElementUtils.*;

public class SimplePageStepsTest extends BaseTest {
    private SimplePage simplePage;
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setup() throws InterruptedException {
        simplePage = new SimplePage();
        loginPage = new LoginPage();
        homePage = new HomePage();

        simplePage.openPage();
        loginPage.doLogin();
        waitAndClick(homePage.confeccionesButton);
        Thread.sleep(5000);
    }

    @Test
    public void simplePage() {

    }
}
