package bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_RedesSociaisPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_RedesSociaisPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    public boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterLabelTitulo() {
        return body().procurarElemento(By.xpath("//div[@id='bagRedeSocial']//h1"));
    }
    
    public Bmouaajm_Elemento obterCampoTextoInstagram() {
        return body().procurarElemento(By.id("bagInstagram"));
    }
   
    public Bmouaajm_Elemento obterCampoTextoFacebook() {
        return body().procurarElemento(By.id("bagFacebook"));
    }
    
    public Bmouaajm_Elemento obterCampoTextoWhatsApp() {
        return body().procurarElemento(By.id("bagWhatsApp"));
    }
    
    public WebElement obterBotaoContinuar() {
        return driver.findElement(By.id("bagBtnContinuarRedeSocial"));
   }
      
   public Bmouaajm_Elemento obterBotaoPular() {
        return body().procurarElemento(By.id("bagBtnPularRedeSocial"));
   }
}
