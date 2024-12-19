package bergs.Bvr.Bvruaajm.test.validations.perfil;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.perfil.Bvruaajm_TaxasPage;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_TaxasValidations {

    Bvruaajm_TaxasPage taxasPage;
    private static final String msgTaxasMaquininha = "Taxas aplicadas nas vendas via maquininha Vero, Vero Tap, Vero X e Vero Wallet";
    private static final String msgTaxasLink = "Taxas aplicadas nas vendas via Link de Pagamento";
    Bmouaajm_Elemento elementos;

    public Bvruaajm_TaxasValidations(AppiumDriver<WebElement> driver) {
        taxasPage = new Bvruaajm_TaxasPage(driver);
    }

    public void validarTaxasCartoes(int bandeira, String PreDatado, String metodoPgto2) {
        elementos = taxasPage.obterTipoBandeira().get(bandeira - 1);
        assertAll(
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(0).obterTexto().contains(PreDatado),
                        "taxa esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(1).obterTexto().contains(metodoPgto2),
                        "taxa esta incoerente com a esparada"));
    }

    public void validarOpcoesPgto(int bandeira, String taxaDebito, String taxaCreditoVista, String taxaRePay,
            String taxaParceladoMenosSeisVezes, String taxaParceladoMaisSeisVezes, String taxaParceldoCliente) {
        elementos = taxasPage.obterTipoBandeira().get(bandeira - 1);
        assertAll(
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(0).obterTexto().contains(taxaDebito),
                        "taxa esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(1).obterTexto().contains(taxaCreditoVista),
                        "taxa esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(2).obterTexto().contains(taxaRePay),
                        "taxa esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(3).obterTexto().contains(taxaParceladoMenosSeisVezes),
                        "taxa esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(4).obterTexto().contains(taxaParceladoMaisSeisVezes),
                        "taxa esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(5).obterTexto().contains(taxaParceldoCliente),
                        "taxa esta incoerente com a esparada"));
    }

    public void validarOpcoesLinkPgto(int bandeira, String taxaDebito, String taxaCreditoVista,
            String taxaParceladoMenosSeisVezes, String taxaParceladoMaisSeisVezes) {
        elementos = taxasPage.obterTipoBandeira().get(bandeira - 1);
        assertAll(
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(0).obterTexto().contains(taxaDebito),
                        "taxa do Debito esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(1).obterTexto().contains(taxaCreditoVista),
                        "taxa do credito a vista esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(2).obterTexto().contains(taxaParceladoMenosSeisVezes),
                        "taxa do credito parcelado menos de seis esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterLinhaTaxaBandeira(elementos).get(3).obterTexto().contains(taxaParceladoMaisSeisVezes),
                        "taxa credito parcelado mais de seis esta incoerente com a esparada"));
    }

    public void validaTextosMinhasTaxas() {
        Assertions.assertEquals(msgTaxasMaquininha, taxasPage.obterTextoInformativoMinhasTaxas().get(0).obterTexto(), "Mensagens estão diferentes.");
        Assertions.assertEquals(msgTaxasLink, taxasPage.obterTextoInformativoMinhasTaxas().get(1).obterTexto(), "Mensagens estão diferentes.");
    }

    public void validarOpcoesTaxasPsr(String taxaDebito, String taxaPreDatado,
            String taxaParceladoMenosSeisVezes, String taxaParceladoMaisSeisVezes) {
        assertAll(
                () -> assertTrue(taxasPage.obterListaTaxasPsr().get(0).obterTexto().contains(taxaDebito),
                        "taxa do Debito esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterListaTaxasPsr().get(1).obterTexto().contains(taxaPreDatado),
                        "taxa do credito a vista esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterListaTaxasPsr().get(2).obterTexto().contains(taxaParceladoMenosSeisVezes),
                        "taxa do credito parcelado menos de seis esta incoerente com a esparada"),
                () -> assertTrue(taxasPage.obterListaTaxasPsr().get(3).obterTexto().contains(taxaParceladoMaisSeisVezes),
                        "taxa credito parcelado mais de seis esta incoerente com a esparada"));
    }
}