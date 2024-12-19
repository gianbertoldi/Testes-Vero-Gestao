package bergs.Bvr.Bvruaajm.test.tests.vender.linkPgto;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_ConsultarLinkPgtoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ExcluirLinkPagamentoTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_GenericTask genericTask;
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.Pannuvia.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_TaskMobile taskMobile;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_SqlBvr sqlBvr;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_ConsultarLinkPgtoTask consultaLinkTask;
    String statusExpirado = "Expirado";
    String statusativo = "Ativo";

    @BeforeEach
    public void preparaTest() {
        taskMobile = new Bvruaajm_TaskMobile(driver);
        genericTask = new Bvruaajm_GenericTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        consultaLinkTask = new Bvruaajm_ConsultarLinkPgtoTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
    }

    @Tag("SmokeTest")
    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Excluir Link de Pagamento a vista expirado")
    public void testCriarLinkPagamentoAVistaExpirado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusDays(2);
        LocalDateTime dataExpirada = LocalDateTime.now().minusDays(1);
        linkTask.criarLinkPagamento(24.97);
        String codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaExclusaoLinkPgtoExpirado(codLink, statusExpirado);
    }

    @Tag("SmokeTest")
    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Excluir Link de Pagamento a vista ativo")
    public void testCriarLinkPagamentoAVistaAtivo() {
        linkTask.criarLinkPagamento(25.97);
        String codLink = jsExecutor.obterIdLinkPgtoCriado();
        consultaLinkTask.validaExclusaoLinkPgtoAtivo(codLink, statusativo);
    }
}
