package bergs.Bvr.Bvruaajm.test.tasks.login;

import java.util.List;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_CriarCartaoVirtualPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_ListarCartoesPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_PrimeiroAcessoPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.login.Bvruaajm_ListaCartoesAdicionadosValitadion;
import bergs.Bvr.Bvruaajm.test.validations.login.Bvruaajm_LoginlValidations;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.enums.Bmouaajm_EventoHtml;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_CriarCartaoVirtualTask extends Bvruaajm_TaskMobile {

    Bvruaajm_CriarCartaoVirtualPage criarCartao;
    Bvruaajm_PrimeiroAcessoPage primeiroAcesso;
    Bvruaajm_ListaCartoesAdicionadosValitadion listaCartaoValidation;
    Bvruaajm_Esperas esperar;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_ListarCartoesPage listaCartoesPage;
    Bvruaajm_LoginlValidations loginValidations;
    String erroCodigoIncorreto = "Código de ativação incorreto.";

    public Bvruaajm_CriarCartaoVirtualTask(AppiumDriver<WebElement> driver) {
        super(driver);
        criarCartao = new Bvruaajm_CriarCartaoVirtualPage(driver);
        primeiroAcesso = new Bvruaajm_PrimeiroAcessoPage(driver);
        listaCartaoValidation = new Bvruaajm_ListaCartoesAdicionadosValitadion(driver);
        esperar = new Bvruaajm_Esperas(driver);
        loginValidations = new Bvruaajm_LoginlValidations(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        listaCartoesPage = new Bvruaajm_ListarCartoesPage(driver);
    }

    public void preencherCampoCpf(String cpf) {
        criarCartao.obterCampoCpf().clicar().preencherLento(cpf);
    }

    public void preencherCampoApelido(String apelido) {
        criarCartao.obterCampoApelido().preencherLento(apelido);
    }

    public void clicarContatoConfirmacaoPorPosicao(int posicao) {
        List<Bmouaajm_Elemento> listaContatos = criarCartao.obterContatoConfirmacao();
        listaContatos.get(posicao).clicar();
    }

    public void preencherCodigoConfirmacao(String codigo) {
        List<WebElement> inputs = criarCartao.obterCodigoAtivacao();
        int i = 0;
        for (WebElement input : inputs) {
            if (codigo.length() > i) {
                input.sendKeys("" + codigo.charAt(i));
            }
            i++;
        }
    }

    public void preencherSenhaAcesso(String obterSenha) {
        criarCartao.obterInputSenha().clicar().preencherLento(obterSenha);
    }

    public void preencherSenhaConfirmacaoAcesso(String obterSenha) {
        criarCartao.obterInputSenhaConfirmacao().clicar().preencherLento(obterSenha).dispararEvento(Bmouaajm_EventoHtml.BLUR);
    }

    public void clicarReenviarCodigo() {
        criarCartao.obterReenviarCodigoAtivacao().clicar();
    }

    /**
     * ESSE METODO PREENCHE CAMPOS PARA NOVO CARTÃO ACESSO
     * 
     * @param cartaoAcesso
     */
    public void preencherDadosNovoCartao(Bvruaajm_CartaoAcesso cartaoAcesso) {
        preencherCampoCpf(cartaoAcesso.obterCpfFormatado());
        preencherCampoApelido(cartaoAcesso.obterApelido());
        jsExecutor.removerFocusElementoAtual();
        genericPage.obterBotaoAvancar().clicar();
        clicarContatoConfirmacaoPorPosicao(0);
        genericPage.obterBotaoAvancar().clicar();
        preencherCodigoConfirmacao(cartaoAcesso.obterCodigoAtivacao());
        preencherSenhaAcesso(cartaoAcesso.obterSenha());
        preencherSenhaConfirmacaoAcesso(cartaoAcesso.obterSenha());
        genericPage.obterBotaoAvancar().clicar();
        criarCartao.obterBotaoMeiaModalVamosLa().clicar();
    }

    /**
     * ESSE METODO PREENCHE CAMPOS PARA VALIDAR CODIGO ATIVA, SENHA E CONFIRMA SENHA
     * 
     * @param cartaoAcesso
     */
    public void preencheDadosNovoCartaoAtePaginaSenha(Bvruaajm_CartaoAcesso cartaoAcesso, String codAtivacao, String senha, String confirmaSenha) {
        preencherCampoCpf(cartaoAcesso.obterCpfFormatado());
        preencherCampoApelido(cartaoAcesso.obterApelido());
        jsExecutor.removerFocusElementoAtual();
        genericPage.obterBotaoAvancar().clicar();
        clicarContatoConfirmacaoPorPosicao(0);
        genericPage.obterBotaoAvancar().clicar();
        preencherCodigoConfirmacao(codAtivacao);
        preencherSenhaAcesso(senha);
        preencherSenhaConfirmacaoAcesso(confirmaSenha);

    }

    /**
     * ESSE METODO FAZ A VERIFICAÇÃO DE REENVIAR CODIGO DE ATIVAÇÃO
     * 
     * @param cpf
     * @param apelido
     */

    public void validarReenviarCodigoDeAtivacao(String cpf, String apelido) {
        definirContextoNativo();
        esperar.aguardarTextoCarregandoInformacoesDesaparecer();
        definirContextoWebview();
        if (!listaCartaoValidation.listaCartoesEstaVisivel()) {
            primeiroAcesso.obterBotaoPrimeiroAcesso().clicar();
            preencherCampoCpf(cpf);
            preencherCampoApelido(apelido);
            jsExecutor.removerFocusElementoAtual();
            genericPage.obterBotaoAvancar().clicar();
            clicarContatoConfirmacaoPorPosicao(0);
            genericPage.obterBotaoAvancar().clicar();
            clicarReenviarCodigo();
            loginValidations.validaTextoReenviarCodigo();
            criarCartao.obterBotaoMeiaModalVamosLa().clicar();
        }
    }

    /**
     * ESSE METODO FAZ A VERIFICAÇÃO EFETUAR CADADASTRO COM O CODGO DE ATIVAÇÃO INCORRETO
     * 
     * @param cartaoAcesso
     * @param codAtivacao
     * @param senha
     * @param confirmaSenha
     */
    public void efetuarCadastraAteInserirCodAtivacao(Bvruaajm_CartaoAcesso cartaoAcesso, String codAtivacao, String senha, String confirmaSenha) {
        definirContextoNativo();
        esperar.aguardarTextoCarregandoInformacoesDesaparecer();
        definirContextoWebview();
        if (!listaCartaoValidation.listaCartoesEstaVisivel()) {
            primeiroAcesso.obterBotaoPrimeiroAcesso().clicar();
            preencheDadosNovoCartaoAtePaginaSenha(cartaoAcesso, codAtivacao, senha, confirmaSenha);
            genericPage.obterBotaoAvancar().clicar();
            loginValidations.validaTextoCodigoInvalido();
        }
    }

    /**
     * ESSE METODO FAZ A VERIFICAÇÃO DO CADASTRO ATE INSERIR SENHA
     * 
     * @param cartaoAcesso
     * @param codAtivacao
     * @param senha
     * @param confirmaSenha
     * @param textoMsg
     */

    public void efetuarCadastraAteInserirSenha(Bvruaajm_CartaoAcesso cartaoAcesso, String codAtivacao, String senha, String confirmaSenha,
            String textoMsg) {
        definirContextoNativo();
        esperar.aguardarTextoCarregandoInformacoesDesaparecer();
        definirContextoWebview();
        if (!listaCartaoValidation.listaCartoesEstaVisivel()) {
            primeiroAcesso.obterBotaoPrimeiroAcesso().clicar();
            preencheDadosNovoCartaoAtePaginaSenha(cartaoAcesso, codAtivacao, senha, confirmaSenha);
            genericValidation.validarTextosEsperadoEAtual(textoMsg, listaCartoesPage.obterSpanMensagemErroCampos().obterTexto());
        }
    }

    public void validaSeOCartaoExiste() {
        definirContextoNativo();
        esperar.aguardarTextoCarregandoInformacoesDesaparecer();
        definirContextoWebview();
        listaCartaoValidation.validaSeOCartaoFoiAdd();
    }
}
