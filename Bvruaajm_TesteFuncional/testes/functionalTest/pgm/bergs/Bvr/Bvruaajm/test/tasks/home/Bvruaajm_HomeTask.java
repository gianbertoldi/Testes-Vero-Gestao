package bergs.Bvr.Bvruaajm.test.tasks.home;

import java.util.List;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.extrato.Bvruaajm_ExtratoMinhasVendasPage;
import bergs.Bvr.Bvruaajm.test.pages.home.Bvruaajm_HomePage;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCardsCarrossel;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.home.Bvruaajm_HomeValidation;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_HomeTask extends Bvruaajm_TaskMobile {

    Bvruaajm_HomePage homePage;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_Esperas esperar;
    Bvruaajm_ElementoNativoTask nativoTask;
    Bvruaajm_ExtratoMinhasVendasPage extratoPage;
    Bvruaajm_HomeValidation homeValidations;


    public Bvruaajm_HomeTask(AppiumDriver<WebElement> driver) {
        super(driver);
        homePage = new Bvruaajm_HomePage(driver);
        homeValidations = new Bvruaajm_HomeValidation(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        esperar = new Bvruaajm_Esperas(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        extratoPage = new Bvruaajm_ExtratoMinhasVendasPage(driver);
    }

    public void obterHomeCarregada() {
        homePage.obterHomeCarregada();
    }

    public void clicarCardConexoes() {
        homePage.obterCardTitulo(Bvruaajm_EnumCardsCarrossel.CARD_CONEXOES.toString()).scrollIntoView().clicar();
    }

    public void validaCriacaoMinhaMetaSemSalvar(String nomeMeta, String valorMeta) {
        adicionaPreencheNomeEValorMinhaMeta(nomeMeta, valorMeta);
        homeValidations.validaBotaoAddMetaEstaHabilitado();
        homePage.obterBotaoCancelarEdicaoMeta().clicar();
    }

    public void validaCampoNomeCriacaoMinhaMeta(String nomeMeta, String valorMeta, String erroNomeMeta) {
        adicionaPreencheNomeEValorMinhaMeta(nomeMeta, valorMeta);
        homeValidations.validaErroNomeMinhaMeta(erroNomeMeta);
    }

    public void validaCampoValorMinimoCriacaoMinhaMeta(String nomeMeta, String valorMeta) {
        adicionaPreencheNomeEValorMinhaMeta(nomeMeta, valorMeta);
        homeValidations.validaErroValorMinhaMeta();
    }

    public void validaEditarCampoValorMinimoMinhaMeta(String nomeMeta, String valorMeta) {
        editarMinhaMeta(nomeMeta, valorMeta);
        homeValidations.validaErroValorMinhaMeta();
    }

    public void validaEditarMinhaMetaESalvar(String nomeMeta, String valorMeta) {
        editarMinhaMeta(nomeMeta, valorMeta);
        homePage.obterBotaoCadastrarMeta().clicar();
        esperar.aguardarTextoProcessandoDesaparecer();
        homeValidations.validarValorMinhaMeta();
    }

    public void validaCartaoBeneficioContatoVeroTask() {
        homePage.obterBotaoQuantoVendi().clicar();
        homePage.obterBeneficiosFechadaQuantoRecebi().clicar();
        List<Bmouaajm_Elemento> bandeiras = homePage.obterListaCartaoBeneficios();
        jsExecutor.scrollIntoView(homePage.obterListaCartaoBeneficios().get(0));
        bandeiras.get(0).clicar();
        jsExecutor.scrollIntoView(homePage.obterClickAquiCartaoBeneficio());
        homePage.obterClickAquiCartaoBeneficio().clicar();
        homeValidations.validacaoCartaoBeneficioContatoVero();
    }

    public void validaExtratoHomeSemTrasacoes() {
        homePage.obterBotaoQuantoVendi().clicar();
        homeValidations.validarSemVendasNaHomeExtrato();
    }
    
    public void validaIconesEscondidosHome() {
        homePage.obterBotaoQuantoVendi().clicar();
        homeValidations.validarIconeEscondidos();
    }
    
    public void validaAcessoPeloExtratoDaHome() {
        homePage.obterListaExtratoHome().clicar();
        homeValidations.validarTituloExtrato();
    }

    /**
     * METODOS PRIVADOS
     */

    private void adicionaPreencheNomeEValorMinhaMeta(String nomeMeta, String valorMeta) {
        homePage.obterBotaoAdicionarMinhaMeta().clicar();
        homePage.obterCampoNomeMeta().clicar().preencher(nomeMeta);
        homePage.obterCampoValorMeta().clicar().preencher(valorMeta);
    }
    
    private void editarMinhaMeta(String nomeMeta, String valorMeta) {
        homePage.obterBotaoEditarMinhaMeta().clicar();
        homePage.obterCampoNomeMeta().clicar().limpar().preencher(nomeMeta);
        homePage.obterCampoValorMeta().clicar().limpar().preencher(valorMeta);
    }

}
