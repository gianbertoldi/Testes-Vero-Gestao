package bergs.Bvr.Bvruaajm.test.tests.jornadaComprador;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_ConsultarLinkPgtoPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_LinkPagamentoPage;
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

public class Bvruaajm_JoranadaCompradorDesbloqueioLinkTest extends Bvruaajm_TesteBaseMisto {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
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
    String avaliacao = "Muito bom a jornada toda";
    String tituloLinkBloqueadoMobile = "Link de Pagamento bloqueado";
    String descricaoLinkBloqueadoMobile = "Link bloqueado, entre em contato com o vendedor para finalizar o pagamento.";

    @AfterEach
    public void finalizaTeste() {
        sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.excluirTransacaoLinkPgto(codLink);
        sqlBvr.excluirNotificacaoLinkPgto(codLink);
        sqlBvr.excluirLinkPgtoCriadoDoDb(codLink);
    }

    @DisplayName("Teste para abrir um link de pagamento bloqueado, acessar os detalhes no app desbloquear e efetuar o pgto")
    @Test
    public void testeDesbloqueioLinkPgtoJoranadaComprador(AppiumDriver<WebElement> mobileDriver, ChromeDriver webDriver) {
        compradorTask = new Bvruaajm_JornadaCompradorTask(webDriver);
        consultaLinkTask = new Bvruaajm_ConsultarLinkPgtoTask(mobileDriver);
        genericTask = new Bvruaajm_GenericTask(mobileDriver);
        venderTask = new Bvruaajm_VenderTask(mobileDriver);
        linkTask = new Bvruaajm_LinkPagamentoTask(mobileDriver);
        jsExecutor = new Bvruaajm_JsExecutor(mobileDriver);
        Bvruaajm_LinkPagamentoPage linkPage = new Bvruaajm_LinkPagamentoPage(mobileDriver);
        Bvruaajm_ConsultarLinkPgtoPage detalheslinkPage = new Bvruaajm_ConsultarLinkPgtoPage(mobileDriver);
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
        genericTask.clicarBotaoVender();
        venderTask.clicarBotaoLinkPagamento();
        linkTask.criarLinkPagamento(6.55);
        codLink = jsExecutor.obterIdLinkPgtoCriado();
        url = "https://" + linkPage.obterUrlLinkPgto().obterTexto();
        webDriver.get(url);
        compradorTask.efetuarPagamentoCompradorAteBloquear(Bvruaajm_EnumCartoesPgto.ERRO_ELO.obterNumeroCartao(), tituloLinkBloqueadoMobile);
        compradorTask.ValidaTituloEDescricaoErroLinkPgto(tituloLinkBloqueadoMobile, descricaoLinkBloqueadoMobile);
        consultaLinkTask.validaDesbloqueioLinkPgto(codLink, 6.55);
        detalheslinkPage.obterLinkPgtoPorCodigo(codLink).clicar();
        url = "https://" + detalheslinkPage.obterUrlDetalhesLinkAtivo().obterTexto();
        webDriver.get(url);
        compradorTask.efetuarPgtoLinkCompradorSucesso(cartao, false, avaliacao);       
    }
}
