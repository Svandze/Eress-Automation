package co.com.automation.steps.making.parameterization.documenttype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.com.automation.pages.making.parameterization.MakingPageEress;
import co.com.automation.pages.making.parameterization.ParameterizationPageEress;
import co.com.automation.pages.making.parameterization.documenttype.DocumentTypePageEress;
import co.com.automation.steps.BaseTestEress;

import static co.com.eress.automation.constants.EressConstants.CONFECCIONES_WINDOW;
import static co.com.eress.automation.utils.randomCodeBuilder.randomCode;
import static utils.ElementUtils.*;
import static utils.ElementUtils.clickWithJavaScript;

public class DocumentTypeTest extends BaseTestEress {
    private MakingPageEress makingPage;
    private ParameterizationPageEress parameterizationPage;
    private DocumentTypePageEress documentTypePage;

    @BeforeEach
    public void setup() {
        super.setup();
        makingPage = new MakingPageEress();
        parameterizationPage = new ParameterizationPageEress();
        documentTypePage = new DocumentTypePageEress();
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
