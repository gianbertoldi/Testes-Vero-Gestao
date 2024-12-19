package bergs.Bvr.Bvruaajm.test.pages.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ElementoNativoPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_ElementoNativoPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return obterTexto().isDisplayed();
    }

    public WebElement obterBotaoEsquerdo() {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@resource-id, 'btnEsquerda')]"));
    }

    public WebElement obterTexto() {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@resource-id, 'txtCentro')]"));
    }

    public WebElement obterBotaoDireito() {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@resource-id, 'btnDireita1')]"));
    }

    public WebElement obterBotaoDireito2() {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@resource-id, 'btnDireita2')]"));
    }    

    public WebElement obterServidorMenu() {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@text , 'Desenvolvimento')]"));
    }
    
    public WebElement obterServidor(String servidor) {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@text, '"+servidor+"')]"));
    }

    public WebElement obterBotaoLixeira() {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@resource-id, 'btnDireita1')]"));
    }

}
