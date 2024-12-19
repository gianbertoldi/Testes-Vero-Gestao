package bergs.Bvr.Bvruaajm.test.validations.vender;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_VenderPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_VeroWalletPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_VeroXPage;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_VenderValidation {

    Bvruaajm_VeroWalletPage walletPage;
    Bvruaajm_VenderPage venderPage;
    Bvruaajm_VeroXPage veroXPage;
    private static final String cnpj = "00.110.560/0001-07";
    private static final String txtChavePix = "Chave Pix";

    public Bvruaajm_VenderValidation(AppiumDriver<WebElement> driver) {
        walletPage = new Bvruaajm_VeroWalletPage(driver);
        venderPage = new Bvruaajm_VenderPage(driver);
        veroXPage = new Bvruaajm_VeroXPage(driver);
    }

    public void validarQrCodeVisiel() {
        Assertions.assertTrue(walletPage.obterQrCodeGerado().estaVisivel(), "QrCode deveria estar visivel.");
    }

    public void validarIconesModalVendasHoje() {
        assertAll(
                () -> assertTrue(walletPage.obterIconeFiltrarVendas().estaVisivel(), "Icone Filtrar deveria estar visivel."),
                () -> assertTrue(walletPage.obterIconeReloadVendas().estaVisivel(), "Icone Reload deveria estar visivel."),
                () -> assertTrue(walletPage.obterBarraTotalDia().estaVisivel(), "Barra total dia deveria estar visivel."));
    }

    public void validarTelaVeroX() {
        assertAll(
                () -> assertTrue(veroXPage.obterQrCodeGerado().estaVisivel(), "Botão compartilhar deveria estar visivel"),
                () -> assertTrue(veroXPage.obterBotaoLinkCompartilhar().estaVisivel(), "Botão compartilhar deveria estar visivel"),
                () -> assertTrue(veroXPage.obterBotaoLinkEditarChavePix().estaVisivel(), "Botao saiba mais deveria estar visivel."),
                () -> assertEquals(txtChavePix, veroXPage.obterTipoChaveQrCode().obterTexto(), "Texto deveria estar igual."));
    }

    public void validarTextoChavePixQrCodeAumentado() {
        Assertions.assertEquals(cnpj, veroXPage.obterTextoChavePix().obterTexto(), "Texto deveria estar igual.");
    }

    public boolean validaVisibiladadeDaTelaQrCodeVeroX() {
        try {
            veroXPage.telaJaAderido();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
