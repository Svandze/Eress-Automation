package steps.confeccion.parametrizacion.calendario;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import pages.making.parametrizacion.calendario.CalendarioPage;
import steps.BaseTestSeress;

import java.util.Date;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.junit.Assert.*;
import static utils.ElementUtils.*;

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
        scrollToElement(parametrizacionPage.calendarioIcon);
        waitAndClick(parametrizacionPage.calendarioIcon);
    }

    @Ignore
    @Test
    public void calendarModule() throws InterruptedException {
        Faker faker = new Faker();
        Date initialDateRange = new Date();
        Date endDateRange = new Date();
        initialDateRange.setYear(2070 - 1900);
        endDateRange.setYear(2110 - 1900);
        String year = String.valueOf(faker.date().between(initialDateRange, endDateRange).getYear() + 1900);
        calendarioPage.initializeNewCalendar(year, true, false, "TEST");
        Thread.sleep(6000);
        calendarioPage.modifyCalendar(year, true, true);
        assertTrue(Boolean.parseBoolean(calendarioPage.sundayCheckbox.getAttribute("aria-checked")));
        assertFalse(Boolean.parseBoolean(calendarioPage.saturdayCheckbox.getAttribute("aria-checked")));
        assertTrue("Holiday list should be visible", calendarioPage.holydayList.isDisplayed());
        waitAndClick(calendarioPage.cancelEditionButton);
        calendarioPage.viewAndDeleteCalendar(year);
    }
}
