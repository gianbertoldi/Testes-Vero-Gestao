package bergs.Bvr.Bvruaajm.test.tests.vender.linkPgto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_SolicitacaoLinkPgtoPsrTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ValidaPsrLinkPgtoTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.LeopoldinoSilva.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.PsrExterno.obterEstabelecimento();
    Bvruaajm_SolicitacaoLinkPgtoPsrTask linkPsrTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_SqlBvr sqlBvr;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_ElementoNativoTask nativoTask;   
    String codigoLink;

    
    @BeforeEach
    public void iniciaTeste() {
        genericTask = new Bvruaajm_GenericTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        genericTask.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
    }
    
    @AfterEach
    public void finalizarTest() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.deletarLojistaTabelaEstabelecimento(String.valueOf(estab.obterCpfCnpj()));
    }

    @Tag("PSR")
    @Test
    @DisplayName("Efetua ades�o ao link e cai na tela de aguardar 12h libera��o")
    public void testeValidaAdesaoLinkSucessoAguardeAprovacao() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.deletarLojistaTabelaEstabelecimento(String.valueOf(estab.obterCpfCnpj()));
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validaTelaTermoAdesaoQueroAderirLinkPgto();
        linkTask.criarLinkPagamento(25);
        codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        nativoTask.clicarBotaoEsquerdo();
        sqlBvr.excluirLinkPgtoCriadoDoDb(codigoLink);
    }

    @Tag("PSR")
    @Test
    @Disabled("Desabilitado pois bloqueio de pagamento via link pode ser descontinuado")
    @DisplayName("Efetuar solicitacao Ades�o Link com um PSR externo")
    public void validaSolicitacaoAdesaoLinkPsr() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        linkPsrTask.validaSolicitacaoLinkPgtoPsr();
    }

}
