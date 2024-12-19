package bergs.Bvr.Bvruaajm.test.pages.mm.gestao;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_ConsultaAcessosPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_ConsultaAcessosPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return false;
    }

    public Bmouaajm_Elemento obterSelecionartFiltroEvento() {
        return body().procurarElemento(By.id("cmbFiltroTipoEvento"));
    }
    
    public Bmouaajm_Elemento obterTipoLojistaConveniado() {
        return body().procurarElemento(By.id("txtFiltroTipoLojista_1"));
    }
    
    public Bmouaajm_Elemento obterTipoLojistaEstabelecimento() {
        return body().procurarElemento(By.id("txtFiltroTipoLojista_2"));
    }
    
    public Bmouaajm_Elemento obterTipoLojistaAmbos() {
        return body().procurarElemento(By.id("txtFiltroTipoLojista_3"));
    }
    
    public Bmouaajm_Elemento obterTipoPessoaFisica() {
        return body().procurarElemento(By.id("txtFiltroTipoPessoaEstab_1"));
    }
    
    public Bmouaajm_Elemento obterTipoPessoaJuridica() {
        return body().procurarElemento(By.id("txtFiltroTipoPessoaEstab_2"));
    }
    
    public Bmouaajm_Elemento obterInputCpfLojista() {
        return body().procurarElemento(By.id("txtFiltroCpfEstab"));
    }
    
    public Bmouaajm_Elemento obterInputCnpjLojista() {
        return body().procurarElemento(By.id("txtFiltroCnpjEstab"));
    }
    
    public Bmouaajm_Elemento obterInputCpfUsuario() {
        return body().procurarElemento(By.id("txtFiltroCpfOperador"));
    }
    
    public Bmouaajm_Elemento obterInputDataInicial() {
        return body().procurarElemento(By.id("txtFiltroDataEventoIni"));
    }
    
    public Bmouaajm_Elemento obterInputDataFinal() {
        return body().procurarElemento(By.id("txtFiltroDataEventoFim"));
    }
    
    public Bmouaajm_Elemento obterTextoTituloPaginaFiltrosAcesso() {
        return body().procurarElemento(By.xpath("//div[@id='containerFiltro']//div[@class='boxdados_title_texto']"));
    }
}
