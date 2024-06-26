package co.com.automation.pages.making.parameterization.regionlocation;

import co.com.automation.pages.BasePageEress;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.ElementUtils.*;

public class RegionLocationPageEress extends BasePageEress {
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAddMachineButton;


    @FindBy(xpath = "//input[@formcontrolname='country_code']")
    public WebElement locationByRegionsCodeCountryInputForm;
    @FindBy(xpath = "//input[@formcontrolname='country']")
    public WebElement locationByRegionsCountryInputForm;

    @FindBy(xpath = "//input[@formcontrolname='region_code']")
    public WebElement locationByRegionsCodeRegionInputForm;
    @FindBy(xpath = "//input[@formcontrolname='region']")
    public WebElement locationByRegionsRegionInputForm;

    @FindBy(xpath = "//input[@formcontrolname='city_code']")
    public WebElement locationByRegionsCodeCityInputForm;
    @FindBy(xpath = "//input[@formcontrolname='city']")
    public WebElement locationByRegionsCityInputForm;


    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "(//input[@placeholder='Buscar'])[2]")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[@aria-label='Si']")
    public WebElement confirmButtonDelete;


    public WebElement getEditButtonForMachine(String locationByRegionsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + locationByRegionsCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForMachine(String locationByRegionsCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + locationByRegionsCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForMachine() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public void findMachine(String locationByRegionsCode) {
        waitAndSendKeys(searchInputField, locationByRegionsCode);
        searchInputField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + locationByRegionsCode + "']")));
    }

    public void setMachineData(String locationByRegionsCodCountry, String locationByRegionsCountry, String locationByRegionCodRegion, String locationByRegionRegion, String locationByRegionsCodCity, String locationByRegionsCity) {
        waitAndSendKeys(locationByRegionsCodeCountryInputForm, locationByRegionsCodCountry);
        waitAndSendKeys(locationByRegionsCountryInputForm, locationByRegionsCountry);
        waitAndSendKeys(locationByRegionsCodeRegionInputForm, locationByRegionCodRegion);
        waitAndSendKeys(locationByRegionsRegionInputForm, locationByRegionRegion);
        waitAndSendKeys(locationByRegionsCodeCityInputForm, locationByRegionsCodCity);
        waitAndSendKeys(locationByRegionsCityInputForm, locationByRegionsCity);
        scrollToElement(confirmAddMachineButton);
        clickWithJavaScript(confirmAddMachineButton);
        implicitWait();
    }

    public void validateLocationByRegionsInfo(String locationByRegionsCodeCountry, String expectLocationByRegionsCodCountry, String expectLocationByRegionsCountry, String expectLocationByRegionCodRegion, String expectLocationByRegionRegion, String expectLocationByRegionsCodCity, String expectLocationByRegionsCity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.attributeToBe(locationByRegionsCodeCountryInputForm, "value", locationByRegionsCodeCountry));
        String currentLocationByRegionsCodeCountry = locationByRegionsCodeCountryInputForm.getAttribute("value");
        String currentLocationByRegionsCountry = locationByRegionsCountryInputForm.getAttribute("value");
        String currentLocationByRegionsCodRegion = locationByRegionsCodeRegionInputForm.getAttribute("value");
        String currentLocationByRegionsRegion = locationByRegionsRegionInputForm.getAttribute("value");
        String currentLocationByRegionsCodCity = locationByRegionsCodeCityInputForm.getAttribute("value");
        String currentLocationByRegionsCity = locationByRegionsCityInputForm.getAttribute("value");
        assertEquals(expectLocationByRegionsCodCountry, currentLocationByRegionsCodeCountry, "The current country code value  matches the expected value");
        assertEquals(expectLocationByRegionsCountry, currentLocationByRegionsCountry, "The current country value  matches the expected value");
        assertEquals(expectLocationByRegionCodRegion, currentLocationByRegionsCodRegion, "The current region code value  matches the expected value");
        assertEquals(expectLocationByRegionRegion, currentLocationByRegionsRegion, "The current region value  matches the expected value");
        assertEquals(expectLocationByRegionsCodCity, currentLocationByRegionsCodCity, "The current city code value  matches the expected value");
        assertEquals(expectLocationByRegionsCity, currentLocationByRegionsCity, "The current city value  matches the expected value");

    }

    public void addLocationByRegions(String locationByRegionsCodCountry, String locationByRegionsCountry, String locationByRegionCodRegion, String locationByRegionRegion, String locationByRegionsCodCity, String locationByRegionsCity) {
        waitAndClick(addButton);
        setMachineData(locationByRegionsCodCountry, locationByRegionsCountry, locationByRegionCodRegion, locationByRegionRegion, locationByRegionsCodCity, locationByRegionsCity);
    }

    public void editLocationByRegions(String locationByRegionsCode, String newLocationByRegionsCodCountry, String newLocationByRegionsCountry, String newLocationByRegionCodRegion, String newLocationByRegionRegion, String newLocationByRegionsCodCity, String newLocationByRegionsCity) {
        findMachine(locationByRegionsCode);
        waitAndClick(getEditButtonForMachine(locationByRegionsCode));
        setMachineData(newLocationByRegionsCodCountry, newLocationByRegionsCountry, newLocationByRegionCodRegion, newLocationByRegionRegion, newLocationByRegionsCodCity, newLocationByRegionsCity);
    }

    public void validateLocationByRegions(String locationByRegionsCode, String expectLocationByRegionsCodCountry, String expectLocationByRegionsCountry, String expectLocationByRegionCodRegion, String expectLocationByRegionRegion, String expectLocationByRegionsCodCity, String expectLocationByRegionsCity) {
        findMachine(locationByRegionsCode);
        waitAndClick(getDetailsButtonForMachine(locationByRegionsCode));
        validateLocationByRegionsInfo(locationByRegionsCode, expectLocationByRegionsCodCountry, expectLocationByRegionsCountry, expectLocationByRegionCodRegion, expectLocationByRegionRegion, expectLocationByRegionsCodCity, expectLocationByRegionsCity);
        clickWithJavaScript(cancelButton);
    }

    public void deleteLocationByRegions(String locationByRegionsCode) {
        findMachine(locationByRegionsCode);
        waitAndClick(getDeleteButtonForMachine());
        waitAndClick(confirmButtonDelete);
        implicitWait();
    }
}
