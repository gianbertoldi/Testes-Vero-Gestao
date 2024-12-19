package bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_DescricaoNegocioPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_DescricaoNegocioPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    public boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterCampoTextoDescricao() {
        return body().procurarElemento(By.id("bagDescNegocio"));
    }
    
    public Bmouaajm_Elemento obterLabelTitulo() {
        return body().procurarElemento(By.xpath("(//h1[contains(@class , 'bvr-ds2-margin-bottom-24')])[1]"));
    }
    
    public WebElement obterBotaoContinuar() {
         return driver.findElement(By.id("bagBtnContinuarDescNegocio"));
    }
       
    public Bmouaajm_Elemento obterBotaoPular() {
         return body().procurarElemento(By.id("bagBtnPularDescNegocio"));
    }
    
}
