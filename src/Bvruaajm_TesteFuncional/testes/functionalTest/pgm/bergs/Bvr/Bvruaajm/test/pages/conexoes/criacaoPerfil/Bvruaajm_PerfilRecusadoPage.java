package bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PerfilRecusadoPage  extends Bmouaajm_PaginaBase{
    public Bvruaajm_PerfilRecusadoPage (AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    public boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterImagemAlerta() {
        return body().procurarElemento(By.xpath("//img[@alt='ícone de alerta']"));
    }
    
    public Bmouaajm_Elemento obterLabelTitulo() {
        return body().procurarElemento(By.xpath("//h1[contains(@class , 'bvr-ds2-flex-centrado-horizontal bag-padding-top-bottom-16')]"));
    }
    
    public Bmouaajm_Elemento obterLabelInformativo() {
        return body().procurarElemento(By.xpath("//p[contains(@class , 'ds-u-text-medium-normal bvr-ds2-flex-centrado-horizontal' )]"));
    }
    
    public Bmouaajm_Elemento obterLabelContatoVero() {
        return body().procurarElemento(By.xpath("//span[contains(@class , 'ds-u-caption-normal bvr-ds2-margem-esquerda-8' )]"));
    }
    
    public Bmouaajm_Elemento obterBotaoRevisar() {
        return body().procurarElemento(By.id("bag-instrucoes-vamos-la-continuar"));
    }
    
}
