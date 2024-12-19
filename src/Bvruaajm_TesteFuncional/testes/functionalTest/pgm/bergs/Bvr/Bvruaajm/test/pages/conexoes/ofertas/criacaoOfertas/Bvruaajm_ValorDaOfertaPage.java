package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ValorDaOfertaPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_ValorDaOfertaPage(AppiumDriver<WebElement>driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterLabelTituloValorOferta() {
        return body().procurarElemento(By.xpath("//div[@id='bagTelaValor']/h1"));
    }
    
    public Bmouaajm_Elemento obterLabelSubtitulo() {
        return body().procurarElemento(By.xpath("//div[@id='bagTelaValor']/p"));
    }
    
    public Bmouaajm_Elemento obterCampoTextoDeValor() {
        return body().procurarElemento(By.id("bagValorDe"));
    }
    
    public Bmouaajm_Elemento obterCampoTextoPorValor() {
        return body().procurarElemento(By.id("bagValorPor"));
    }
    
    public Bmouaajm_Elemento obterLabelMensagemErroCampoDe() {
        return body().procurarElemento(By.xpath("(//span[contains(@class , 'bag-erro-mensagem')])[1]"));
    }
    
    public Bmouaajm_Elemento obterLabelMensagemErroCampoPor() {
        return body().procurarElemento(By.xpath("(//span[contains(@class , 'bag-erro-mensagem')])[2]"));
    }
}
