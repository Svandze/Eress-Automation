package co.com.automation.steps.making.parameterization.calendar;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.calendar.CalendarPage;
import co.com.automation.steps.BaseTestEress;

import java.util.Date;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.junit.Assert.*;
import static utils.ElementUtils.*;

public class CalendarTest extends BaseTestEress {

    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private CalendarPage calendarPage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        calendarPage = new CalendarPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.calendarioIcon);
        waitAndClick(parameterizationPage.calendarioIcon);
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
        calendarPage.initializeNewCalendar(year, true, false, "TEST");
        Thread.sleep(6000);
        calendarPage.modifyCalendar(year, true, true);
        assertTrue(Boolean.parseBoolean(calendarPage.sundayCheckbox.getAttribute("aria-checked")));
        assertTrue(Boolean.parseBoolean(calendarPage.saturdayCheckbox.getAttribute("aria-checked")));
        assertTrue("Holiday list should be visible", calendarPage.holydayList.isDisplayed());
        waitAndClick(calendarPage.cancelEditionButton);
        calendarPage.viewAndDeleteCalendar(year);
    }
}
