package bergs.Bvr.Bvruaajm.test.tests.vender.linkPgto;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBiq;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.vender.Bvruaajm_LinkPagamentoValidation;

public class Bvruaajm_ValidaAvalicaoLinkPgtoTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.Alberto.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_ElementoNativoTask nativoTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_SqlBiq sqlBiq;
    Bvruaajm_LinkPagamentoValidation linkValidation;
    String codigoLink;
    Bvruaajm_SqlBvr sqlBvr;
    List<String> codLinks;
    String avaliacao = "Teste Avaliação Concluido com Sucesso!";

    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        genericTask.clicarBotaoVender();
        sqlBiq = new Bvruaajm_SqlBiq();
        sqlBiq.deletarLinhaAvaliacaoLinkBIQ(cartaoAcesso);
        jsExecutor.deletarQuantidadeDeLinksCriadosLocalStoragePorCpf(cartaoAcesso);
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
    }

    @AfterEach
    public void finalizarTest() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.excluirTresLinkPgtoCriadoDoDbAvaliacao(codLinks.get(0), codLinks.get(1), codLinks.get(2));
    }

    @Tag("SmokeTest")
    @Tag("LinkPgto")
    @Test
    @DisplayName("Preencher Avaliacao Link Criado com 4 Estrelas")
    public void testValidarAvaliacaoLinkCriadoQuatroEstrela() {
        codLinks = linkTask.gerarAvaliacaoLinkPagamento(15);
        linkTask.efetuarAvaliacaoLinkPelaQuantidadeDeEstrela(4, avaliacao);
    }

    @Tag("LinkPgto")
    @Test
    @DisplayName("Preencher Avaliacao Link Criado com 2 Estrelas")
    public void testValidarAvaliacaoLinkCriadoDuasEstrela() {
        codLinks = linkTask.gerarAvaliacaoLinkPagamento(15);
        linkTask.efetuarAvaliacaoLinkPelaQuantidadeDeEstrela(2, avaliacao);
    }
}
