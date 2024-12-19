package bergs.Bvr.Bvruaajm.test.validations.simulador;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.servicos.simulador.Bvruaajm_SimuladorPage;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_SimuladorValidation {

    Bvruaajm_SimuladorPage simuladorPage;
    double mdr;
    double antecipacao;
    int txRegistro = 1;
    double bvr;
    double beq;
    double esperado;

    public Bvruaajm_SimuladorValidation(AppiumDriver<WebElement> driver) {
        simuladorPage = new Bvruaajm_SimuladorPage(driver);
    }

    public void calculaMediaResultadoQuantoVouReceber(double valor, double mdr, double antecipacao) {
        bvr = valor - (valor * mdr / 100);
        beq = bvr - (bvr * antecipacao  / 100) - txRegistro;
    }

    public void calculaMediaResultadoQuantoVouReceberParcelado(double valor, int parcela, double mdr) {
        double[] parcelas = new double[parcela];
        bvr = valor - (valor * mdr / 100);
        double tempValor = bvr / parcela;
        parcelas[0] = tempValor - (tempValor * antecipacao / 100);
        antecipacao = antecipacao * parcela;
        for (int i = 1; i < parcela; i++) {
            parcelas[i] = tempValor - (tempValor*antecipacao/100);
        }

        for (int i = 0; i < parcela; i++) {
            beq += parcelas[i];
        }

        beq = beq + 1;
    }

    public void validaQuantoVouReceber(double valor, double mdr, double antecipacao) {
        calculaMediaResultadoQuantoVouReceber(valor, mdr, antecipacao);
        esperado = Bvruaajm_Formatador.formatarDeStringParaDouble(simuladorPage.obterVouReceber().obterTexto());
        assertAll(
                () -> assertTrue(esperado > (beq - 0.2)),
                () -> assertTrue(esperado < (beq + 0.2)));
    }  

    public void validaQuantoVouReceberValorIntegral(double valor, double mdr, double antecipacao) {
        calculaMediaResultadoQuantoVouReceber(valor, mdr, antecipacao);
        double valorIntegral = valor * (valor / (beq + txRegistro)) + txRegistro;
        esperado = Bvruaajm_Formatador.formatarDeStringParaDouble(simuladorPage.obterValorCliente().obterTexto());
        assertAll(
                () -> assertTrue(esperado > (valorIntegral - 0.2)),
                () -> assertTrue(esperado < (valorIntegral + 0.2)));
    }
    
    public void validaQuantoVouReceberParcelado(double valor, int parcela, double mdr) {
        calculaMediaResultadoQuantoVouReceberParcelado(valor, parcela, mdr);
        esperado = Bvruaajm_Formatador.formatarDeStringParaDouble(simuladorPage.obterVouReceber().obterTexto());
        assertAll(
                () -> assertTrue(esperado > (beq - 0.4)),
                () -> assertTrue(esperado < (beq + 0.4)));
    }
}
