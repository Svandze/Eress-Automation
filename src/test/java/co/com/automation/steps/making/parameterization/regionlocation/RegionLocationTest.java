package co.com.automation.steps.making.parameterization.regionlocation;

import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.steps.BaseTestEress;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.regionlocation.RegionLocationPage;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
public class RegionLocationTest extends BaseTestEress {


    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private RegionLocationPage regionLocationPage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        regionLocationPage = new RegionLocationPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        clickWithJavaScript(parameterizationPage.localizacionRegionesIcon);
    }

    @Test
    public void locationByRegionsTest() {
        Faker faker = new Faker();
        String codCountry= randomCode();
        String updateCodCountry = randomCode();
        String updateCountry = faker.country().name();
        String updateCodRegion = randomCode();
        String updateRegion = "Region update";
        String updateCodCity = randomCode();
        String updateCity = faker.country().capital();
        regionLocationPage.addLocationByRegions(codCountry, faker.country().name(),randomCode(), "region", randomCode(), faker.country().capital());
        regionLocationPage.editLocationByRegions(codCountry, updateCodCountry, updateCountry, updateCodRegion, updateRegion, updateCodCity, updateCity);
        regionLocationPage.validateLocationByRegions(updateCodCountry,updateCodCountry, updateCountry, updateCodRegion, updateRegion, updateCodCity, updateCity);
        regionLocationPage.deleteLocationByRegions(updateCodCountry);
    }
}
