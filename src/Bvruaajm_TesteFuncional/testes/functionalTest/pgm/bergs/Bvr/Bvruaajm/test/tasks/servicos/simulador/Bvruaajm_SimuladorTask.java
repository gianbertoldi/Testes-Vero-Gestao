package bergs.Bvr.Bvruaajm.test.tasks.servicos.simulador;

import java.util.List;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.generic.Bvruaajm_GenericPage;
import bergs.Bvr.Bvruaajm.test.pages.home.Bvruaajm_HomePage;
import bergs.Bvr.Bvruaajm.test.pages.servicos.simulador.Bvruaajm_SimuladorPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_JsExecutor;
import bergs.Bvr.Bvruaajm.test.validations.Bvruaajm_GenericValidation;
import bergs.Bvr.Bvruaajm.test.validations.simulador.Bvruaajm_SimuladorValidation;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_SimuladorTask extends Bvruaajm_TaskMobile {

    Bvruaajm_HomePage homePage;
    Bvruaajm_SimuladorPage simuladorPage;
    Bvruaajm_GenericValidation genericValidation;
    Bvruaajm_GenericPage genericPage;
    Bvruaajm_JsExecutor jsExecutor;
    Bvruaajm_Esperas esperas;
    Bvruaajm_SimuladorValidation simuladorValidation;
    String erroValorSimulador = "O valor deve ser maior ou igual a R$ 1,00.";
    String ecolhaBandeira = "Escolha a bandeira";
    String creditoLojista = "Crédito parcelado lojista";
    String infoLogistaParcelado = "Nesta modalidade, o estabelecimento recebe o valor mês a mês conforme a quantidade de parcelas.";
    String cifraoAndesDoValor = "R$ ";

    public Bvruaajm_SimuladorTask(AppiumDriver<WebElement> driver) {
        super(driver);
        homePage = new Bvruaajm_HomePage(driver);
        simuladorPage = new Bvruaajm_SimuladorPage(driver);
        genericValidation = new Bvruaajm_GenericValidation(driver);
        jsExecutor = new Bvruaajm_JsExecutor(driver);
        genericPage = new Bvruaajm_GenericPage(driver);
        esperas = new Bvruaajm_Esperas(driver);
        simuladorValidation = new Bvruaajm_SimuladorValidation(driver);
    }

    public void clicarBotaoSimuladorCarrosselHome() {
        jsExecutor.scrollIntoView(homePage.obterBotaoSimuladorCarrossel());
        homePage.obterBotaoSimuladorCarrossel().clicar();
    }

    public void validaValorMinimo(double valor) {
        simuladorPage.obterCampoValorSimulador().preencherLento(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor));
        jsExecutor.removerFocusElementoAtual();
        genericValidation.validarTextosEsperadoEAtual(erroValorSimulador, simuladorPage.obterMsgErroValor().obterTexto());
    }

    public void validaNovaSimulacao(double valor, int tipoCartao, int tipoModalidade) {
        simuladorVenda(valor, tipoCartao, tipoModalidade);
        simuladorPage.obterCalcularSimulacao().clicar();
        simuladorPage.obterBotaoNovaSimulacao().clicar();
        genericValidation.validarTextosEsperadoEAtual(ecolhaBandeira, simuladorPage.obterTextoEscolhaBandeira().obterTexto());
    }

    public void validacaoSimulacaoSemValorIntegralDebito(double valor, int tipoCartao, int tipoModalidade, double valorCalculado) {
        simuladorVenda(valor, tipoCartao, tipoModalidade);
        simuladorPage.obterCalcularSimulacao().clicar();
        esperas.aguardarTextoProcessandoDesaparecer();
        genericValidation.validarTextosEsperadoEAtual(cifraoAndesDoValor + Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor),
                simuladorPage.obterValorCliente().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valorCalculado),
                simuladorPage.obterVouReceber().obterTexto());

    }

    public void validacaoSimulacaoValorIntegralDebito(double valor, int tipoCartao, int tipoModalidade, double valorCalculado) {
        simuladorVenda(valor, tipoCartao, tipoModalidade);
        simuladorPage.obterCalcularSimulacao().clicar();
        esperas.aguardarTextoProcessandoDesaparecer();
        simuladorPage.obterBotaoQueroReceberValorIntegral().clicar();
        genericValidation.validarTextosEsperadoEAtual(cifraoAndesDoValor + Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valorCalculado),
                simuladorPage.obterValorCliente().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor),
                simuladorPage.obterVouReceber().obterTexto());

    }

    
    public void validacaoSimulacaoSemValorIntegral(double valor, int tipoCartao, int tipoModalidade, double mdr, double antecipacao) {
        simuladorVenda(valor, tipoCartao, tipoModalidade);
        simuladorPage.obterCalcularSimulacao().clicar();
        validaValoresSimuladoSemValorIntegral(valor, mdr, antecipacao);
    }

    public void validacaoSimulacaoValorIntegral(double valor, int tipoCartao, int tipoModalidade, double mdr, double antecipacao) {
        simuladorVenda(valor, tipoCartao, tipoModalidade);
        simuladorPage.obterCalcularSimulacao().clicar();
        validaValoresSimuladoComValorIntegral(valor, mdr, antecipacao);
    }

    public void validacaoSimulacaoCreditoParceladoSemValorIntegral(double valor, int tipoCartao, int tipoModalidade, int parcela, double mdr) {
        simuladorVendaParcelado(valor, tipoCartao, tipoModalidade, parcela);
        simuladorPage.obterCalcularSimulacao().clicar();
        validaValoresSimuladoSemValorIntegralParcelado(valor, parcela, mdr);
    }

    public void validacaoSimulacaoCreditoParceladoValorIntegral(double valor, int tipoCartao, int tipoModalidade, int parcela, double mdr, double antecipacao) {
        simuladorVendaParcelado(valor, tipoCartao, tipoModalidade, parcela);
        simuladorPage.obterCalcularSimulacao().clicar();
        validaValoresSimuladoComValorIntegral(valor, mdr, antecipacao);
    }

    public void validarResumoSemAntecipacao(double valor, int tipoCartao, int tipoModalidade, int parcela, double valorCalculado) {
        genericValidation.validarTextosEsperadoEAtual(String.valueOf(parcela), simuladorPage.obterQuantidadeParcelasResumo().obterTexto());
        genericValidation.validarTextosEsperadoEAtual(String.valueOf(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valorCalculado / parcela)),
                simuladorPage.obterValorDaParcelaResumo().obterTexto());
        simuladorPage.obterDemaisParcelasResumo().clicar();
        List<Bmouaajm_Elemento> selecionaUltimoPrazoParcelar = simuladorPage.obterUltimaParcelaResumo();
        genericValidation.validarTextosEsperadoEContains("Prazo da " + String.valueOf(parcela),
                selecionaUltimoPrazoParcelar.get((parcela - 1)).obterTexto());
    }

    public void validaQuantidadeParcelasSimulada(int parcela) {
        simuladorPage.obterExibirMaisMenosParcelas().clicar();
        List<Bmouaajm_Elemento> quantidadeParcelas = simuladorPage.obterQuantidadeParcelas();
        genericValidation.validarTextosEsperadoEAtual(Integer.toString(parcela), Integer.toString(quantidadeParcelas.size() - 1));
        simuladorPage.obterExibirMaisMenosParcelas().clicar();
    }

    public void validaDescricaoEInfoParcelamentoLojista(double valor, int tipoCartao, int tipoModalidade) {
        simuladorVenda(valor, tipoCartao, tipoModalidade);
        genericValidation.validarTextosEsperadoEAtual(creditoLojista, simuladorPage.obterSubTituloModalidade().obterTexto());
        simuladorPage.obterModalidadeDePagamento().clicar();
        List<Bmouaajm_Elemento> selecionarModalidade = simuladorPage.obterListaTipoPagemento();
        genericValidation.validarTextosEsperadoEAtual(creditoLojista, selecionarModalidade.get((tipoModalidade - 1)).obterTexto());
        simuladorPage.obterIconeInfoCreditoParceladoLojista().clicar();
        genericValidation.validarTextosEsperadoEAtual(creditoLojista, genericPage.obterTituloMeiaModal().obterTexto());
        genericValidation.validarTextosEsperadoEContains(infoLogistaParcelado, genericPage.obterDescricaoMeiaModal().obterTexto());
        genericPage.obterBotaoMeiaModalEntendi().clicar();
    }

    private void simuladorVenda(double valor, int tipoCartao, int tipoModalidade) {
        simuladorPage.obterCampoValorSimulador().clicar().preencherLento(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor));
        simuladorPage.obterCampoEscolherBandeira().clicar();
        List<Bmouaajm_Elemento> selecaoTipoCartao = simuladorPage.obterListaTipoBandeira();
        selecaoTipoCartao.get((tipoCartao - 1)).clicar();
        simuladorPage.obterModalidadeDePagamento().clicar();
        List<Bmouaajm_Elemento> selecionarModalidade = simuladorPage.obterListaTipoPagemento();
        selecionarModalidade.get((tipoModalidade - 1)).clicar();
    }

    private void simuladorVendaParcelado(double valor, int tipoCartao, int tipoModalidade, int parcela) {
        simuladorVenda(valor, tipoCartao, tipoModalidade);
        simuladorPage.obterQuantidadeParcelamento().clicar();
        List<Bmouaajm_Elemento> selecaoQuantidadeParcela = simuladorPage.obterListaQuantidadeParcelamento();
        selecaoQuantidadeParcela.get((parcela - 2)).clicar();
    }

    private void validaValoresSimuladoSemValorIntegral(double valor, double mdr, double antecipacao) {
        esperas.aguardarTextoProcessandoDesaparecer();
        genericValidation.validarTextosEsperadoEAtual(cifraoAndesDoValor + Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor),
                simuladorPage.obterValorCliente().obterTexto());
        simuladorValidation.validaQuantoVouReceber(valor, mdr, antecipacao);
    }

    private void validaValoresSimuladoComValorIntegral(double valor, double mdr, double antecipacao) {
        esperas.aguardarTextoProcessandoDesaparecer();
        simuladorPage.obterBotaoQueroReceberValorIntegral().clicar();
        simuladorValidation.validaQuantoVouReceberValorIntegral(valor, mdr, antecipacao);
        genericValidation.validarTextosEsperadoEAtual(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor),
                simuladorPage.obterVouReceber().obterTexto());

    }

    private void validaValoresSimuladoSemValorIntegralParcelado(double valor,int parcela, double mdr) {
        esperas.aguardarTextoProcessandoDesaparecer();
        genericValidation.validarTextosEsperadoEAtual(cifraoAndesDoValor + Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor),
                simuladorPage.obterValorCliente().obterTexto());
        simuladorValidation.validaQuantoVouReceberParcelado(valor, parcela, mdr);
    }

    public void validaLinkIndiponivel(double valor, int tipoCartao, String modalidadeLiberada) {
        simuladorPage.obterCampoValorSimulador().clicar().preencherLento(Bvruaajm_Formatador.formatarNumeroDuasCasasComVirgula(valor));
        simuladorPage.obterCampoEscolherBandeira().clicar();
        simuladorPage.obterListaTipoBandeira().get(tipoCartao - 1).clicar();
        simuladorPage.obterModalidadeDePagamento().clicar();
        genericValidation.validaElementoEstaInvisivel(simuladorPage.obtersDisponabilidadeModalidadeLiberada(modalidadeLiberada));
    }
    
    public void validaDisponibilidadeDeParcelasLinkPgto(double valor, int tipoCartao, int tipoModalidade, String parcelasIndisponivel) {
        simuladorVenda(valor, tipoCartao, tipoModalidade);
        simuladorPage.obterQuantidadeParcelamento().clicar();
        genericValidation.validaElementoEstaInvisivel(simuladorPage.obtersDisponabilidadeDeParcelas(parcelasIndisponivel));
    }
}