package pages.confeccion.parametrizacion.grupomovimientos;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

import static utils.ElementUtils.*;
import static utils.ElementUtils.waitAndClick;

    public class GrupoMovimientosPage extends BasePage {
        @FindBy(xpath = "//button[@type='submit']")
        public WebElement confirmAddMovementGroup;

        @FindBy(xpath = "//input[@formcontrolname='code']")
        public WebElement movementGroupCodeInputForm;

        @FindBy(xpath = "//input[@formcontrolname='description']")
        public WebElement movementGroupDescriptionInputForm;

        @FindBy(xpath = "//button[normalize-space()='Adicionar']")
        public WebElement addButton;

        @FindBy(xpath = "//button[normalize-space()='Cancelar']")
        public WebElement cancelButton;

        @FindBy(xpath = "//div[@class='search__input']//input[@placeholder='Buscar']")
        public WebElement searchInputField;
        @FindBy(xpath = "//button[@aria-label='Si']")
        public WebElement confirmButtonDelete;


        public WebElement getEditButtonForMovementGroup(String movementGroupCode) {
            return driver.findElement(By.xpath("(//td[contains(text(),'" + movementGroupCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
        }

        public WebElement getDetailsButtonForMovementGroup(String movementGroupCode) {
            return driver.findElement(By.xpath("(//td[contains(text(),'" + movementGroupCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
        }

        public WebElement getDeleteButtonForMovementGroup() {
            return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
        }

        public void findMovementGroup(String movementGroupCode) {
            waitAndSendKeys(searchInputField, movementGroupCode);
            searchInputField.sendKeys(Keys.ENTER);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".toast-title"))));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='" + movementGroupCode + "']")));
        }

        public void setMovementGroupData(String movementGroupCode, String descriptionMovementGroup) {
            implicitWait();
            waitAndSendKeys(movementGroupCodeInputForm, movementGroupCode);
            waitAndSendKeys(movementGroupDescriptionInputForm, descriptionMovementGroup);
            scrollToElement(confirmAddMovementGroup);
            clickWithJavaScript(confirmAddMovementGroup);
        }

        public void validateMovementGroupInfo(String movementGroupCode, String descriptionMovementGroup) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
            wait.until(ExpectedConditions.attributeToBe(movementGroupCodeInputForm, "value", movementGroupCode));
            String currentMovementGroupCode = movementGroupCodeInputForm.getAttribute("value");
            String currentDescriptionMovementGroup = movementGroupDescriptionInputForm.getAttribute("value");
            Assert.assertEquals("El valor actual del código del grupo de movimientos coincide con el esperado", movementGroupCode, currentMovementGroupCode);
            Assert.assertEquals("El valor actual de la descripción coincide con el esperado", descriptionMovementGroup, currentDescriptionMovementGroup);
        }

        public void addMovementGroup(String movementGroupCode, String descriptionMovementGroup) {
            waitAndClick(addButton);
            waitAndSendKeys(movementGroupCodeInputForm, movementGroupCode);
            setMovementGroupData(movementGroupCode, descriptionMovementGroup);
        }

        public void editMovementGroup(String movementGroupCode, String newMovementGroupCode, String NewDescriptionMovementGroup) {
            findMovementGroup(movementGroupCode);
            waitAndClick(getEditButtonForMovementGroup(movementGroupCode));
            setMovementGroupData(newMovementGroupCode, NewDescriptionMovementGroup);
        }

        public void validateMovementGroup(String movementGroupCode, String expectMovementGroupCode, String expectDescriptionMovementGroup) {
            findMovementGroup(movementGroupCode);
            waitAndClick(getDetailsButtonForMovementGroup(movementGroupCode));
            validateMovementGroupInfo(expectMovementGroupCode, expectDescriptionMovementGroup);
            clickWithJavaScript(cancelButton);
        }

        public void deleteMovementGroup(String movementGroupCode) {
            findMovementGroup(movementGroupCode);
            waitAndClick(getDeleteButtonForMovementGroup());
            waitAndClick(confirmButtonDelete);
        }

    }


