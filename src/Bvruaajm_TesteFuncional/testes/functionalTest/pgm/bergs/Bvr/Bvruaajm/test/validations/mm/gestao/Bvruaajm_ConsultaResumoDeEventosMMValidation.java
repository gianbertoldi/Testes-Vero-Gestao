package bergs.Bvr.Bvruaajm.test.validations.mm.gestao;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.Bvr.Bvruaajm.test.pages.mm.gestao.Bvruaajm_ConsultaResumoDeEventosMMPage;
import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_ConsultaResumoDeEventosMMValidation extends Bmouaajm_PaginaBase {

    Bvruaajm_ConsultaResumoDeEventosMMPage resumoEventoPage;
    Bmouaajm_Elemento elementos;
    private static final List<String> TEXTO_DA_LINHA_DA_TABELA = Arrays.asList("1", "8", "Acesso",
            "ACESSA O APP COM UM CARTÃO (HOME)");

    public Bvruaajm_ConsultaResumoDeEventosMMValidation(RemoteWebDriver driver) {
        super(driver);
        resumoEventoPage = new Bvruaajm_ConsultaResumoDeEventosMMPage(driver);
    }

    @Override
    protected boolean estaPronto() {
        return false;
    }

    public void validarElementoNaLinhaDaTabelaDeResumoEventos(String linha) {
        for (int i = 0; i < resumoEventoPage.obterLinahaDaTabelaResumoDeEventos(linha).size(); i++) {
            Assertions.assertEquals(TEXTO_DA_LINHA_DA_TABELA.get(i), resumoEventoPage.obterLinahaDaTabelaResumoDeEventos(linha).get(i).obterTexto(),
                    "Textos estao diferentes");
        }
        Assertions.assertTrue((resumoEventoPage.obterListaResumoDeEventos().size() - 1) == 8);
    }
}
