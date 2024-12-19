package bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PerfilEcPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_PerfilEcPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    public boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterNomeFantasia() {
        return body().procurarElemento(By.id("bagNomeFantasia"));
    }
    
    public Bmouaajm_Elemento obterTipoCategoria() {
        return body().procurarElemento(By.xpath("//span[@mm-html='cod_categoria_formatada']"));
    }
    
    public Bmouaajm_Elemento obterLabelDescricao() { 
        return body().procurarElemento(By.id("descNegocio"));
    }
    
    public List<Bmouaajm_Elemento> obterQuantidadeDeRedesSocais() {
        return body().procurarElementos(By.xpath("//li[contains(@class ,'bag-flex bag-flex-alinhar-verticalmente') and not(contains(@class, 'hide'))]/span"));
    }
    
    public Bmouaajm_Elemento obterLabelRedesSociais(int id) {
        return body().procurarElemento(By.xpath("(//li[contains(@class ,'bag-flex bag-flex-alinhar-verticalmente') and not(contains(@class, 'hide'))]/span)["+id+"]"));
    }
    
    public Bmouaajm_Elemento obterLabelDescricaoInfo() {
        return body().procurarElemento(By.xpath("//div[contains(@class , 'bag-notificacao-info')]/span"));
    }
    
    public Bmouaajm_Elemento obterLabelPrimeiraParteEndereco() {
        return body().procurarElemento(By.xpath("//p[contains(@mm-html , 'logradouro')]"));
    }
    
    public Bmouaajm_Elemento obterLabelSegundaParteEndereco() {
        return body().procurarElemento(By.xpath("//p[contains(@mm-html , 'bairro')]"));
    }
    
    public Bmouaajm_Elemento obterBotaoCadastrarDescricao() {
        return body().procurarElemento(By.id("btnCadastrarDescricao"));
    }
    
    public Bmouaajm_Elemento obterLabelBotaoCadastrarDescricao() {
        return body().procurarElemento(By.xpath("//button[@id='btnCadastrarDescricao']//span"));
    }
    
    public Bmouaajm_Elemento obterBotaoEditarDescricao() {
        return body().procurarElemento(By.id("iconeEditarDescricao"));
    }

    public Bmouaajm_Elemento obterBotaoFinalizarCadastro() {
        return body().procurarElemento(By.id("bagBtnPrimarioConfirmarPerfil"));
    }
            
    public Bmouaajm_Elemento obterBotaoCadastrarRedesSociais() {
        return body().procurarElemento(By.id("btnCadastrarRedesSociais"));
    }
    
    public Bmouaajm_Elemento obterBotaoEditarRedesSociais() {
        return body().procurarElemento(By.id("iconeEditarRedesSociais"));
    }

    public Bmouaajm_Elemento obterBotaoEditarCategoria() {
        return body().procurarElemento(By.id("iconeEditarCategoria"));
    }
}
