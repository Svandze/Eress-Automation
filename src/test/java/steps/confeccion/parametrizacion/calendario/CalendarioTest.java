package steps.confeccion.parametrizacion.calendario;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.confeccion.parametrizacion.ConfeccionPage;
import pages.confeccion.parametrizacion.ParametrizacionPage;
import pages.confeccion.parametrizacion.calendario.CalendarioPage;
import pages.confeccion.parametrizacion.gradodificultad.GradoDificultadPage;
import steps.BaseTestSeress;

import java.time.Duration;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static utils.ElementUtils.ScrollToElement;
import static utils.ElementUtils.waitAndClick;
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
        initialDateRange.setYear(2040 - 1900); // Ajuste para Date.setYear()
        endDateRange.setYear(2049 - 1900); // Ajuste para Date.setYear()
        String year = String.valueOf(faker.date().between(initialDateRange, endDateRange).getYear() + 1900); // Ajuste para obtener el año correcto

        waitAndClick(calendarioPage.addButton);
        waitAndClick(calendarioPage.yearSetup);

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS)); // Espera hasta 10 segundos
        try {
            // Espera hasta que el botón para el año deseado esté visible y luego haz clic
            while(true) {
                try {
                    WebElement yearElement = calendarioPage.pickYear(year);
                    wait.until(ExpectedConditions.visibilityOf(yearElement));
                    if (yearElement.isDisplayed()) {
                        yearElement.click();
                        break;
                    }
                } catch (Exception e) {
                    Thread.sleep(4000);
                    waitAndClick(calendarioPage.nextYearButton);
                }
            }
        } catch (Exception e) {
            // Manejar excepción si es necesario
        }

        Thread.sleep(10000);
    }
}
