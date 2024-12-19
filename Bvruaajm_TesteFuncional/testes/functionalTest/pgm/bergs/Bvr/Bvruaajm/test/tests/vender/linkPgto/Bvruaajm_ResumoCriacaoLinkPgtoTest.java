package bergs.Bvr.Bvruaajm.test.tests.vender.linkPgto;

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
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ResumoCriacaoLinkPgtoTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.Alberto.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_ElementoNativoTask nativoTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_SqlBvr sqlBvr;
    String horaExpiracao3Dias = "3 dias";
    String descricao = "Teste de descricao";
    String descricaoMudado = "Mudando descricao";


    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        taskMobile.definirContextoWebview();
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
    }

    @AfterEach
    public void finalizaTeste() {
        sqlBvr = new Bvruaajm_SqlBvr();
        String codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        nativoTask.clicarBotaoEsquerdo();
        sqlBvr.excluirLinkPgtoCriadoDoDb(codigoLink);
    }

    @Tag("CriacaoLinkPgto")
    @Test
    @DisplayName("Criar Link de Pagamento a vista e editar o valor na tela resumo")
    public void testCriarLinkPagamentoEEditarValorNaTelaResumo() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validarEditarValorTelaResumoSemSalvar(15, 0);
    }

    @Tag("CriacaoLinkPgto")
    @Test
    @DisplayName("Teste que cria um link de pagamento a vista, e na tela resumo edita para parcelado")
    public void testCriarLinkPagamentoEEditarFormaPgtoTelaResumo() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validarEditarFormaPagamento(20, 4);
    }
    
    @Tag("CriacaoLinkPgto")
    @Test
    @DisplayName("Teste que cria um link de pagamento a vista com descricao")
    public void testCriarLinkComDescricao() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validarDefinirDescricaoLinkPgto(20, descricao);
    }

    @Tag("CriacaoLinkPgto")
    @Test
    @DisplayName("Teste faz edicao da descricao do link de pagamento")
    public void testeEdicaoDescricaoLink() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validarEditarDescricaoLink(20, descricao, descricaoMudado);
    }

    @Tag("CriacaoLinkPgto")
    @Test
    @DisplayName("Teste faz edicao da data de expiração do link de pagamento")
    public void testeEdicaoDataExpiracao() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validarEditarDataExpiracao(20, 1, horaExpiracao3Dias);
    }
}
