package bergs.Bvr.Bvruaajm.test.pages.mm.gestao;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_ConsultaResumoDeEventosMMPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_ConsultaResumoDeEventosMMPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override   
    protected boolean estaPronto() {
        return false;
    }

    public Bmouaajm_Elemento obterInputDataInicial() {
        return body().procurarElemento(By.id("txtFiltroDataEventoIni"));
    }
    
    public Bmouaajm_Elemento obterInputDataFinal() {
        return body().procurarElemento(By.id("txtFiltroDataEventoFim"));
    }
    
    public List<Bmouaajm_Elemento> obterListaResumoDeEventos() {
        return body().procurarElementos(By.xpath("//table[@id='lstEvento']//tbody//tr"));
    }
    
    public List<Bmouaajm_Elemento> obterLinahaDaTabelaResumoDeEventos(String linha) {
        return body().procurarElementos(By.xpath("//table[@id='lstEvento']//tbody//tr[" + linha +"]//td"));
    }
}
