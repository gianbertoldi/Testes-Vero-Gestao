package bergs.Bvr.Bvruaajm.test.pages.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_ListarCartoesPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;
    Bvruaajm_CartaoAcesso cartaoAcesso;

    public Bvruaajm_ListarCartoesPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterDivCartao() {
        return body().procurarElemento(By.id("divCartoes"), Duration.ofSeconds(5));
    }

    public WebElement obterCartao(Bvruaajm_CartaoAcesso cartaoAcesso) {
        String cartaoXpath = "//li[contains(@class, 'cartao') and ./div[contains(@class, 'cartao-dados') and ./div[text()='%s']]]";
        this.cartaoAcesso = cartaoAcesso;
        cartaoXpath = String.format(cartaoXpath, cartaoAcesso.obterCpfFormatado());
        return driver.findElement(By.xpath(cartaoXpath));
    }

    public Bmouaajm_Elemento obterCartao(String cartaoAcessoCPF) {
        String cartaoXpath = "//li[contains(@class, 'cartao') and ./div[contains(@class, 'cartao-dados') and ./div[text()='%s']]]";
        cartaoXpath = String.format(cartaoXpath, cartaoAcessoCPF);
        return body().findElement(By.xpath(cartaoXpath));
    }

    public Bmouaajm_Elemento obterBotaoNovoCartao() {
        return body().procurarElemento(By.id("footerNovoCartao"));
    }

    public WebElement obterMenuOpcoesCartao(Bvruaajm_CartaoAcesso cartaoAcesso) {
        return obterCartao(cartaoAcesso).findElement(By.className("cartao-opcoes"));
    }
    
    public Bmouaajm_Elemento obterEditarCartao(){
        return body().procurarElemento(By.xpath("(//ul[@id='lista-opcoes-cartao']/li[@onclick='oBvrsloha.clicarAlterarSenha();'])[2]"));
    }

    public Bmouaajm_Elemento obterBotaoMenuExcluirCartao() {
        return body().procurarElemento(By.id("login-cartao-excluir"));
    }

    public Bmouaajm_Elemento obterBotaoExcluirCartao() {
        esperas.aguardarElementoDesaparecer(By.id("login-cartao-excluir"));
        esperas.visibilidadeDoElemento(By.id("bvr-botao-modal-cadastrar"));
        return body().findElement(By.id("bvr-botao-modal-cadastrar"));
    }

    public Bmouaajm_Elemento obterSpanMensagemErroCampos() {
        return body().procurarElemento(By.xpath("//span[@class='mensagem-erro ds-u-caption-dialog-error']"));
    }
    
    public WebElement obterCampoSenhaNativo() {
        esperas.visibilidadeDoElemento(By.className("android.widget.EditText"));
        return driver.findElement(By.className("android.widget.EditText"));
    }

    public WebElement obterBotaoOkNativo() {
        esperas.visibilidadeDoElemento(By.className("android.widget.Button"));
        return driver.findElement(By.className("android.widget.Button"));
    }
    
    public WebElement obterSenhaInvalidaNativo() {
        esperas.visibilidadeDoElemento(By.id("android:id/message"));
        return driver.findElement(By.id("android:id/message"));
    }
}
