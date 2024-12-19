package bergs.Bvr.Bvruaajm.test.validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_GenericValidation {

    Bvruaajm_GenericPage genericPage;

    public Bvruaajm_GenericValidation(AppiumDriver<WebElement> driver) {
        genericPage = new Bvruaajm_GenericPage(driver);
    }

    /**
     * VALIDA SE CPF/CNJP É UM ESTABELECIMENTO
     * 
     * @param cpfCnpj
     * @return
     */
    public boolean selecionarEstabelecimento(String cpfCnpj) {
        try {
            genericPage.obterEstabelecimentoPorCpfOuCnpj(cpfCnpj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * VALIDA SE CPF/CNJP É UM CONVENIADO
     * 
     * @param cpfCnpj
     * @return
     */
    public boolean selecionarConveniado(String cpfCnpj) {
        try {
            genericPage.obterConveniadoPorCpfOuCnpj(cpfCnpj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void validarTextosEsperadoEAtual(String textoEsperado, String textoAtual) {
        Assertions.assertEquals(textoEsperado, textoAtual, "Mensagens estão diferentes.");
    }

    public void validarTextosEsperadoEContains(String textoEsperado, String textoAtual) {
        Assertions.assertTrue(textoAtual.contains(textoEsperado), "Mensagens estão diferentes.");
    }

    public void validaElementoEstaHabilitado(WebElement el) {
        Assertions.assertTrue(el.isEnabled(), "Elemento deveria estar Habilitado");
    }

    public void validaElementoEstaDesabilitado(Bmouaajm_Elemento el) {
        Assertions.assertTrue(el.obterAtributo("Disabled") != null, "Elemento deveria estar Desabilitado");
    }
    
    public void validaValorMenorQueOEsperado(double valor, double valorEsperado) {
        Assertions.assertTrue(valor > valorEsperado);
    }
    
    public void validaValorMaiorQueOEsperado(double valor, double valorEsperado) {
        Assertions.assertTrue(valor < valorEsperado);
    }
    
    public void validaElementoEstaInvisivel(WebElement el) {
        Assertions.assertFalse(el.isDisplayed(), "Elemento deveria estar invisivel");
    }
}
