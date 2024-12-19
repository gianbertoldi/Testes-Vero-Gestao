package bergs.Bvr.Bvruaajm.test.tests.perfilVendedor;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.perfilVendedor.Bvruaajm_PerfilVendedorTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FakeGenerator;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumStatusLinkPagamento;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ValidarLinkPgtoOutroUserPerfilVendedorTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.PerfilVendedor.obterCartaoAcesso();
    Bvruaajm_CartaoAcesso cartaoAcesso2 = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.Alberto.obterEstabelecimento();
    Bvruaajm_PerfilVendedorTask vendedorTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_ElementoNativoTask nativeTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_SqlBvr sqlBvr;
    String codigoLink;
    String nomeComprador = Bvruaajm_FakeGenerator.obterNomeSobrenome();

    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        nativeTask = new Bvruaajm_ElementoNativoTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        vendedorTask = new Bvruaajm_PerfilVendedorTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso2);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        linkTask.criarLinkPagamento(15.47);
        codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        this.driver.closeApp();
        this.driver.launchApp();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
    }

    @AfterEach
    public void excluirLinkCriado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.excluirLinkPgtoCriadoDoDb(codigoLink);
    }

    @Tag("PerfilVendedor")
    @DisplayName("Valida Link Criado Perfil ADM no Vendedor link ativo")
    @Test
    public void validaLinkCriadoAtivoOutroUserNoPerfilVendedor() {
        vendedorTask.acessarLinkPgtoPefilVendedor();
        vendedorTask.validarConsultaLinkCriadoOutroUserNoPerfilVendedor(codigoLink);
        nativeTask.clicarBotaoEsquerdo();
    }

    @Tag("PerfilVendedor")
    @DisplayName("Valida Link Criado Perfil ADM no Vendedor link bloqueado")
    @Test
    public void validaLinkCriadoBloqueadoOutroUserNoPerfilVendedor() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.atualizarStatusLinkPgto(codigoLink, Bvruaajm_EnumStatusLinkPagamento.BLOQUEADO);
        vendedorTask.acessarLinkPgtoPefilVendedor();
        vendedorTask.validarConsultaLinkCriadoOutroUserNoPerfilVendedor(codigoLink);
        nativeTask.clicarBotaoEsquerdo();
    }

    @Tag("PerfilVendedor")
    @DisplayName("Valida Link Criado Perfil ADM no Vendedor link expirado")
    @Test
    public void validaLinkCriadoExpiradoOutroUserNoPerfilVendedor() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusMinutes(1441);
        LocalDateTime dataExpirada = LocalDateTime.now().minusMinutes(1);
        sqlBvr.atualizarDataCadastroLinkPgto(codigoLink, dataCriacao, dataExpirada);
        vendedorTask.acessarLinkPgtoPefilVendedor();
        vendedorTask.validarConsultaLinkCriadoOutroUserNoPerfilVendedor(codigoLink);
        nativeTask.clicarBotaoEsquerdo();
    }

    @Tag("SmokeTest")
    @Tag("PerfilVendedor")
    @DisplayName("Valida Link Criado Perfil ADM no Vendedor link pago")
    @Test
    public void validaLinkCriadoPagoOutroUserNoPerfilVendedor() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime data = LocalDateTime.now();
        sqlBvr.atualizarStatusLinkPgto(codigoLink, Bvruaajm_EnumStatusLinkPagamento.PAGO);
        sqlBvr.inserirLinkPagoNaTransacao(codigoLink, "7.75", nomeComprador, data);
        vendedorTask.acessarLinkPgtoPefilVendedor();
        vendedorTask.validarConsultaLinkCriadoOutroUserNoPerfilVendedor(codigoLink);
        nativeTask.clicarBotaoEsquerdo();
        sqlBvr.excluirTransacaoLinkPgto(codigoLink);
    }

    @Tag("PerfilVendedor")
    @DisplayName("Valida Link Criado Perfil ADM no Vendedor link cancelado")
    @Test
    public void validaLinkCriadoCanceladoOutroUserNoPerfilVendedor() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime data = LocalDateTime.now();
        sqlBvr.atualizarStatusLinkPgto(codigoLink, Bvruaajm_EnumStatusLinkPagamento.PAGO);
        sqlBvr.inserirLinkPagoNaTransacao(codigoLink, "7.75", nomeComprador, data);
        sqlBvr.atualizaLinkPgtoNaTransacaoParaCancelado(codigoLink, "E", data);
        vendedorTask.acessarLinkPgtoPefilVendedor();
        vendedorTask.validarConsultaLinkCriadoOutroUserNoPerfilVendedor(codigoLink);
        nativeTask.clicarBotaoEsquerdo();
        sqlBvr.excluirTransacaoLinkPgto(codigoLink);
    }
}
