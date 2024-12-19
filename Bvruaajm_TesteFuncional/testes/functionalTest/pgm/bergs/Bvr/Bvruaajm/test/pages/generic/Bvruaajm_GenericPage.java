package bergs.Bvr.Bvruaajm.test.pages.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Formatador;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_GenericPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_GenericPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterBotaoAvancar() {
        esperas.esperarAte(driver -> body().findElement(By.id("btnAvancar")).estaVisivel(), 10);
        return body().findElement(By.id("btnAvancar"));
    }

    public Bmouaajm_Elemento obterSetaComboEstabelecimento() {
        return body().procurarElemento(By.id("bvr-combo-estabelecimento-seta"));
    }

    public Bmouaajm_Elemento obterEstabelecimentoPorCpfOuCnpj(String cpfCnpj) throws InterruptedException {
        esperas.visibilidadeDoElemento(By.xpath("//li[@bvr-tipo-lojista ='E' and contains(@id, '" +Long.parseLong(Bmouaajm_Formatador.filtrarNaoNumericos(cpfCnpj)) + "')]"),10);
        return body().findElement(By.xpath("//li[@bvr-tipo-lojista ='E' and contains(@id, '"+ Long.parseLong(Bmouaajm_Formatador.filtrarNaoNumericos(cpfCnpj)) + "')]"));
    }

    public Bmouaajm_Elemento obterConveniadoPorCpfOuCnpj(String cpfCnpj) throws InterruptedException {
        esperas.visibilidadeDoElemento(By.xpath("//li[@bvr-tipo-lojista ='C' and contains(@id, '"
                + Long.parseLong(Bmouaajm_Formatador.filtrarNaoNumericos(cpfCnpj)) + "')]"), 5);
        return body().findElement(By.xpath("//li[@bvr-tipo-lojista ='C' and contains(@id, '"
                + Long.parseLong(Bmouaajm_Formatador.filtrarNaoNumericos(cpfCnpj)) + "')]"));
    }

    public Bmouaajm_Elemento obterBotaoVender() {
        return body().procurarElemento(By.id("botao-footer-vender"));
    }

    public Bmouaajm_Elemento obterBotaoHome() {
        return body().procurarElemento(By.id("botao-footer-home"));
    }

    public Bmouaajm_Elemento obterBotaoExtratos() {
        return body().procurarElemento(By.id("botao-footer-extratos"));
    }

    public Bmouaajm_Elemento obterBotaoServicos() {
        return body().procurarElemento(By.id("botao-footer-servicos"));
    }

    public Bmouaajm_Elemento obterBotaoPerfil() {
        return body().procurarElemento(By.id("botao-footer-perfil"));
    }

    public Bmouaajm_Elemento obterMeiaModalMensagem() {
        return body().procurarElemento(By.id("bvr-modal-mensagem-"));
    }

    public Bmouaajm_Elemento obterMensagemMeiaModalDivTextoCentrado() {
        return body().procurarElemento(By.xpath("//div[@class='bvr-texto-centrado']"));
    }

    public Bmouaajm_Elemento obterBotaoVamosLa() {
        return body().procurarElemento(By.xpath("//ds-button[@label='Vamos lá!']"));
    }

    public Bmouaajm_Elemento obterTituloMeiaModal() {
        return body().procurarElemento(By.xpath("//div[contains(@id,'bvr-modal-mensagem-')]//div[contains(@class,'bvr-ds3-modal-titulo')]"));
    }

    public Bmouaajm_Elemento obterDescricaoMeiaModal() {
        return body().procurarElemento(By.xpath("//div[contains(@id,'bvr-modal-mensagem-')]//div[contains(@class,'ds-u-text-medium-sub-normal')]"));
    }

    public Bmouaajm_Elemento obterDescricaoMeiaModalModalConteudo() {
        return body().procurarElemento(By.xpath("//div[contains(@class,'modal-conteudo')]//div[contains(@class,'medium-normal ds-my-5')]"));
    }

    public Bmouaajm_Elemento obterBotaoMeiaModalEntendi() {
        return body().procurarElemento(By.xpath("//ds-button[@class='bvr-ds2-botao-conteudo']"));
    }

    public Bmouaajm_Elemento obterBotaoPrimarioMeiaModal() {
        return body().procurarElemento(By.xpath("//div[@class='bvr-ds3-container-botoes']/ds-button[@variant='primary']"), Duration.ofSeconds(10));
    }

    public Bmouaajm_Elemento obterTituloContatoVero() {
        return body().procurarElemento(By.id("bvr-suporte-titulo"));
    }
    
    public Bmouaajm_Elemento obterBotaoEntendi() {
        return body().procurarElemento(By.xpath("//button[contains(@id,'botaoPrimarioModalMensagem')]"));
    }
    
    public Bmouaajm_Elemento obterTituloConversarComVero() {
        return body().procurarElemento(By.id("bvr-suporte-titulo"));
    }
    
    public Bmouaajm_Elemento obterCardTenhoManquininha() {
        return body().procurarElemento(By.id("bvr-perfil-fale-conosco-suporte"));
    }

    public Bmouaajm_Elemento obterTituloTenhoMaquininha() {
        return body().procurarElemento(By.id("bvr-suporte-titulo"));
    }
}
