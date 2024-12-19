package bergs.Bvr.Bvruaajm.test.pages.conexoes.edicaoPerfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_EdicaoCategoriaDoPerfilPage extends Bmouaajm_PaginaBase{
    
    public Bvruaajm_EdicaoCategoriaDoPerfilPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
   
    @Override
    public boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterCardCategoria(String tipoCategoria) {
        return body().procurarElemento(By.xpath("//ds-card-selection[contains(@label, '"+tipoCategoria+"')]"));        
    }

    public Bmouaajm_Elemento obterSelecaoAtual() {
        return body().procurarElemento(By.xpath("//ds-card-selection[contains(@helper, 'Categoria atual')]"));
    }
}
