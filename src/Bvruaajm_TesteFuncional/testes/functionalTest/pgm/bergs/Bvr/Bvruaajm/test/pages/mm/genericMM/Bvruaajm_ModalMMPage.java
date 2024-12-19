package bergs.Bvr.Bvruaajm.test.pages.mm.genericMM;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_ModalMMPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_ModalMMPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return false;
    }

    public Bmouaajm_Elemento obterModalInfraContent() {
        return body().procurarElemento(By.id("modalInfraContent"));
    }
    
    public Bmouaajm_Elemento obterBotaoOK() {
        return body().procurarElemento(By.xpath("//div[@id='modalMessageInfraContainer']//div/button[contains(text(),'Ok')]"));
    }
}
