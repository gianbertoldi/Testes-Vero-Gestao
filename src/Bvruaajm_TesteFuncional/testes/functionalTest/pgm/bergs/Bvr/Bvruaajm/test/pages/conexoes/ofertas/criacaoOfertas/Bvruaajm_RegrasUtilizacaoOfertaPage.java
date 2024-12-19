package bergs.Bvr.Bvruaajm.test.pages.conexoes.ofertas.criacaoOfertas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_RegrasUtilizacaoOfertaPage extends Bmouaajm_PaginaBase {
    
    private Bvruaajm_Esperas esperas;

    public Bvruaajm_RegrasUtilizacaoOfertaPage(AppiumDriver<WebElement> driver) {
        super(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }

    public Bmouaajm_Elemento obterTitulo() {
        return body().procurarElemento(By.xpath("//*[@id='bagTelaRegras']/h1"));
    }

    public Bmouaajm_Elemento obrterSubtitulo() {
        return body().procurarElemento(By.xpath("//*[@id='bagTelaRegras']/p"));
    }

   public Bmouaajm_Elemento obterLabelDiasSemana(String dia) {
       return body().procurarElemento(By.xpath("//button[text() = '"+dia+"']"));
   }
    
    public Bmouaajm_Elemento obterBotaoQuandoTodosDias() {
        return body().procurarElemento(By.xpath("//button[@data-value='todos']"));
    }
    

    public Bmouaajm_Elemento obterBotaoQuandoSegunda() {
        return body().procurarElemento(By.xpath("//button[@data-value='segunda']"));
    }

    public Bmouaajm_Elemento obterBotaoQuandoTerca() {
        return body().procurarElemento(By.xpath("//button[@data-value='terca']"));
    }

    public Bmouaajm_Elemento obterBotaoQuandoQuarta() {
        return body().procurarElemento(By.xpath("//button[@data-value='quarta']"));
    }

    public Bmouaajm_Elemento obterBotaoQuandoQuinta() {
        return body().procurarElemento(By.xpath("//button[@data-value='quinta']"));
    }

    public Bmouaajm_Elemento obterBotaoQuandoSexta() {
        return body().procurarElemento(By.xpath("//button[@data-value='sexta']"));
    }

    public Bmouaajm_Elemento obterBotaoQuandoSabado() {
        return body().procurarElemento(By.xpath("//button[@data-value='sabado']"));
    }

    public Bmouaajm_Elemento obterBotaoQuandoDomingo() {
        return body().procurarElemento(By.xpath("//button[@data-value='domingo']"));
    }

    public WebElement obterPeriodoInicial() {
        return driver.findElement(By.id("bagHorarioInicio"));
    }

    public WebElement obterPeriodoFinal() {
        return driver.findElement(By.id("bagHorarioFinal"));
    }

    public Bmouaajm_Elemento obterFormaConsumoLocal() {
        return body().procurarElemento(By.xpath("//*[@data-value='consumo_local']"));
    }

    public Bmouaajm_Elemento obterFormaEntregre() {
        return body().procurarElemento(By.xpath("//*[@data-value='entrega']"));
    }

    public Bmouaajm_Elemento obterFormaRetirada() {
        return body().procurarElemento(By.xpath("//*[@data-value='retirada']"));
    }

    public Bmouaajm_Elemento obterInclusoBebidas() {
        return body().procurarElemento(By.xpath("//*[@data-value='inclui_bebida']"));
    }

    public Bmouaajm_Elemento obterInclusoCouvert() {
        return body().procurarElemento(By.xpath("//*[@data-value='inclui_couvert_artistico']"));
    }

    public Bmouaajm_Elemento obterInclusoSobremesas() {
        return body().procurarElemento(By.xpath("//*[@data-value='inclui_sobremesa']"));
    }

    public Bmouaajm_Elemento obterInclusoTaxasServicos() {
        return body().procurarElemento(By.xpath("//*[@data-value='inclui_taxa_servico']"));
    }

    public Bmouaajm_Elemento obterOutroOfertas() {
        return body().procurarElemento(By.xpath("//*[@data-value='valido_outras_ofertas']"));
    }

    public Bmouaajm_Elemento obterOutroFeriados() {
        return body().procurarElemento(By.xpath("//*[@data-value='valido_feriado']"));
    }
    
    public Bmouaajm_Elemento obterSpamHorario() {
        return body().procurarElemento(By.id("bagMensagemHorario"));
    }
    
    public Bmouaajm_Elemento obterBotaoHoraInicial() {
        return body().procurarElemento(By.id("bagHorarioInicio"));
    }
    
    public Bmouaajm_Elemento obterBotaoHoraFinal() {
        return body().procurarElemento(By.id("bagHorarioFinal"));
    }
    
    public WebElement obterPonteiro(String ponteiro) {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@content-desc, '"+ponteiro+"')]"));
    }
        
    public WebElement obterBotaoSetRelogio() {
        return esperas.visibilidadeDoElemento(By.xpath("//*[contains(@resource-id, 'button1')]"));
    }
    
    public WebElement obterBotaoPmRelogio() {
        return esperas.visibilidadeDoElemento(By.xpath("//android.widget.TimePicker//android.widget.RadioButton[2]"));
    }
    
    public WebElement obterBotaoAmRelogio() {
        return esperas.visibilidadeDoElemento(By.xpath("//android.widget.TimePicker//android.widget.RadioButton[1]"));
    }    
    
    public Bmouaajm_Elemento obterTooltip() {
        return body().procurarElemento(By.id("bagIconeComToolTip"));
    }
    
}
