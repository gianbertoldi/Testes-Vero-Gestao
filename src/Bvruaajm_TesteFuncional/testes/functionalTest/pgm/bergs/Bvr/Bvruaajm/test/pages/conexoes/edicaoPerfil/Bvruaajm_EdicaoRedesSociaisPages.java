package bergs.Bvr.Bvruaajm.test.pages.conexoes.edicaoPerfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;



public class Bvruaajm_EdicaoRedesSociaisPages extends Bmouaajm_PaginaBase{
    

    public Bvruaajm_EdicaoRedesSociaisPages(AppiumDriver<WebElement> driver) {
        super(driver);
    }
   
    @Override
    public boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterLabelTitulo() {
        return body().procurarElemento(By.xpath("//h2[contains(@class , 'ds-u-title-normal bvr-ds2-margin-bottom-24')][1]"));
    }
    
    public Bmouaajm_Elemento obterCampoEditarInstagram() {
        return body().procurarElemento(By.id("bagEditarInstagram"));
    }
    
    public Bmouaajm_Elemento obterCampoEditarFacebook() {
        return body().procurarElemento(By.id("bagEditarFacebook"));
    }
    
    public Bmouaajm_Elemento obterCampoEditarWhatsapp() {
        return body().procurarElemento(By.id("bagEditarWhatsApp"));
    }
    
    public Bmouaajm_Elemento obterBotaoSalvar(){
        return body().procurarElemento(By.id("bagBtnSalvarRedeSocial"));

    }

}
