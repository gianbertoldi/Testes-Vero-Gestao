package bergs.Bvr.Bvruaajm.test.tests.perfilVendedor;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.perfilVendedor.Bvruaajm_PerfilVendedorTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FakeGenerator;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumStatusLinkPagamento;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ConsutarVendaPerfilVendedorTest extends Bvruaajm_TesteBaseMobile {


    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.PerfilVendedor.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_ElementoNativoTask nativeTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_PerfilVendedorTask vendedorTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_SqlBvr sqlBvr;
    String codigoLink;
    String nomeComprador = Bvruaajm_FakeGenerator.obterNomeSobrenome();
    LocalDateTime data = LocalDateTime.now();
    String confirmado = "Confirmada";
    String cancelada = "Cancelada";

    @BeforeEach
    public void iniciarTest() {
        genericTask = new Bvruaajm_GenericTask(driver);
        nativeTask = new Bvruaajm_ElementoNativoTask(driver);
        linkTask = new Bvruaajm_LinkPagamentoTask(driver);
        vendedorTask = new Bvruaajm_PerfilVendedorTask(driver);
        taskMobile.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        sqlBvr = new Bvruaajm_SqlBvr();
        linkTask.acessarReceberPgtoLinkPefilVendedor();
        linkTask.criarLinkPagamento(13);
        codigoLink = jsExecutor.obterIdLinkPgtoCriado();
        sqlBvr.atualizarStatusLinkPgto(codigoLink, Bvruaajm_EnumStatusLinkPagamento.PAGO);
        sqlBvr.inserirLinkPagoNaTransacao(codigoLink, "13.00", nomeComprador, data);
        nativeTask.clicarBotaoEsquerdo();
        nativeTask.clicarBotaoEsquerdo();
    }
    
    @AfterEach
    public void finalizarTest() {
        sqlBvr = new Bvruaajm_SqlBvr();
        nativeTask.clicarBotaoEsquerdo();
        sqlBvr.excluirTransacaoLinkPgto(codigoLink);
        sqlBvr.excluirLinkPgtoCriadoDoDb(codigoLink);
    }
    
    @Tag("PerfilVendedor")
    @Disabled("teste não esta na lista de implantação")
    @Test
    @DisplayName("Verifica o resultado pesquisa chave resultado")
    public void validaResultadoConsutarPorPalavraChave() {
        vendedorTask.validaResultadoPesquiisaConsultarVenda(Bvruaajm_Formatador.formatarNomeAbreviar(nomeComprador));
    }
    
    @Tag("PerfilVendedor")
    @Disabled("teste não esta na lista de implantação")
    @Test
    @DisplayName("Verifica o resultado pesquisa chave sem resultado")
    public void validaConsultaPalavraChaveSemResultado() {    
        vendedorTask.validaFiltroPesquisaSemResultados(nomeComprador);
    }
    
    @Tag("PerfilVendedor")
    @Disabled("teste não esta na lista de implantação")
    @Test
    @DisplayName("Verifica Consulta de Vendas Detalhes Venda Confirmada Link Pgto")
    public void validaConsultaDetalhesVendaConfirmadaLinkPgto() {  
        vendedorTask.clicarBotaoConsultarVendasPerfilVendedor();
        vendedorTask.validaDetalhamentoDeVenda(Bvruaajm_Formatador.formatarNomeAbreviar(nomeComprador), confirmado);
    }
    
    @Tag("PerfilVendedor")
    @Disabled("teste não esta na lista de implantação")
    @Test
    @DisplayName("Verifica Consulta de Vendas Detalhes Venda Cancelado Link Pgto")
    public void validaConsultaDetalhesVendaCanceladaLinkPgto() {    
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.atualizarStatusLinkPgto(codigoLink, Bvruaajm_EnumStatusLinkPagamento.CANCELADO);
        sqlBvr.atualizaLinkPgtoNaTransacaoParaCancelado(codigoLink, "E", data);
        vendedorTask.clicarBotaoConsultarVendasPerfilVendedor();
        vendedorTask.validaDetalhamentoDeVenda(Bvruaajm_Formatador.formatarNomeAbreviar(nomeComprador), cancelada);
    }
    
    @Tag("PerfilVendedor")
    @Disabled("teste não esta na lista de implantação")
    @Test
    @DisplayName("Verifica Consulta de Vendas Detalhes Venda Confirmada Link Pgto clicando em atualizar")
    public void validaConsultaDetalhesVendaConfirmadaLinkPgtoClicarAtualizar() {
        sqlBvr = new Bvruaajm_SqlBvr();
        linkTask.acessarReceberPgtoLinkPefilVendedor();
        linkTask.criarLinkPagamento(14);
        String codigoLink2 = jsExecutor.obterIdLinkPgtoCriado();
        nativeTask.clicarBotaoEsquerdo();
        nativeTask.clicarBotaoEsquerdo();
        vendedorTask.clicarBotaoConsultarVendasPerfilVendedor();
        nomeComprador = Bvruaajm_FakeGenerator.obterNomeSobrenome();
        sqlBvr.atualizarStatusLinkPgto(codigoLink2, Bvruaajm_EnumStatusLinkPagamento.PAGO);
        sqlBvr.inserirLinkPagoNaTransacao(codigoLink2, "14.00", nomeComprador, data);
        vendedorTask.validaAtualizarListaVendasHoje(Bvruaajm_Formatador.formatarNomeAbreviar(nomeComprador), confirmado);
        
        sqlBvr.excluirTransacaoLinkPgto(codigoLink2);
        sqlBvr.excluirLinkPgtoCriadoDoDb(codigoLink2);
    }
    
}
