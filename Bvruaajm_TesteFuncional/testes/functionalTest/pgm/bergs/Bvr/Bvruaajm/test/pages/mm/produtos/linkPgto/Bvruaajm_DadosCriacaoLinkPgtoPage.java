package bergs.Bvr.Bvruaajm.test.pages.mm.produtos.linkPgto;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_DadosCriacaoLinkPgtoPage extends Bmouaajm_PaginaBase{

    public Bvruaajm_DadosCriacaoLinkPgtoPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean estaPronto() {
        return false;
    }

    public Bmouaajm_Elemento obterInputTipoEcPF() {
        return body().procurarElemento(By.id("txtFiltroTipoEcPf"));
    }
    
    public Bmouaajm_Elemento obterInputTipoEcPJ() {
        return body().procurarElemento(By.id("txtFiltroTipoEcPj"));
    }
    
    public Bmouaajm_Elemento obterInputTipoEcTodos() {
        return body().procurarElemento(By.id("txtFiltroTipoEcTodos"));
    }
    
    public Bmouaajm_Elemento obterInputTextCpfCnpjEc() {
        return body().procurarElemento(By.id("txtFiltroCpfCnpjEc"));
    }
    
    public Bmouaajm_Elemento obterInputTextCpfUserApp() {
        return body().procurarElemento(By.id("txtFiltroCpfUsuario"));
    }
    
    public Bmouaajm_Elemento obterRadioDataCriacao() {
        return body().procurarElemento(By.id("rdFiltroData"));
    }
    
    public Bmouaajm_Elemento obterCampoDataCriacao() {
        return body().procurarElemento(By.id("txtFiltroData"));
    }
    
    public Bmouaajm_Elemento obterRadioPeriodoMes() {
        return body().procurarElemento(By.id("rdFiltroMes"));
    }
    
    public Bmouaajm_Elemento obterComboMesInicio() {
        return body().procurarElemento(By.id("cmbMesDe"));
    }
    
    public Bmouaajm_Elemento obterComboMesFim() {
        return body().procurarElemento(By.id("cmbMesAte"));
    }
    
    public Bmouaajm_Elemento obterComboAnoInicio() {
        return body().procurarElemento(By.id("cmbAnoDe"));
    }
    
    public Bmouaajm_Elemento obterComboAnoFim() {
        return body().procurarElemento(By.id("cmbAnoAte"));
    }
    
    public Bmouaajm_Elemento obterCheckStatusLinkTodos() {
        return body().procurarElemento(By.id("cbFiltroStatusLinkTodos"));
    }
    
    public Bmouaajm_Elemento obterCheckStatusLinkVariado(String status) {
        return body().procurarElemento(By.id("cbFiltroStatus" + status));
    }
    
    public Bmouaajm_Elemento obterCheckStatusLinkAtivo() {
        return body().procurarElemento(By.id("cbFiltroStatusAtivo"));
    }
    
    public Bmouaajm_Elemento obterCheckStatusLinkPago() {
        return body().procurarElemento(By.id("cbFiltroStatusPago"));
    }
    
    public Bmouaajm_Elemento obterCheckStatusLinkCancelado() {
        return body().procurarElemento(By.id("cbFiltroStatusCancelado"));
    }
    
    public Bmouaajm_Elemento obterCheckStatusLinkExpirado() {
        return body().procurarElemento(By.id("cbFiltroStatusExpirado"));
    }
    
    public Bmouaajm_Elemento obterCheckStatusLinkBloqueado() {
        return body().procurarElemento(By.id("cbFiltroStatusBloqueado"));
    }
    
    public Bmouaajm_Elemento obterComboFormaPgto() {
        return body().procurarElemento(By.id("txtFiltroFormaDePagamento"));
    }
    
    public Bmouaajm_Elemento obterComboNroParcelas() {
        return body().procurarElemento(By.id("txtFiltroNumeroDeParcelas"));
    }
    
    public Bmouaajm_Elemento obterBotaoPesquisar() {
        return body().procurarElemento(By.id("btnPesquisarFiltro"));
    }
    
    public Bmouaajm_Elemento obterBotaoLimpar() {
        return body().procurarElemento(By.id("btnLimparFiltroFiltro"));
    }
    
    public Bmouaajm_Elemento obterTextTotalLinks() {
        return body().procurarElemento(By.id("totalDeLinks"));
    }
    
    public Bmouaajm_Elemento obterTextTotalValor() {
        return body().procurarElemento(By.id("valorTotal"));
    }
    
}
