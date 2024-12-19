package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_SelecaoImagemOfertasPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_SelecaoImagemOfertasPage(AppiumDriver<WebElement>driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterLabelTituloImagem() { 
        return body().procurarElemento(By.xpath("//div[@id='bagTelaImagem']//h1"));
    }
    
    public Bmouaajm_Elemento obterLabelSubtituloImagem() {
        return body().procurarElemento(By.xpath("//div[@id='bagTelaImagem']//p"));
    }
    
    public Bmouaajm_Elemento obterBotaoEscolherImagem() {
        return body().procurarElemento(By.id("bagBtnImagemEscolher"));
    }
    
    public Bmouaajm_Elemento obterBotaoEscolherGaleria() {
        return body().procurarElemento(By.xpath("//span[text()='Escolher da galeria']"));
    }
    
    public Bmouaajm_Elemento obterSrcImagem() {
        return body().procurarElemento(By.xpath("//img[@id='bagSelecaoImgOferta']"));
    }
}
