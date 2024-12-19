package bergs.Bvr.Bvruaajm.test.pages.perfil;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_TaxasPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_TaxasPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return obterMenuTaxas().estaVisivel();
    }

    public Bmouaajm_Elemento obterMenuTaxas() {
        return body().procurarElemento(By.id("faixa-atual"));
    }

    public List<Bmouaajm_Elemento> obterAtivarChevron() {
        return body().procurarElementos(By.xpath("//div[@class='ds-u-label-small-normal bvr-ds-color-action bvr-taxas-mais-menos']"));
    }

    public List<Bmouaajm_Elemento> obterTipoBandeira() {
        return body().procurarElementos(By.xpath("//div[@class='bvr-painel-taxas-detalhe ds-u-background-color-ui-surface ds-u-radius-03 ds-mb-3']"), Duration.ofSeconds(5));
    }
    
    public List<Bmouaajm_Elemento> obterTipoBandeiraLinkPgto() {
        return body().procurarElementos(By.xpath("//div[@id='bvr-lista-taxas-link-detalhe']//div[contains(@class, 'bvr-painel-taxas-detalhe')]"), Duration.ofSeconds(5));
    }

    public List<Bmouaajm_Elemento> obterLinhaTaxaBandeira(Bmouaajm_Elemento element) {
        return element.findElements(By.cssSelector("li"));
    }

    public Bmouaajm_Elemento obterAreaTaxasMaquininha() {
        return body().procurarElemento(By.id("bvr-taxas-solucoes-vero"));
    }

    public Bmouaajm_Elemento obterAreaTaxasLinkPgto() {
        return body().procurarElemento(By.id("bvr-taxas-link"));
    }

    public Bmouaajm_Elemento obterInfoAderirAoLinkPgtoTaxas() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-taxas-link-nao-aderido-2']//div[@class='bvr-flex-1 ds-u-caption-normal']"));
    }
    
    public Bmouaajm_Elemento obterQueroAderirAoLinkPgto() {
        return body().procurarElemento(By.id("bvr-taxas-aderir-link-1"));
    }
    
    public List<Bmouaajm_Elemento> obterTextoInformativoMinhasTaxas(){
        return body().procurarElementos(By.xpath("//div[@class='ds-u-text-medium-normal ds-mb-4']"));
    }

    public WebElement obterCardTaxasPsr() {
        return driver.findElement(By.id("bvr-taxas-box-psr"));
    }
    
    public Bmouaajm_Elemento obterAreaTaxasPsr() {
        return body().procurarElemento(By.id("bvr-taxas-psr"));
    }
    
    public List<Bmouaajm_Elemento> obterListaTaxasPsr() {
        return body().procurarElementos(By.xpath("//ul[@id='bvr-ul-taxas-detalhe-1']//li"));
    }
    
    public Bmouaajm_Elemento obterTituloCardMaquininha() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-taxas-box-solucoes-vero']//div[@class='ds-u-label-medium-normal ds-mb-3']"));
    }
    
    public Bmouaajm_Elemento obterTituloCardLink() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-taxas-box-link']//div[@class='ds-u-label-medium-normal ds-mb-3']"));
    }
    
    public Bmouaajm_Elemento obterTituloCardPsr() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-taxas-box-psr']//div[@class='ds-u-label-medium-normal ds-mb-3']"));
    }
}