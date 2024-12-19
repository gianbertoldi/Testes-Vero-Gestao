package bergs.Bvr.Bvruaajm.test.validations.jornadaComprador;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;

import bergs.Bvr.Bvruaajm.test.pages.jornadaComprador.Bvruaajm_JornadaCompradorDadosCompradorPage;

public class Bvruaajm_JornadaCompradorValidation {

    Bvruaajm_JornadaCompradorDadosCompradorPage jornadaCompradorPage;
    
    public Bvruaajm_JornadaCompradorValidation(ChromeDriver driver) {
        jornadaCompradorPage = new Bvruaajm_JornadaCompradorDadosCompradorPage(driver);
    }
    
    public void validarTextosEsperdoEAtual(String textoEsperado, String textoAtual) {
        Assertions.assertEquals(textoEsperado, textoAtual, "Mensagens estão diferentes.");
    }
    
    public void validarTextosEsperdoEContains(String textoEsperado, String textoAtual) {
        Assertions.assertTrue(textoAtual.contains(textoEsperado), "Mensagens estão diferentes.");
    }
    
    public void validaQuantidadeDeParcelasLinkPgto(int parcelas, int quantidaParcelas) {
        Assertions.assertEquals(parcelas, quantidaParcelas, "Quantidade parcela esta diferente");
    }
}
