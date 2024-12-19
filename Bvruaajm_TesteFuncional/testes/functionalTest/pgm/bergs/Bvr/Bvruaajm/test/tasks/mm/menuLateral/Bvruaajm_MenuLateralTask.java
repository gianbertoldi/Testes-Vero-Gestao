package bergs.Bvr.Bvruaajm.test.tasks.mm.menuLateral;

import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.Bvr.Bvruaajm.test.pages.mm.menuLateral.Bvruaajm_MenuLateralMMPage;
import bergs.bmo.bmouaajm.suporte.tasks.Bmouaajm_TaskBase;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Frame;

public class Bvruaajm_MenuLateralTask extends Bmouaajm_TaskBase {
    
    protected Bmouaajm_Frame frame;
    Bvruaajm_MenuLateralMMPage menuLateral;
    
    public Bvruaajm_MenuLateralTask(RemoteWebDriver driver) {
        super(driver);
        frame = new Bmouaajm_Frame(driver);
        menuLateral = new Bvruaajm_MenuLateralMMPage(driver);
    }

    public void acessarMenuGestaoAnaliseEventos() {
        frame.menuSuperior();
        menuLateral.obterBotaoGestao().clicar();
        menuLateral.obterBotaoGestaoAnaliseEventos().clicar();
        frame.conteudoPrincipal();
    }
    
    public void acessarMenuGestaoResumoEventos() {
        frame.menuSuperior();
        menuLateral.obterBotaoGestao().clicar();
        menuLateral.obterBotaoGestaoResumoEventos().clicar();
        frame.conteudoPrincipal();
    }
    
    public void acessarMenuProdutoVeroXWalletGerarQrCode() {
        frame.menuSuperior();
        menuLateral.obterBotaoProduto().clicar();
        menuLateral.obterBotaoProdutosVeroXWallet().clicar();
        menuLateral.obterBotaoProdutoVeroXWalletGerarQrCode().clicar();
        frame.conteudoPrincipal();
    }
    
    public void acessarMenuGestaoConsolidadoApp() {
        frame.menuSuperior();
        menuLateral.obterBotaoGestao().clicar();
        menuLateral.obterBotaoGestaoConsolidadoApp().clicar();
        frame.conteudoPrincipal();
    }
    
    public void acessarMenuProdutoLinkDadosCriacao() {
        frame.menuSuperior();
        menuLateral.obterBotaoProduto().clicar();
        menuLateral.obterBotaoProdutoLinkPgto().clicar();
        menuLateral.obterBotaoDadosCriacaoLinkPgto().clicar();
        frame.conteudoPrincipal();
    }
    
    public void acessarMenuProdutoLinkDadosTransacao() {
        frame.menuSuperior();
        menuLateral.obterBotaoProduto().clicar();
        menuLateral.obterBotaoProdutoLinkPgto().clicar();
        menuLateral.obterBotaoDadosTransacaoLinkPgto().clicar();
        frame.conteudoPrincipal();
    }
    
    public void acessarMenuProdutoLinkGerenciaLimite() {
        frame.menuSuperior();
        menuLateral.obterBotaoProduto().clicar();
        menuLateral.obterBotaoProdutoLinkPgto().clicar();
        menuLateral.obterBotaoGerenciaLimiteLinkPgto().clicar();
        frame.conteudoPrincipal();
    }
}
