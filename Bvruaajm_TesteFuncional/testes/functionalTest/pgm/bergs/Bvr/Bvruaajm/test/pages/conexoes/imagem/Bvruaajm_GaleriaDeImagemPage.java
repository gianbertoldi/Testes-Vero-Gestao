package bergs.Bvr.Bvruaajm.test.pages.conexoes.imagem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaMobile;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_GaleriaDeImagemPage  extends Bmouaajm_PaginaMobile{ 
    
    private Bvruaajm_Esperas esperas;
    
    public Bvruaajm_GaleriaDeImagemPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() { 
        return  obterFundoGaleria().isDisplayed();
    }
    
    public WebElement obterFundoGaleria() { 
        return esperas.visibilidadeDoElemento(By.id("dir_list"));
    }
    
    public WebElement obterImagem(String nomeDaImagem) {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@content-desc , '"+nomeDaImagem+"')]"));
    }
}
