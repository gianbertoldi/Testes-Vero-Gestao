package bergs.Bvr.Bvruaajm.test.validations.vender;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_PerfilVendedorPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_ConsultarLinkPgtoPage;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ConsultaLinkPgtoValidation {

    Bvruaajm_ConsultarLinkPgtoPage consultaLinkPage;
    Bvruaajm_PerfilVendedorPage perfilVendedorPage;
    private static final String TITULO = "Informações do link";
    private static final String ATIVO = "Ativo";
    private static final String COPIAR = "Copiar link";
    private static final String COMPARTILHAR = "Compartilhar link";
    private static final String PAGO = "Pago";
    private static final String MASCARA_FINAL_CARTAO = "•••• 0148";
    private static final String NSU = "9999";
    private static final String AUTORIZADOR = "999999";
    private static final String CANCELADO = "Pagamento cancelado";
    private static final String BLOQUEADO = "Bloqueado";
    private static final String EXPIRADO = "Expirado";
    private static final String NAO_EXCLUIR = "Não, cancelar";
    private static final String EXCLUIR = "Sim, excluir";

    public Bvruaajm_ConsultaLinkPgtoValidation(AppiumDriver<WebElement> driver) {
        consultaLinkPage = new Bvruaajm_ConsultarLinkPgtoPage(driver);
        perfilVendedorPage = new Bvruaajm_PerfilVendedorPage(driver);
    }

    public void validaTelaDetalhesLinkAtivo(String valorFormatado) {
        assertAll(
                () -> assertEquals(TITULO, consultaLinkPage.obterTituloDetalheDoLink().obterTexto(), "Titulos não são iguais."),
                () -> assertEquals(ATIVO, consultaLinkPage.obterStatusDetalheDoLink().obterTexto(),
                        "Status diferente, Status obtido: " + consultaLinkPage.obterStatusDetalheDoLink().obterTexto()),
                () -> assertEquals(valorFormatado, consultaLinkPage.obterValorDetalheDoLink().obterTexto()),
                () -> assertEquals(COPIAR, consultaLinkPage.obterBotaoCopiarLinkDetalheDoLink().obterTexto()),
                () -> assertEquals(COMPARTILHAR, consultaLinkPage.obterBotaoCompartilharLinkDetalheDoLink().obterTexto()),
                () -> assertTrue(consultaLinkPage.obterUrlDetalhesLinkAtivo().estaVisivel(), "URL não esta visivel."));
    }

    public void validaLinkPgtoEstaVisivel(String codigoLink) {
        Assertions.assertTrue(consultaLinkPage.obterLinkPgtoPorCodigo(codigoLink).estaVisivel(),
                "Link Pgto vão esta visivel após clicar chevron voltar.");
    }

    public void validaLinkPgtoNaoEstaVisivel(String codigoLink) {
        Assertions.assertFalse(retornaLinkNaoVisivelDetalhesLink(codigoLink));
    }

    public void validaTelaDetalhesLinkPago(String valorFormatado, String nome, String data) {
        assertAll(
                () -> assertEquals(TITULO, consultaLinkPage.obterTituloDetalheDoLink().obterTexto(), "Titulos não são iguais."),
                () -> assertEquals(PAGO, consultaLinkPage.obterStatusDetalheDoLink().obterTexto(),
                        "Status diferente, Status obtido: " + consultaLinkPage.obterStatusDetalheDoLink().obterTexto()),
                () -> assertEquals(valorFormatado, consultaLinkPage.obterValorDetalheDoLink().obterTexto()),
                () -> assertEquals(nome, consultaLinkPage.obterNomePagadorDetalheLinkPgtoPago().obterTexto()),
                () -> assertEquals(data, consultaLinkPage.obterDataPagamentoDetalheLinkPgto().obterTexto()),
                () -> assertEquals(MASCARA_FINAL_CARTAO, consultaLinkPage.obterNumeroCartaoDetalheLinkPgto().obterTexto()),
                () -> assertEquals(NSU, consultaLinkPage.obterNsuPagamentoDetalheLinkPgto().obterTexto()),
                () -> assertEquals(AUTORIZADOR, consultaLinkPage.obterAutorizadorPagamentoDetalheLinkPgto().obterTexto()));
    }

    public void validaTelaDetalhesLinkExpirado() {
        assertAll(
                () -> assertEquals(TITULO, consultaLinkPage.obterTituloDetalheDoLink().obterTexto(), "Titulos não são iguais."),
                () -> assertEquals(EXPIRADO, consultaLinkPage.obterStatusDetalheDoLink().obterTexto(),
                        "Status diferente, Status obtido: " + consultaLinkPage.obterStatusDetalheDoLink().obterTexto()),
                () -> assertTrue(consultaLinkPage.obterBotaoCriarNovoDetalhesLinkPgto().estaVisivel()));
    }

    public void validaTelaDetalhesLinkBloqueado() {
        assertAll(
                () -> assertEquals(TITULO, consultaLinkPage.obterTituloDetalheDoLink().obterTexto(), "Titulos não são iguais."),
                () -> assertEquals(BLOQUEADO, consultaLinkPage.obterStatusDetalheDoLink().obterTexto(),
                        "Status diferente, Status obtido: " + consultaLinkPage.obterStatusDetalheDoLink().obterTexto()),
                () -> assertTrue(consultaLinkPage.obterCampoSobreLinkBloqueado().estaVisivel(), "Campo descrição link bloqueado não esta visivel"),
                () -> assertTrue(consultaLinkPage.obterCampoSobreLinkBloqueado().obterTexto().contains("Sobre o link bloqueado")));
    }

    public void validaTelaDetalhesLinkCancelado(String valorFormatado, String nome, String data) {
        assertAll(
                () -> assertEquals(TITULO, consultaLinkPage.obterTituloDetalheDoLink().obterTexto(), "Titulos não são iguais."),
                () -> assertEquals(CANCELADO, consultaLinkPage.obterStatusDetalheDoLink().obterTexto(),
                        "Status diferente, Status obtido: " + consultaLinkPage.obterStatusDetalheDoLink().obterTexto()),
                () -> assertEquals(valorFormatado, consultaLinkPage.obterValorDetalheDoLink().obterTexto()),
                () -> assertEquals(nome, consultaLinkPage.obterNomePagadorDetalheLinkPgtoPago().obterTexto()),
                () -> assertEquals(data, consultaLinkPage.obterDataPagamentoDetalheLinkPgto().obterTexto()),
                () -> assertTrue(consultaLinkPage.obterTituloCampoCancelamento().estaVisivel(), "Campo Cancelamento deve estar visivel"),
                () -> assertEquals("Cancelamento", consultaLinkPage.obterTituloCampoCancelamento().obterTexto(), "Titulo esta Diferente"),
                () -> assertEquals(data, consultaLinkPage.obterDataCancelamentoDetalheLinkPgto().obterTexto()));
    }

    public void validaLinkExcluidoNaLista(String codLink) {
        Assertions.assertFalse(validaLinkVisivelNaListaConsultar(codLink));
    }

    public void validaBotoesMeiaModalExclusaoLinkVisivel() {
        assertAll(
                () -> assertEquals(NAO_EXCLUIR, consultaLinkPage.obterBotaoSecundarioMeiaModalNaoCancelar().obterAtributo("label"),
                        "Texto botão diferente"),
                () -> assertEquals(EXCLUIR, consultaLinkPage.obterBotaoPrimarioMeiaModalExcluirLink().obterAtributo("label"),
                        "Texto botão diferente"));
    }

    /**
     * valida se à elementos na tela
     */
    public boolean validaSeEstaNoPerfilVendedor() {
        try {
            perfilVendedorPage.obterTituloPageReceberPagamento();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validaLinkVisivelNaListaConsultar(String codLink) {
        try {
            consultaLinkPage.obterLinkPgtoPorCodigo(codLink);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean retornaLinkNaoVisivelDetalhesLink(String codigoLink) {
        try {
            consultaLinkPage.obterLinkPgtoPorCodigo(codigoLink);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
