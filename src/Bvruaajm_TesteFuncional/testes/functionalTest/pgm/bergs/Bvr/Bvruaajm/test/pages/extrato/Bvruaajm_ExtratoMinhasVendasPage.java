package bergs.Bvr.Bvruaajm.test.pages.extrato;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ExtratoMinhasVendasPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_ExtratoMinhasVendasPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterTituloExtrato() {
        return body().procurarElemento(By.id("bvr-mv-titulo"));
    }
    
    public Bmouaajm_Elemento obterVendaNaListagemExtrato(String dataFormatado, String nsuVenda) {
        return body().procurarElemento(By.id("bvr-mv-venda-" + dataFormatado + "-" + nsuVenda), Duration.ofSeconds(5));
    }
    
    public Bmouaajm_Elemento obterStatusDaVenda() {
        return body().procurarElemento(By.xpath("//div[@id='div-dmv-status']//span[@class='ds-u-text-medium-normal']"));
    }
    
    public Bmouaajm_Elemento obterInfoMdrDisponivelProximoDiaUtil() {
        return body().procurarElemento(By.xpath("//div[@id='div-dmv-detalhes-recebimento-info']//div[@class='ds-u-caption-normal bvr-dmv-info']"));
    }
    
    public List<Bmouaajm_Elemento> obterLista() {
        return body().procurarElementos(By.cssSelector("[id^='bvr-mv-venda-']"));
    }
    
    public Bmouaajm_Elemento obterTextoTaxasMdr() {
        return body().procurarElemento(By.xpath("//div[@id='div-dmv-detalhes-recebimento-dados']//div[@class='ds-u-text-medium-sub-normal']"));
    }
}
