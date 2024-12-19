package bergs.Bvr.Bvruaajm.test.tasks.login;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_CriarCartaoVirtualPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_ListarCartoesPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_PrimeiroAcessoPage;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.login.Bvruaajm_ListaCartoesAdicionadosValitadion;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ListaCartoesTask extends Bvruaajm_TaskMobile {

    Bvruaajm_ListarCartoesPage listaCartoesPage;
    Bvruaajm_ListaCartoesAdicionadosValitadion listaCartaoValidation;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_Esperas esperar;
    Bvruaajm_PrimeiroAcessoPage primeiroAcesso;
    Bvruaajm_CriarCartaoVirtualTask criarCartao;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_CriarCartaoVirtualPage criarCartaoPage;
    Bvruaajm_ElementoNativoTask nativeTask;
    String erroCpfJaExiste = "Já existe cartão com este CPF";
    String senhaInvalida = "Senha inválida";
    String tituloCpfNaoVinculado = "Este CPF não está vinculado a nenhum estabelecimento";
    String txtCaminhoIncluirCpf = "Menu Perfil > Meus Negócios > Gerenciar Usuários > Incluir Usuário";
    String txtConversarVero = "Como você prefere conversar com a Vero?";
    String codigoAtivacao = "111111";
    String senha = "teste0102";
    String senhaAlteradaMsg = "Sua senha foi alterada com sucesso.";

    public Bvruaajm_ListaCartoesTask(AppiumDriver<WebElement> driver) {
        super(driver);
        listaCartoesPage = new Bvruaajm_ListarCartoesPage(driver);
        listaCartaoValidation = new Bvruaajm_ListaCartoesAdicionadosValitadion(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        esperar = new Bvruaajm_Esperas(driver);
        primeiroAcesso = new Bvruaajm_PrimeiroAcessoPage(driver);
        criarCartao = new Bvruaajm_CriarCartaoVirtualTask(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        criarCartaoPage = new Bvruaajm_CriarCartaoVirtualPage(driver);
        nativeTask = new Bvruaajm_ElementoNativoTask(driver);
    }

    public void clicarCartaoDaLista(Bvruaajm_CartaoAcesso cartaoAcesso) {
        esperar.esperarAte(driver -> listaCartoesPage.obterCartao(cartaoAcesso).isDisplayed(), 30);
        jsExecutor.scrollIntoView(listaCartoesPage.obterCartao(cartaoAcesso));
        listaCartoesPage.obterCartao(cartaoAcesso).click();
    }

    public void clicarBotaoNovoCartao() {
        listaCartoesPage.obterBotaoNovoCartao().clicar();
    }

    public void inserirSenhaCartao(Bvruaajm_CartaoAcesso cartaoAcesso) {
        definirContextoNativo();
        listaCartoesPage.obterCampoSenhaNativo().click();
        listaCartoesPage.obterCampoSenhaNativo().sendKeys(cartaoAcesso.obterSenha());
        listaCartoesPage.obterBotaoOkNativo().click();
        definirContextoWebview();
    }

    public void iniciaCadastroInserindoCpfEApelido(String cpf, String apelido, String textoValidacao) {
        definirContextoNativo();
        esperar.aguardarTextoCarregandoInformacoesDesaparecer();
        definirContextoWebview();
        if (listaCartaoValidation.listaCartoesEstaVisivel()) {
            clicarBotaoNovoCartao();
            criarCartao.preencherCampoCpf(cpf);
            criarCartao.preencherCampoApelido(apelido);
            jsExecutor.removerFocusElementoAtual();
            genericValidation.validarTextosEsperadoEAtual(textoValidacao, listaCartoesPage.obterSpanMensagemErroCampos().obterTexto());
        } else {
            primeiroAcesso.obterBotaoPrimeiroAcesso().clicar();
            criarCartao.preencherCampoCpf(cpf);
            criarCartao.preencherCampoApelido(apelido);
            jsExecutor.removerFocusElementoAtual();
            genericValidation.validarTextosEsperadoEAtual(textoValidacao, listaCartoesPage.obterSpanMensagemErroCampos().obterTexto());
        }
    }

    public void iniciaCadastroEValidaCampoApelidoComCaracterEspecial(String cpf, String apelido, String textoValidacao) {
        definirContextoNativo();
        esperar.aguardarTextoCarregandoInformacoesDesaparecer();
        definirContextoWebview();
        if (listaCartaoValidation.listaCartoesEstaVisivel()) {
            clicarBotaoNovoCartao();
            criarCartao.preencherCampoCpf(cpf);
            criarCartao.preencherCampoApelido(apelido);
            jsExecutor.removerFocusElementoAtual();
            genericValidation.validarTextosEsperadoEAtual(textoValidacao, jsExecutor.obterValorCampoApelido());
        } else {
            primeiroAcesso.obterBotaoPrimeiroAcesso().clicar();
            criarCartao.preencherCampoCpf(cpf);
            criarCartao.preencherCampoApelido(apelido);
            jsExecutor.removerFocusElementoAtual();
            genericValidation.validarTextosEsperadoEAtual(textoValidacao, jsExecutor.obterValorCampoApelido());
        }
    }

    public void iniciaCadastroCartaoExistenteNaLista(Bvruaajm_CartaoAcesso cartaoAcesso) {
        definirContextoNativo();
        esperar.aguardarTextoCarregandoInformacoesDesaparecer();
        definirContextoWebview();
        if (listaCartaoValidation.listaCartoesEstaVisivel()) {
            if (listaCartaoValidation.cartaoEstaVisivel(cartaoAcesso)) {
            } else {
                clicarBotaoNovoCartao();
                efetuarCadastroNovoCartaoNaLista(cartaoAcesso);
            }
        } else if (this.primeiroAcesso.obterBotaoPrimeiroAcesso().estaVisivel()) {
            primeiroAcesso.obterBotaoPrimeiroAcesso().clicar();
            efetuarCadastroNovoCartaoNaLista(cartaoAcesso);
        }
    }

    public void preencherDadosCartaoExistente(Bvruaajm_CartaoAcesso cartaoAcesso) {
        clicarBotaoNovoCartao();
        criarCartao.preencherCampoCpf(cartaoAcesso.obterCpfFormatado());
        criarCartao.preencherCampoApelido(cartaoAcesso.obterApelido());
        jsExecutor.removerFocusElementoAtual();
        genericPage.obterBotaoAvancar().clicar();
        genericValidation.validarTextosEsperadoEAtual(erroCpfJaExiste,
                genericPage.obterMensagemMeiaModalDivTextoCentrado().obterTexto());
    }

    public void inserirSenhaInvalida(Bvruaajm_CartaoAcesso cartaoAcesso) {
        clicarCartaoDaLista(cartaoAcesso);
        inserirSenhaCartao(cartaoAcesso);
        definirContextoNativo();
        genericValidation.validarTextosEsperadoEContains(senhaInvalida, listaCartoesPage.obterSenhaInvalidaNativo().getText());
        definirContextoWebview();
    }
    
    public void validarTrocarSenhaDoCartao(Bvruaajm_CartaoAcesso cartaoAcesso) {
        definirContextoNativo();
        esperar.aguardarTextoCarregandoInformacoesDesaparecer();
        definirContextoWebview();
        jsExecutor.scrollIntoView(listaCartoesPage.obterCartao(cartaoAcesso));
        listaCartoesPage.obterMenuOpcoesCartao(cartaoAcesso).click();
        listaCartoesPage.obterEditarCartao().clicar();
        esperar.aguardarTextoProcessandoDesaparecer();
        criarCartao.clicarContatoConfirmacaoPorPosicao(1);
        genericPage.obterBotaoAvancar().clicar();
        criarCartao.preencherCodigoConfirmacao(codigoAtivacao);
        criarCartao.preencherSenhaAcesso(senha);
        criarCartao.preencherSenhaConfirmacaoAcesso(senha);
        genericPage.obterBotaoAvancar().clicar();
        genericValidation.validarTextosEsperadoEAtual(senhaAlteradaMsg, genericPage.obterDescricaoMeiaModal().obterTexto());
        criarCartaoPage.obterBotaoMeiaModalVamosLa().clicar();
    }

    public void validaAcessoCpfNaoCadastrado(Bvruaajm_CartaoAcesso cartaoAcesso) {
        abrePageCriarCartao(cartaoAcesso);
        criarCartao.preencherCampoCpf(cartaoAcesso.obterCpfFormatado());
        criarCartao.preencherCampoApelido(cartaoAcesso.obterApelido());
        jsExecutor.removerFocusElementoAtual();
        genericPage.obterBotaoAvancar().clicar();
        genericValidation.validarTextosEsperadoEAtual(tituloCpfNaoVinculado, criarCartaoPage.obterTituloCpfNaoCadastrado().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(txtCaminhoIncluirCpf, criarCartaoPage.obterTextoCaminhoCpfNaoCadastrado().obterTexto());
        criarCartaoPage.obterLinkAquiEntreEmContato().clicar();
        genericValidation.validarTextosEsperadoEAtual(txtConversarVero, genericPage.obterTituloConversarComVero().obterTexto());
    }
    
    public void validarTelaContatoComVeroAcesso() {
        nativeTask.clicarBotaoDireito2();
        genericValidation.validarTextosEsperadoEAtual(txtConversarVero, genericPage.obterTituloConversarComVero().obterTexto());
    }

    /**** METODOS PRIVADOS ****/

    /**
     * 
     * @param cartaoAcesso
     */
    private void efetuarCadastroNovoCartaoNaLista(Bvruaajm_CartaoAcesso cartaoAcesso) {
        criarCartao.preencherDadosNovoCartao(cartaoAcesso);
    }

    /* CLICAR EM ADICIONAR NOVO CARTÃO OU CARTÃO PRIMEIRO ACESSO CASO CARTÂO ACESSO NÃO ESTEJA ADICIONADO */
    private void abrePageCriarCartao(Bvruaajm_CartaoAcesso cartaoAcesso) {
        definirContextoNativo();
        esperar.aguardarTextoCarregandoInformacoesDesaparecer();
        definirContextoWebview();
        if (listaCartaoValidation.listaCartoesEstaVisivel()) {
            if (listaCartaoValidation.cartaoEstaVisivel(cartaoAcesso)) {
            } else {
                clicarBotaoNovoCartao();
            }
        } else if (this.primeiroAcesso.obterBotaoPrimeiroAcesso().estaVisivel()) {
            primeiroAcesso.obterBotaoPrimeiroAcesso();
        }
    }

}
