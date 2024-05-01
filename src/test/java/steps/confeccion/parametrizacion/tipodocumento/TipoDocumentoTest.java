package steps.confeccion.parametrizacion.tipodocumento;

import org.junit.Before;
import org.junit.Test;
import pages.making.parametrizacion.ConfeccionPage;
import pages.making.parametrizacion.ParametrizacionPage;
import pages.making.parametrizacion.tipodocumento.TipoDocumentoPage;
import steps.BaseTestSeress;

import static org.example.constants.SeressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.MachineCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.clickWithJavaScript;

public class TipoDocumentoTest extends BaseTestSeress {
    private ConfeccionPage confeccionPage;
    private ParametrizacionPage parametrizacionPage;
    private TipoDocumentoPage tipoDocumentoPage;

    @Before
    public void setup() {
        super.setup();
        confeccionPage = new ConfeccionPage();
        parametrizacionPage = new ParametrizacionPage();
        tipoDocumentoPage= new TipoDocumentoPage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(confeccionPage.parameterizationIcon);
        implicitWait();
        clickWithJavaScript(parametrizacionPage.tipoDocumentoIcon);
    }

    @Test
    public void documentTypeManagementTest()  {
        String documentTypeCode = randomCode();
        String documentTypeDescription = "Test";
        String updateDocumentTypeCode = randomCode();
        String updatedDocumentTypeDescription = "Update Test";
        tipoDocumentoPage.addDocumentType(documentTypeCode, documentTypeDescription);
        tipoDocumentoPage.editDocumentType(documentTypeCode,updateDocumentTypeCode,updatedDocumentTypeDescription);
        tipoDocumentoPage.validateDocumentType(updateDocumentTypeCode, updateDocumentTypeCode, updatedDocumentTypeDescription);
        tipoDocumentoPage.deleteDocumentType(updateDocumentTypeCode);


    }
}
