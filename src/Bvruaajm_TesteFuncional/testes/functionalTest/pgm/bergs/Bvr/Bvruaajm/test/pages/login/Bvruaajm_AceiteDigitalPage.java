package bergs.Bvr.Bvruaajm.test.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_AceiteDigitalPage extends Bmouaajm_PaginaBase {


    public Bvruaajm_AceiteDigitalPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterInputPropAdesaoVero() {
        return body().procurarElemento(By.xpath("//label[@for='bvr-ad-checkbox-BDK']"));
    }
    
    public Bmouaajm_Elemento obterInputContatoVero() {
        return body().procurarElemento(By.xpath("//label[@for='bvr-ad-checkbox-1']"));
    }
    
    public Bmouaajm_Elemento obterInputTermoAdesaoCartaoPrePago() {
        return body().procurarElemento(By.xpath("//label[@for='bvr-ad-checkbox-2']"));
    }
    
    public Bmouaajm_Elemento obterBotaoAvancarAceite() {
        return body().procurarElemento(By.id("bvr-ad-btn-avancar"));
    }
    
}
