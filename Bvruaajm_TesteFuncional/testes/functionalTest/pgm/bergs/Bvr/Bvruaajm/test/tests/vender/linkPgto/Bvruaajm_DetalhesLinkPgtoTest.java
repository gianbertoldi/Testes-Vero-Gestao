package bergs.Bvr.Bvruaajm.test.tests.vender.linkPgto;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_OnboardingTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_ConsultarLinkPgtoTask;
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

public class Bvruaajm_DetalhesLinkPgtoTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.Alberto.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_OnboardingTask onboardingTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_ElementoNativoTask nativoTask;
    Bvruaajm_ConsultarLinkPgtoTask consultaLinkTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_SqlBvr sqlBvr;
    String codLink;
    String nomeComprador = Bvruaajm_FakeGenerator.obterNomeSobrenome();
    String txtDescricao = "teste descricao";
    String InfoCancelamentoDesabilitado = "No momento não é possível cancelar esta venda por aqui. Você pode efetuar o cancelamento pelo menu \"serviços\" ou entrar em contato com a Vero para mais informações.";
    String tituloContatoVero = "Como você prefere conversar com a Vero?";

    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        consultaLinkTask = new Bvruaajm_ConsultarLinkPgtoTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        onboardingTask.verificaPularOnboardingGeneric();
    }

    @AfterEach
    public void finalizaTeste() {
        sqlBvr = new Bvruaajm_SqlBvr();
        nativoTask.clicarBotaoEsquerdo();
        sqlBvr.excluirLinkPgtoCriadoDoDb(codLink);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Ativo")
    public void testVerificaDetalhesLinkPgtoAtivo() {
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        consultaLinkTask.validaDetalhesLinkPgtoAtivo(codLink, 15.75);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Ativo com descricao")
    public void testVerificaDetalhesLinkPgtoAtivoComDescricao() {
        linkTask.criarLinkPagamentoParcelado(20.75, 4, txtDescricao);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        consultaLinkTask.validarDetalhesLinkpgtoAtivoParceladoComDescricao(codLink, 20.75, txtDescricao);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Pago")
    public void testVerificaDetalhesLinkPgtoPago() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime data = LocalDateTime.now();
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarStatusLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.PAGO);
        sqlBvr.inserirLinkPagoNaTransacao(codLink, "15.75", nomeComprador, data);
        consultaLinkTask.validaDetalhesLinkPgtoPago(codLink, 15.75, nomeComprador, data);
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Cancelado")
    public void testVerificaDetalhesLinkPgtoCancelado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime data = LocalDateTime.now();
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarStatusLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.CANCELADO);
        sqlBvr.inserirLinkPagoNaTransacao(codLink, "15.75", nomeComprador, data);
        sqlBvr.atualizaLinkPgtoNaTransacaoParaCancelado(codLink, "E", data);
        consultaLinkTask.validaDetalhesLinkPgtoCancelado(codLink, 15.75, nomeComprador, data);
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Expirado de 6 horas")
    public void testVerificaDetalhesLinkPgtoExpiradoSeisHoras() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusMinutes(361);
        LocalDateTime dataExpirada = LocalDateTime.now().minusMinutes(1);
        int expiraEm6Horas = 1;
        linkTask.gerarLinkComExpiracaoEditada(15.75, expiraEm6Horas);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalhesLinkPgtoExpirado(codLink);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Expirado de 24 horas")
    public void testVerificaDetalhesLinkPgtoExpiradoVinteQuatroHoras() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusMinutes(1441);
        LocalDateTime dataExpirada = LocalDateTime.now().minusMinutes(1);
        int expiraEm24Horas = 3;
        linkTask.gerarLinkComExpiracaoEditada(15.75, expiraEm24Horas);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalhesLinkPgtoExpirado(codLink);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Detalhes Link Pgto Expirado de 3 dias")
    public void testVerificaDetalhesLinkPgtoExpiradoTresDias() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusDays(4);
        LocalDateTime dataExpirada = LocalDateTime.now().minusDays(1);
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalhesLinkPgtoExpirado(codLink);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Detalhes Link Pgto se o cancelamento esta desabilidato apos passar 30 dias")
    public void testVerificaCancelamentoLinkDesabilitadosAposNoventaDias() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime data = LocalDateTime.now().minusDays(91);
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarStatusLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.PAGO);
        sqlBvr.inserirLinkPagoNaTransacao(codLink, "15.75", nomeComprador, data);
        consultaLinkTask.validaDetalhesLinkPgtoCancelamentoMaisDeUmDia(codLink, 15.75, nomeComprador, data);
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }

}
