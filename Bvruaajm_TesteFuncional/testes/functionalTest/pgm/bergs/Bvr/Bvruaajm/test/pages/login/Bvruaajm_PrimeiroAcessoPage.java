package bergs.Bvr.Bvruaajm.test.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PrimeiroAcessoPage extends Bmouaajm_PaginaBase{

    Bvruaajm_Esperas esperas;

    public Bvruaajm_PrimeiroAcessoPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return obterDivPrimeiroAcesso().estaVisivel();
    }
    
    public Bmouaajm_Elemento obterDivPrimeiroAcesso() {
        return body().procurarElemento(By.id("divSemCartoes"));
    }
    
    public Bmouaajm_Elemento obterBotaoPrimeiroAcesso() {
        esperas.visibilidadeDoElemento(By.id("btnPrimeiroAcesso"), 30);
        return body().findElement(By.id("btnPrimeiroAcesso"));
    }

}
