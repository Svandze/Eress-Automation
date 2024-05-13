package co.com.automation.steps.making.parameterization.calendar;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.calendar.CalendarPageEress;
import co.com.automation.steps.BaseTestEress;

import java.util.Date;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.junit.jupiter.api.Assertions.*;
import static utils.ElementUtils.*;

public class CalendarTest extends BaseTestEress {

    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private CalendarPageEress calendarPage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        calendarPage = new CalendarPageEress();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        scrollToElement(parameterizationPage.calendarioIcon);
        waitAndClick(parameterizationPage.calendarioIcon);
    }

    @Disabled
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
        assertTrue(calendarPage.holydayList.isDisplayed(), "Holiday list should be visible");
        waitAndClick(calendarPage.cancelEditionButton);
        calendarPage.viewAndDeleteCalendar(year);
    }
}
