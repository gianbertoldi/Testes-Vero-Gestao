package bergs.Bvr.Bvruaajm.test.pages.home.psr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PsrPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_PsrPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterBotaoNovaSolicitacao() {
        return body().procurarElemento(By.id("bvr-psr-solicitacoes-btn-avancar"));
    }

    public Bmouaajm_Elemento obterCheckBoxPsrCielo() {
        return body().procurarElemento(By.xpath("//li[@id='bvr-psr-adquirente-01027058000191']/div"));
    }

    public Bmouaajm_Elemento obterCheckBoxPsrGetnet() {
        return body().procurarElemento(By.xpath("//li[@id='bvr-psr-adquirente-10440482000154']/div"));
    }

    public Bmouaajm_Elemento obterBotaoEnviaSolicitacaoPsr() {
        return body().procurarElemento(By.id("bvr-psr-btn-avancar"));
    }

    public Bmouaajm_Elemento obterBotaoMinhaSolicitacaoPsr() {
        return body().procurarElemento(By.id("bvr-psr-su-btn-avancar"));
    }

    public Bmouaajm_Elemento obterTituloSolicitacaoEnviadaPsr() {
        return body().procurarElemento(By.xpath("//div[@class='ds-u-title-normal  bvr-ds3-padding-bottom-16']"));
    }

    public Bmouaajm_Elemento obterTextoSolicitacaoEnviadaPsr() {
        return body().procurarElemento(By.id("bvr-psr-su-texto-confirma"));
    }

    public Bmouaajm_Elemento obterChevronMinhaSolicitacaoHabilitadaCielo() {
        return body().procurarElemento(
                By.id("bvr-psr-solicitacoes-01027058000191"));
    }
    
    public Bmouaajm_Elemento obterTextoMinhaSolicitacaoHabilitadaCielo() {
        return body().procurarElemento(By.xpath("//li[@id='bvr-psr-solicitacoes-01027058000191']/div[@class='bvr-psr-sol-detalhe ds-u-text-medium-normal']"));
    }

    public Bmouaajm_Elemento obterChevronMinhaSolicitacaoPendenteGetNet() {
        return body().procurarElemento(
                By.id("bvr-psr-solicitacoes-10440482000154"));
    }

    public Bmouaajm_Elemento obterTextoMinhaSolicitacaoPendenteGetNet() {
        return body().procurarElemento(
                By.xpath("//li[@id='bvr-psr-solicitacoes-10440482000154']/div[@class='bvr-psr-sol-detalhe ds-u-text-medium-normal']"));
    }
}
