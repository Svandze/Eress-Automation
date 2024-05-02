package co.com.automation.pages.making.parameterization.calendar;

import co.com.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;
import static co.com.eress.automation.utils.CalendarHelper.findDayInMonth;
import static co.com.eress.automation.utils.CalendarHelper.stringToMonth;
import static utils.ElementUtils.*;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    private WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    private WebElement cancelButton;

    @FindBy(xpath = "//p-calendar")
    private WebElement yearSetup;

    @FindBy(xpath = "//chevronrighticon/ancestor::button")
    private WebElement nextYearButton;

    @FindBy(css = "#saturday")
    public WebElement saturdayCheckbox;

    @FindBy(css = "#sunday")
    public WebElement sundayCheckbox;

    @FindBy(xpath = "//tbody/tr")
    public WebElement holydayList;

    @FindBy(xpath = "//seress-ui-button/button")
    public WebElement cancelEditionButton;

    @FindBy(xpath = "//button[@aria-label='Si']")
    private WebElement confirmButtonDelete;

    @FindBy(xpath = "//td/*/*/input[@type='text']")
    private WebElement dateInputField;

    @FindBy(xpath = "//*[contains(@class, 'p-datepicker-month')]")
    private WebElement calendarMonthTitle;

    @FindBy(xpath = "//*[contains(@class, 'p-datepicker-year')]")
    private WebElement calendarYearTitle;

    @FindBy(xpath = "//td/input")
    private WebElement descriptionInput;

    @FindBy(xpath = "//*[@value='Agregar']")
    private WebElement addNewYear;

    public WebElement pickDay(String dayOfMonth) {
        return driver.findElement(By.xpath("//table/*/tr/td/span[text()='" + dayOfMonth + "']"));

    }

    public void initializeNewCalendar(String year, boolean saturday, boolean sunday, String description) {
        addNewCalendarEntry();
        navigateToCalendarSettings();
        setupYear(year, 10);
        setupWeekendCheckboxes(saturday, sunday);
        waitAndClick(dateInputField);
        dateInputField.click();
        clickOnSpecifiedDay(java.time.DayOfWeek.WEDNESDAY);
        enterDescription(description);
        addYearToCalendar();
    }

    public void clickOnSpecifiedDay(DayOfWeek dayOfWeek) {
        LocalDate date = findDayInMonth(parseInt(calendarYearTitle.getText()), stringToMonth(calendarMonthTitle.getText()), dayOfWeek);
        pickDay(String.valueOf(date.getDayOfMonth())).click();
    }

    public void modifyCalendar(String year, boolean newSaturday, boolean newSunday) {
        editCalendar(year);
        setupWeekendCheckboxes(newSaturday, newSunday);
        addYearToCalendar();
    }

    public void viewAndDeleteCalendar(String year) {
        viewCalendarDetails(year);
        deleteCalendar(year);
    }

    public void navigateToCalendarSettings() {
        waitAndClick(yearSetup);
    }

    public void addNewCalendarEntry() {
        waitAndClick(addButton);
    }

    public void cancelCalendarEdition() {
        waitAndClick(cancelEditionButton);
    }

    public void confirmDelete() {
        clickWithJavaScript(confirmButtonDelete);
    }

    public void setupYear(String year, int maxAttempts) {
        navigateCalendarToselectedYear(year, maxAttempts);
    }

    public void setupWeekendCheckboxes(boolean saturday, boolean sunday) {
        verifyAndClickCheck(saturdayCheckbox, saturday);
        verifyAndClickCheck(sundayCheckbox, sunday);
    }

    public void enterDescription(String description) {
        waitAndSendKeys(descriptionInput, description);
    }

    public void addYearToCalendar() {
        waitAndClick(addNewYear);
    }

    public void editCalendar(String year) {
        getEditButtonForCalendar(year).click();
    }

    public void viewCalendarDetails(String year) {
        waitAndClick(getDetailsButtonForCalendar(year));
    }

    public void deleteCalendar(String year) {
        waitAndClick(getDeleteButtonForCalendar(year));
        confirmDelete();
    }

    private WebElement getEditButtonForCalendar(String year) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + year + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    private WebElement getDetailsButtonForCalendar(String year) {
        return driver.findElement(By.xpath("(//*/*[contains(text(),'" + year + "')]//following-sibling::*/*/seress-ui-button)[2]"));
    }

    private WebElement getDeleteButtonForCalendar(String year) {
        return driver.findElement(By.xpath("(//*/*[contains(text(),'" + year + "')]//following-sibling::*/*/seress-ui-button)[3]"));
    }

    private void navigateCalendarToselectedYear(String year, int maxAttempts) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int attempts = 0;
        while (true) {
            try {
                WebElement yearElement = driver.findElement(By.xpath("//span[contains(text(),'" + year + "')]"));
                wait.until(ExpectedConditions.visibilityOf(yearElement));
                clickWithJavaScript(yearElement);
                break;
            } catch (TimeoutException | NoSuchElementException e) {
                if (++attempts >= maxAttempts) {
                    throw new RuntimeException("No se pudo encontrar el año después de " + maxAttempts + " intentos.");
                }
                clickWithJavaScript(nextYearButton);
            }
        }
    }
}
