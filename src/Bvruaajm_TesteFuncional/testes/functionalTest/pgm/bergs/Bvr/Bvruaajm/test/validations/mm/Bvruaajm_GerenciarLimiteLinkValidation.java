package bergs.Bvr.Bvruaajm.test.validations.mm;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

import bergs.bmo.bmouaajm.suporte.elementos.core.Bmouaajm_Elemento;
import bergs.bmo.bmouaajm.suporte.pageobject.Bmouaajm_PaginaBase;

public class Bvruaajm_GerenciarLimiteLinkValidation extends Bmouaajm_PaginaBase {

    private static final String ADM_PRODUTO = "Administradores do Produto";
    private static final String USUARIO = "Administradores do Produto";
    public Bvruaajm_GerenciarLimiteLinkValidation(RemoteWebDriver driver) {
        super(driver);
    }
    
    @Override
    protected boolean estaPronto() {
        return false;
    }

    public void verificaPresencaTabelaELinhasAlteracaoNaPagina(Bmouaajm_Elemento elementoTabela, int qtdLinhas) {
        assertAll(
                () -> assertTrue(verificaVisibilidadeElemento(elementoTabela), "Tabela deveria estar visivel"),
                () -> assertEquals(10, qtdLinhas, "Quantidade de linhas na tabela são diferentes"));
    }

    public void verificaSeTabelaEstaInvisivel(Bmouaajm_Elemento obterTabelaHistoricoAlteracao) {
        Assertions.assertFalse(verificaVisibilidadeElemento(obterTabelaHistoricoAlteracao));
    }
    
    private boolean verificaVisibilidadeElemento(Bmouaajm_Elemento el) {
        try {
            return el.estaVisivel();
        } catch (Exception e) {
            return false;
        }
    }

    public void validaColunaValorMaxEDataHora(List<Bmouaajm_Elemento> obterColunasPrimeiraLinhaTabela, String valor, String format) {
        assertAll(
                () -> assertEquals(valor, obterColunasPrimeiraLinhaTabela.get(0).obterTexto(), "Valores estão diferentes"),
                () -> assertEquals(ADM_PRODUTO, obterColunasPrimeiraLinhaTabela.get(1).obterTexto(), "Valores estão diferentes"),
                () -> assertEquals(USUARIO, obterColunasPrimeiraLinhaTabela.get(2).obterTexto(), "Valores estão diferentes"),
                () -> assertEquals(format, obterColunasPrimeiraLinhaTabela.get(3).obterTexto(), "Cada e hora não estão iguais"));
    }
}
