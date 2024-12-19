package bergs.Bvr.Bvruaajm.test.tasks.generic;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_CriarCartaoVirtualPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_PrimeiroAcessoPage;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_HomeTask;
import bergs.Bvr.Bvruaajm.test.tasks.login.Bvruaajm_CriarCartaoVirtualTask;
import bergs.Bvr.Bvruaajm.test.tasks.login.Bvruaajm_ListaCartoesTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.login.Bvruaajm_ListaCartoesAdicionadosValitadion;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_GenericTask extends Bvruaajm_TaskMobile {

    Bvruaajm_PrimeiroAcessoPage primeiroAcesso;
    Bvruaajm_ListaCartoesAdicionadosValitadion listaCartaoValidation;
    Bvruaajm_ListaCartoesTask listaCartoesTask;
    Bvruaajm_CriarCartaoVirtualTask criarCartao;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_Esperas esperar;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_HomeTask home;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_CriarCartaoVirtualPage cartaoVirtualPage;
    Bvruaajm_Esperas esperas;

    public Bvruaajm_GenericTask(AppiumDriver<WebElement> driver) {
        super(driver);
        primeiroAcesso = new Bvruaajm_PrimeiroAcessoPage(driver);
        listaCartaoValidation = new Bvruaajm_ListaCartoesAdicionadosValitadion(driver);
        listaCartoesTask = new Bvruaajm_ListaCartoesTask(driver);
        criarCartao = new Bvruaajm_CriarCartaoVirtualTask(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        esperar = new Bvruaajm_Esperas(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        home = new Bvruaajm_HomeTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        cartaoVirtualPage = new Bvruaajm_CriarCartaoVirtualPage(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    /** METODOS DE AÇÃO CLICAR **/

    public void clicarBotaoVender() {
        genericPage.obterBotaoVender().clicar();
    }

    public void clicarBotaoHome() {
        genericPage.obterBotaoHome().clicar();
    }

    public void clicarBotaoExtratos() {
        genericPage.obterBotaoExtratos().clicar();
    }

    public void clicarBotaoServicos() {
        genericPage.obterBotaoServicos().clicar();
    }

    public void clicarBotaoPerfil() {
        genericPage.obterBotaoPerfil().clicar();
    }

    /** METODOS PARA EFETUAR LOGIN E SELECIONAR ESTABELECIMENTO QUE SERÁ UTILIZADO **/

    /**
     * ESSE METODO INSERE CARTÃO PARA FAZER LOGIN CASO SEJA PRIMEIRO ACESSO E EFETUAR LOGIN ESSE METODO INSERE NOVO CARTÃO CASO NÃO ESTEJA CADASTRADO NA
     * LISTA DE CARTÕES E EFETUA LOGIN ESSE METODO EFETUA LOGIN EM UM CARTÃO JA EXISTENTE
     * 
     * @param cartaoAcesso
     */
    public void prepararTesteLogado(Bvruaajm_CartaoAcesso cartaoAcesso) {
        definirContextoNativo();
        esperar.aguardarTextoCarregandoInformacoesDesaparecer();
        definirContextoWebview();
        if (listaCartaoValidation.listaCartoesEstaVisivel()) {
            if (listaCartaoValidation.cartaoEstaVisivel(cartaoAcesso)) {
                efetuarLogin(cartaoAcesso);
            } else {
                listaCartoesTask.clicarBotaoNovoCartao();
                efetuarCadastroNovoCartao(cartaoAcesso);
            }
        } else if (this.primeiroAcesso.obterBotaoPrimeiroAcesso().estaVisivel()) {
            primeiroAcesso.obterBotaoPrimeiroAcesso().clicar();
            efetuarCadastroNovoCartao(cartaoAcesso);
        }
    }

    /**
     * ESSE METODO CHAMA OS METODOS DE VALIDAÇÃO DE ESTABELECIMENTO E CONVENIADO
     * 
     * @param estab
     */
    public void selecionaEstabelecimentoOuConveniado(Bvruaajm_Estabelecimento estab) {
        genericPage.obterSetaComboEstabelecimento().clicar();
        try {
            String cpfCnpj = String.valueOf(estab.obterCpfCnpj());
            if (genericValidation.selecionarEstabelecimento(cpfCnpj)) {
                jsExecutor.scrollIntoView(genericPage.obterEstabelecimentoPorCpfOuCnpj(cpfCnpj));
                genericPage.obterEstabelecimentoPorCpfOuCnpj(cpfCnpj).clicar();
            } else {
                jsExecutor.scrollIntoView(genericPage.obterConveniadoPorCpfOuCnpj(cpfCnpj));
                genericPage.obterConveniadoPorCpfOuCnpj(cpfCnpj).clicar();
            }
            esperas.aguardarTextoProcessandoDesaparecer();
        } catch (Exception e) {

        }
    }

    /** METODOS PRIVADOS **/

    /**
     * 
     * ESSE METODO EFETUAR PROCESSO DE CADASTRAR NOVO CARTÃO
     * 
     * @param cartaoAcesso
     */
    private void efetuarCadastroNovoCartao(Bvruaajm_CartaoAcesso cartaoAcesso) {
        criarCartao.preencherDadosNovoCartao(cartaoAcesso);
        efetuarLogin(cartaoAcesso);
    }

    private void efetuarLogin(Bvruaajm_CartaoAcesso cartaoAcesso) {
        listaCartoesTask.clicarCartaoDaLista(cartaoAcesso);
        listaCartoesTask.inserirSenhaCartao(cartaoAcesso);
        esperar.aguardarTextoProcessandoDesaparecer();
        onboardingTask.verificaPularOnboardingGeneric();
    }

}
