package bergs.Bvr.Bvruaajm.test.validations.home;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.extrato.Bvruaajm_ExtratoMinhasVendasPage;
import bergs.Bvr.Bvruaajm.test.pages.home.Bvruaajm_HomePage;
import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Esperas;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_HomeValidation {

    Bvruaajm_HomePage homePage;
    Bvruaajm_Esperas esperas;
    Bvruaajm_ExtratoMinhasVendasPage extratoPage;
    
    public Bvruaajm_HomeValidation(AppiumDriver<WebElement> driver) {
        homePage = new Bvruaajm_HomePage(driver);
        esperas = new Bvruaajm_Esperas(driver);
        extratoPage = new Bvruaajm_ExtratoMinhasVendasPage(driver);
    }
    
    public void validaCarrosel(String card , String titulo , String mensagem) {
        assertAll(
                () -> assertTrue(homePage.obterCardIcone(card).scrollIntoView().estaVisivel() , "Icone n�o esta visivel"),
                () -> assertEquals(titulo , homePage.obterCardTitulo(card).obterTexto() , "Titulo do Card nao correspondem"),
                () -> assertEquals(mensagem , homePage.obterCardTexto(card).obterTexto() , "Mensagens no card n�o correspondem")
                );
    }
    
    public void validaBloqueioDaVisualizacao() {
        homePage.obterCarrosselPai().scrollIntoView();
        Assertions.assertTrue(homePage.obterQuantidadeDeCardsVisiveis() < 4 , "Card N�o Deveria estar visiviel");
    }

    public void validacaoCartaoBeneficioContatoVero() {
        String conversarComVero = "Como voc� prefere conversar com a Vero?";
        Assertions.assertEquals(conversarComVero, homePage.obterTituloConversarComVero().obterTexto(), "textos est�o incoerentes");
    }
    
    public void validaBotaoAddMetaEstaHabilitado() {
        Assertions.assertTrue(homePage.obterBotaoCadastrarMeta().estaHabilitado(), "Elemento deveria estar Habilitado");
    }
    
    public void validaErroNomeMinhaMeta(String erroNome) {
        assertAll(
                () -> assertEquals(erroNome, homePage.obterMsgErroNomeMeta().obterTexto(), "textos est�o incoerentes"),
                () -> assertTrue(homePage.obterBotaoCadastrarMeta().obterAtributo("Disabled") != null, "Elemento deveria estar Desabilitado"));
    }
    
    public void validaErroValorMinhaMeta() {
        String msgErroValor = "O valor deve ser entre R$100,00 e R$ 999.999,99";
        assertAll(
                () -> assertEquals(msgErroValor, homePage.obterMsgErroValorMeta().obterTexto(), "textos est�o incoerentes"),
                () -> assertTrue(homePage.obterBotaoCadastrarMeta().obterAtributo("Disabled") != null, "Elemento deveria estar Desabilitado"));
    }
    
    public void validarValorMinhaMeta() {
        String valorMinhaMeta = "999,00";
        Assertions.assertEquals(valorMinhaMeta, homePage.obterValorMinhaMetaHome().obterTexto(), "textos est�o incoerentes");
    }
    
    public void validarIconeEscondidos() {
        String iconeOcultosTotalVenda = "�������";
        String iconesOcultos = "����";
        assertAll(
                () -> assertEquals(iconeOcultosTotalVenda, homePage.obterIconesEscondidosValorTotal().obterTexto(), "textos est�o incoerentes"),
                () -> assertEquals(iconesOcultos , homePage.obterIconesEscondidosValorTotalBandeiras().obterTexto() , "textos est�o incoerentes"),
                () -> assertEquals(iconesOcultos , homePage.obterIconesEscondidosValorMinhaMeta().obterTexto(), "textos est�o incoerentes")
                );
    }
    
    public void validarSemVendasNaHomeExtrato() {
        String vendasDeHoje = "Vendas de hoje";
        String msgPrimeiraVenda = "Assim que sua primeira venda for realizada, ela aparecer� aqui! ";
        assertAll(
                () -> assertEquals(vendasDeHoje, homePage.obterTituloVendaHojeExtrato().obterTexto(), "textos est�o incoerentes"),
                () -> assertTrue(homePage.obterSemTrasacaAindaExtrato().obterTexto().contains(msgPrimeiraVenda) , "textos est�o incoerentes")
                );
    }
    
    public void validarTituloExtrato() {
        String tituloExtrato = "Minhas Vendas";
        Assertions.assertEquals(tituloExtrato, extratoPage.obterTituloExtrato().obterTexto());
    }
}
