package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.homeOfertas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_HomeOfertasPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_HomeOfertasPage(AppiumDriver<WebElement>driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true; 
    }
    
    public Bmouaajm_Elemento obterIconeHomeVazia() { 
        return body().procurarElemento(By.className("bag-width10-5rem-auto"));
    }
    
    public Bmouaajm_Elemento obterLabelTituloHomeVazia() {
        return body().procurarElemento(By.xpath("//*[@id='bagHomeEC']/h1"));
    }
    
    public Bmouaajm_Elemento obterLabelSubtitulo() {
        return body().procurarElemento(By.xpath("//*[@id='bagHomeEC']/p"));
    }
    
    public Bmouaajm_Elemento obterBotaoOferta() {
        return body().procurarElemento(By.id("bag-home-vazia-oferta"));
    }
    
    public Bmouaajm_Elemento obterBotaoContinuar() {
        return body().procurarElemento(By.id("bagBtnCadastroAvancar"));
    } 
    
    public Bmouaajm_Elemento obterLabelUltimaOferta() {
        return body().procurarElemento(By.xpath("//div[contains(@class, 'bvr-ds2-margin-top-24')]/label"));
    }
    
    public Bmouaajm_Elemento obterLabelNomeEstabelecimento() {
        return body().procurarElemento(By.id("bagNomeFantasia"));
    }
    
    public Bmouaajm_Elemento obterCategoriaEstabelecimento() {
        return body().procurarElemento(By.xpath("//ds-tag[contains(@mm-label, 'dados_estab.cod')]"));
    }
    
    public Bmouaajm_Elemento obterLabelNomeOferta(){
        return body().procurarElemento(By.xpath("//div[contains(@class , 'bag-basic-card')]/span[1]"));
    }
    
    public Bmouaajm_Elemento obterLabelValoresDaOferta() {
        return body().procurarElemento(By.xpath("//div[contains(@class , 'bag-basic-card')]/span[2]"));
    }
    
    public Bmouaajm_Elemento obterLabelStatusOferta() {
        return body().procurarElemento(By.xpath("//ds-tag[@mm-label='status_oferta_formatado']"));
    }
    
    public Bmouaajm_Elemento obterDetalhesDaOferta() {
        return body().procurarElemento(By.xpath("//a[contains(@class, 'bag-flex')]"));
    }
    
    public Bmouaajm_Elemento obterImagemOferta() {
        return body().procurarElemento(By.xpath("//img[@mm-src ='imagem_oferta']"));
    }
    
    public Bmouaajm_Elemento obterCardNovaOferta() {
        return body().procurarElemento(By.id("btnCriarNovaOferta"));
    }
    
    public Bmouaajm_Elemento obterCardListaOfertas(String statusOferta) {
        return body().procurarElemento(By.xpath("(//*[@id='bagListasOfertas_"+statusOferta+"']//div)[1]"));
    }
    
    public Bmouaajm_Elemento obterLabelCardNomeOferta(String idOferta) {
        return body().procurarElemento(By.xpath("//div[contains(@id , '"+idOferta+"')]//span[contains(@id , 'bvr-card-selection-item__label')]"));
    }
    
    public Bmouaajm_Elemento obterLabelCardValoresOferta(String idOferta) {
        return body().procurarElemento(By.xpath("//div[contains(@id , '"+idOferta+"')]//span[contains(@id , 'bvr-card-selection-item__sublabel')]"));
    }
    
    public Bmouaajm_Elemento obterImagemCard(String idOferta) {
        return body().procurarElemento(By.xpath("//div[contains(@id , '"+idOferta+"')]//img[contains(@mm-src , 'srcImgEsq')]"));
    }
    
    public Bmouaajm_Elemento obterLabelCardStatusOferta() {
        return body().procurarElemento(By.xpath("(//section[@id='bagIdSessaoOfertasPorStatus']//label)[1]"));
    }
    
    public Bmouaajm_Elemento obterCardDesativadas() {
        return body().procurarElemento(By.id("btnTileDesativadas"));
    }
    
    public Bmouaajm_Elemento obterCardExpiradas() {
        return body().procurarElemento(By.id("btnTileExpiradas"));
    }
    
    public Bmouaajm_Elemento obterLabelExpiradas() {
        return body().procurarElemento(By.xpath("//label[contains(@mm-html , 'nome_status')]"));
    }
}
