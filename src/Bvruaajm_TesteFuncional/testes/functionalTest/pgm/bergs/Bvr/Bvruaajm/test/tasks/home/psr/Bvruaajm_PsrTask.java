package bergs.Bvr.Bvruaajm.test.tasks.home.psr;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.home.Bvruaajm_HomePage;
import bergs.Bvr.Bvruaajm.test.pages.home.psr.Bvruaajm_PsrPage;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.validations.home.Bvruaajm_PsrValidations;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PsrTask extends Bvruaajm_TaskMobile {

    Bvruaajm_HomePage homePage;
    Bvruaajm_PsrPage psrPage;
    Bvruaajm_OnboardingTask genericonbording;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_Esperas esperas;
    Bvruaajm_PsrValidations psrValidation;
    Bvruaajm_ElementoNativoTask nativoTask;

    public Bvruaajm_PsrTask(AppiumDriver<WebElement> driver) {
        super(driver);
        homePage = new Bvruaajm_HomePage(driver);
        psrPage = new Bvruaajm_PsrPage(driver);
        genericonbording = new Bvruaajm_OnboardingTask(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        esperas = new Bvruaajm_Esperas(driver);
        psrValidation = new Bvruaajm_PsrValidations(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
    }

    public void acessarPrs() {
        homePage.obterBotaoPsrTelaHome().clicar();
    }
    
    public void validaPsrIndisponivelPerfilConsulta() {
        homePage.obterBotaoSimuladorCarrossel();
        homePage.obterBotaoPsrTelaHome().clicar();
        nativoTask.clicarBotaoEsquerdo();
    }

    public void validaNovaSolicitacaoPsrCielo() {
        psrPage.obterBotaoNovaSolicitacao().clicar();
        psrPage.obterCheckBoxPsrCielo().clicar();
        psrPage.obterBotaoEnviaSolicitacaoPsr().clicar();
        psrValidation.solicitacaoCieloEnviada();
    }

    public void validarSolicitacaoPendetePrs() { 
        psrPage.obterChevronMinhaSolicitacaoPendenteGetNet().clicar();
        psrValidation.solicitacaoGetNetPendente();
    }

    public void validarSolicitacaoHabilitadaPrs() {
        psrPage.obterChevronMinhaSolicitacaoHabilitadaCielo().clicar();
        psrValidation.solicitacaoCieloHabilitada();
    }

}
