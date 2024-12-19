package bergs.Bvr.Bvruaajm.test.validations.conexoes;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_OnboardingConexoesPage;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_OnboardingValidation {

    private Bvruaajm_OnboardingConexoesPage onboardingPage;
    
    public Bvruaajm_OnboardingValidation(AppiumDriver<WebElement> driver){
        onboardingPage = new Bvruaajm_OnboardingConexoesPage(driver);
    }
    
    public void validaOnboarding(int indice, String titulo, String texto) {
        
        assertAll(
                () -> assertTrue(onboardingPage.obterImagem(indice).estaVisivel()),
                () -> assertEquals(titulo, onboardingPage.obterTitulo(indice).obterTexto()),
                () -> assertEquals(texto, onboardingPage.obterMensagemTexto(indice).obterTexto())
                );
    }
}
