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
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_ConsultarLinkPgtoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FakeGenerator;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumStatusLinkPagamento;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;

public class Bvruaajm_ValidaDetalhesLinkPerfilVendedorTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.PerfilVendedor.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.Alberto.obterEstabelecimento();
    Bvruaajm_PerfilVendedorTask vendedorTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_TaskMobile taskMobile;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_ElementoNativoTask nativeTask;
    Bvruaajm_ConsultarLinkPgtoTask consultaLinkTask;
    Bvruaajm_SqlBvr sqlBvr;
    String codLink;
    String nomeComprador = Bvruaajm_FakeGenerator.obterNomeSobrenome();

    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        nativeTask = new Bvruaajm_ElementoNativoTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        vendedorTask = new Bvruaajm_PerfilVendedorTask(driver);
        consultaLinkTask = new Bvruaajm_ConsultarLinkPgtoTask(driver);
        taskMobile = new Bvruaajm_TaskMobile(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        vendedorTask.acessarLinkPgtoPefilVendedor();
    }

    @AfterEach
    public void finalizaTeste() {
        sqlBvr = new Bvruaajm_SqlBvr();
        nativeTask.clicarBotaoEsquerdo();
        sqlBvr.excluirLinkPgtoCriadoDoDb(codLink);
    }

    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Ativo Perfil Vendedor")
    public void testVerificaDetalhesLinkPgtoAtivo() {
        linkTask.criarLinkPagamento(15.44);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        consultaLinkTask.validaDetalhesLinkPgtoAtivo(codLink, 15.44);
    }

    @Tag("SmokeTest")
    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Ativo com descricao Perfil Vendedor")
    public void testVerificaDetalhesLinkPgtoAtivoComDescricao() {
        String txtDescricao = "teste descricao";
        linkTask.criarLinkPagamentoParcelado(20.44, 4, txtDescricao);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        consultaLinkTask.validarDetalhesLinkpgtoAtivoParceladoComDescricao(codLink, 20.44, txtDescricao);
    }

    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Pago Perfil Vendedor")
    public void testVerificaDetalhesLinkPgtoPago() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime data = LocalDateTime.now();
        linkTask.criarLinkPagamento(15.44);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarStatusLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.PAGO);
        sqlBvr.inserirLinkPagoNaTransacao(codLink, "15.44", nomeComprador, data);
        consultaLinkTask.validaDetalhesLinkPgtoPago(codLink, 15.44, nomeComprador, data);
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }

    @Tag("SmokeTest")
    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Bloqueado Perfil Vendedor")
    public void testVerificaDetalhesLinkPgtoBloqueado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        linkTask.criarLinkPagamento(15.44);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarStatusLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.BLOQUEADO);
        consultaLinkTask.validaDetalhesLinkPgtoBloqueado(codLink);
    }

    @Tag("PerfilVendedor")
    @Test
    public void testVerificaDetalhesLinkPgtoCancelado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime data = LocalDateTime.now();
        linkTask.criarLinkPagamento(15.44);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarStatusLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.CANCELADO);
        sqlBvr.inserirLinkPagoNaTransacao(codLink, "15.44", nomeComprador, data);
        sqlBvr.atualizaLinkPgtoNaTransacaoParaCancelado(codLink, "E", data);
        consultaLinkTask.validaDetalhesLinkPgtoCancelado(codLink, 15.44, nomeComprador, data);
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }

    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Expirado de 6 horas Perfil Vendedor")
    public void testVerificaDetalhesLinkPgtoExpiradoSeisHoras() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusMinutes(361);
        LocalDateTime dataExpirada = LocalDateTime.now().minusMinutes(1);
        linkTask.gerarLinkComExpiracaoEditada(78.75, 1);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalhesLinkPgtoExpirado(codLink);
    }

    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Expirado de 12 horas Perfil Vendedor")
    public void testVerificaDetalhesLinkPgtoExpiradoDozeHoras() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusMinutes(721);
        LocalDateTime dataExpirada = LocalDateTime.now().minusMinutes(1);
        linkTask.gerarLinkComExpiracaoEditada(15.44, 2);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalhesLinkPgtoExpirado(codLink);
    }

    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Expirado de 24 horas Perfil Vendedor")
    public void testVerificaDetalhesLinkPgtoExpiradoVinteQuatroHoras() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusMinutes(1441);
        LocalDateTime dataExpirada = LocalDateTime.now().minusMinutes(1);
        linkTask.criarLinkPagamento(15.44);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalhesLinkPgtoExpirado(codLink);
    }

    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Expirado de 3 dias Perfil Vendedor")
    public void testVerificaDetalhesLinkPgtoExpiradoTresDias() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusDays(4);
        LocalDateTime dataExpirada = LocalDateTime.now().minusDays(1);
        linkTask.gerarLinkComExpiracaoEditada(15.44, 4);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalhesLinkPgtoExpirado(codLink);
    }

    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Expirado de 5 dias Perfil Vendedor")
    public void testVerificaDetalhesLinkPgtoExpiradoCincoDias() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusDays(6);
        LocalDateTime dataExpirada = LocalDateTime.now().minusDays(1);
        linkTask.gerarLinkComExpiracaoEditada(15.44, 5);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalhesLinkPgtoExpirado(codLink);
    }

    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Expirado de 7 dias Perfil Vendedor")
    public void testVerificaDetalhesLinkPgtoExpiradoSeteDias() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusDays(8);
        LocalDateTime dataExpirada = LocalDateTime.now().minusDays(1);
        linkTask.gerarLinkComExpiracaoEditada(15.44, 6);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalhesLinkPgtoExpirado(codLink);
    }

    @Tag("PerfilVendedor")
    @Test
    @DisplayName("Valida Desbloqueio Link Pgto Bloqueado Perfil Vendedor")
    public void testDesbloquearLinkPgtoBloqueado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        linkTask.criarLinkPagamento(15.44);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarStatusLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.BLOQUEADO);
        consultaLinkTask.validaDesbloqueioLinkPgto(codLink, 15.44);
    }
}
