package bergs.Bvr.Bvruaajm.test.tasks.vender;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_VeroXPage;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.vender.Bvruaajm_VenderValidation;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_VeroXTask extends Bvruaajm_TaskMobile {

    Bvruaajm_VenderValidation venderValidation;
    Bvruaajm_Esperas esperas;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_ElementoNativoTask nativoTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_VeroXPage veroXPage;
    Bvruaajm_OnboardingTask pularOnbording;
    Bvruaajm_GenericValidation genericValidations;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_GenericTask genericTask;

    public Bvruaajm_VeroXTask(AppiumDriver<WebElement> driver) {
        super(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        venderValidation = new Bvruaajm_VenderValidation(driver);
        pularOnbording = new Bvruaajm_OnboardingTask(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        veroXPage = new Bvruaajm_VeroXPage(driver);
        genericValidations = new Bvruaajm_GenericValidation(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        genericTask = new Bvruaajm_GenericTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    public void validaFluxoAdesaoVeroX(String titulo, String confirmacaoMeiaModal) {
        pularOnbording.verificaPularOnboardingVeroX();
        if (venderValidation.validaVisibiladadeDaTelaQrCodeVeroX()) {
            nativoTask.clicarBotaoDireito();
            genericPage.obterBotaoPrimarioMeiaModal().clicar();
            esperas.aguardarElementoDesaparecer(genericPage.obterBotaoPrimarioMeiaModal());
            genericPage.obterBotaoPrimarioMeiaModal().clicar();
            venderTask.clicarBotaoVeroX();
        }
        genericValidations.validarTextosEsperadoEAtual(titulo, veroXPage.obterTituloAdesaoVeroX().obterTexto());
        veroXPage.obterBotaoIniciaAdesao().clicar();
        veroXPage.obterSelecionarEstabLogado().clicar();
        veroXPage.obterSelecionarChavePix().clicar();
        veroXPage.obterPixPorCnpj().clicar();
        veroXPage.obterConfirmarChavePixCnpj().clicar();
        veroXPage.obterBotaoConfirmarAdesao().clicar();
        genericValidations.validaElementoEstaDesabilitado(genericPage.obterBotaoPrimarioMeiaModal());
        veroXPage.obterCheckBoxLiEconcordoTermoVeroX().clicar();
        genericPage.obterBotaoPrimarioMeiaModal().clicar();
        esperas.aguardarTextoProcessandoDesaparecer();
        genericValidations.validarTextosEsperadoEAtual(confirmacaoMeiaModal, genericPage.obterTituloMeiaModal().obterTexto());;
        genericPage.obterBotaoPrimarioMeiaModal().clicar();
    }

    public void validaTelaVeroX() {
        venderTask.clicarBotaoVeroX();
        pularOnbording.verificaPularOnboardingVeroX();
        venderValidation.validarTelaVeroX();
        veroXPage.obterSetaAumentarQrCode().clicar();
        venderValidation.validarTextoChavePixQrCodeAumentado();
        veroXPage.obterSetaAumentarQrCode().clicar();
    }
}
