package bergs.Bvr.Bvruaajm.test.tasks.perfil;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_CriarCartaoVirtualPage;
import bergs.Bvr.Bvruaajm.test.pages.perfil.Bvruaajm_PerfilPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.perfil.Bvruaajm_PerfilValidation;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PerfilTask extends Bvruaajm_TaskMobile {

    Bvruaajm_PerfilPage perfilPage;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_PerfilValidation perfilValidation;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_CriarCartaoVirtualPage criarCartaoPage;
    String msgSucessoAlteracao = "Alterações realizadas com sucesso!";
    String msgEmailInvalido = "Insira um e-mail válido";
    String txtConversarVero = "Como você prefere conversar com a Vero?";
    

    public Bvruaajm_PerfilTask(AppiumDriver<WebElement> driver) {
        super(driver);
        perfilPage = new Bvruaajm_PerfilPage(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        perfilValidation = new Bvruaajm_PerfilValidation(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        criarCartaoPage = new Bvruaajm_CriarCartaoVirtualPage(driver);
    }

    public void verificaAtualizacaoCadastroLocalStorage(Bvruaajm_CartaoAcesso cartaoAcesso) {
        definirContextoWebview();
        String cpf = StringUtils.leftPad(String.valueOf(Long.toString(cartaoAcesso.obterCpf())), 11, "0");
        String emailAtualizado = jsExecutor.retornaLocalStorageAtualizaEmailCadastrado(cpf);
        if (emailAtualizado != "null") {
            jsExecutor.removeLocalStorageEmailAtualizadoCpf(cpf);
            jsExecutor.removeLocalStorageExibiuModalEmailCpf(cpf);
        }
    }

    public void validaMeiaModalSimEstaAtualizado() {
        perfilValidation.validaVisibilidadeMeiaModalAtualizaEmail();
        perfilPage.obterBotaoSecundarioMeiaModalEmail().clicar();
    }

    public void validaMeiaModalQueroAtualizar(String email) {
        perfilValidation.validaVisibilidadeMeiaModalAtualizaEmail();
        genericPage.obterBotaoPrimarioMeiaModal().clicar();
        perfilPage.obterCampoEmailMeusDados().clicar().limpar().preencherLento(email);
        jsExecutor.removerFocusElementoAtual();
        genericPage.obterBotaoAvancar().clicar();
        genericValidation.validarTextosEsperadoEAtual(msgSucessoAlteracao,
                genericPage.obterMensagemMeiaModalDivTextoCentrado().obterTexto());
        perfilPage.obterBotaoAtualizacaoOK().clicar();
    }

    public void validaMeiaModalBotaoAgoraNao() {
        perfilValidation.validaVisibilidadeMeiaModalAtualizaEmail();
        perfilPage.obterBotaoSecundarioMeiaModalEmail().clicar();
    }

    public void validaMeiaModalBotaoCadastrarAgora(String email) {
        perfilValidation.validaVisibilidadeMeiaModalAtualizaEmail();
        genericPage.obterBotaoPrimarioMeiaModal().clicar();
        genericValidation.validarTextosEsperadoEAtual(msgEmailInvalido, perfilPage.obterMsgErroEmail().obterTexto());
        perfilPage.obterCampoEmailMeusDados().clicar().limpar().preencherLento(email);
        jsExecutor.removerFocusElementoAtual();
        genericPage.obterBotaoAvancar().clicar();
        genericValidation.validarTextosEsperadoEAtual(msgSucessoAlteracao,
                genericPage.obterMensagemMeiaModalDivTextoCentrado().obterTexto());
        perfilPage.obterBotaoAtualizacaoOK().clicar();
    }

    public void validarISPBDomicilioBancario() {
        perfilPage.menuMeusNegocios().clicar();
        perfilPage.obterDomicioBancario().clicar();
        perfilValidation.validarDomicioBancarioMeusNegocios();
    }

    public void validarISPBDomicilioBancarioContaPrePago() {
        perfilPage.menuMeusNegocios().clicar();
        perfilPage.obterDomicioBancario().clicar();
        perfilValidation.validarDomicioBancarioMeusNegociosContaPrePago();
    }

    public void validaTelaPerfil() {
        genericPage.obterBotaoPerfil().clicar();
        perfilValidation.validarDadosPerfilEstaComoEsperado();
    }

    public void validaMesagemErroNosCamposMeuPerfil() {
        acessarMeusDadosELimparDados();
        perfilValidation.validaMeusDadosCpfDesabilitado();
        perfilValidation.validarCamposMeusDadosMensagensErro();
        genericValidation.validaElementoEstaDesabilitado(genericPage.obterBotaoAvancar());
    }

    public void validaMsgErroMeusDadosCelular(String numCel, String msgErro) {
        genericPage.obterBotaoPerfil().clicar();
        perfilPage.menuPerfilAjustes().clicar();
        perfilPage.obterCampoCelularMeusDados().limpar().preencher(numCel);
        jsExecutor.removerFocusElementoAtual();
        genericValidation.validarTextosEsperadoEAtual(msgErro, perfilPage.obterMsgErroCelular().obterTexto());
    }
   
    public void validarFaleConoscoCredeciadoVero() {
        genericPage.obterBotaoPerfil().clicar();
        perfilPage.menuFaleConosco().clicar();
        genericPage.obterCardTenhoManquininha().clicar();
        perfilValidation.validarCardsFaleConosco();
    }

    private void acessarMeusDadosELimparDados() {
        genericPage.obterBotaoPerfil().clicar();
        perfilPage.menuPerfilAjustes().clicar();
        perfilPage.obterCampoNomeMeusDados().limpar();
        perfilPage.obterCampoCelularMeusDados().limpar();
        perfilPage.obterCampoEmailMeusDados().limpar();
    }

    public void validaTextosDeOpcoesDeNotificacao() {
        genericPage.obterBotaoPerfil().clicar();
        perfilPage.menuPerfilAjustes().clicar();
        jsExecutor.scrollIntoView(perfilPage.obterTxtEmailPush());
        perfilValidation.validarTextosOpcoesNotificacao();
    }
    
    public void acessarMeusNegocios() {
        perfilPage.menuMeusNegocios().clicar();
    }
}
