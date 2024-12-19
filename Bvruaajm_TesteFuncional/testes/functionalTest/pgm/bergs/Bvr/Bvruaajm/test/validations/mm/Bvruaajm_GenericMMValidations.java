package bergs.Bvr.Bvruaajm.test.validations.mm;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;


public class Bvruaajm_GenericMMValidations extends Bmouaajm_PaginaBase {

    public Bvruaajm_GenericMMValidations(RemoteWebDriver driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return false;

    }
    public void validarTextosEsperadoEAtual(String textoEsperado, String textoAtual) {
        Assertions.assertEquals(textoEsperado, textoAtual, "Mensagens estão diferentes.");
    }

    public void validarTotalResultadoDaPesquisa(String textoEsperado, String textoAtual) {
        Assertions.assertEquals("Total de " + textoEsperado + " registros", textoAtual, "Numero de registros inconcistentes");
    }

    public void validarTextosEsperadoEContains(String textoEsperado, String textoAtual) {
        Assertions.assertTrue(textoAtual.contains(textoEsperado), "Mensagens estão diferentes.");
    }
    
    public void validaImagemEstaNaTela(Bmouaajm_Elemento el, String urlImagem) {
        Assertions.assertTrue(el.obterPropriedade("src").toString().contains(urlImagem), "A imagem não esta na tela");
    }
}
