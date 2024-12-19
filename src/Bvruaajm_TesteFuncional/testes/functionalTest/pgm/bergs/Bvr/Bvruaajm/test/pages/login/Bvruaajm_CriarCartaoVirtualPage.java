package bergs.Bvr.Bvruaajm.test.pages.login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_CriarCartaoVirtualPage extends Bmouaajm_PaginaBase {

    Bvruaajm_Esperas esperas;

    public Bvruaajm_CriarCartaoVirtualPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterCampoApelido() {
        return body().procurarElemento(By.id("cadCliApelido"));
    }

    public Bmouaajm_Elemento obterCampoCpf() {
        return body().procurarElemento(By.id("cadCliCpf"));
    }

    public List<Bmouaajm_Elemento> obterContatoConfirmacao() {
        esperas.visibilidadeDoElemento(By.xpath("//tr[contains(@id, 'tr-linha-contato')]"));
        return body().findElements(By.xpath("//tr[contains(@id, 'tr-linha-contato')]"));
    }

    public Bmouaajm_Elemento obterInputEmailConfirma() {
        return body().procurarElemento(By.id("emailConfirma"));
    }

    public Bmouaajm_Elemento obterInputTelefoneConfirma() {
        return body().procurarElemento(By.id("telefoneConfirma"));
    }

    public List<WebElement> obterCodigoAtivacao() {
        esperas.visibilidadeDoElemento(By.xpath("//div[@id='codigos-ativacao']/input"));
        return driver.findElements(By.xpath("//div[@id='codigos-ativacao']/input"));
    }

    public Bmouaajm_Elemento obterInputSenha() {
        return body().procurarElemento(By.id("ativacaoSenha1"));
    }

    public Bmouaajm_Elemento obterInputSenhaConfirmacao() {
        return body().procurarElemento(By.id("ativacaoSenha2"));
    }

    public Bmouaajm_Elemento obterReenviarCodigoAtivacao() {
        return body().procurarElemento(By.id("a-solicita-ativacao"));
    }

    public Bmouaajm_Elemento obterTituloReenviarCodigoAtivacao() {
        return body().procurarElemento(By.xpath("//div[@class='bvr-ds3-modal-conteudo']/div[contains(@class,'bvr-ds3-modal-titulo') and contains(@class, 'bvr-ds3-modal-texto-centrado')]"));
    }
    
    public Bmouaajm_Elemento obterBotaoMeiaModalVamosLa() {
        return body().procurarElemento(By.xpath("//ds-button[@class='bvr-ds2-botao-conteudo']"));
    }
    
    public Bmouaajm_Elemento obterTituloCpfNaoCadastrado() {
        return body().procurarElemento(By.xpath("//div[@class='ds-u-title-normal bvr-ds3-margin-bottom-16']"));
    }
    
    public Bmouaajm_Elemento obterTextoCaminhoCpfNaoCadastrado() {
        return body().procurarElemento(By.xpath("//div[@class='ds-u-text-medium-normal']/strong"));
    }
    
    public Bmouaajm_Elemento obterLinkAquiEntreEmContato() {
        return body().procurarElemento(By.id("bvr-login-cpf-inexistente-clique-canais"));
    }
    
}
