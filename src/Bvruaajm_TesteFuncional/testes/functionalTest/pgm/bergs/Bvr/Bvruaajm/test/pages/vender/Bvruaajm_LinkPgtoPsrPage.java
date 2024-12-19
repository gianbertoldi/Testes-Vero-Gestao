package bergs.Bvr.Bvruaajm.test.pages.vender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_LinkPgtoPsrPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_LinkPgtoPsrPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }

    public List<Bmouaajm_Elemento> obterPaginasCarrossel() {
        return body().procurarElementos(By.xpath("//div[contains(@class,'bvr-dots-redondo-onboarding')]/div"));
    }
    
    public Bmouaajm_Elemento obterTextoCardAtualCarrossel() {
        return body().procurarElemento(By.xpath("//div[@class='owl-stage']/div[contains(@class,'active center')]//div[@mm-html='texto']"));
    }
    
    public Bmouaajm_Elemento obterBotaoEuQuero() {
        return body().procurarElemento(By.id("bvr-ve-euquero"));
    }
    
    public Bmouaajm_Elemento obterTitulo() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-pix-onboarding']/h1"));
    }
    
    public Bmouaajm_Elemento obterTextoFaciliteSuasVendas() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-pix-onboarding']/div[contains(@class,'bvr-texto-centrado')]"));
    }
    
    public Bmouaajm_Elemento obterPaginaCarrossel(int page) {
        return body().procurarElemento(By.xpath("//div[@class='owl-stage']/div[" + page + "]"));
    }
    
    public Bmouaajm_Elemento obterCarrosselTotal() {
        return body().procurarElemento(By.cssSelector(".owl-stage"));
    }
}
