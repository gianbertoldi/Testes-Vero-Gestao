package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_DescricaoOfertasPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_DescricaoOfertasPage(AppiumDriver<WebElement>driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterLabelTitulo() {
        return body().procurarElemento(By.xpath("(//*[@id='bagTelaNomeDescricao']/p)[1]"));
    }
    
    public Bmouaajm_Elemento obterLabelSubtitulo() {
        return body().procurarElemento(By.xpath("(//*[@id='bagTelaNomeDescricao']/p)[2]"));
    }
    
    public Bmouaajm_Elemento obterCampoTextoNomeOferta() {
        return body().procurarElemento(By.id("bagNomeOferta"));
    }
    
    public Bmouaajm_Elemento obterCampoTextoDescricaoOferta() {
        return body().procurarElemento(By.id("bagDescOferta"));
    }
}
