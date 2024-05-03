package co.com.automation.pages.making.parameterization.workshifts;

import co.com.automation.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

public class WorkShiftsPage extends BasePage {

    @FindBy(xpath = "//input[@formcontrolname='code']")
    public WebElement workShiftsCodeInputForm;
    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement workShiftsDescriptionInputForm;


    @FindBy(xpath = "(//div[@class='col-12 col-md-6'])[3]/div/p-calendar/span/input")
    public WebElement workShiftsInitialHourInputForm;


    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement workShiftsInitialIncreaseHH;

    @FindBy(xpath = "(//p-calendar/span/div/div/div/span)[1]")
    public WebElement workShiftsIntialHHNumber;

    @FindBy(xpath = "//p-inputnumber[@type='number']/span/input")
    public WebElement workShiftsCheckInputForm;
    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement workShiftsInitialIncreaseMM;

    @FindBy(xpath = "(//p-calendar/span/div/div/div/span)[3]")
    public WebElement workShiftsInitialMMNumber;
    @FindBy(xpath = "(//div[@class='col-12 col-md-6'])[4]/div/p-calendar/span/input")
    public WebElement workShiftsFinalHourInputForm;

    @FindBy(xpath = "//input[@class='p-inputtext p-component p-element p-inputnumber-input p-filled']")
    public WebElement workShiftsHoursInputForm;

    @FindBy(xpath = "//button[normalize-space()='Agregar']")
    public WebElement addButton;

    @FindBy(xpath = "//i[@class='pi pi-bg pi-custom pi-plus ng-star-inserted']")
    public WebElement add;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;

    @FindBy(xpath = "(//input[@placeholder='Buscar'])[2]")
    public WebElement searchInputField;
    public WebElement getEditButtonForWorkShifts(String workShiftsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + workShiftsCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForWorkShifts(String workShiftsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + workShiftsCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForWorkShifts() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findWorkShifts(String workShiftsCode) {
        waitAndSendKeys(searchInputField, workShiftsCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + workShiftsCode + "']")));
    }

    public void setWorkShiftsData(String workShiftsCode, String workShiftsDescription, int numberInitialHour, int numberInitialMinute,int numberFinalHour, int numberFinalMinute) {
        scrollToElement(workShiftsCodeInputForm);
        waitAndSendKeys(workShiftsCodeInputForm, workShiftsCode);
        waitAndSendKeys(workShiftsDescriptionInputForm, workShiftsDescription);
        hour(workShiftsInitialHourInputForm,workShiftsInitialIncreaseHH, workShiftsIntialHHNumber,numberInitialHour);
        minute(workShiftsInitialIncreaseMM,workShiftsInitialMMNumber, numberInitialMinute);
        waitAndClick(workShiftsCodeInputForm);
        hour(workShiftsFinalHourInputForm,workShiftsInitialIncreaseHH, workShiftsIntialHHNumber,numberFinalHour);
        minute(workShiftsInitialIncreaseMM,workShiftsInitialMMNumber, numberFinalMinute);
        waitAndClick(workShiftsCodeInputForm);
        implicitWait();
        waitAndClick(addButton);
    }


