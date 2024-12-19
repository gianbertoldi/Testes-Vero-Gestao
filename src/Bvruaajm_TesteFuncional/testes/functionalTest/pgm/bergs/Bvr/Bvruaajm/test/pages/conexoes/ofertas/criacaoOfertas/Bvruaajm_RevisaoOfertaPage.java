package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_RevisaoOfertaPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_RevisaoOfertaPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterImagemCabecalho() {
        return body().procurarElemento(By.id("bagImagemOferta"));
    }

    public Bmouaajm_Elemento obterNomeOferta() {
        return body().procurarElemento(By.xpath("//*[@mm-html='nome']"));
    }

    public Bmouaajm_Elemento obterIconeEc() {
        return body().procurarElemento(By.id("bagConfirmacaoLogo"));
    }

    public Bmouaajm_Elemento obterLabelValorAnterior() {
        return body().procurarElemento(By.className("ds-u-label-medium-sub-normal"));
    }

    public Bmouaajm_Elemento obterLabelValorDepois() {
        return body().procurarElemento(By.xpath("//p[contains (@mm-html, 'R$ {@valor_para}' )]"));
    }

    public Bmouaajm_Elemento obterDiaDaSemana(String diaSemana) {
        return body().procurarElemento(By.xpath("//div[contains (@mm-class , '" + diaSemana + "')]"));
    }

    public Bmouaajm_Elemento obterLabelHorario() {
        return body().procurarElemento(By.xpath("//p[@class='ds-u-text-medium-normal']"));
    }

    public Bmouaajm_Elemento obterLabelDescricao() {
        return body().procurarElemento(By.xpath("//p[@mm-html='desc_oferta']"));
    }

    public Bmouaajm_Elemento obterLabelRegrasValidas() {
        return body().procurarElemento(By.xpath("(//ul[@id='bagListaRegrasOferta']/li)[1]"));
    }

    public Bmouaajm_Elemento obterLabelRegrasNaoInclui() {
        return body().procurarElemento(By.xpath("(//*[@mm-html='texto' and contains(text() , 'Não') ])[1]"));
    }

    public Bmouaajm_Elemento obterLabelRegrasNaoIncluiDetalhes() {
        return body().procurarElemento(By.xpath("(//*[@mm-html='valor' and contains(text() , 'Não') ])[1]"));
    }
    
    public Bmouaajm_Elemento obterLabelRegrasItensInclusos() {
        return body().procurarElemento(By.xpath("//*[@mm-html='texto' and contains(text() , 'Inclui')]"));
    }

    public Bmouaajm_Elemento obterLabelRegrasOutros() {
        return body().procurarElemento(By.xpath("(//li[contains(text() , 'válida') or contains(text() , 'Válida')])[1]"));
    }

    public Bmouaajm_Elemento obterLabelRegrasOutrosSegundoTexto() {
        return body().procurarElemento(By.xpath("(//li[contains(text() , 'válida') or contains(text() , 'Válida')])[2]"));
    }
    
    public Bmouaajm_Elemento obterLabelRegrasValidasDetalhes() {
        return body().procurarElemento(By.xpath("(//ul[@id='bagListaRegrasDetalheOferta']/li)[1]"));
    }
   
    public Bmouaajm_Elemento obterListaRegras() {
        return body().procurarElemento(By.id("bagListaRegrasOferta"));
    }

    public Bmouaajm_Elemento obterLabelTextoInformativo() {
        return body().procurarElemento(By.xpath("//p[contains(@class, 'ds-u-text-medium-normal bvr-ds2-margin-bottom-24')]"));
    }
    
    public Bmouaajm_Elemento obterLabelDataCriacao() {
        return body().procurarElemento(By.xpath("//div[@id='bagDadosStatusOferta']//p[2]"));
    }
    
    public Bmouaajm_Elemento obterLabelDataExpiracao() {
        return body().procurarElemento(By.xpath("//*[contains(@mm-html, 'Essa oferta irá expirar')]"));
    }
    
    public Bmouaajm_Elemento obterLabelDataExpirada() {
        return body().procurarElemento(By.xpath("//*[contains(@mm-html, 'Expirada')]"));
    }
    
    public Bmouaajm_Elemento obterLabelDataDesativacao() {
        return body().procurarElemento(By.xpath("//*[contains(@mm-html, 'Desativada')]"));

    }
 
    public Bmouaajm_Elemento obterIconeEdicaoDosCampos(String iconeEdicaoTexto) {
        return  body().procurarElemento(By.xpath("//ds-icon[contains(@onclick , '"+ iconeEdicaoTexto +"')]"), Duration.ofMillis(30));
    }
    
    public Bmouaajm_Elemento obterBotaoDesativarOferta() {
        return body().procurarElemento(By.xpath("//a[@class='bag-flex bag-flex-alinhar-verticalmente ds-u-label-medium-action   ']"));
    }
    
    public Bmouaajm_Elemento obterBotaoConfirmarDesativar() {
        return body().procurarElemento(By.xpath("//ds-button[@label='Sim, desativar']"));
    }
    
    public Bmouaajm_Elemento obterBotaoEditarValorDaOferta() {
        return body().procurarElemento(By.xpath("//ds-icon[contains(@onclick, 'oBvrsoeha_CadastroOferta.ETAPA.VALOR')]"));
    }
    
    public Bmouaajm_Elemento obterBotaoEditarImagem() {
        return body().procurarElemento(By.id("bagImagemOferta"));
    }
}
