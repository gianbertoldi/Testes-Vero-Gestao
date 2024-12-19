package bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_InformativoPerfilPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_InformativoPerfilPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    public boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterBotaoVamosLa() {
        return body().procurarElemento(By.id("bag-instrucoes-vamos-la-continuar") , Duration.ofMillis(30));
    }
    
    public Bmouaajm_Elemento obterLabelTitulo() {
        return body().procurarElemento(By.xpath("//*[@id='bag-instrucoes']//h1"));
    }
    
    public Bmouaajm_Elemento obterLabelSubtitulo() {
        return body().procurarElemento(By.xpath("//p[contains(@class , 'bvr-ds2-caixa-texto-24' )]"));
    }
    
    public Bmouaajm_Elemento obterLabelMiniTituloInformativo() {
        return body().procurarElemento(By.xpath("//*[@id='bag-instrucoes']//label"));
    }
    
    public int quantidadIcones() {
        return body().procurarElementos(By.xpath("//*[contains(@class , 'bag-icone-tamanho-padrao')]")).size();
    }
    
    public Bmouaajm_Elemento obterLabelPrimeiraEtapa() {
        return body().findElement(By.xpath("(//span[contains(@class , 'bvr-ds2-caixa-texto-24')])[1]"));
    }
    
    public Bmouaajm_Elemento obterLabelSegundaEtapa() {
        return body().findElement(By.xpath("(//span[contains(@class , 'bvr-ds2-caixa-texto-24')])[2]"));
    }
    
    public Bmouaajm_Elemento obterLabelTerceiraEtapa() {
        return body().findElement(By.xpath("(//span[contains(@class , 'bvr-ds2-caixa-texto-24')])[3]"));
    }
}
