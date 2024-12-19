package bergs.Bvr.Bvruaajm.test.pages.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_OnboardingPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_OnboardingPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterBtnAvancarOnboarding() {
        esperas.esperarAte(driver -> body().findElement(By.xpath("//*[@id='btn-avancar']")).estaVisivel(), 2);
        return body().findElement(By.xpath("//*[@id='btn-avancar']"));
    }

    public Bmouaajm_Elemento obterTelaOnboarding() throws Exception {
        esperas.esperarAte(driver -> body().findElement(By.xpath("//*[@id='bvr-onboarding']")).estaVisivel(), 3);
        return body().findElement(By.xpath("//*[@id='bvr-onboarding']"));
    }
    
    public Bmouaajm_Elemento telaOnbordigVeroX() {
        esperas.esperarAte(
                driver -> body().findElement(By.xpath("//div[@class='bvr-pix-onboarding-capa-titulo']/h1[@class='ds-u-title-normal']")).estaVisivel(),
                2);
        return body().findElement(By.xpath("//div[@class='bvr-pix-onboarding-capa-titulo']/h1[@class='ds-u-title-normal']"));
    }

    public Bmouaajm_Elemento btnDoOnbordingVeroX() {
        esperas.esperarAte(driver -> body().findElement(By.id("bvr-pix-onboarding-btn")).estaVisivel(), 2);
        return body().findElement(By.id("bvr-pix-onboarding-btn"));
    }

}
