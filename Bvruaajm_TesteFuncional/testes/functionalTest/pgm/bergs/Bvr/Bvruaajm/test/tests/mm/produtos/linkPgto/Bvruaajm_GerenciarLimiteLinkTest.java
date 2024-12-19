package bergs.Bvr.Bvruaajm.test.tests.mm.produtos.linkPgto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bergs.Bvr.Bvruaajm.test.tasks.mm.genericMM.Bvruaajm_GenericMMTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.menuLateral.Bvruaajm_MenuLateralTask;
import bergs.Bvr.Bvruaajm.test.tasks.mm.produtos.linkPgto.Bvruaajm_GerenciarLimiteLinkTask;
import bergs.Bvr.Bvruaajm.test.tests.testeBase.Bvruaajm_TesteBaseMM;
import bergs.Bvr.Bvruaajm.test.utils.conexaoSql.Bvruaajm_SqlBvr;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumEstabelecimentoConveniado;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;

public class Bvruaajm_GerenciarLimiteLinkTest extends Bvruaajm_TesteBaseMM {
    
    Bvruaajm_SqlBvr sqlBvr;
    Bvruaajm_GerenciarLimiteLinkTask limiteLinkTask;
    Bvruaajm_GenericMMTask genericMMTask;
    Bvruaajm_MenuLateralTask menuLateralTask;
    Bvruaajm_Estabelecimento estabCnpjSemLinkCadastrado = Bvruaajm_EnumEstabelecimentoConveniado.InstalacoesHidCuritibaLtda.obterEstabelecimento();
    Bvruaajm_Estabelecimento estabCpfValido = Bvruaajm_EnumEstabelecimentoConveniado.TesteBVR.obterEstabelecimento();
    Bvruaajm_Estabelecimento estabCpfSemLinkCadastrado = Bvruaajm_EnumEstabelecimentoConveniado.MaicoDaSilva.obterEstabelecimento();
    Bvruaajm_Estabelecimento estabCnpjValido = Bvruaajm_EnumEstabelecimentoConveniado.ConsultoriaInfoteca.obterEstabelecimento();
    Bvruaajm_Estabelecimento estabCnpjInvalado = Bvruaajm_EnumEstabelecimentoConveniado.CnpjInvalido.obterEstabelecimento();
    Bvruaajm_Estabelecimento estabCpfInvalado = Bvruaajm_EnumEstabelecimentoConveniado.CpfInvalido.obterEstabelecimento();
    String valorInformadoIgual = "O valor informado deve ser diferente do valor atual.";
    String valorMinimo = "O valor limite mínimo para criação de um link é R$ 5,00";
    String cnpjInvalido = "* CNPJ inválido";
    String cpfInvalido = "* CPF inválido";
    
    String registroNaoEncontrado = "Registro não encontrado.";
    
    @BeforeEach
    public void iniciaTest() {
        limiteLinkTask = new Bvruaajm_GerenciarLimiteLinkTask(driver);
        genericMMTask = new Bvruaajm_GenericMMTask(driver);
        menuLateralTask = new Bvruaajm_MenuLateralTask(driver);
        menuLateralTask.acessarMenuProdutoLinkGerenciaLimite();
    }
    
    @DisplayName("Valida presença tabela de historico alteração link")
    @Test
    public void validaLimiteLinkCadastrado() {
        limiteLinkTask.validaLimiteLinkCadastrado(estabCnpjValido.obterCnpjZerosAEsquerda());
    }
    
    @DisplayName("Valida quando Ec cpf não tem o link pgto cadastrado")
    @Test
    public void validaRetornoComCpfECSemLinkCadastrado() {
        limiteLinkTask.validaRetornoCpfCnpjSemCadastroLinkPgto(estabCpfSemLinkCadastrado.obterCpfCnpjFormatado(), registroNaoEncontrado);
    }

    @DisplayName("Valida quando Ec CNPJ não tem o link pgto cadastrado")
    @Test
    public void validaRetornoComCnpjECSemLinkCadastrado() {
        limiteLinkTask.validaRetornoCpfCnpjSemCadastroLinkPgto(estabCnpjSemLinkCadastrado.obterCpfCnpjFormatado(), registroNaoEncontrado);
    }

    @DisplayName("Valida cpf sem historico de alteracao")
    @Test
    public void validaCpfSemHistoricoDeAlteracao() {
        limiteLinkTask.validaEcSemHistoricoAlteracao(estabCpfValido.obterCpfCnpjFormatado());
    }
    
    @DisplayName("Valida edicao no valor limite")
    @Test
    public void validaEdicaoNoValorLimiteLink() {
        sqlBvr = new Bvruaajm_SqlBvr();
        limiteLinkTask.validaEdicaoValorLimite(estabCpfValido.obterCpfCnpjFormatado(), "R$5.000,01");
        sqlBvr.excluirHistoricoAlteracaoLimiteLink(estabCpfValido.obterCpfCnpj());
        sqlBvr.atualizarLimiteValorLinkEc(estabCpfValido.obterCpfCnpj());
    }
    
    @DisplayName("Valida retorno editando para mesmo valor ja cadastrado")
    @Test
    public void validaRetornoEditarMesmoValorCadastradoLimite() {
        limiteLinkTask.validaRetornoEditarValor(estabCpfValido.obterCpfCnpjFormatado(), "R$5.000,00", valorInformadoIgual);
    }

    @DisplayName("Valida retorno editando valor menor que cinco")
    @Test
    public void validaRetornoEditarValorIgualAZero() {
        limiteLinkTask.validaRetornoEditarValor(estabCpfValido.obterCpfCnpjFormatado(), "R$1,00", valorMinimo);
    }
    
    @DisplayName("Valida retorno para Cnpj invalido")
    @Test
    public void validaRetornoCnpjInvalido() {
        limiteLinkTask.validaRetornoCnpjCpfInvalido(estabCnpjInvalado.obterCpfCnpjFormatado(), cnpjInvalido);
    }
    
    @DisplayName("Valida retorno para Cpf invalido")
    @Test
    public void validaRetornoCpfInvalido() {
        limiteLinkTask.validaRetornoCnpjCpfInvalido(estabCpfInvalado.obterCpfCnpjFormatado(), cpfInvalido);
    }
}
