package steps.confeccion.parametrizacion.calendario;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.calendario.CalendarioPage;
import steps.BaseTestSeress;

import java.time.DayOfWeek;
import java.util.Date;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.ScrollToElement;
import static utils.ElementUtils.clickWithJavaScript;
import static utils.ElementUtils.implicitWait;
import static utils.ElementUtils.waitAndClick;
import static utils.ElementUtils.waitAndSendKeys;
import static utils.ElementUtils.windowHandler;

public class CalendarioTest extends BaseTestSeress {

    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private CalendarioPage calendarioPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        calendarioPage = new CalendarioPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        ScrollToElement(parametrizacionPage.calendarioIcon);
        waitAndClick(parametrizacionPage.calendarioIcon);
    }

    @Test
    public void calendarModule() throws InterruptedException {
        Faker faker = new Faker();
        Date initialDateRange = new Date();
        Date endDateRange = new Date();
        initialDateRange.setYear(2060 - 1900);
        endDateRange.setYear(2100 - 1900);
        String year = String.valueOf(faker.date().between(initialDateRange, endDateRange).getYear() + 1900);
        waitAndClick(calendarioPage.addButton);
        waitAndClick(calendarioPage.yearSetup);
        calendarioPage.navigateCalendarToselectedYear(year, 10);
        calendarioPage.verifyAndClickCheck(calendarioPage.saturdayCheckbox, true);
        calendarioPage.verifyAndClickCheck(calendarioPage.sundayCheckbox, false);
        implicitWait();
        ScrollToElement(calendarioPage.dateInputField);
        waitAndClick(calendarioPage.dateInputField);
        calendarioPage.dateInputField.click();
        calendarioPage.clickOnSpecifiedDay(DayOfWeek.WEDNESDAY);
        waitAndSendKeys(calendarioPage.descriptionInput, "TEST");
        waitAndClick(calendarioPage.addNewYear);
        Thread.sleep(6000);
        ScrollToElement(calendarioPage.getDetailsButtonForCalendar(year));
        calendarioPage.getEditButtonForCalendar(year).click();
        calendarioPage.verifyAndClickCheck(calendarioPage.sundayCheckbox, true);
        waitAndClick(calendarioPage.addNewYear);
        implicitWait();
        ScrollToElement(calendarioPage.getDetailsButtonForCalendar(year));
        waitAndClick(calendarioPage.getDetailsButtonForCalendar(year));
        implicitWait();
        Assert.assertEquals(Boolean.parseBoolean(calendarioPage.sundayCheckbox.getAttribute("aria-checked")), true);
        Assert.assertEquals(Boolean.parseBoolean(calendarioPage.saturdayCheckbox.getAttribute("aria-checked")), true);
        Assert.assertTrue(calendarioPage.holydayList.isDisplayed());
        waitAndClick(calendarioPage.cancelEditionButton);
        implicitWait();
        ScrollToElement(calendarioPage.getDeleteButtonForCalendar(year));
        waitAndClick(calendarioPage.getDeleteButtonForCalendar(year));
        clickWithJavaScript(calendarioPage.confirmButtonDelete);
    }
}