        public void validateWorkShiftsInfo(String workShiftsCode, String workShiftsDescription, int expectWorkShiftInitialHour, int expectWorkShiftInitialMinute, int expectWorkShiftFinalHour, int expectWorkShiftFinalMinute) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(workShiftsCodeInputForm, "value", workShiftsCode));
        String currentWorkShiftsCode = workShiftsCodeInputForm.getAttribute("value");
        String currentWorkShiftsDescription = workShiftsDescriptionInputForm.getAttribute("value");
        String currenthoursWorkShifts = workShiftsHoursInputForm.getAttribute("value");
        double numeroHoras=  calcularHoras(expectWorkShiftInitialHour, expectWorkShiftInitialMinute, expectWorkShiftFinalHour, expectWorkShiftFinalMinute);
        int horas = (int) numeroHoras;
        double minutos = (numeroHoras - horas) * 60;
        Float totalHoras= Float.valueOf((horas+"."+(int) minutos));
        boolean resultado = validarHoras(currenthoursWorkShifts,totalHoras);
        Assert.assertEquals("The current code value  matches the expected value", workShiftsCode, currentWorkShiftsCode);
        Assert.assertEquals("The current description value  matches the expected value", workShiftsDescription, currentWorkShiftsDescription);
       // Assert.assertTrue("La validación ha fallado", resultado);
        }

    public void addWorkShifts(String workShiftsCode, String workShiftsDescription, int initialHour, int initialMinute, int finalHour, int finalMinute) {
        implicitWait();
        scrollToElement(add);
        waitAndClick(add);
        waitAndSendKeys(workShiftsCodeInputForm, workShiftsCode);
        setWorkShiftsData(workShiftsCode, workShiftsDescription, initialHour, initialMinute, finalHour, finalMinute);
    }

    public void editWorkShifts(String workShiftsCode, String newWorkShiftsCode, String newWorkShiftsDescription, int newWorkShiftInitialHour, int newWorkShiftInitialMinute, int newWorkShiftFinalHour, int newWorkShiftFinalMinute) {
        implicitWait();
        findWorkShifts(workShiftsCode);
        waitAndClick(getEditButtonForWorkShifts(workShiftsCode));
        setWorkShiftsData(newWorkShiftsCode, newWorkShiftsDescription, newWorkShiftInitialHour, newWorkShiftInitialMinute , newWorkShiftFinalHour, newWorkShiftFinalMinute);
    }

    public void validateWorkShifts(String workShiftsCode, String expectWorkShiftsCode, String expectWorkShiftsDescription,  int expectWorkShiftInitialHour, int expectWorkShiftInitialMinute, int expectWorkShiftFinalHour, int expectWorkShiftFinalMinute) {
        findWorkShifts(workShiftsCode);
        waitAndClick(getDetailsButtonForWorkShifts(workShiftsCode));
        validateWorkShiftsInfo(expectWorkShiftsCode, expectWorkShiftsDescription,expectWorkShiftInitialHour, expectWorkShiftInitialMinute, expectWorkShiftFinalHour, expectWorkShiftFinalMinute );
        clickWithJavaScript(cancelButton);
    }

    public void deleteWorkShifts(String workShiftsCode) {
        findWorkShifts(workShiftsCode);
        scrollToElement(getDeleteButtonForWorkShifts());
        implicitWait();
        waitAndClick(getDeleteButtonForWorkShifts());
        waitAndClick(confirmButtonDelete);
        implicitWait();

    }


    public void hour(WebElement input, WebElement increase, WebElement hour, int targetHour) {
        waitAndClick(input);
        implicitWait();
        int currentHour = Integer.parseInt(hour.getText());
        int maxAttempts = 25;

        if (currentHour == targetHour) {
            return;
        }

        if (targetHour != currentHour) {

            for (int attempt = 0; attempt < maxAttempts && currentHour != targetHour; attempt++) {
                waitAndClick(increase);
                currentHour = Integer.parseInt(hour.getText());
            }
        }
    }

    public void minute(WebElement increase, WebElement minute, int targetMinute) {


        int currentHour = Integer.parseInt(minute.getText());
        int maxAttempts = 60;

        if (currentHour == targetMinute) {
            return;
        }


        if (targetMinute != currentHour) {

            for (int attempt = 0; attempt < maxAttempts && currentHour != targetMinute; attempt++) {
                waitAndClick(increase);
                currentHour = Integer.parseInt(minute.getText());
            }
        }
    }

    public double calcularHoras( int numberInitialHour, int numberInitialMinute,int numberFinalHour, int numberFinalMinute) {

        String horaInicial = String.format("%02d:%02d", numberInitialHour, numberInitialMinute);
        String horaFinal = String.format("%02d:%02d", numberFinalHour, numberFinalMinute);

        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        try {
            Date fechaInicial = formatoHora.parse(horaInicial);
            Date fechaFinal = formatoHora.parse(horaFinal);

            long diferenciaMilisegundos = fechaFinal.getTime() - fechaInicial.getTime();
            double diferenciaHoras = diferenciaMilisegundos / (1000 * 60 * 60.0);
            if (diferenciaHoras < 0) {
                diferenciaHoras += 24;
            }
            return diferenciaHoras;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public boolean validarHoras(String currentHoursWorkShifts, float totalHoras) {
        float currentHours = Float.parseFloat(currentHoursWorkShifts);

        // Definir una tolerancia aceptable para la comparación de números flotantes
        float tolerancia = 0.02f;

        // Calcular la diferencia absoluta entre los dos números
        float diferencia = Math.abs(totalHoras - currentHours);

        // Comparar la diferencia con la tolerancia
        boolean resultado = diferencia <= tolerancia;

        return resultado;
    }
}

