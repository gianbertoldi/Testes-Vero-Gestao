package bergs.Bvr.Bvruaajm.test.pages.servicos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_MeusChamadosPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_MeusChamadosPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterTituloCentralDeChamados() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-lista-incidentes-menu']//span"));
    }

    public Bmouaajm_Elemento obterTituloCardMeusChamados() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-card-consultar-chamados']//div[@class='ds-u-label-medium-normal ds-mb-3']"));
    }

    public Bmouaajm_Elemento obterTituloCardNovoChamado() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-card-novo-chamado']//div[@class='ds-u-label-medium-normal ds-mb-3']"));
    }

    public Bmouaajm_Elemento obterBotaoMeusChamados() {
        return body().procurarElemento(By.id("bvr-consultar-incidente"));
    }

    public Bmouaajm_Elemento obterBotaoNovoChamado() {
        return body().procurarElemento(By.id("bvr-novo-incidente"));
    }
    
    public WebElement obterCardMeusChamado() {
        return driver.findElement(By.id("bvr-card-consultar-chamados"));
    }

    public Bmouaajm_Elemento obterMaisDetalhes() {
        return body().procurarElemento(By.xpath("//div[@class='bvr-incidente-mais-detalhes bvr-incidente-borda']"));
    }
    
    public Bmouaajm_Elemento obterTextoClassificao() {
        return body().procurarElemento(By.xpath("//div[contains(@class,'bvr-incidente-titulo-classificacao')]"));
    }
}
