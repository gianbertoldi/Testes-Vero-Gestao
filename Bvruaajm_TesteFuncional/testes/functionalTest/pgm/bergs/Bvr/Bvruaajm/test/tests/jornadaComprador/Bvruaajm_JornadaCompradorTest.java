package bergs.Bvr.Bvruaajm.test.tests.jornadaComprador;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.jornadaComprador.Bvruaajm_JornadaCompradorTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_LinkPagamentoTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_VenderTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMisto;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartoesPgto;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartoesPgto;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_JornadaCompradorTest extends Bvruaajm_TesteBaseMisto {
    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_CartoesPgto cartao = Bvruaajm_EnumCartoesPgto.CREDITO_MASTERCARD.obterNumeroCartao();
    Bvruaajm_JornadaCompradorTask compradorTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_SqlBvr sqlBvr;
    String codLink;
    String url;
    String avaliacao = "Muito bom a jornada toda";
    String tituloLinkBloqueado = "Link de Pagamento bloqueado";
    String tituloLinkExpirado = "Link de Pagamento expirado";
    String descriLinkExpirado = "Entre em contato com o vendedor e solicite um novo link para efetuar o pagamento.";
    String tituloLinkPago = "Link de Pagamento já utilizado";
    String descriLinkPago = "Um comprovante foi enviado para o email informado durante a transação. Para realizar uma nova compra entre em contato com o vendedor.";

    @BeforeEach
    public void iniciarTesteIbridos(AppiumDriver<WebElement> mobileDriver) {
        genericTask = new Bvruaajm_GenericTask(mobileDriver);
        venderTask = new Bvruaajm_VenderTask(mobileDriver);
        linkTask = new Bvruaajm_LinkPagamentoTask(mobileDriver);
        jsExecutor = new Bvruaajm_JsExecutor(mobileDriver);
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        url = "https://" + linkTask.criarLinkPagamento(6);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
    }

    @AfterEach
    public void finalizaTeste() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.excluirNotificacaoLinkPgto(codLink);
        sqlBvr.excluirLinkPgtoCriadoDoDb(codLink);
    }

    @Tag("JornadaComprador")
    @DisplayName("Teste para abrir a jornada do comprador e efetuar o pagamento de sucesso do link")
    @Test
    public void testeCriarLinkAbrindoJornadaComprador(ChromeDriver webDriver) {
        sqlBvr = new Bvruaajm_SqlBvr();
        compradorTask = new Bvruaajm_JornadaCompradorTask(webDriver);
        webDriver.get(url);

        compradorTask.efetuarPgtoLinkCompradorSucesso(cartao, false, avaliacao);
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }

    @Tag("JornadaComprador")
    @DisplayName("Teste para abrir a jornada do comprador e efetuar o pagamento recusado do link")
    @Test
    public void testeCriarLinkEFalharComMasterCard(ChromeDriver webDriver) {
        sqlBvr = new Bvruaajm_SqlBvr();
        compradorTask = new Bvruaajm_JornadaCompradorTask(webDriver);
        webDriver.get(url);
        compradorTask.efetuarPgtoLinkCompradorFalha(Bvruaajm_EnumCartoesPgto.ERRO_ELO.obterNumeroCartao());
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }

    @Tag("JornadaComprador")
    @DisplayName("Teste para abrir a jornada do comprador e efetuar tres pagamento recusados do link para bloquear")
    @Test
    public void testeFazerPgtoComFalhaAteBloquear(ChromeDriver webDriver) {
        sqlBvr = new Bvruaajm_SqlBvr();
        compradorTask = new Bvruaajm_JornadaCompradorTask(webDriver);
        webDriver.get(url);
        compradorTask.efetuarPagamentoCompradorAteBloquear(Bvruaajm_EnumCartoesPgto.ERRO_ELO.obterNumeroCartao(), tituloLinkBloqueado);
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }

    @Tag("JornadaComprador")
    @DisplayName("Teste para validar link expirado jornada comprador")
    @Test
    public void testeValidaInformacaoLinkExpirado(ChromeDriver webDriver) {
        sqlBvr = new Bvruaajm_SqlBvr();
        LocalDateTime dataCriacao = LocalDateTime.now().minusMinutes(1441);
        LocalDateTime dataExpirada = LocalDateTime.now().minusMinutes(1);
        sqlBvr.atualizarDataCadastroLinkPgto(codLink, dataCriacao, dataExpirada);
        compradorTask = new Bvruaajm_JornadaCompradorTask(webDriver);
        webDriver.get(url);
        compradorTask.ValidaTituloEDescricaoErroLinkPgto(tituloLinkExpirado, descriLinkExpirado);
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }

    @Tag("JornadaComprador")
    @DisplayName("Teste para validar link pago jornada comprador")
    @Test
    public void testeValidaInformacaoLinkPago(ChromeDriver webDriver) {
        sqlBvr = new Bvruaajm_SqlBvr();
        compradorTask = new Bvruaajm_JornadaCompradorTask(webDriver);
        webDriver.get(url);
        compradorTask.efetuarPgtoLinkCompradorSucesso(cartao, false, avaliacao);
        webDriver.get(url);
        compradorTask.ValidaTituloEDescricaoErroLinkPgto(tituloLinkPago, descriLinkPago);
        sqlBvr.excluirTransacaoLinkPgto(codLink);
    }
}
