package bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM;

import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.Bvr.Bvruaajm.test.pages.mm.genericMM.Bvruaajm_ModalMMPage;
import bergs.Bvr.Bvruaajm.test.validations.mm.Bvruaajm_GenericMMValidations;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Frame;

public class Bvruaajm_ModaMMTask extends Bmouaajm_TaskBase {

    protected Bmouaajm_Frame frame;
    Bvruaajm_ModalMMPage modalPage;
    Bvruaajm_GenericMMValidations genericConsultaMMAValidation;

    public Bvruaajm_ModaMMTask(RemoteWebDriver driver) {
        super(driver);
        frame = new Bmouaajm_Frame(driver);
        modalPage = new Bvruaajm_ModalMMPage(driver);
        genericConsultaMMAValidation = new Bvruaajm_GenericMMValidations(driver);
    }

    public void clicarBotaoOk() {
        modalPage.obterBotaoOK().clicar();
    }

    public void validarTextoModal(String obterModalContent) {
        genericConsultaMMAValidation.validarTextosEsperadoEContains(obterModalContent, modalPage.obterModalInfraContent().obterTexto());
    }
}
