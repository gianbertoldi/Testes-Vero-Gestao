package bergs.Bvr.Bvruaajm.test.tests.jornadaComprador;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.jornadaComprador.Bvruaajm_JornadaCompradorTask;
import bergs.Bvr.Bvruaajm.test.tasks.vender.Bvruaajm_ConsultarLinkPgtoTask;
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

public class Bvruaajm_JornadaCompradorTelaDePgtoTest extends Bvruaajm_TesteBaseMisto {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.Alberto.obterEstabelecimento();
    Bvruaajm_CartoesPgto cartao = Bvruaajm_EnumCartoesPgto.CREDITO_MASTERCARD.obterNumeroCartao();
    Bvruaajm_JornadaCompradorTask compradorTask;
    Bvruaajm_GenericTask genericTask;
    Bvruaajm_VenderTask venderTask;
    Bvruaajm_LinkPagamentoTask linkTask;
    Bvruaajm_ConsultarLinkPgtoTask consultaLinkTask;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_SqlBvr sqlBvr;
    String codLink;
    String url;
    int parcelas = 3;

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
        url = "https://" + linkTask.criarLinkPagamentoParcelado(15.30, parcelas, "parcelas");
        codLink = jsExecutor.obterIdLinkPgtoCriado();
    }

    @AfterEach
    public void finalizaTeste() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.excluirTransacaoLinkPgto(codLink);
        sqlBvr.excluirNotificacaoLinkPgto(codLink);
        sqlBvr.excluirLinkPgtoCriadoDoDb(codLink);
    }

    @Tag("JornadaComprador")
    @DisplayName("Teste para abrir a jornada do comprador Validar a quantidade parcela default na tela dados de pgto")
    @Test
    public void testeParcelasPreDefinidasTelaDadosDoCartao(ChromeDriver webDriver) {
        compradorTask = new Bvruaajm_JornadaCompradorTask(webDriver);
        webDriver.get(url);
        compradorTask.validarParcelasPreDefinidasNaTelaDadosPgto(cartao, parcelas);
    }
}
