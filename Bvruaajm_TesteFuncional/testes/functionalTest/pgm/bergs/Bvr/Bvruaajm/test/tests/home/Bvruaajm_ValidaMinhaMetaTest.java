package bergs.Bvr.Bvruaajm.test.tests.home;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.generic.Bvruaajm_GenericTask;
import bergs.Bvr.Bvruaajm.test.tasks.home.Bvruaajm_HomeTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMobile;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ValidaMinhaMetaTest extends Bvruaajm_TesteBaseMobile {

    Bvruaajm_CartaoAcesso cartaoAcesso = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_Estabelecimento estab = Bvruaajm_EnumEstabelecimentoConveniado.JonathanBarbiero.obterEstabelecimento();
    Bvruaajm_Estabelecimento estab2 = Bvruaajm_EnumEstabelecimentoConveniado.SupermercadoGecepel.obterEstabelecimento();
    Bvruaajm_HomeTask homeTask;
    Bvruaajm_GenericTask genericTask;
    String nomeMetaErroMinimoCaracter = "Digite entre 3 e 21 caracteres";
    String nomeMetaErroCaracterEspecial = "Digite apenas caracteres alfanuméricos";
    String nomeMinhaMeta = "Meta Teste";
    String menosDeDoisCaracteres = "Me";
    String caracteresInvalidos = "M!n#@ m&t@";

    @BeforeEach
    public void preparaTest() {
        homeTask = new Bvruaajm_HomeTask(driver);
        genericTask =  new Bvruaajm_GenericTask(driver);
        genericTask.prepararTesteLogado(cartaoAcesso);
        genericTask.selecionaEstabelecimentoOuConveniado(estab);
    }

    @DisplayName("Validar fluxo criação minha meta clicando em cancelar no final")
    @Tag("home")
    @Test
    public void validaCriacaoMinhaMetaCliandoEmCancelar() {
        homeTask.validaCriacaoMinhaMetaSemSalvar(nomeMinhaMeta, "900,00");
    }

    @DisplayName("Valida criação minha meta com minimo caracter no nome")
    @Tag("home")
    @Test

    public void validaCriacaoMinhaMetaComNomeMinimoCaracter() {
        homeTask.validaCampoNomeCriacaoMinhaMeta(menosDeDoisCaracteres, "900,00", nomeMetaErroMinimoCaracter);
    }

    @DisplayName("Valida criação minha meta com nome invalido")
    @Tag("home")
    @Test
    public void validaCriacaoMinhaMetaComNomeInvalido() {
        homeTask.validaCampoNomeCriacaoMinhaMeta(caracteresInvalidos, "900,00", nomeMetaErroCaracterEspecial);
    }

    @DisplayName("Valida criação minha meta com valor abaixo de R$100,00")
    @Tag("home")
    @Test
    public void validaCriacaoMinhaMetaComValorInvalido() {
        homeTask.validaCampoValorMinimoCriacaoMinhaMeta(nomeMinhaMeta, "99,00");
    }

    @DisplayName("Valida edição minha meta com valor abaixo de R$100,00")
    @Tag("home")
    @Test
    public void validaEditarMinhaMetaComValorInvalido() {
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        homeTask.validaEditarCampoValorMinimoMinhaMeta(nomeMinhaMeta, "99,00");
    }

    @DisplayName("Valida edição minha meta com valor valido")
    @Tag("SmokeTest")
    @Tag("home")
    @Test
    public void validaEditarMinhaMetaComValorValido() {
        Bvruaajm_SqlBvr sqlBvr = new Bvruaajm_SqlBvr();
        sqlBvr.atualizaValorMinhaMeta("1000", String.valueOf(estab2.obterCpfCnpj()));
        genericTask.selecionaEstabelecimentoOuConveniado(estab2);
        homeTask.validaEditarMinhaMetaESalvar(nomeMinhaMeta, "999,00");
    }
}
