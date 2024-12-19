package bergs.Bvr.Bvruaajm.test.pages.mm.gestao;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_ConsolidadoAppMMPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_ConsolidadoAppMMPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return false;
    }

    public Bmouaajm_Elemento obterRadioData() {
        return body().procurarElemento(By.id("rdFiltroData"));
    }
    
    public Bmouaajm_Elemento obterRadioMesAno() {
        return body().procurarElemento(By.id("rdFiltroMes"));
    }
    
    public Bmouaajm_Elemento obterInputData() {
        return body().procurarElemento(By.id("txtFiltroDataEvento"));
    }
    
    public Bmouaajm_Elemento obterSelecaoMesAno() {
        return body().procurarElemento(By.id("cmbMesAno"));
    }
    
    public Bmouaajm_Elemento obterTotalEstabelecimentosDistintos() {
        return body().procurarElemento(By.id("total_de_estabelecimentos_distintos"));
    }
    
    public Bmouaajm_Elemento obterTotalUsuariosDistintos() {
        return body().procurarElemento(By.id("total_usu"));
    }
    
    public Bmouaajm_Elemento obterTotalAcessos() {
        return body().procurarElemento(By.id("total_acesso"));
    }
}
