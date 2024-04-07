package pages.confeccion.parametrizacion.calendario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CalendarioPage extends BasePage {

    @FindBy(xpath = "//button[normalize-space()='Adicionar']")
    public WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Cancelar']")
    public WebElement cancelButton;

    @FindBy(xpath = "//p-calendar")
    public WebElement yearSetup;

    @FindBy(xpath = "//chevronrighticon/ancestor::button")
    public WebElement nextYearButton;

    @FindBy(xpath = "(//div[@class='p-checkbox-box'])[1]")
    public WebElement disableSaturday;

    @FindBy(xpath = "(//div[@class='p-checkbox-box'])[2]")
    public WebElement disableSunday;

    public WebElement getEditButtonForLevelDifficulty(String levelDifficultyCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + levelDifficultyCode + "')]/following-sibling::td/div/seress-ui-button)[1]"));
    }

    public WebElement getDetailsButtonForLevelDifficulty(String levelDifficultyCode) {
        return driver.findElement(By.xpath("(//td[contains(text(),'" + levelDifficultyCode + "')]/following-sibling::td/div/seress-ui-button)[2]"));
    }

    public WebElement getDeleteButtonForLevelDifficulty() {
        return driver.findElement(By.xpath("//*[@texttooltip=\"Eliminar\"]/button"));
    }

    public WebElement pickYear(String year) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + year + "')]"));
    }
}
