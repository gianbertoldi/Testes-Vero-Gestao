package bergs.Bvr.Bvruaajm.test.pages.perfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PerfilPage extends Bmouaajm_PaginaBase{

    Bvruaajm_Esperas esperar;
    
    public Bvruaajm_PerfilPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperar = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return menuPerfil().estaVisivel();
    }
    
    public Bmouaajm_Elemento menuPerfil() {
        return body().procurarElemento(By.id("div-menu"));
    }
    
    public Bmouaajm_Elemento menuMeusNegocios() {
        return body().procurarElemento(By.id("opcao-PEMN"));
    }
    
    public Bmouaajm_Elemento obterDomicioBancario() {
        return body().procurarElemento(By.id("opcao-VRDB"));
    }
    
    public Bmouaajm_Elemento menuPerfilAjustes() {
        return body().procurarElemento(By.id("opcao-VRMD"));
    }
    
    public Bmouaajm_Elemento menuFaleConosco() {
        return body().procurarElemento(By.id("opcao-VRSU"));
    }
    
    public Bmouaajm_Elemento obterTaxas() {
        return body().procurarElemento(By.id("opcao-VRTX"));
    }
    
    public Bmouaajm_Elemento menuGerenciarUsuario() {
        return body().procurarElemento(By.id("opcao-VRGE"));
    }

    public Bmouaajm_Elemento obterEmailPerfil() {
        return body().procurarElemento(By.id("perfil-email"));
    }
    
    public Bmouaajm_Elemento obterCelularPerfil() {
        return body().procurarElemento(By.id("perfil-celular"));
    }
    
    public Bmouaajm_Elemento obterTipoPerfil() {
        return body().procurarElemento(By.id("perfil-role"));
    }
    
    public Bmouaajm_Elemento obterNomePerfil() {
        return body().procurarElemento(By.id("perfil-nome"));
    }
    
    public Bmouaajm_Elemento obterCampoCpfMeusDados() {
        return body().procurarElemento(By.id("cadCliCpf"));
    }
    
    public Bmouaajm_Elemento obterCampoNomeMeusDados() {
        return body().procurarElemento(By.id("cadCliApelido"));
    }
    
    public Bmouaajm_Elemento obterCampoCelularMeusDados() {
        return body().procurarElemento(By.id("telefoneConfirma"));
    }
    
    public Bmouaajm_Elemento obterCampoEmailMeusDados() {
        return body().procurarElemento(By.id("emailConfirma"));
    }
    
    public Bmouaajm_Elemento obterMeiaModalSeuEmailEstaAtualizado() {
        return body().procurarElemento(By.xpath("//div[contains(@id,'bvr-modal-mensagem-')]/div[@class='bvr-ds3-modal-conteudo']"));
    }
    
    public Bmouaajm_Elemento obterBotaoSecundarioMeiaModalEmail() {
        return body().procurarElemento(By.xpath("//ds-button[@class='bvr-ds2-botao-conteudo' and @variant='secondary']"));
    }
    
    public Bmouaajm_Elemento obterBotaoAtualizacaoOK() {
        return body().procurarElemento(By.id("bvr-botao-modal-cadastrar"));
    }
    
    public Bmouaajm_Elemento obterSpanMensagemErroCampos() {
        return body().procurarElemento(By.xpath("//label[@id='lblEmailConfirma']//span[contains(@class,'mensagem-erro')]"));
    }
    
    public Bmouaajm_Elemento obterCampoBancoPrimeiroCartao() {
        return body().procurarElemento(By.cssSelector("#domicilio-bandeira-1 div:nth-child(2) span:nth-child(1)"));
    }
    
    public Bmouaajm_Elemento obterCampoISPBPrimeiroCartao() {
        return body().procurarElemento(By.cssSelector("#domicilio-bandeira-1 div:nth-child(2) span:nth-child(2)"));
    }
    
    public Bmouaajm_Elemento obterCampoAgenciaPrimeiroCartao() {
        return body().procurarElemento(By.cssSelector("#domicilio-bandeira-1 div:nth-child(2) span:nth-child(3)"));
    }
    
    public Bmouaajm_Elemento obterCampoContaPrimeiroCartao() {
        return body().procurarElemento(By.cssSelector("#domicilio-bandeira-1 div:nth-child(2) span:nth-child(4)"));
    }
    
    public Bmouaajm_Elemento obterMsgErroNome() {
        return body().procurarElemento(By.xpath("//label[@id='lblCadCliApelido']/span[@class='mensagem-erro ds-u-caption-normal-sub']"));
    }
    
    public Bmouaajm_Elemento obterMsgErroCelular() {
        return body().procurarElemento(By.xpath("//label[@id='lblTelefoneConfirma']/span[@class='mensagem-erro ds-u-caption-normal-sub']"));
    }
    
    public Bmouaajm_Elemento obterMsgErroEmail() {
        return body().procurarElemento(By.xpath("//label[@id='lblEmailConfirma']/span[@class='mensagem-erro ds-u-caption-normal-sub'] "));
    }
    
    public Bmouaajm_Elemento obterTxtTituloPush() {
        return body().procurarElemento(By.xpath("//div[@class='ds-m-5']//div[@class='ds-u-title-normal']"));
    }
    
    public Bmouaajm_Elemento obterTxtDescricaoPush() {
        return body().procurarElemento(By.xpath("//div[@class='ds-m-5']//div[@class='ds-u-text-small-sub-normal ds-mt-3']"));
    }
    
    public Bmouaajm_Elemento obterTxtCelularPush() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-md-push']//label"));
    }
    
    public Bmouaajm_Elemento obterTxtEmailPush() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-md-email']//label"));
    }
    
}
