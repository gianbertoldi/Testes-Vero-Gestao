package bergs.Bvr.Bvruaajm.test.tests.mm.gestao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.gestao.Bvruaajm_ConsultaMMAcessosRetornosTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.menuLateral.Bvruaajm_MenuLateralTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMM;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumCartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_ConsultaMMAcessosRetornosTest extends Bvruaajm_TesteBaseMM {

    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_MenuLateralTask menuLateralTask;
    Bvruaajm_ConsultaMMAcessosRetornosTask consultaMMAcessosRetorno;
    Bvruaajm_CartaoAcesso cpfUsuario = Bvruaajm_EnumCartaoAcesso.QrCode.obterCartaoAcesso();
    Bvruaajm_CartaoAcesso cpfInvalido = Bvruaajm_EnumCartaoAcesso.CPFInvalido.obterCartaoAcesso();
    Bvruaajm_Estabelecimento EstabCnpjInvalido = Bvruaajm_EnumEstabelecimentoConveniado.CnpjInvalido.obterEstabelecimento();
    Bvruaajm_Estabelecimento EstabCpfInvalido = Bvruaajm_EnumEstabelecimentoConveniado.CpfInvalido.obterEstabelecimento();
    String textoModalSemFiltro = "Deve ser definido o Evento ou o CPF do usuário.";
    String textoModalSemDataInicial = "O campo Data Início deve ser informado.";
    String textoModalSemDataFinal = "O campo Data Fim deve ser informado.";
    String retornoCpfUsuarioInvalido = "* CPF inválido";
    String CnpjTipoPessoaInvalido = "* CNPJ inválido";

    @BeforeEach
    public void iniciaTest() {
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        consultaMMAcessosRetorno = new Bvruaajm_ConsultaMMAcessosRetornosTask(driver);
        menuLateralTask = new Bvruaajm_MenuLateralTask(driver);
        menuLateralTask.acessarMenuGestaoAnaliseEventos();
        genericMMTask.clicarBotaoLimpar();
    }

    
    @Tag("MM5Gestao")
    @DisplayName("Valida Modal Sem Data Inicial")
    @Test
    public void validaModalSemDataInicial() {
        consultaMMAcessosRetorno.validaModalSemDataInicialSelecionada(cpfUsuario.obterCpfFormatado(), textoModalSemDataInicial);
    }
    
    @Tag("MM5Gestao")
    @DisplayName("Valida a Modal Sem Filtros Selecionandos")
    @Test
    public void validaModalSemFiltrosSelecionandos() {
        consultaMMAcessosRetorno.validaModalSemFitroSelecionado(textoModalSemFiltro);
    }
    
    @Tag("MM5Gestao")
    @DisplayName("Valida a Modal Sem Data Final")
    @Test
    public void validaModalSemDataFinal() {
        consultaMMAcessosRetorno.validaModalSemDataFinalSelecionada(cpfUsuario.obterCpfFormatado(), textoModalSemDataFinal);
    }
    
    @Tag("MM5Gestao")
    @DisplayName("Valida a Retorno Cpf Usuario Invalido")
    @Test
    public void validaRetornoCpfUsuariosInvalido() {
        consultaMMAcessosRetorno.validaRetornoCpfUsuariosInvalido(cpfInvalido.obterCpfFormatado(), retornoCpfUsuarioInvalido);
    }
    
    @Tag("MM5Gestao")
    @DisplayName("Valida a Retorno Cnpj Tipo Pessoa Invalido")
    @Test
    public void validaRetornoCnpjTipoPessoaInvalido() {
        consultaMMAcessosRetorno.validaRetornoCnpjTipoPessoaInvalido(EstabCnpjInvalido.obterCnpjZerosAEsquerda(), CnpjTipoPessoaInvalido);
    }
    
    @Tag("MM5Gestao")
    @DisplayName("Valida a Retorno Cpf Tipo Pessoa Invalido")
    @Test
    public void validaRetornoCpfTipoPessoaInvalido() {
        consultaMMAcessosRetorno.validaRetornoCpfTipoPessoaInvalido(EstabCpfInvalido.obterCpfCnpjFormatado(), retornoCpfUsuarioInvalido);
    }
}
