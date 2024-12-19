package bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_CriacaoPerfilSucessoPage extends Bmouaajm_PaginaBase {

    public Bvruaajm_CriacaoPerfilSucessoPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterIcone() {
        return body().procurarElemento(By.xpath("//ds-icon[@name='schedule']"));
    }
    
    public Bmouaajm_Elemento obterLabelTitulo() {
        return body().procurarElemento(By.xpath("//*[@id='bagSucessoCriacao']//h2"));
    }
    
    public Bmouaajm_Elemento obterLabelMensagem() {
        return body().procurarElemento(By.xpath("//*[@id='bagSucessoCriacao']//p"));
    }
    
    public Bmouaajm_Elemento obterBotaoCadastrarOferta() {
        return body().procurarElemento(By.id("bagBtnCadastrarOfertaAgora"));
    }
    
    public Bmouaajm_Elemento obterBotaoIrParaHome(){
        return body().procurarElemento(By.id("bagBtnIrParaPrograma"));
    }
}
