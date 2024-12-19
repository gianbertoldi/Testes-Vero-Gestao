package bergs.Bvr.Bvruaajm.test.pages.mm.produtos.linkPgto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_GerenciaLimiteLinkPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_GerenciaLimiteLinkPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return false;
    }

    public Bmouaajm_Elemento obterInputCpfCnpjEc() {
        return body().procurarElemento(By.id("txtFiltroCpfCnpjEc"));
    }
    
    public Bmouaajm_Elemento obterBotaoConsultar() {
        return body().procurarElemento(By.id("btnConsultarFiltro"));
    }
    
    public Bmouaajm_Elemento obterBotaoEditar() {
        return body().procurarElemento(By.id("btnEditarFiltro"));
    }
    
    public Bmouaajm_Elemento obterBotaoSalvarAlteracao() {
        return body().procurarElemento(By.id("btnSalvarFiltro"));
    }
    
    public Bmouaajm_Elemento obterInputValorMaxCriacaoLink() {
        return body().procurarElemento(By.id("inputValorMaximoLink"));
    }
    
    public Bmouaajm_Elemento obterTabelaHistoricoAlteracao() {
        return body().procurarElemento(By.id("lstHistoricoLimiteLink"));
    }
    
    public List<Bmouaajm_Elemento> obterColunasPrimeiraLinhaTabela() {
        return body().procurarElementos(By.xpath("//table[@id='lstHistoricoLimiteLink']/tbody/tr[1]/td"));
    }
    
    public List<Bmouaajm_Elemento> obterLinhasTabela() {
        return body().procurarElementos(By.xpath("//table[@id='lstHistoricoLimiteLink']/tbody/tr"));
    }
    
    public Bmouaajm_Elemento obterTextoTotalRegistroTabela() {
        return body().procurarElemento(By.xpath("//table[@id='lstHistoricoLimiteLink']/tfoot//div[@class='DivEsq']"));
    }
    
    public Bmouaajm_Elemento obterBotaoPrimeiraPagTabela() {
        return body().procurarElemento(By.xpath("//table[@id='lstHistoricoLimiteLink']/tfoot//div[contains(@class,'btnPagPrimeira')]"));
    }
    
    public Bmouaajm_Elemento obterBotaoPagAnteriorTabela() {
        return body().procurarElemento(By.xpath("//table[@id='lstHistoricoLimiteLink']/tfoot//div[contains(@class,'btnPagAnterior')]"));
    }
    
    public Bmouaajm_Elemento obterBotaoPagProximaTabela() {
        return body().procurarElemento(By.xpath("//table[@id='lstHistoricoLimiteLink']/tfoot//div[contains(@class,'btnPagProxima')]"));
    }
    
    public Bmouaajm_Elemento obterBotaoUltimaPagTabela() {
        return body().procurarElemento(By.xpath("//table[@id='lstHistoricoLimiteLink']/tfoot//div[contains(@class,'btnPagUltima')]"));
    }
}
