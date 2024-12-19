package bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_SelecaoDeCategoriaPage extends Bmouaajm_PaginaBase{
    
    private Bvruaajm_Esperas esperas;
    
    public Bvruaajm_SelecaoDeCategoriaPage(AppiumDriver<WebElement> driver) {
        super(driver);  
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    public boolean estaPronto() {
        return true;
    }
    
    public WebElement obterCardCategoria(String tipoCategoria) {
        return driver.findElement(By.xpath("//ds-card-selection[@label='"+tipoCategoria+"']"));
    }
    
    public Bmouaajm_Elemento obterLabelTitulo() {
        esperas.visibilidadeDoElemento(By.xpath("(//h1[contains(@class ,'bvr-ds2-margin-bottom-8')])[1]"), 30);
        return body().procurarElemento(By.xpath("(//h1[contains(@class ,'bvr-ds2-margin-bottom-8')])[1]"));
    }
    
    public Bmouaajm_Elemento obterSubTitulo() {
        return body().procurarElemento(By.xpath("//p[contains(@class ,'bvr-ds2-margin-bottom-24')]"));
    }
}               
