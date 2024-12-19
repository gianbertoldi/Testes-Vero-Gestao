package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.termoAdesao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_TermoDeAdesaoPage  extends Bmouaajm_PaginaBase{

    public Bvruaajm_TermoDeAdesaoPage(AppiumDriver<WebElement>driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }

    
    public Bmouaajm_Elemento obterLabelTitulo() {
        return body().procurarElemento(By.xpath("//section[@id='bagSectionTelaAceiteTermo']//h1"));
    }
    
    public Bmouaajm_Elemento obterLabelSubtitulo() {
        return body().procurarElemento(By.xpath("//section[@id='bagSectionTelaAceiteTermo']//p"));
    }
    
    public Bmouaajm_Elemento obterLinkTermoAdesao() {
        return body().procurarElemento(By.xpath("//section[@id='bagSectionTelaAceiteTermo']//a"));
    }
    
    public Bmouaajm_Elemento obterBotaoLiAceito() {
        return body().procurarElemento(By.id("btnAceiteTermo"));
    }
    
    public Bmouaajm_Elemento obterIconeAlerta() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-modal-mensagem-3']//img"));
    }

    public Bmouaajm_Elemento obterTituloModal() {
        return body().procurarElemento(By.xpath("(//div[@id='bvr-modal-mensagem-3']//div)[3]"));
    }   
    
    public Bmouaajm_Elemento obterSubtituloModal() {
        return body().procurarElemento(By.xpath("(//div[@id='bvr-modal-mensagem-3']//div)[4]"));
    }   
}
