package bergs.Bvr.Bvruaajm.test.tasks.perfilVendedor;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_PerfilVendedorPage;
import bergs.Bvr.Bvruaajm.test.pages.vender.Bvruaajm_LinkPagamentoPage;
import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_ElementoNativoTask;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.vender.Bvruaajm_ConsultaLinkPgtoValidation;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PerfilVendedorTask extends Bvruaajm_TaskMobile {

    Bvruaajm_PerfilVendedorPage perfilVendedorPage;
    Bvruaajm_LinkPagamentoPage linkPage;
    Bvruaajm_ConsultaLinkPgtoValidation consultaValidation;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_ElementoNativoTask nativeTask;
    String titulo = "Como você quer vender?";
    String semResultado = "Não existem resultados para esta pesquisa.";
    String formaPgto = "Link de Pagamento";
    
    public Bvruaajm_PerfilVendedorTask(AppiumDriver<WebElement> driver) {
        super(driver);
        perfilVendedorPage = new Bvruaajm_PerfilVendedorPage(driver);
        linkPage = new Bvruaajm_LinkPagamentoPage(driver);
        consultaValidation = new Bvruaajm_ConsultaLinkPgtoValidation(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        nativeTask = new Bvruaajm_ElementoNativoTask(driver);
    }
    
    public void clicarBotaoConsultarVendasPerfilVendedor() {
        perfilVendedorPage.obterBotaoConsultarVendas().clicar();
    }
    
    public void validaTituloPageReceberPagamento() {
        perfilVendedorPage.obterBotaoReceberPagamento().clicar();
        genericValidation.validarTextosEsperadoEAtual(titulo, perfilVendedorPage.obterTituloPageReceberPagamento().obterTexto());
    }

    public void acessarLinkPgtoPefilVendedor() {
        perfilVendedorPage.obterBotaoReceberPagamento().clicar();
        perfilVendedorPage.obterBotaoLinkPefilVendedor().clicar();
    }

    public void validarConsultaLinkCriadoOutroUserNoPerfilVendedor(String codLink) {
        linkPage.obterBotaoConsultarLinksCriados().clicar();
        consultaValidation.validaLinkPgtoNaoEstaVisivel(codLink);
    }
    
    public void validaResultadoPesquiisaConsultarVenda(String pesquisa) {
        clicarBotaoConsultarVendasPerfilVendedor();
        preencherPesquisaConsultaVendsas(pesquisa);
        genericValidation.validarTextosEsperadoEAtual(pesquisa, perfilVendedorPage.obterResultaDaPesquisaFiltro().obterTexto());
    }
    
    public void validaFiltroPesquisaSemResultados(String pesquisa) {
        clicarBotaoConsultarVendasPerfilVendedor();
        preencherPesquisaConsultaVendsas(pesquisa);
        genericValidation.validarTextosEsperadoEAtual(semResultado, perfilVendedorPage.obterTxtPesquisaSemResultado().obterTexto());
    }
    
    public void validaDetalhamentoDeVenda(String nome, String statos) {
        perfilVendedorPage.obterVendaConsultaVendasPerfilVendedor(nome).clicar();
        genericValidation.validarTextosEsperadoEAtual(statos, perfilVendedorPage.obterStatusDePgtoDetalhesConsultaPerfilVendesdor().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(formaPgto, perfilVendedorPage.obterTipoPgtoDetalhesConsultaPerfilVendesdor().obterTexto());
    }
    
    public void validaAtualizarListaVendasHoje(String nome, String statos) {
        perfilVendedorPage.obterBotaoAtualizarVendasHoje().clicar();
        validaDetalhamentoDeVenda(nome, statos);
    }
    
    private void preencherPesquisaConsultaVendsas(String pesquisa) {
        nativeTask.clicarBotaoDireito2();
        perfilVendedorPage.obterCaixaDeTextoConsultaVendas().preencherLento(pesquisa);
    }
}
