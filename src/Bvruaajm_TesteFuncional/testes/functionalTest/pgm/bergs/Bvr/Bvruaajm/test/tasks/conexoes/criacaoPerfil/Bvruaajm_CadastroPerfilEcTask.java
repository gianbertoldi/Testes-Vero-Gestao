package bergs.Bvr.Bvruaajm.test.tasks.conexoes.criacaoPerfil;

import org.openqa.selenium.WebElement;

import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_CriacaoPerfilSucessoPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_DescricaoNegocioPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_FotoPerfilPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_InformativoPerfilPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_PerfilEcPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_RedesSociaisPage;
import bergs.Bvr.Bvruaajm.test.pages.conexoes.criacaoPerfil.Bvruaajm_SelecaoDeCategoriaPage;
import bergs.Bvr.Bvruaajm.test.tasks.taskBase.Bvruaajm_TaskMobile;
import bergs.Bvr.Bvruaajm.test.utils.constantes.criacaoPerfil.Bvruaajm_DescricaoPerfilConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.criacaoPerfil.Bvruaajm_CategoriaPerfilConstante;
import bergs.Bvr.Bvruaajm.test.utils.constantes.criacaoPerfil.Bvruaajm_InformativoPerfilConstante;
import bergs.Bvr.Bvruaajm.test.validations.conexoes.criacaoPerfil.Bvruaajm_PrimeiroAcessoValidation;
import io.appium.java_client.AppiumDriver;

public class Bvruaajm_CadastroPerfilEcTask extends Bvruaajm_TaskMobile {

    private Bvruaajm_InformativoPerfilPage informativoPage;
    private Bvruaajm_PrimeiroAcessoValidation primeiroAcessoValidacao;
    private Bvruaajm_SelecaoDeCategoriaPage selecaoCategoriaPage;
    private Bvruaajm_DescricaoNegocioPage descricaoPage;
    private Bvruaajm_RedesSociaisPage redesSociais;
    private Bvruaajm_FotoPerfilPage fotoPerfilPage;
    private Bvruaajm_PerfilEcPage perfilEcPage;
    private Bvruaajm_CriacaoPerfilSucessoPage criacaoPefil;

    public Bvruaajm_CadastroPerfilEcTask(AppiumDriver<WebElement> driver) {
        super(driver);
        informativoPage = new Bvruaajm_InformativoPerfilPage(driver);
        primeiroAcessoValidacao = new Bvruaajm_PrimeiroAcessoValidation(driver);
        selecaoCategoriaPage = new Bvruaajm_SelecaoDeCategoriaPage(driver);
        descricaoPage = new Bvruaajm_DescricaoNegocioPage(driver);
        redesSociais = new Bvruaajm_RedesSociaisPage(driver);
        fotoPerfilPage = new Bvruaajm_FotoPerfilPage(driver);
        criacaoPefil = new Bvruaajm_CriacaoPerfilSucessoPage(driver);
        perfilEcPage = new Bvruaajm_PerfilEcPage(driver);
    }

    public void avancarEtapaInformativoPerfil() {
        primeiroAcessoValidacao.validaInformativoPerfil(Bvruaajm_InformativoPerfilConstante.TITULO_INFORMATIVO,Bvruaajm_InformativoPerfilConstante.SUBTITULO_INFORMATIVO,Bvruaajm_InformativoPerfilConstante.MINITITULO_INFORMATIVO,Bvruaajm_InformativoPerfilConstante.PRIMEIRA_ETAPA,Bvruaajm_InformativoPerfilConstante.SEGUNDA_ETAPA,Bvruaajm_InformativoPerfilConstante.TERCEIRA_ETAPA);
        informativoPage.obterBotaoVamosLa().clicar();
    }

    public void selecionarTipoCategoria(String tipoCategoria) {
        primeiroAcessoValidacao.validaCategoriaPerfil(Bvruaajm_CategoriaPerfilConstante.TITULO_CATEGORIA , Bvruaajm_CategoriaPerfilConstante.SUBTITULO_CATEGORIA , tipoCategoria);
        selecaoCategoriaPage.obterCardCategoria(tipoCategoria).click();
    }

    public void preencherDescricaoNegocio(String descricaoNegocio) {
        primeiroAcessoValidacao.validaDescricaoPerfil(Bvruaajm_DescricaoPerfilConstante.TITULO_DESCRICAO);
        descricaoPage.obterCampoTextoDescricao().preencher(descricaoNegocio);

        if (descricaoPage.obterBotaoContinuar().getAttribute("disabled") != null) {
            descricaoPage.obterBotaoPular().clicar();
        } else {
            descricaoPage.obterBotaoContinuar().click();
        }
    }

    public void preencherRedesSociais(String instagram, String facebook, String whatsWhapp) {
        primeiroAcessoValidacao.validaRedeSociais();
        redesSociais.obterCampoTextoFacebook().preencher(facebook);
        redesSociais.obterCampoTextoInstagram().preencher(instagram);
        redesSociais.obterCampoTextoWhatsApp().preencherLento(whatsWhapp);

        if (redesSociais.obterBotaoContinuar().getAttribute("disabled") != null) {
            redesSociais.obterBotaoPular().clicar();
        } else {
            redesSociais.obterBotaoContinuar().click();
        }
    }

    public void escolherLogoMarca(String caminhoImagem) {
        if (caminhoImagem.equals("") || caminhoImagem == null) {
            fotoPerfilPage.obterBotaoPularEtapa().clicar();
        } else {
            // ver com o time se da para alterar o campo para mandar um sendkeys
        }
    }

    public void criarPerfilEcCompleto(String tipoCategoria, String descricaoNegocio, String instagram, String facebook, String whatsWhapp,
            String caminhoImagem) {
        avancarEtapaInformativoPerfil();
        selecionarTipoCategoria(tipoCategoria);
        preencherDescricaoNegocio(descricaoNegocio);
        preencherRedesSociais(instagram, facebook, whatsWhapp);
        escolherLogoMarca(caminhoImagem);
    }

    public void cadastrarDescricao() {
        perfilEcPage.obterBotaoCadastrarDescricao().clicar();
    }

    public void finalizarCriacaoPerfil() {
        perfilEcPage.obterBotaoFinalizarCadastro().clicar();
    }

    public void irParaHome() {
        criacaoPefil.obterBotaoIrParaHome().clicar();
    }
    
    public void avancarRevisarOferta() {
        informativoPage.obterBotaoVamosLa().clicar();

    }
}
