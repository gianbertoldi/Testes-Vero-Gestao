package bergs.Bvr.Bvruaajm.test.pages.home;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_NotificacoesPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_NotificacoesPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterTextoMeiaModalNotificacaoTitulo() {
        return body().procurarElemento(By.id("mensagem-titulo"));
    }

    public Bmouaajm_Elemento obterTextoMeiaModalNotificacaoDescricao() {
        return body().procurarElemento(By.id("mensagem-texto"));
    }

    public Bmouaajm_Elemento obterBotaoMeiaModalNotificacaoEntendi() {
        return body().procurarElemento(By.id("popup-mensagem-button"));
    }

    public List<Bmouaajm_Elemento> obterListaDeNotificacoes() {
        return body().procurarElementos(By.xpath("//ul[@id='ulMensagem']/li"));
    }

    public Bmouaajm_Elemento obterStatusNotificacaoNaoLida() {
        return body().procurarElemento(By.cssSelector("li#li-9998.navegacao-item.bvr-card-mensagem.bvr-visualizado-N"), Duration.ofSeconds(5));
    }
    
    public Bmouaajm_Elemento obterTextoTituloTelaCheia() {
        return body().procurarElemento(By.id("mensagem-titulo-tc"), Duration.ofSeconds(10));
    }
    
    public Bmouaajm_Elemento obterDescricaoTelaCheia() {
        return body().procurarElemento(By.id("mensagem-texto-tc"), Duration.ofSeconds(10));
    }
    
    public Bmouaajm_Elemento obterSeImagemEstaNaTela() {
        return body().findElement(By.id("imagem-popup-mensagem-tc"));
    }
}
