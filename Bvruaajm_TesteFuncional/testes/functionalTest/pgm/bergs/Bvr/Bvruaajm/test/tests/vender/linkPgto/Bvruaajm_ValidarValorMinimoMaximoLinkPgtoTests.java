package bergs.Bvr.Bvruaajm.test.tests.vender.linkPgto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.vender.Bvruaajm_LinkPagamentoValidation;

public class Bvruaajm_ValidarValorMinimoMaximoLinkPgtoTests extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_GenericTask genericTask;
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_TaskMobile taskMobile;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_LinkPagamentoValidation linkValidation;
    Bvruaajm_ElementoNativoTask nativoTask;
    String codigoLink;
    String limite;
    String cpfCnpjLimite = "110560000107";
    String mensagemErro;
    Bvruaajm_SqlBvr sqlBvr;

    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        linkValidation = new Bvruaajm_LinkPagamentoValidation(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        taskMobile = new Bvruaajm_TaskMobile(driver);
        taskMobile.definirContextoWebview();
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
    }
    
    @AfterEach
    public void finalizarTest() {
        sqlBvr = new Bvruaajm_SqlBvr();
        limite = "5000";
        sqlBvr.atualizarLimiteMaxLink(limite, cpfCnpjLimite);
    }
    
    @Tag("CriacaoLinkPgto")
    @Test
    @DisplayName("Valida se apos a alteração de limite fica a nova definição ao criar o link")
    public void validaValorMaximoLnkComAlteracaoDeLimite() {
        limite = "2000";
        mensagemErro = "O valor máximo é de R$ 2.000,00."; 
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.atualizarLimiteMaxLink(limite, cpfCnpjLimite);
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validarValorMaximoLinkPgto(2001.00, mensagemErro);
    }

    @Tag("CriacaoLinkPgto")
    @Test
    @DisplayName("valida se pula a tela de forma de pagamento de valor menores de dez reais")
    public void validaCriacaoLinkValorMinimoAVista() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.criarLinkValorMenorDezReais(5.00);
        codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr = new Bvruaajm_SqlBvr();
        nativoTask.clicarBotaoEsquerdo();
        sqlBvr.excluirLinkPgtoCriadoDoDb(codigoLink);
    }

    @Tag("CriacaoLinkPgto")
    @DisplayName("valida se pula a tela de quantidade de parcelas de valor menores de quinze reais")
    @Test
    public void validaCriarLinkPgtoParceladoDuasVezes() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.criarLinkPagamentoParceladoMenosQueQuinzeReais(10.00);
        codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr = new Bvruaajm_SqlBvr();
        nativoTask.clicarBotaoEsquerdo();
        sqlBvr.excluirLinkPgtoCriadoDoDb(codigoLink);
    }

    @Tag("CriacaoLinkPgto")
    @DisplayName("valida se o maximo de parcelas é de 6x")
    @Test
    public void validarParcelasDeSeisVezes() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validaQuantidadeDeParcelasDisponiveis(34, 6);
    }

    @Tag("CriacaoLinkPgto")
    @DisplayName("valida se o maximo de parcelas é de 18x")
    @Test
    public void validarParcelasDezoitoVezes() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validaQuantidadeDeParcelasDisponiveis(90, 18);
    }

    @Tag("CriacaoLinkPgto")
    @DisplayName("valida se o fluxo de de parcela apos editar o valor ")
    @Test
    public void validarEditarValorParcelaMinima() {
        venderTask.clicarBotaoLinkPagamento();
        linkTask.validaEditarValorLinkPgtoMinimoParecela(20, 4, 15, 3);
    }

    @Tag("CriacaoLinkPgto")
    @DisplayName("valida se o fluxo ao editar valor com valor menor do que pode ser parcelado ")
    @Test
    public void validarEditarValorMenorQueParcelaMinima() {
        venderTask.clicarBotaoLinkPagamento();
        linkTask.validaEditarValorLinkPgtoMinimoPulaParcela(20, 4, 6);
    }

}
