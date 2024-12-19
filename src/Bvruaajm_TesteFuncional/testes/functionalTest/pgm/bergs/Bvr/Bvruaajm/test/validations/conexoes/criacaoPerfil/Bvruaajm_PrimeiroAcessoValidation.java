package bergs.Bvr.Bvruaajm.test.validations.conexoes.criacaoPerfil;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_CriacaoPerfilSucessoPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_DescricaoNegocioPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_InformativoPerfilPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_PerfilEcPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_PerfilRecusadoPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_RedesSociaisPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_SelecaoDeCategoriaPage;
import bergs.Bvr.Bvruaajm.test.utils.constantes.criacaoPerfil.Bvruaajm_RedeSociaisConstante;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_PrimeiroAcessoValidation {

    private Bvruaajm_InformativoPerfilPage informativoPage;
    private Bvruaajm_SelecaoDeCategoriaPage categoriaPage;
    private Bvruaajm_DescricaoNegocioPage descricaoNegPage;
    private Bvruaajm_RedesSociaisPage redesSociaisPage;
    private Bvruaajm_PerfilEcPage perfilPage;
    private Bvruaajm_CriacaoPerfilSucessoPage criacaoPerfil;
    private Bvruaajm_PerfilRecusadoPage perfilRecusado;

    public Bvruaajm_PrimeiroAcessoValidation(AppiumDriver<WebElement> driver) {
        informativoPage = new Bvruaajm_InformativoPerfilPage(driver);
        categoriaPage = new Bvruaajm_SelecaoDeCategoriaPage(driver);
        descricaoNegPage = new Bvruaajm_DescricaoNegocioPage(driver);
        redesSociaisPage = new Bvruaajm_RedesSociaisPage(driver);
        perfilPage = new Bvruaajm_PerfilEcPage(driver);
        criacaoPerfil = new Bvruaajm_CriacaoPerfilSucessoPage(driver);
        perfilRecusado = new Bvruaajm_PerfilRecusadoPage(driver);
    }

    public void validaInformativoPerfil(String tituloInformativo , String subtituloInformativo , String minitituloInformativo , String primeiraEtapa , String segundaEtapa , String terceiraEtapa) {
        assertAll(
                () -> assertEquals(tituloInformativo , informativoPage.obterLabelTitulo().obterTexto()),
                () -> assertEquals(subtituloInformativo , informativoPage.obterLabelSubtitulo().obterTexto()),
                () -> assertEquals(minitituloInformativo , informativoPage.obterLabelMiniTituloInformativo().obterTexto()),
                () -> assertEquals(primeiraEtapa , informativoPage.obterLabelPrimeiraEtapa().obterTexto()),
                () -> assertEquals(segundaEtapa , informativoPage.obterLabelSegundaEtapa().obterTexto()),
                () -> assertEquals(terceiraEtapa, informativoPage.obterLabelTerceiraEtapa().obterTexto()),
                () -> assertTrue(informativoPage.quantidadIcones() == 3));
    }

    public void validaCategoriaPerfil(String tituloCategoria , String subtituloCategoria , String tipoCategoria) {
        assertAll(
                () -> assertEquals(tituloCategoria , categoriaPage.obterLabelTitulo().obterTexto()),
                () -> assertEquals(subtituloCategoria,categoriaPage.obterSubTitulo().obterTexto()),
                () -> assertTrue(categoriaPage.obterCardCategoria(tipoCategoria).isDisplayed()));
    }

    public void validaDescricaoPerfil(String tituloDescricao) {
        assertAll(
                () -> assertEquals(tituloDescricao , descricaoNegPage.obterLabelTitulo().obterTexto()),
                () -> assertTrue(descricaoNegPage.obterCampoTextoDescricao().estaVisivel()));
    }

    public void validaRedeSociais() {
        assertAll(
                () -> assertEquals(Bvruaajm_RedeSociaisConstante.TITULO_REDES_SOCIAIS, redesSociaisPage.obterLabelTitulo().obterTexto()),
                () -> assertTrue(redesSociaisPage.obterCampoTextoFacebook().estaVisivel()),
                () -> assertTrue(redesSociaisPage.obterCampoTextoInstagram().estaVisivel()),
                () -> assertTrue(redesSociaisPage.obterCampoTextoWhatsApp().estaVisivel()));
    }

    public void validaPerfilEcCompleto(String nomeFantasia, String categoria, String descricao, String endereco, List<String> redeSocial) {
        assertAll(
                () -> assertEquals(nomeFantasia, perfilPage.obterNomeFantasia().obterTexto()),
                () -> {
                    if (descricao.isEmpty()) {
                        assertTrue(perfilPage.obterBotaoCadastrarDescricao().estaVisivel());
                    } else {
                        assertEquals(descricao, perfilPage.obterLabelDescricao().obterTexto());
                    }
                },
                () -> {
                    if (redeSocial.stream().allMatch(String::isEmpty)) {
                        assertTrue(perfilPage.obterBotaoCadastrarRedesSociais().estaVisivel());
                    } else {
                        for (int i = 1; i <= perfilPage.obterQuantidadeDeRedesSocais().size(); i++) {
                            assertEquals(redeSocial.get(i - 1).toString(), perfilPage.obterLabelRedesSociais(i).obterTexto());
                        }
                    }
                },
                () -> assertEquals(endereco,  perfilPage.obterLabelPrimeiraParteEndereco().obterTexto() + "\n" + perfilPage.obterLabelSegundaParteEndereco().obterTexto()),
                () -> assertEquals(categoria, perfilPage.obterTipoCategoria().obterTexto()));
    }

    public void validaCriacaoPerfil(String perfilTitulo , String perfilMensagemSucesso , String perfilBotaoCadastro , String perfilBotaoHome) {
        assertAll(
                () -> assertTrue(criacaoPerfil.obterIcone().estaVisivel(), "Não esta visivel icone de sucesso"),
                () -> assertEquals(perfilTitulo, criacaoPerfil.obterLabelTitulo().obterTexto()),
                () -> assertEquals(perfilMensagemSucesso, criacaoPerfil.obterLabelMensagem().obterTexto()),
                () -> assertEquals(perfilBotaoCadastro, criacaoPerfil.obterBotaoCadastrarOferta().obterTexto()),
                () -> assertEquals(perfilBotaoHome, criacaoPerfil.obterBotaoIrParaHome().obterTexto()));
    }
    
    public void validaPerfilRecusado(String perfilRecusadoTitulo , String perfilRecusadoTextoInformativo) {
        assertAll(
                () -> assertTrue(perfilRecusado.obterImagemAlerta().estaVisivel()),
                () -> assertEquals(perfilRecusadoTitulo , perfilRecusado.obterLabelTitulo().obterTexto()),
                () -> assertEquals(perfilRecusadoTextoInformativo , perfilRecusado.obterLabelInformativo().obterTexto()),
                () -> assertTrue(perfilRecusado.obterBotaoRevisar().estaVisivel())
                );
    }
    
    public void validaPerfilEmAnalise(String perfilAnaliseTitulo , String perfilAnaliseMensagemRetorno , String perfilAnaliseBotaoHome) {
        assertAll(
                () -> assertEquals(perfilAnaliseTitulo , criacaoPerfil.obterLabelTitulo().obterTexto()),
                () -> assertEquals(perfilAnaliseMensagemRetorno , criacaoPerfil.obterLabelMensagem().obterTexto()),
                () -> assertEquals(perfilAnaliseBotaoHome , criacaoPerfil.obterBotaoIrParaHome().obterTexto())
                );
        
    }
    
}
