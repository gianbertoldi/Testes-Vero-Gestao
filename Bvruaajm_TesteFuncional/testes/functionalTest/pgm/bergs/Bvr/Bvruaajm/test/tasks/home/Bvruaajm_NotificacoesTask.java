package bergs.Bvr.Bvruaajm.test.tasks.home;

import java.util.List;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.home.Bvruaajm_NotificacoesPage;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.home.Bvruaajm_NotificacoesValidations;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_NotificacoesTask extends Bvruaajm_TaskMobile {

    Bvruaajm_NotificacoesPage notificacoesPage;
    Bvruaajm_NotificacoesValidations notificacaoValidations;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_Esperas esperar;
    Bvruaajm_ElementoNativoTask nativoTask;

    public Bvruaajm_NotificacoesTask(AppiumDriver<WebElement> driver) {
        super(driver);
        notificacoesPage = new Bvruaajm_NotificacoesPage(driver);
        notificacaoValidations = new Bvruaajm_NotificacoesValidations(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        esperar = new Bvruaajm_Esperas(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
    }

    public void validaSeMeiaModalNotificacaoAbreMesagemMaisRecenteNaHome() {
        notificacaoValidations.validarNotificacao();
        notificacoesPage.obterBotaoMeiaModalNotificacaoEntendi().clicar();
    }

    public void validaMensagemNaoLida(int numNotificacao) {
        nativoTask.clicarBotaoDireito2();
        notificacaoValidations.statusNotificacaoNaoLida(numNotificacao);
        List<Bmouaajm_Elemento> notificacao = notificacoesPage.obterListaDeNotificacoes();
        notificacao.get(numNotificacao - 1).clicar();
        notificacaoValidations.validarNotificacao();
        notificacoesPage.obterBotaoMeiaModalNotificacaoEntendi().clicar();
        notificacaoValidations.statusNotificacaoLida(numNotificacao);
    }

    public void validaModalTelaCheiaNaHome() {
        notificacaoValidations.validarNotificacaoTelaCheia();
        notificacaoValidations.validaImagemEstaNaTela(notificacoesPage.obterSeImagemEstaNaTela());
    }

    public void validaNotificacaoPagamentoLink() {
        nativoTask.clicarBotaoEsquerdo();
        nativoTask.clicarBotaoEsquerdo();
        nativoTask.clicarBotaoEsquerdo();
        nativoTask.clicarBotaoDireito2();
        List<Bmouaajm_Elemento> notificacao = notificacoesPage.obterListaDeNotificacoes();
        notificacao.get(0).clicar();
        
    }
}
