package co.com.automation.steps.making.parameterization.documenttype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPage;
import co.com.automation.pages.making.parameterization.ParameterizationPage;
import co.com.automation.pages.making.parameterization.documenttype.DocumentTypePage;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.clickWithJavaScript;

public class DocumentTypeTest extends BaseTestEress {
    private MakingPage makingPage;
    private ParameterizationPage parameterizationPage;
    private DocumentTypePage documentTypePage;

    @BeforeEach
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
