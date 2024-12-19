package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.edicaoOferta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_EdicaoOfertaPage extends  Bmouaajm_PaginaBase{

    public Bvruaajm_EdicaoOfertaPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento labelTitulo() {
        return body().procurarElemento(By.xpath("//p[@mm-html='titulo']"));
    }
    
    public Bmouaajm_Elemento labelSubtitulo() {
        return body().procurarElemento(By.xpath("//p[@mm-html='subtitulo']"));
    }
    
    public Bmouaajm_Elemento cmapoDeTextoNome() {
        return body().procurarElemento(By.id("bagNomeOferta"));
    }
    
    public Bmouaajm_Elemento campoDeTextoDescricao() {
        return body().procurarElemento(By.id("bagDescOferta"));
    }
    
    public Bmouaajm_Elemento botaoSalvar() {
        return body().procurarElemento(By.id("bagBtnCadastroAvancar"));
    }
    
    public Bmouaajm_Elemento labelTituloRegras() {
        return body().procurarElemento(By.xpath("//div[@id='bagTelaRegras']//h1"));
    }
    
    public Bmouaajm_Elemento labelSubtituloRegras() {
        return body().procurarElemento(By.xpath("//div[@id='bagTelaRegras']//p"));
    }
    
    public Bmouaajm_Elemento obterLabelDiasSemana(String dia) {
        return body().procurarElemento(By.xpath("//button[text() = '"+dia+"']"));
    }
    
    public Bmouaajm_Elemento obterBotaoQuandoTodosDias() {
        return body().procurarElemento(By.xpath("//button[@data-value='todos']"));
    }
    
    public Bmouaajm_Elemento obterBotaoAlteraImagem() {
        return body().procurarElemento(By.id("bagBtnImagemPrimario"));
    }
    
    public Bmouaajm_Elemento obterTituloImagem() {
        return body().procurarElemento(By.xpath("//div[@id='bagTelaImagem']//h1"));
    }
    
    public Bmouaajm_Elemento obterSubTituloImagem() {
        return body().procurarElemento(By.xpath("//div[@id='bagTelaImagem']//p"));
    }
    
    public Bmouaajm_Elemento labelTituloDiasDaOferta() {
        return body().procurarElemento(By.xpath("//div[@id='bagTelaRegras']/h1"));
    }
    
    public Bmouaajm_Elemento labelSubtituloDiasDaOferta() {
        return body().procurarElemento(By.xpath("//div[@id='bagTelaRegras']/p"));
    }
}
