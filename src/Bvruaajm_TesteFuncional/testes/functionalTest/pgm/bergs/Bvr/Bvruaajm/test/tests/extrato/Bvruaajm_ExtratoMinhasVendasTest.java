package bergs.Bvr.Bvruaajm.test.tests.extrato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_LinkPagamentoPage;
import bergs.Bvr.Bvruaajm.test.tasks.extrato.Bvruaajm_MenuExtraroTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_HomeTask;
import bergs.Bvr.Bvruaajm.test.tasks.jornadaComprador.Bvruaajm_JornadaCompradorTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_ConsultarLinkPgtoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMisto;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_FakeGenerator;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartoesPgto;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartoesPgto;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ExtratoMinhasVendasTest extends Bvruaajm_TesteBaseMisto {

    Bvruaajm_JornadaCompradorTask compradorTask;
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_CartoesPgto cartao = Bvruaajm_EnumCartoesPgto.CREDITO_MASTERCARD.obterNumeroCartao();
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_HomeTask homeTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_ElementoNativoTask nativoTask;
    Bvruaajm_ConsultarLinkPgtoTask consultaLinkTask;
    Bvruaajm_MenuExtraroTask extratoTask;
    Bvruaajm_SqlBvr sqlBvr;
    String codLink;
    String nomeComprador = Bvruaajm_FakeGenerator.obterNomeSobrenome();
    String valorDaVenda = "16,35";
    String avaliacao = "Muito bom a jornada toda";
    String url;
    String nsu;

    @BeforeEach
    public void iniciaTeste(AppiumDriver<WebElement> mobileDriver, ChromeDriver webDriver) {
        compradorTask = new Bvruaajm_JornadaCompradorTask(webDriver);
        genericTask = new Bvruaajm_GenericTask(mobileDriver);
        homeTask = new Bvruaajm_HomeTask(mobileDriver);
        venderTask = new Bvruaajm_VenderTask(mobileDriver);
        linkTask = new Bvruaajm_LinkPagamentoTask(mobileDriver);
        jsExecutor = new Bvruaajm_JsExecutor(mobileDriver);
        nativoTask = new Bvruaajm_ElementoNativoTask(mobileDriver);
        extratoTask = new Bvruaajm_MenuExtraroTask(mobileDriver);
        consultaLinkTask = new Bvruaajm_ConsultarLinkPgtoTask(mobileDriver);
        Bvruaajm_LinkPagamentoPage linkPage = new Bvruaajm_LinkPagamentoPage(mobileDriver);
        genericTask.definirContextoWebview();
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        linkTask.criarLinkPagamento(16.35);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        url = "https://" + linkPage.obterUrlLinkPgto().obterTexto();
        webDriver.get(url);
        compradorTask.efetuarPgtoLinkCompradorSucesso(cartao, false, avaliacao);
        
    }

    @AfterEach
    public void finalizaTeste() {
        sqlBvr = new Bvruaajm_SqlBvr();
        nativoTask.clicarBotaoEsquerdo();
        sqlBvr.excluirTransacaoLinkPgto(codLink);
        sqlBvr.excluirNotificacaoLinkPgto(codLink);
        sqlBvr.excluirLinkPgtoCriadoDoDb(codLink);
    }
    
    @Test
    @Tag("Extrato")
    @Disabled("Ainda não esta implantado ")
    @DisplayName("Valida lista extrato com venda confirmada")
    public void validaVendaConfirmadaListagemExtrato() {
        LocalDate dataAtaul = LocalDate.now();
        DateTimeFormatter formtado = DateTimeFormatter.ofPattern("ddMMyyyy");
        String data = dataAtaul.format(formtado);
        nsu = consultaLinkTask.acessarDetalhesLinkPgtoPagoEObterNsu(codLink);
        nativoTask.clicarBotaoEsquerdo();       
        nativoTask.clicarBotaoEsquerdo();
        nativoTask.clicarBotaoEsquerdo();
        genericTask.clicarBotaoExtratos();
        extratoTask.validaVendaConfirmaListaExtratoMenuExtrato(data, nsu);
    }
}
