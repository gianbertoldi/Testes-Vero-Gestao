package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_CriacaoOfertaSucessoPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_CriacaoOfertaSucessoPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterLabelTitulo() {
        return body().procurarElemento(By.xpath("//*[@id='bagTelaSucesso']//h1"));
    }
    
    public Bmouaajm_Elemento obterLabelMensagem() {
        return body().procurarElemento(By.xpath("//*[@id='bagTelaSucesso']//p"));
    }
    
    public Bmouaajm_Elemento obterIcone() {
        return body().procurarElemento(By.xpath("//ds-icon[@name='schedule']"));
    }
    
    public Bmouaajm_Elemento obterSpam() {
        return body().procurarElemento(By.xpath("//*[@id='bagTelaSucesso']//span"));
    }
    
    public Bmouaajm_Elemento obterBotaoIrParaOPrograma() {
        return body().procurarElemento(By.id("bagBtnIrParaPrograma"));
    }

}
