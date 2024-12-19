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
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.validations.vender.Bvruaajm_LinkPagamentoValidation;

public class Bvruaajm_CriarLinkPagamentoTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.Alberto.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_ElementoNativoTask nativoTask;   
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_LinkPagamentoValidation linkValidation;
    String codigoLink;
    Bvruaajm_SqlBvr sqlBvr;
    String txtInfo = "O pagamento via d�bito estar� dispon�vel em todas as formas de recebimento";
    String txtModal = "Em todas as formas de recebimento, caso seja utilizado um cart�o de d�bito ou um cart�o m�ltiplo "
            + "(que oferece a op��o d�bito e cr�dito), o comprador poder� efetuar o pagamento tamb�m via d�bito.";
    String descricao = "Descricao";

    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();

    }
    
    @AfterEach
    public void finalizarTest() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.excluirLinkPgtoCriadoDoDb(codigoLink);
    }

    @Tag("SmokeTest")
    @Test
    @DisplayName("Criar Link de Pagamento a vista")
    public void testCriarLinkPagamentoAVista() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.criarLinkPagamento(30);
        codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        nativoTask.clicarBotaoEsquerdo();
    }

    @Tag("SmokeTest")
    @Tag("CriacaoLinkPgto")
    @Test
    @DisplayName("Teste que cria um link de pagamento credito parcelado")
    public void testCriarLinkComPagamentoParcelado() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.criarLinkPagamentoParcelado(50, 6, descricao);
        codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        nativoTask.clicarBotaoEsquerdo();
    }

    @Tag("CriacaoLinkPgto")
    @Disabled("Fluxo do test ainda n�o implantado no MR")
    @Test
    @DisplayName("Teste que valida as informa��es de recebimento a vista e parcelado")
    public void testeValidaInfoRecebimentoAVistaParcelado() {
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
        linkTask.validaInfoRecebimentoAVistaParcelado(26, txtInfo, txtModal);
    }
}
