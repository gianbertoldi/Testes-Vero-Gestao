package bergs.Bvr.Bvruaajm.test.tests.perfilVendedor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;

public class Bvruaajm_CriarLinkPgtoPerfilVendedorTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.PerfilVendedor.obterCartaoAcesso();
    Bvruaajm_ElementoNativoTask nativeTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_SqlBvr sqlBvr;
    String codigoLink;
    String horaExpiracao = "6 horas";

    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        nativeTask = new Bvruaajm_ElementoNativoTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        linkTask.acessarReceberPgtoLinkPefilVendedor();
    }

    @AfterEach
    public void excluirLinkCriado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.excluirLinkPgtoCriadoDoDb(codigoLink);
    }

    @DisplayName("Criar Link á vista no perfil vendedor")
    @Tag("PerfilVendedor")
    @Test
    public void criarLinkPgtoPerfilVendedorCreditoVista() {
        linkTask.criarLinkPagamento(13);
        codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        nativeTask.clicarBotaoEsquerdo();
    }

    @DisplayName("Criar Link parcelado em 5x no perfil vendedor")
    @Tag("SmokeTest")
    @Tag("PerfilVendedor")
    @Test
    public void criarLinkPgtoPerfilVendedorCreditoParcelado() {
        linkTask.criarLinkPagamentoParcelado(130, 5, "parcelado");
        codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        nativeTask.clicarBotaoEsquerdo();
    }

    @DisplayName("Criar Link com expiração de 6h no perfil vendedor")
    @Tag("PerfilVendedor")
    @Test
    public void testeCriarLinkComExpiracaoSeisHoras() {
        linkTask.validarExpiracaoLinkPgtoSeisHoras(15, 1, horaExpiracao);
        codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr = new Bvruaajm_SqlBvr();
        nativeTask.clicarBotaoEsquerdo();
        sqlBvr.excluirLinkPgtoCriadoDoDb(codigoLink);
    }
}
