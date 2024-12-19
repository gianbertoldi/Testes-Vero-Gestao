package bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_FotoPerfilPage extends Bmouaajm_PaginaBase{

    
    public Bvruaajm_FotoPerfilPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }
    
    @Override
    public boolean estaPronto() {
        return true;
    }
    
    public Bmouaajm_Elemento obterLabelTitulo() {
        return body().procurarElemento(By.xpath("//div[@id = 'bagSelecaoImagem']//h2"));
    }
    
    public Bmouaajm_Elemento obterLabelSubtitulo() {
        return body().procurarElemento(By.xpath("//div[@id = 'bagSelecaoImagem']//p"));
    }
    
    public Bmouaajm_Elemento obterIcone() {
        return body().procurarElemento(By.id("bagImgLogoPadrao"));
    }
    
    public Bmouaajm_Elemento obterBotaoPularEtapa() {
        return body().procurarElemento(By.id("bagBtnSecundarioSelecionarImagem"));
    }
}