package bergs.Bvr.Bvruaajm.test.tasks.perfil;

import java.util.List;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.perfil.Bvruaajm_PerfilPage;
import bergs.Bvr.Bvruaajm.test.pages.perfil.Bvruaajm_TaxasPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.perfil.Bvruaajm_TaxasValidations;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_TaxasTask extends Bvruaajm_TaskMobile {

    Bvruaajm_PerfilPage perfilPage;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_TaxasPage taxasPage;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_Esperas esperar;
    Bvruaajm_TaxasValidations taxasValidations;
    String naoAderiuLinkPgto = "Você ainda não aderiu ao Link de Pagamento :(";
    String tituloMaquininha = "Maquininha e outras soluções Vero";
    String tituloLink = "Link de Pagamento";
    String tituloPsr = "Outras maquininhas";

    public Bvruaajm_TaxasTask(AppiumDriver<WebElement> driver) {
        super(driver);
        perfilPage = new Bvruaajm_PerfilPage(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        taxasPage = new Bvruaajm_TaxasPage(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        esperar = new Bvruaajm_Esperas(driver);
        taxasValidations = new Bvruaajm_TaxasValidations(driver);
    }

    public void validaDuasLinhasTaxas(int bandeira, String metodoDePgtoUm, String metodoDePgtoDois) {
        inicioTaxasMaquininha(bandeira);
        taxasValidations.validarTaxasCartoes(bandeira, metodoDePgtoUm, metodoDePgtoDois);
    }

    public void validaOpcoesPgtoTaxas(int bandeira, String taxaDebito, String taxaCreditoVista, String taxaRePay,
            String taxaParceladoMenosSeisVezes, String taxaParceladoMaisSeisVezes, String taxaParceldoCliente) {
        inicioTaxasMaquininha(bandeira);
        List<Bmouaajm_Elemento> abrirChevron = taxasPage.obterAtivarChevron();
        abrirChevron.get((bandeira - 1)).clicar();
        taxasValidations.validarOpcoesPgto(bandeira, taxaDebito, taxaCreditoVista, taxaRePay, taxaParceladoMenosSeisVezes, taxaParceladoMaisSeisVezes,
                taxaParceldoCliente);
    }

    public void validarTaxasLinkPgto(int bandeira, String taxaDebito, String taxaCreditoVista,
            String taxaParceladoMenosSeisVezes, String taxaParceladoMaisSeisVezes) {
        inicioTaxasLinkPgto(bandeira);
        List<Bmouaajm_Elemento> abrirChevron = taxasPage.obterAtivarChevron();
        abrirChevron.get((bandeira - 1)).clicar();
        taxasValidations.validarOpcoesLinkPgto(bandeira, taxaDebito, taxaCreditoVista, taxaParceladoMenosSeisVezes, taxaParceladoMaisSeisVezes);
    }

    public void validaLinkNaoAderido() {
        perfilPage.obterTaxas().clicar();
        taxasPage.obterAreaTaxasLinkPgto().clicar();
        genericValidation.validarTextosEsperadoEAtual(naoAderiuLinkPgto, taxasPage.obterInfoAderirAoLinkPgtoTaxas().obterTexto());
        taxasPage.obterQueroAderirAoLinkPgto().clicar();
    }

    private void inicioTaxasLinkPgto(int bandeira) {
        acessarAreasDeTaxas();
        perfilPage.obterTaxas().clicar();
        taxasPage.obterAreaTaxasLinkPgto().clicar();
        esperar.aguardarTextoProcessandoDesaparecer();
        List<Bmouaajm_Elemento> tipoBandeira = taxasPage.obterTipoBandeira();
        jsExecutor.scrollIntoView(tipoBandeira.get(bandeira - 1));
    }

    private void inicioTaxasMaquininha(int bandeira) {
        acessarAreasDeTaxas();
        perfilPage.obterTaxas().clicar();
        taxasPage.obterAreaTaxasMaquininha().clicar();
        esperar.aguardarTextoProcessandoDesaparecer();
        List<Bmouaajm_Elemento> tipoBandeira = taxasPage.obterTipoBandeira();
        jsExecutor.scrollIntoView(tipoBandeira.get(bandeira - 1));
    }

    public void acessarAreasDeTaxas() {
        perfilPage.menuMeusNegocios().clicar();
    }

    public void validaTagsDeTaxaLinkEMaquininha() {
        acessarAreasDeTaxas();
        perfilPage.obterTaxas().clicar();
        taxasValidations.validaTextosMinhasTaxas();
    }

    public void validaCardOutrasCredenciadorasNaoAparece() {
        perfilPage.obterTaxas().clicar();
        genericValidation.validaElementoEstaInvisivel(taxasPage.obterCardTaxasPsr());
    }

    public void validaTaxasOutrasCredenciadoras(String taxaDebito, String preDatado, String taxaParceladoMenosSeisVezes,
            String taxaParceladoMaisSeisVezes) {
        perfilPage.obterTaxas().clicar();
        esperar.aguardarTextoProcessandoDesaparecer();
        taxasPage.obterAreaTaxasPsr().clicar();
        taxasValidations.validarOpcoesTaxasPsr(taxaDebito, preDatado, taxaParceladoMenosSeisVezes, taxaParceladoMaisSeisVezes);
    }

    public void validaCardMenuTaxas() {
        perfilPage.obterTaxas().clicar();
        esperar.aguardarTextoProcessandoDesaparecer();
        genericValidation.validarTextosEsperadoEAtual(tituloMaquininha, taxasPage.obterTituloCardMaquininha().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(tituloLink, taxasPage.obterTituloCardLink().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(tituloPsr, taxasPage.obterTituloCardPsr().obterTexto());
    }
}