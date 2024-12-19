package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.homeOfertas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_OfertasDesativadasExpiradasPage  extends Bmouaajm_PaginaBase{

    public Bvruaajm_OfertasDesativadasExpiradasPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento iconeOfertasDesativadasVazia() {
        return body().procurarElemento(By.id("bag-imagem-home-sem-oferta"));
    }
    
    public Bmouaajm_Elemento labelTituloOfertasDesativadasVazia() {
        return body().procurarElemento(By.xpath("//h1[@mm-html='titulo_formatado']"));
    }
    
    public Bmouaajm_Elemento labelMensagemOfertasDesativadasVazia() {
        return body().procurarElemento(By.xpath("//p[@mm-html='texto_formatado']"));
    }
}
