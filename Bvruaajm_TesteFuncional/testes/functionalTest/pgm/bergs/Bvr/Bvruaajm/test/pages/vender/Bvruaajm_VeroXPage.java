package bergs.Bvr.Bvruaajm.test.pages.vender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_VeroXPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_VeroXPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterQrCodeGerado() {
        return body().procurarElemento(By.id("bvr-pix-gerado-qr-code"));
    }

    public Bmouaajm_Elemento obterTipoChaveQrCode() {
        return body().procurarElemento(By.id("bvr-pix-painel-tipo-chave"));
    }

    public Bmouaajm_Elemento obterSetaAumentarQrCode() {
        return body().procurarElemento(By.id("bvr-pix-painel-seta"));
    }

    public Bmouaajm_Elemento obterBotaoLinkCompartilhar() {
        return body().procurarElemento(By.id("bvr-pix-painel-link-compartilhar"));
    }

    public Bmouaajm_Elemento obterBotaoLinkEditarChavePix() {
        return body().procurarElemento(By.id("bvr-pix-painel-editar"));
    }

    public Bmouaajm_Elemento obterTextoChavePix() {
        return body().procurarElemento(By.id("bvr-painel-pix-chave"));
    }

    public Bmouaajm_Elemento obterTituloAdesaoVeroX() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-pix-adesao']//div[contains(@class, 'ds-u-title-normal')]"));
    }

    public Bmouaajm_Elemento obterBotaoIniciaAdesao() {
        return body().procurarElemento(By.id("bvr-pix-btn-selecina-estabelecimento"));
    }

    public Bmouaajm_Elemento obterSelecionarEstabLogado() {
        return body().procurarElemento(By.id("bvr-pix-ul-estabelecimento-selecionado"));
    }

    public Bmouaajm_Elemento obterSelecionarChavePix() {
        return body().procurarElemento(By.id("bvr-pix-receber-chave_pix"));
    }

    public Bmouaajm_Elemento obterPixPorCnpj() {
        return body().procurarElemento(By.id("bvr-qual-chave-cpf_cnpj"));
    }

    public Bmouaajm_Elemento obterConfirmarChavePixCnpj() {
        return body().procurarElemento(By.id("bvr-pix-btn-adesao-cpf-cnpj"));
    }

    public Bmouaajm_Elemento obterBotaoConfirmarAdesao() {
        return body().procurarElemento(By.id("bvr-pix-btn-confirma-adesao"));
    }

    public Bmouaajm_Elemento obterCheckBoxLiEconcordoTermoVeroX() {
        return body().procurarElemento(By.xpath("//div[@class='bvr-ds3-checkbox ds-u-text-medium-normal']"));
    }

    public Bmouaajm_Elemento telaJaAderido() {
        esperas.esperarAte(
                driver -> body().findElement(By.id("bvr-pix-painel-qr-code")).estaVisivel(),
                10);
        return body().findElement(By.id("bvr-pix-painel-qr-code"));
    }
}
