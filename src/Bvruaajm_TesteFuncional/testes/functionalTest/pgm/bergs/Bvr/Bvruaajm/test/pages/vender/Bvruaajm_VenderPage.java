package bergs.Bvr.Bvruaajm.test.pages.vender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_VenderPage extends Bmouaajm_PaginaBase{
    
    public Bvruaajm_VenderPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        if(obterBotaoLinkPagamento().estaVisivel() || obterBotaoVeroX().estaVisivel() || obterBotaoVeroWallet().estaVisivel()) {
            return true;
        }
        return false;
    }
    
    public Bmouaajm_Elemento obterBotaoLinkPagamento() {
        return body().procurarElemento(By.id("bvr-ve-li-link-pgto"));
    }
    
    public Bmouaajm_Elemento obterBotaoVeroX() {
        return body().procurarElemento(By.id("bvr-ve-li-verox"));
    }

    public Bmouaajm_Elemento obterBotaoVeroWallet() {
        return body().procurarElemento(By.id("bvr-ve-li-vero-wallet"));
    }
    
    public Bmouaajm_Elemento obterTituloPagina() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-ve-vender']/h2"));
    }
}
