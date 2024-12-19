package bergs.Bvr.Bvruaajm.test.pages.servicos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_GeolocalizacaoPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;
    
    public Bvruaajm_GeolocalizacaoPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterBotaoAvancarInicio() {
        return body().procurarElemento(By.id("btnAvanca100"));
    }
    
    public Bmouaajm_Elemento obterBotaoAvancar() {
        return body().procurarElemento(By.id("btnAvanca50"));
    }

    public Bmouaajm_Elemento obterTextoEstabelecimento() {
        return body().procurarElemento(By.xpath("//div[@id='divCpfCnpj']//label"));
    }
    
    public Bmouaajm_Elemento obterTextoNomeFantasia() {
        return body().procurarElemento(By.id("spNomeFantasia"));
    }
    
    public Bmouaajm_Elemento obterChevronLocalizacaoFixa() {
        return body().procurarElemento(By.id("idImgPainelFixa"));
    }
    
    public Bmouaajm_Elemento obterTextoLongadouro() {
        return body().procurarElemento(By.id("spLogradouroFixa"));
    }
    
    public Bmouaajm_Elemento obterTituloContato() {
        return body().procurarElemento(By.id("lblEtapasDados"));
    }
    
    public Bmouaajm_Elemento obterTituloFuncionamento() {
        return body().procurarElemento(By.id("lblEtapasDados"));
    }
    
    public Bmouaajm_Elemento obterBotaoSalvar() {
        return body().procurarElemento(By.id("btnSalvar"));
    }
    
    public Bmouaajm_Elemento obterAbrirSelecaoEstabelecimento() {
        return body().procurarElemento(By.id("divConta"));
    }
    
    public WebElement selecionarEstabelecimento() {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@resource-id, 'txtCentro')], //* [contains(@index,'4')]    "));
    }
    
    public WebElement obterBotaoConfirmo() {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@resource-id, 'button1')]"));
    }
}
