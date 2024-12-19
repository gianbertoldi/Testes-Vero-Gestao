
package bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_OnboardingConexoesPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_OnboardingConexoesPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterTitulo (int i) {
        return body().findElement(By.xpath("(//*[@mm-html='titulo'])["+i+"]"));
    }
    
    public Bmouaajm_Elemento obterImagem(int i) {
        return body().procurarElemento(By.xpath("(//*[@alt='imagem'])["+i+"]"));
    }
    
    public Bmouaajm_Elemento obterMensagemTexto(int i) {
        return body().procurarElemento(By.xpath("(//*[@mm-html='texto'])["+i+"]"));
    }
    
    
}
