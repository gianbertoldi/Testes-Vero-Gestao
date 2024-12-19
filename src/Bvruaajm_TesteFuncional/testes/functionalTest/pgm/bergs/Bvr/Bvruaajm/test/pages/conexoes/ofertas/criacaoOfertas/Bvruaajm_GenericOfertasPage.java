package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_GenericOfertasPage extends Bmouaajm_PaginaBase{

    private Bvruaajm_Esperas esperas;

    public Bvruaajm_GenericOfertasPage(AppiumDriver<WebElement>driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }
   
    public WebElement obterBotaoContinuar() {
        esperas.aguardarTextoProcessandoDesaparecer();
        return driver.findElement(By.id("bagBtnCadastroAvancar"));
    }
    
    public Bmouaajm_Elemento obterBotaoContinuarEtapaImagem() {
        return body().procurarElemento(By.id("bagBtnImagemPrimario") , Duration.ofMillis(30));
    }
    
    public Bmouaajm_Elemento obterBotaoCancelar() {
        return body().procurarElemento(By.id("bagBtnCadastroCancelar"));
    }
}
