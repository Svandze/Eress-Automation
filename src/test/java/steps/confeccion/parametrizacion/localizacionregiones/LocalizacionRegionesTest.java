package steps.confeccion.parametrizacion.localizacionregiones;

import pages.making.parametrizacion.ConfeccionPage;
import steps.BaseTestSeress;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pages.making.parametrizacion.ParametrizacionPage;
import pages.making.parametrizacion.localizacionregiones.LocalizacionRegionesPage;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;
public class LocalizacionRegionesTest extends BaseTestSeress {


    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private LocalizacionRegionesPage localizacionRegionesPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        localizacionRegionesPage = new LocalizacionRegionesPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        clickWithJavaScript(parametrizacionPage.localizacionRegionesIcon);
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
        localizacionRegionesPage.addLocationByRegions(codCountry, faker.country().name(),randomCode(), "region", randomCode(), faker.country().capital());
        localizacionRegionesPage.editLocationByRegions(codCountry, updateCodCountry, updateCountry, updateCodRegion, updateRegion, updateCodCity, updateCity);
        localizacionRegionesPage.validateLocationByRegions(updateCodCountry,updateCodCountry, updateCountry, updateCodRegion, updateRegion, updateCodCity, updateCity);
        localizacionRegionesPage.deleteLocationByRegions(updateCodCountry);
    }
}
