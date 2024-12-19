package bergs.Bvr.Bvruaajm.test.pages.extrato;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_MenuExtratoPage  extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_MenuExtratoPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterMinhasVendas() {
        return body().procurarElemento(By.id("opcao-VRMI"));
    }
    
    public Bmouaajm_Elemento obterQuantoVendi() {
        return body().procurarElemento(By.id("opcao-ETQV"));
    }
    
    public Bmouaajm_Elemento obterQuantoRecebi() {
        return body().procurarElemento(By.id("opcao-ETQR"));
    }
    
    public Bmouaajm_Elemento obterQuantoVouReceber() {
        return body().procurarElemento(By.id("opcao-ETVR"));
    }
    
    public Bmouaajm_Elemento obterCartaoPrePago() {
        return body().procurarElemento(By.id("opcao-ETCP"));
    }
    
    public Bmouaajm_Elemento obtertransacoesCanceladas() {
        return body().procurarElemento(By.id("opcao-ETOC"));
    }
    
    public Bmouaajm_Elemento obterRelatorioDeRecebiveis() {
        return body().procurarElemento(By.id("opcao-RBRR"));
    }
    
}
