package bergs.Bvr.Bvruaajm.test.pages.servicos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ServicosPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_ServicosPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterBotaoAntecipacao() {
        return body().procurarElemento(By.id("opcao-SVAN"));
    }

    public Bmouaajm_Elemento obterBotaoSimulador() {
        return body().procurarElemento(By.id("opcao-VRSV"));
    }

    public Bmouaajm_Elemento obterBotaoGestaoRePay() {
        return body().procurarElemento(By.id("opcao-SVGR"));
    }

    public Bmouaajm_Elemento obterBotaoGeolocalizacao() {
        return body().procurarElemento(By.id("opcao-RBPP"));
    }

    public Bmouaajm_Elemento obterBotaoBobinas() {
        return body().procurarElemento(By.id("opcao-SVBO"));
    }

    public Bmouaajm_Elemento obterBotaoCancelamentos() {
        return body().procurarElemento(By.id("opcao-SVCA"));
    }

    public Bmouaajm_Elemento obterBotaoDirf() {
        return body().procurarElemento(By.id("opcao-SVDI"));
    }

    public Bmouaajm_Elemento obterBotaoCartaDeCircularizacao() {
        return body().procurarElemento(By.id("opcao-SVCC"));
    }

    public Bmouaajm_Elemento obterBotaoConciliacao() {
        return body().procurarElemento(By.id("opcao-SVCO"));
    }

    public Bmouaajm_Elemento obterBotaoDownloadDeArquivos() {
        return body().procurarElemento(By.id("opcao-SVDA"));
    }

    public Bmouaajm_Elemento obterBotaoConsultaPagamentoB2B() {
        return body().procurarElemento(By.id("opcao-SVB2"));
    }
    
    public Bmouaajm_Elemento obterBotaoMeusChamados() {
        return body().procurarElemento(By.id("opcao-VRXX"));
    }
}
