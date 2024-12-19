package bergs.Bvr.Bvruaajm.test.pages.vender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_VeroWalletPage extends Bmouaajm_PaginaBase{
    
    public Bvruaajm_VeroWalletPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterQrCodeGerado() {
        return body().procurarElemento(By.id("bvr-gerado-qr-code"));
    }
    
    public Bmouaajm_Elemento obterBarraModalMovelWallet() {
        return body().procurarElemento(By.id("minhas-vendas-hoje-barra"));
    }
    
    public Bmouaajm_Elemento obterTituloBarraModalMovelWallet() {
        return body().procurarElemento(By.className("bvr-texto-minhas-vendas-hoje"));
    }
    
    public Bmouaajm_Elemento obterIconeFiltrarVendas() {
        return body().procurarElemento(By.id("bvr-filtro-minhas-vendas"));
    }
    
    public Bmouaajm_Elemento obterIconeReloadVendas() {
        return body().procurarElemento(By.id("bvr-reload-minhas-vendas-hoje"));
    }
    
    public Bmouaajm_Elemento obterBarraTotalDia() {
        return body().procurarElemento(By.id("bvr-total-vendas-do-dia"));
    }
}
