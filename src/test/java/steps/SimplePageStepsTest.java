package steps;


import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.SimplePage;

import static org.example.constants.SeressConstants.EMAIL;
import static org.example.constants.SeressConstants.PASSWORD;
import static utils.ElementUtils.*;

public class SimplePageStepsTest extends BaseTest {

    @Before
    public void setup() throws InterruptedException {
        SimplePage simplePage = new SimplePage();
        simplePage.openPage();
        waitAndSendKeys(simplePage.emailInput, EMAIL);
        waitAndSendKeys(simplePage.passwordInput, PASSWORD);
        waitAndClick(simplePage.loginButton);
        waitAndClick(simplePage.confeccionesButton);
        Thread.sleep(5000);
    }

    @Test
    public void simplePage() {

    }
}
