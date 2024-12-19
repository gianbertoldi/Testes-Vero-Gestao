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

public class Bvruaajm_ValidaDetalhesBloqueioLinkTest extends Bvruaajm_TesteBaseMobile {

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
    String expirado = "Expirado";
    String linkBloqueado = "Link bloqueado";
    String linkDebloqueado = "Link desbloqueado";
    String ativo = "Ativo";
    String pago =  "Pago";
    String linkPAgo =  "Link pago";

    @BeforeEach
    public void preparaTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        venderTask = new Bvruaajm_VenderTask(driver);
        onboardingTask = new Bvruaajm_OnboardingTask(driver);
        nativoTask = new Bvruaajm_ElementoNativoTask(driver);
        consultaLinkTask = new Bvruaajm_ConsultarLinkPgtoTask(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
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
    @DisplayName("Valida Detalhes Link Pgto Bloqueado")
    public void testVerificaDetalhesLinkPgtoBloqueado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataPrimeiroBloq = LocalDateTime.now().minusMinutes(1);
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarBloqueioLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.BLOQUEADO, dataPrimeiroBloq, null, null);
        consultaLinkTask.validaDetalhesLinkPgtoBloqueado(codLink);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Desbloqueio Link Pgto Bloqueado")
    public void testDesbloquearLinkPgtoBloqueado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataPrimeiroBloq = LocalDateTime.now().plusSeconds(5);
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarBloqueioLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.BLOQUEADO, dataPrimeiroBloq, null, null);
        consultaLinkTask.validaDesbloqueioLinkPgto(codLink, 15.75);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Desbloqueio Link Pgto Bloqueado pela segunda vez")
    public void testDesbloquearLinkPgtoBloqueadoPelaSegundaVez() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataPrimeiroBloq = LocalDateTime.now().minusMinutes(1);
        LocalDateTime dataSegundoBloq = LocalDateTime.now().plusMinutes(1);
        LocalDateTime dataDesbloq = LocalDateTime.now();
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarBloqueioLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.BLOQUEADO, dataPrimeiroBloq, dataSegundoBloq, dataDesbloq);
        consultaLinkTask.validaTentativaSegundoDesbloqueio(codLink);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida detalhes link expirado e bloqueado uma vez")
    public void testValidaDetalheLinkExpiradoBloqueado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusMinutes(1441);
        LocalDateTime dataExpirada = LocalDateTime.now().minusMinutes(1);
        LocalDateTime dataPrimeiroBloq = LocalDateTime.now().minusMinutes(20);
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarBloqueioLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.BLOQUEADO, dataPrimeiroBloq, null, null);
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalheBloqueioLink(codLink, 15.75, expirado, linkBloqueado);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida detalhes link expirado, bloqueado e desbloqueado")
    public void testValidaDetalheLinkExpiradoBloqueadoEDesbloq() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusMinutes(1441);
        LocalDateTime dataExpirada = LocalDateTime.now().minusMinutes(1);
        LocalDateTime dataPrimeiroBloq = LocalDateTime.now().minusMinutes(20);
        LocalDateTime dataPrimeiroDesbloq = LocalDateTime.now().minusMinutes(15);
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarBloqueioLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.ATIVO, dataPrimeiroBloq, dataPrimeiroDesbloq, null);
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        consultaLinkTask.validaDetalheBloqueioLink(codLink, 15.75, expirado, linkDebloqueado);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida detalhes link Ativo desbloqueado")
    public void testValidaDetalheLinkAtivoDesbloqueado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusMinutes(120);
        LocalDateTime dataExpirada = LocalDateTime.now().plusMinutes(120);
        LocalDateTime dataPrimeiroBloq = LocalDateTime.now().minusMinutes(20);
        LocalDateTime dataPrimeiroDesbloq = LocalDateTime.now().minusMinutes(15);
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        sqlBvr.atualizarBloqueioLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.ATIVO, dataPrimeiroBloq, dataPrimeiroDesbloq, null);
        consultaLinkTask.validaDetalheBloqueioLink(codLink, 15.75,ativo , linkDebloqueado);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida detalhes link Pago ja desbloqueado")
    public void testValidaDetalheLinkPagoJaDesbloqueado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataPrimeiroBloq = LocalDateTime.now();
        LocalDateTime dataPrimeiroDesbloq = LocalDateTime.now().plusSeconds(5);
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarBloqueioLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.PAGO, dataPrimeiroBloq, dataPrimeiroDesbloq, null);
        sqlBvr.inserirLinkPagoNaTransacao(codLink, "15.75", nomeComprador, dataPrimeiroDesbloq.plusSeconds(5));
        consultaLinkTask.validaDetalheBloqueioLink(codLink, 15.75, pago, linkPAgo);
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida Detalhes Link Pgto no filtro bloqueado")
    public void testVerificaDetalhesLinkPgtoTabBloqueado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataPrimeiroBloq = LocalDateTime.now().minusMinutes(1);
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarBloqueioLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.BLOQUEADO, dataPrimeiroBloq, null, null);
        consultaLinkTask.validaTabLinkPgtoBloqueado(codLink, 4);
    }

    @Tag("DetalhesLinkPgto")
    @Test
    @DisplayName("Valida se ao desbloquear o link ele sai do filtro de bloqueado")
    public void testVerificaDesblqueioLinkPgtoTabBloqueado() {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataPrimeiroBloq = LocalDateTime.now().minusMinutes(1);
        linkTask.criarLinkPagamento(15.75);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarBloqueioLinkPgto(codLink, Bvruaajm_EnumStatusLinkPagamento.BLOQUEADO, dataPrimeiroBloq, null, null);
        consultaLinkTask.validaDebloqueioDoLinkMudancaTabParaTodos(codLink, 4);
    }
}
