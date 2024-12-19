package bergs.Bvr.Bvruaajm.test.validations.login;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.login.Bvruaajm_ListarCartoesPage;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ListaCartoesAdicionadosValitadion {

    Bvruaajm_ListarCartoesPage listaCartao;
    Bvruaajm_Esperas esperar;

    public Bvruaajm_ListaCartoesAdicionadosValitadion(AppiumDriver<WebElement> driver) {
        esperar = new Bvruaajm_Esperas(driver);
        listaCartao = new Bvruaajm_ListarCartoesPage(driver);
    }

    public boolean listaCartoesEstaVisivel() {
        try {
            return listaCartao.obterDivCartao().estaVisivel();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void validaSeOCartaoFoiAdd() {
        Assertions.assertFalse(listaCartoesEstaVisivel());
    }

    public boolean cartaoEstaVisivel(Bvruaajm_CartaoAcesso cartaoAcesso) {
        try {
            esperar.esperarAte(driver -> listaCartao.obterCartao(cartaoAcesso).isDisplayed(), 10);
            listaCartao.obterCartao(cartaoAcesso);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
