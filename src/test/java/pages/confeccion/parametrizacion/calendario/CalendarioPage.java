package pages.confeccion.parametrizacion.calendario;

import org.example.utils.CalendarHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

import static java.lang.Integer.*;
import static org.example.utils.CalendarHelper.*;
import static utils.ElementUtils.ScrollToElement;
import static utils.ElementUtils.clickWithJavaScript;
import static utils.ElementUtils.waitAndClick;

public class CalendarioPage extends BasePage {

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//p-calendar")
    public WebElement yearSetup;

    @FindBy(xpath = "//chevronrighticon/ancestor::button")
    public WebElement nextYearButton;

    @FindBy(css = "#saturday")
    public WebElement saturdayCheckbox;

    @FindBy(css = "#sunday")
    public WebElement sundayCheckbox;

    @FindBy(xpath = "//tbody/tr")
    public WebElement holydayList;

    @FindBy(xpath = "//seress-ui-button/button")
    public WebElement cancelEditionButton;

    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;

    @FindBy(xpath = "//td/*/*/input[@type='text']")
    public WebElement dateInputField;

    @FindBy(xpath = "//*[contains(@class, 'p-datepicker-month')]")
    public WebElement calendarMonthTitle;

    @FindBy(xpath = "//*[contains(@class, 'p-datepicker-year')]")
    public WebElement calendarYearTitle;

    @FindBy(xpath = "//td/input")
    public WebElement descriptionInput;

    @FindBy(xpath = "//*[@value='Agregar']")
    public WebElement addNewYear;

    public WebElement getEditButtonForCalendar(String year) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + year + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForCalendar(String year) {
        return driver.findElement(By.xpath("(//*/*[contains(text(),'" + year + "')]//following-sibling::*/*/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForCalendar(String year) {
        return driver.findElement(By.xpath("(//*/*[contains(text(),'" + year + "')]//following-sibling::*/*/seress-ui-button)[3]"));
    }

    public WebElement pickYear(String year) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + year + "')]"));
    }

    public WebElement pickDay(String dayOfMonth) {
        return driver.findElement(By.xpath("//table/*/tr/td/span[text()='" + dayOfMonth + "']"));

    }

    public void clickOnSpecifiedDay(DayOfWeek dayOfWeek) {
        LocalDate date = findDayInMonth(parseInt(calendarYearTitle.getText()), stringToMonth(calendarMonthTitle.getText()), dayOfWeek);
        pickDay(String.valueOf(date.getDayOfMonth())).click();
    }

    public void navigateCalendarToselectedYear(String year, int maxAttempts) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int attempts = 0;
        while (true) {
            try {
                WebElement yearElement = pickYear(year);
                wait.until(ExpectedConditions.visibilityOf(yearElement));
                clickWithJavaScript(yearElement);
                break;
            } catch (TimeoutException | NoSuchElementException e) {
                if (++attempts >= maxAttempts) {
                    throw new RuntimeException("No se pudo encontrar el año después de " + maxAttempts + " intentos.");
                }
                ScrollToElement(nextYearButton);
                clickWithJavaScript(nextYearButton);
            }
        }
    }
}
