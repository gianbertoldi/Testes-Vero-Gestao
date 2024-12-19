package bergs.Bvr.Bvruaajm.test.tasks.extrato;

import java.util.List;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.extrato.Bvruaajm_ExtratoMinhasVendasPage;
import bergs.Bvr.Bvruaajm.test.pages.extrato.Bvruaajm_MenuExtratoPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_MenuExtraroTask extends Bvruaajm_TaskMobile {

    Bvruaajm_MenuExtratoPage extratoPage;
    Bvruaajm_ExtratoMinhasVendasPage minhasVendasPage;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_Esperas esperas;
    String statusVenda = "Confirmada";
    String infoMdrDisponivelProximoDiaUtil = "Você poderá consultar aqui a taxa MDR e o valor a receber desta venda no próximo dia útil ;)";
    String textoMdr = "Taxa MDR";

    public Bvruaajm_MenuExtraroTask(AppiumDriver<WebElement> driver) {
        super(driver);
        extratoPage = new Bvruaajm_MenuExtratoPage(driver);
        minhasVendasPage = new Bvruaajm_ExtratoMinhasVendasPage(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        esperas = new Bvruaajm_Esperas(driver);
    }

    public void validaVendaConfirmaListaExtratoMenuExtrato(String dataFormatada, String nsuVenda) {
        extratoPage.obterMinhasVendas().clicar();
        minhasVendasPage.obterVendaNaListagemExtrato(dataFormatada, nsuVenda).clicar();
        genericValidation.validarTextosEsperadoEAtual(statusVenda, minhasVendasPage.obterStatusDaVenda().obterTexto());
    }

    public void validaInfoMdrDiponivelProximoDiaUtil(String dataFormatada, String nsuVenda) {
        extratoPage.obterMinhasVendas().clicar();
        procurarVendaNaListaComCarregamentoFinalDePagina(dataFormatada, nsuVenda);
        genericValidation.validarTextosEsperadoEContains(minhasVendasPage.obterInfoMdrDisponivelProximoDiaUtil().obterTexto(),
                infoMdrDisponivelProximoDiaUtil);
    }

    public void validaMdrDaVenda(String dataFormatada, String nsuVenda) {
        extratoPage.obterMinhasVendas().clicar();
        procurarVendaNaListaComCarregamentoFinalDePagina(dataFormatada, nsuVenda);
        genericValidation.validarTextosEsperadoEContains(minhasVendasPage.obterTextoTaxasMdr().obterTexto(),
                textoMdr);
    }

    private boolean procurarVendaNaLista(String dataFormatada, String nsuVenda) {
        try {
            return minhasVendasPage.obterVendaNaListagemExtrato(dataFormatada, nsuVenda).estaVisivel();
        } catch (Exception e) {
            return false;
        }
    }

    private void procurarVendaNaListaComCarregamentoFinalDePagina(String dataFormatada, String nsuVenda) {
        for (int i = 0; i <= 3; i++) {
            if (!procurarVendaNaLista(dataFormatada, nsuVenda)) {
                List<Bmouaajm_Elemento> lista = minhasVendasPage.obterLista();
                Bmouaajm_Elemento elementos = lista.get(lista.size() - 1);
                jsExecutor.scrollIntoView(elementos);
                esperas.aguardarPorcessandoFimDePaginaDesaparecer();
            } else {
                minhasVendasPage.obterVendaNaListagemExtrato(dataFormatada, nsuVenda).clicar();
                break;
            }
        }
    }
}
