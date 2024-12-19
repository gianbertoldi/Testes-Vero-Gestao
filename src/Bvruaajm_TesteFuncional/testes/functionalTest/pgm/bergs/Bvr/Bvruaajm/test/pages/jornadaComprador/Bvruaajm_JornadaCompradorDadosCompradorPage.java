package bergs.Bvr.Bvruaajm.test.pages.jornadaComprador;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_JornadaCompradorDadosCompradorPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_JornadaCompradorDadosCompradorPage(ChromeDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterCampoVendidoPorECPrimeiraTela() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-landing-page']//div[@class='spacer-8 ske-width-90 ske-margin-bottom-8']"));
    }
    
    public Bmouaajm_Elemento obterBotaoContinuarInicial() {
        return body().procurarElemento(By.xpath("//div[@id='bvr-landing-page']//button"));
    }
    
    public Bmouaajm_Elemento obterInputNomeComprador() {
        return body().procurarElemento(By.id("nome"));
    }
    
    public Bmouaajm_Elemento obterInputCpfComprador() {
        return body().procurarElemento(By.id("cpf"));
    }
    
    public Bmouaajm_Elemento obterInputCelularComprador() {
        return body().procurarElemento(By.id("celular"));
    }
    
    public Bmouaajm_Elemento obterInputEmailComprador() {
        return body().procurarElemento(By.id("email"));
    }
    
    public Bmouaajm_Elemento obterContinuarDadosPessoais() {
        return body().procurarElemento(By.id("continuarDadosPessoais"));
    }
}
