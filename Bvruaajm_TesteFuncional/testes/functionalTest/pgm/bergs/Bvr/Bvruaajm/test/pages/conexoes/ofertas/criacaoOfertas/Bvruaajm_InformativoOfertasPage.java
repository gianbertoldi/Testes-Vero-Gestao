package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_InformativoOfertasPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_InformativoOfertasPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterTitulo() {
        return body().procurarElemento(By.xpath("//div[@id='bagInstrucoesOferta']//h1"));
    }
    
    public Bmouaajm_Elemento obterSubtitulo() {
        return body().procurarElemento(By.xpath("//div[@id='bagInstrucoesOferta']//p"));
    }
    
    public Bmouaajm_Elemento obterIcones(int id) {
        return body().procurarElemento(By.xpath("(//*[@id='bagInstrucoesOferta']//ds-icon)["+id+"]"));
    }
    
    public Bmouaajm_Elemento obterLabelSobreOfertaPrimeiro() {
        return body().procurarElemento(By.xpath("(//span[contains(@class ,'bag-padding-left-16')])[1]"));
    }
    
    public Bmouaajm_Elemento obterLabelSobreOfertaSegundo() {
        return body().procurarElemento(By.xpath("(//span[contains(@class ,'bag-padding-left-16')])[2]"));
    }
    
    public Bmouaajm_Elemento obterLabelSobreOfertasTerceiro() {
        return body().procurarElemento(By.xpath("(//span[contains(@class ,'bag-padding-left-16')])[3]"));
    }
    
    public Bmouaajm_Elemento obterLabelSobreOfertasQuarto() {
        return body().procurarElemento(By.xpath("(//span[contains(@class ,'bag-padding-left-16')])[4]"));
    }
    
    public Bmouaajm_Elemento obterLabelSobreOfertasQuinto() {
        return body().procurarElemento(By.xpath("(//span[contains(@class ,'bag-padding-left-16')])[5]"));
    }
    
    public Bmouaajm_Elemento obterBotaoVamosLa() {
        return body().procurarElemento(By.id("bag-instrucoes-vamos-la"));
    }
}
