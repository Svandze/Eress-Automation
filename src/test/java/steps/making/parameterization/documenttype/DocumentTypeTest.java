package steps.making.parameterization.documenttype;

import org.junit.Before;
import org.junit.Test;
import pages.making.parameterization.MakingPage;
import pages.making.parameterization.ParameterizationPage;
import pages.making.parameterization.documenttype.DocumentTypePage;
import steps.BaseTestEress;

import static org.example.constants.EressConstants.CONFECCIONES_WINDOW;
import static org.example.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.clickWithJavaScript;

public class DocumentTypeTest extends BaseTestEress {
    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private DocumentTypePage documentTypePage;

    @Before
    public void setup() {
        super.setup();
        makingPage = new MakingPage();
        parameterizationPage = new ParameterizationPage();
        documentTypePage = new DocumentTypePage();
        windowHandler(CONFECCIONES_WINDOW);
        waitAndClick(makingPage.parameterizationIcon);
        implicitWait();
        clickWithJavaScript(parameterizationPage.tipoDocumentoIcon);
    }

    @Test
    public void documentTypeManagementTest()  {
        String documentTypeCode = randomCode();
        String documentTypeDescription = "Test";
        String updateDocumentTypeCode = randomCode();
        String updatedDocumentTypeDescription = "Update Test";
        documentTypePage.addDocumentType(documentTypeCode, documentTypeDescription);
        documentTypePage.editDocumentType(documentTypeCode,updateDocumentTypeCode,updatedDocumentTypeDescription);
        documentTypePage.validateDocumentType(updateDocumentTypeCode, updateDocumentTypeCode, updatedDocumentTypeDescription);
        documentTypePage.deleteDocumentType(updateDocumentTypeCode);


    }
}
