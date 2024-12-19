package bergs.Bvr.Bvruaajm.test.pages.servicos.simulador;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_SimuladorPage extends Bmouaajm_PaginaBase {
    
    public Bvruaajm_SimuladorPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterCampoValorSimulador() {
        return body().procurarElemento(By.id("txt-simulador-valor"));
    }
    
    public Bmouaajm_Elemento obterCampoEscolherBandeira() {
        return body().procurarElemento(By.id("simulador-bandeira-fechado"));
    }
    
    public List<Bmouaajm_Elemento> obterListaTipoBandeira() {
        return body().procurarElementos(By.xpath("//ul[@id='lista-bandeiras-simulador']/li"));
    }
    
    public Bmouaajm_Elemento obterModalidadeDePagamento() {
        return body().procurarElemento(By.id("simulador-modalidade-fechado"));
    }
    
    public List<Bmouaajm_Elemento> obterListaTipoPagemento() {
        return body().procurarElementos(By.xpath("//ul[@id='lista-modalidade-simulador']/li"));
    }
    
    public Bmouaajm_Elemento obterCalcularSimulacao() {
        return body().procurarElemento(By.id("simulador-calcular"));
    }
    
    public Bmouaajm_Elemento obterVouReceber() {
        return body().procurarElemento(By.id("simulador-valor-recebe"));
    }
    
    public Bmouaajm_Elemento obterValorCliente() {
        return body().procurarElemento(By.id("simulador-valor-venda"));
    }
    
    public Bmouaajm_Elemento obterBotaoQueroReceberValorIntegral() {
        return body().procurarElemento(By.id("bvr-sv-switch"));
    }
    
    public Bmouaajm_Elemento obterQuantidadeParcelamento() {
        return body().procurarElemento(By.id("simulador-parcela-fechado"));
    }
    
    public List<Bmouaajm_Elemento> obterListaQuantidadeParcelamento() {
        return body().procurarElementos(By.xpath("//ul[@id='lista-parcela-simulador']/li"));
    }
    
    public Bmouaajm_Elemento obterQuantidadeParcelasResumo() {
        return body().procurarElemento(By.id("simulador-resultado-parcelas-quantidade"));
    }
    
    public Bmouaajm_Elemento obterValorDaParcelaResumo() {
        return body().procurarElemento(By.id("simulador-resultado-parcelas-valor"));
    }
    
    public Bmouaajm_Elemento obterDemaisParcelasResumo() {
        return body().procurarElemento(By.id("simulador-resultado-mais-parcelas"));
    }
    
    public List<Bmouaajm_Elemento> obterUltimaParcelaResumo() {
        return body().procurarElementos(By.xpath("//ul[@id='simulador-resultado-parcelas-lista']/li"));
    }
    
    public Bmouaajm_Elemento obterMsgErroValor() {
        return body().procurarElemento(By.xpath("//div[@id='container-simulador-valor']/span[@class='mensagem-erro']"));
    }
    public Bmouaajm_Elemento obterBotaoNovaSimulacao() {
        return body().procurarElemento(By.id("simulador-nova"));
    }
    
    public Bmouaajm_Elemento obterTextoEscolhaBandeira() {
        return body().procurarElemento(By.xpath("//div[@id='simulador-bandeira-fechado']/div[@class='bvr-accordion-fechado-titulo']"));
    }
    
    public Bmouaajm_Elemento obterExibirMaisMenosParcelas() {
        return body().procurarElemento(By.id("simulador-resultados-mais-menos"));
    }
    
    public List<Bmouaajm_Elemento> obterQuantidadeParcelas() {
        return body().procurarElementos(By.xpath("//ul[@id='simulador-resultado-parcelas-lista']/li"));
    }

    public Bmouaajm_Elemento obterIconeInfoCreditoParceladoLojista() {
        return body().procurarElemento(By.id("info-modalidade-28"));
    }
    
    public Bmouaajm_Elemento obterSubTituloModalidade() {
        return body().procurarElemento(By.xpath("//div[@id='simulador-modalidade-fechado']/div[contains(@class,'bvr-accordion-fechado-valor')]"));
    }
    
    public WebElement obtersDisponabilidadeModalidadeLiberada(String localLista) {
        return driver.findElement(By.xpath("//ul[@id='lista-modalidade-simulador']/li[" + localLista +"]//input"));
    }
    
    public WebElement obtersDisponabilidadeDeParcelas(String localLista) {
        return driver.findElement(By.xpath("//ul[@id='lista-parcela-simulador']/li["+ localLista +"]"));
    }
}
