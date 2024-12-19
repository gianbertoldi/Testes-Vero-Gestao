package bergs.Bvr.Bvruaajm.test.validations.login;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_CriarCartaoVirtualPage;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_LoginlValidations {

    Bvruaajm_GenericPage genericPage;
    Bvruaajm_CriarCartaoVirtualPage criarCartao;

    private static final String FIM_CREDECIAMENTO = "Credenciamento finalizado";
    private static final String MENSAGEM_DA_MODAL = "Agora você vai conhecer todos os recursos que o app Vero oferece ao seu negócio";
    private static final String REENVIAR_CODIGO = "Código reenviado!";
    private static final String CODIGO_ATIVACAO_INVALIDO = "Código de ativação incorreto.";
    
    public Bvruaajm_LoginlValidations(AppiumDriver<WebElement> driver) {
        genericPage = new Bvruaajm_GenericPage(driver);
        criarCartao = new Bvruaajm_CriarCartaoVirtualPage(driver);
    }
    
    public void validarModalCredeciamentoCpf() {
            assertAll (
                    () -> assertEquals(FIM_CREDECIAMENTO,  genericPage.obterTituloMeiaModal().obterTexto(),"Titulo esta incoerente"),
                    () -> assertEquals(MENSAGEM_DA_MODAL, genericPage.obterDescricaoMeiaModal().obterTexto(), "texto esta incoerente")); 
    }
    
    public void validaTextoReenviarCodigo() { 
        Assertions.assertEquals(REENVIAR_CODIGO, criarCartao.obterTituloReenviarCodigoAtivacao().obterTexto(), "Texto incoerente");
    }
    
    public void validaTextoCodigoInvalido () { 
        Assertions.assertEquals(CODIGO_ATIVACAO_INVALIDO, criarCartao.obterTituloReenviarCodigoAtivacao().obterTexto(), "Texto incoerente");
    }
}
