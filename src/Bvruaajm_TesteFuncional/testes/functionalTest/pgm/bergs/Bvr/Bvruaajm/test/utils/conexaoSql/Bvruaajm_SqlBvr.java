package bergs.Bvr.Bvruaajm.test.utils.conexaoSql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;
import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumStatusLinkPagamento;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_SQL;
import bergs.bth.comunicacao.pojo.Bthotajm_Retorno;

public class Bvruaajm_SqlBvr extends Bmouaajm_SQL{

    public Bvruaajm_SqlBvr() {
        caminhoSql = "cntl/sql/";
    }
    
    @Override
    public String codigoGrupo() {
        return "Trocado";
    }

    @Override
    public String nomeProduto() {
        return "VERO APP";
    }

    /**  Esse Metodo efetua a Inser��o de um dado na tabela Transacao de um Link Pago  **/
    public Bthotajm_Retorno inserirLinkPagoNaTransacao(String codLink, String valor, String nomeComprador, LocalDateTime dataPag) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codLink", codLink);
        campos.put("valor", valor);
        campos.put("nomeComprador", nomeComprador);
        campos.put("dataPag", Bvruaajm_Formatador.obterDataAtualFormatadaDB(dataPag));
        return executarSql("Bvruaajm_InserirLinkPagoNaTransacao", campos);
    }
    
    /**  Esse Metodo efetua a Atualiza��o do link pgto na tabela Link_Pagamento  **/
    public Bthotajm_Retorno atualizarStatusLinkPgto(String codLink, Bvruaajm_EnumStatusLinkPagamento status) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codLink", codLink);
        campos.put("status", status.toString());
        return executarSql("Bvruaajm_AtualizarStatusLinkPgto", campos);
    }
    
    /**  Esse Metodo efetua a Atualiza��o do link pgto Para uma data uma mantendo o status atual  **/
    public Bthotajm_Retorno atualizarDataCadastroLinkPgto(String codLink, LocalDateTime dataCriacao, LocalDateTime dataExpiracao) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codLink", codLink);
        campos.put("dataCriacao", Bvruaajm_Formatador.obterDataAtualFormatadaDB(dataCriacao));
        campos.put("dataExpiracao", Bvruaajm_Formatador.obterDataAtualFormatadaDB(dataExpiracao));
        return executarSql("Bvruaajm_AtualizarDataCadastroExpiracaoLinkPgto", campos);
    }
    
    public Bthotajm_Retorno atualizaLinkPgtoNaTransacaoParaCancelado(String codLink, String status, LocalDateTime dataHora) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codLink", codLink);
        campos.put("status", status);
        campos.put("dataHora", Bvruaajm_Formatador.obterDataAtualFormatadaDB(dataHora));
        return executarSql("Bvruaajm_AtualizarTransacaoLinkPgtoParaCancelado", campos);
    }
    
    public Bthotajm_Retorno atualizarDataAtualizacaoCadastro(LocalDate dataAtualizaCad, Bvruaajm_CartaoAcesso cartaoAcesso) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("dataAtualizada", String.valueOf(dataAtualizaCad));
        campos.put("cpf", Long.toString(cartaoAcesso.obterCpf()));
        return executarSql("Bvruaajm_AtualizarDataAtualizacaoCadastro", campos);
    }
    
    public Bthotajm_Retorno atualizarEmailUsuarioParaNull(LocalDate dataAtualizaCad, Bvruaajm_CartaoAcesso cartaoAcesso) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("dataAtualizada", String.valueOf(dataAtualizaCad));
        campos.put("cpf", Long.toString(cartaoAcesso.obterCpf()));
        campos.put("email", "NULL");
        return executarSql("Bvruaajm_AtualizarEmailUsuarioParaNull", campos);
    }
    
    public Bthotajm_Retorno atualizarEmailUsuarioEmailGenerico(LocalDate dataAtualizaCad, Bvruaajm_CartaoAcesso cartaoAcesso) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("dataAtualizada", String.valueOf(dataAtualizaCad));
        campos.put("cpf", Long.toString(cartaoAcesso.obterCpf()));
        campos.put("email", "'teste@teste.com'");
        return executarSql("Bvruaajm_AtualizarEmailUsuarioParaNull", campos);
    }

    public Bthotajm_Retorno excluirLinkPgtoCriadoDoDb(String codigoLink) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codigoLink", codigoLink);
        return executarSql("Bvruaajm_ExcluirLinkPgtoCriadoDoBanco", campos);
    }
    
    public Bthotajm_Retorno excluirTresLinkPgtoCriadoDoDbAvaliacao(String codigoLink1, String codigoLink2, String codigoLink3) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codigoLink1", codigoLink1);
        campos.put("codigoLink2", codigoLink2);
        campos.put("codigoLink3", codigoLink3);
        return executarSql("Bvruaajm_ExcluirTresLinkPgtoCriadoDoDbAvaliacao", campos);
    }

    public Bthotajm_Retorno excluirTransacaoLinkPgto(String codLink) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codLink", codLink);
        return executarSql("Bvruaajm_ExcluirTransacaoLinkPgto", campos);
    }
    
    public Bthotajm_Retorno atualizaValorMinhaMeta(String valor, String cpfCnpj) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("valor", valor);
        campos.put("cpfCnpj", cpfCnpj);
        return executarSql("Bvruaajm_AtualizaValorMinhaMetaPorCpfCnpj", campos);
    }
    
    public Bthotajm_Retorno deletarLojistaTabelaEstabelecimento(String cpfCnpj) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cpfCnpj", cpfCnpj);
        return executarSql("Bvruaajm_DeletarLojistaTabelaEstabelecimento", campos);
    }
    
    public Bthotajm_Retorno deletarTransacaoLojistaCpfCnpj(String cpfCnpj) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cpfCnpj", cpfCnpj);
        return executarSql("Bvruaajm_DeletarTransacaoLojistaCpfCnpj", campos);
    }
    
    public Bthotajm_Retorno inserirNotificacaoNaTabelaMensagem(String codMsg, String tituloMsg, String descricaoMsg, LocalDateTime dataExpiracao, LocalDateTime dataCriacao, LocalDateTime dataUltimaAtalizacao) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codMsg", codMsg);
        campos.put("tituloMsg", tituloMsg);
        campos.put("descricaoMsg", descricaoMsg);
        campos.put("dataExpiracao", Bvruaajm_Formatador.obterDataAtualFormatadaDB(dataExpiracao));
        campos.put("dataCriacao", Bvruaajm_Formatador.obterDataAtualFormatadaDB(dataCriacao));
        campos.put("dataUltimaAtalizacao", Bvruaajm_Formatador.obterDataAtualFormatadaDB(dataUltimaAtalizacao));
        return executarSql("Bvruaajm_InserirNotificacaoNaTabelaMensagem", campos);
    }
    
    public Bthotajm_Retorno deletarNotificaDaTabelaMensagem(String codMsg) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codMsg", codMsg);
        return executarSql("Bvruaajm_ExcluirMensagemDoBanco", campos);
    }
    
    public Bthotajm_Retorno deletarNotificaDaTabelaControleMensagem(String codMsg) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codMsg", codMsg);
        return executarSql("Bvruaajm_ExcluirDoControleMensagem", campos);
    }
    
    public Bthotajm_Retorno atualizarNotificacaoControleMsgNaoLido(String lida, String codMsg) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("lido", lida);
        campos.put("codMsg", codMsg);
        return executarSql("Bvruaajm_AtualizarNotificacaoControleMsgNaoLido", campos);
    }
    
    public Bthotajm_Retorno atualizarNotificacaoTelaCheiaComImagem(LocalDateTime dataExpiracao, LocalDateTime dataPublicacao, String codMsg) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("dataExpiracao", Bvruaajm_Formatador.obterDataAtualFormatadaDB(dataExpiracao));
        campos.put("dataPublicacao", Bvruaajm_Formatador.obterDataAtualFormatadaDB(dataPublicacao));
        campos.put("codMsg", codMsg);
        return executarSql("Bvruaajm_AtualizarNotificacaoData", campos);      
    }
    
    public Bthotajm_Retorno atualizarLimiteMaxLink(String limiteMax, String cpfCnpj) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("limiteMax", limiteMax);
        campos.put("cpfCnpj", cpfCnpj);
        return executarSql("Bvruaajm_AtualizarLimiteMaxLink", campos);      
    }
    
    /**  Esse Metodo efetua a Atualiza��o do link pgto na tabela Link_Pagamento  
     *   Para o Status bloqueado e inserindo dados nos campos
     *   DATA_PRIMEIRO_BLOQUEIO
     *   DATA_PRIMEIRO_DESBLOQUEIO
     *   DATA_SEGUNDO_BLOQUEIO
     * 
     * **/
    public Bthotajm_Retorno atualizarBloqueioLinkPgto(String codLink, Bvruaajm_EnumStatusLinkPagamento status, LocalDateTime dataPrimeiroBloq, LocalDateTime dataPrimeiroDesbloq, LocalDateTime dataSegundoBloq) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codLink", codLink);
        campos.put("status", status.toString());
        if(dataPrimeiroBloq != null)
            campos.put("dataPrimeiroBloq", "'" + dataPrimeiroBloq.format(formatter) + "'");
        else
            campos.put("dataPrimeiroBloq", "NULL");
        if(dataSegundoBloq != null)
            campos.put("dataSegundoBloq", "'" + dataSegundoBloq.format(formatter) + "'");
        else
            campos.put("dataSegundoBloq", "NULL");
        if(dataPrimeiroDesbloq != null)
            campos.put("dataPrimeiroDesbloq", "'" + dataPrimeiroDesbloq.format(formatter) + "'");
        else
            campos.put("dataPrimeiroDesbloq", "NULL");
        return executarSql("Bvruaajm_AtualizaBloqueioLinkPgto", campos);
    }

    public Bthotajm_Retorno excluirNotificacaoLinkPgto(String codLink) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("codLink", codLink);
        return executarSql("Bvruaajm_ExcluirNotificacaoLinkPgto", campos);
    }
    
    public Bthotajm_Retorno atualizaTipoPerfilAcessoLojistaParaAceiteDigitalPorCpf(String cpfUser) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cpfUsuario", cpfUser);
        return executarSql("Bvruaajm_AtualizaTipoPerfilAcessoLojistaParaAceiteDigitalPorCpf", campos);
    }

    public Bthotajm_Retorno excluirHistoricoAlteracaoLimiteLink(long obterCpfCnpj) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cpfCnpjEc", String.valueOf(obterCpfCnpj));
        return executarSql("Bvruaajm_ExcluirHistoricoAlteracaoLimiteLink", campos);
    }

    public Bthotajm_Retorno atualizarLimiteValorLinkEc(long obterCpfCnpj) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cpfCnpjEc", String.valueOf(obterCpfCnpj));
        return executarSql("Bvruaajm_AtualizarLimiteValorLinkEc", campos);
    }
    
    public Bthotajm_Retorno atualizarEmailUsuarioParaCorrespondente(Bvruaajm_CartaoAcesso cartaoAcesso) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cpf", Long.toString(cartaoAcesso.obterCpf()));
        campos.put("email", "'teste@teste.com'");
        return executarSql("Bvruaajm_AtualizarEmailUsuarioParaCorrespondente", campos);
    }
    
    public Bthotajm_Retorno excluirEstabelecimentoDeUmUsuario(Bvruaajm_CartaoAcesso cartaoAcesso, Bvruaajm_Estabelecimento estab) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cpf", Long.toString(cartaoAcesso.obterCpf()));
        campos.put("cpfCnpj", Long.toString(estab.obterCpfCnpj()));
        return executarSql("Bvruaajm_ExcluirEstabelecimentoDeUmUsuario", campos);
    }
}
