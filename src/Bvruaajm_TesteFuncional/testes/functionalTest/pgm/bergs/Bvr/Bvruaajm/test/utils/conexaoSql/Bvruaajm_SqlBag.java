package bergs.Bvr.Bvruaajm.test.utils.conexaoSql;

import java.util.HashMap;
import java.util.Map;

import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_SQL;
import bergs.bth.comunicacao.pojo.Bthotajm_Retorno;

public class Bvruaajm_SqlBag extends Bmouaajm_SQL{
    
    public Bvruaajm_SqlBag() {
        caminhoSql = "cntl/sql/";
    }
    
    @Override
    public String codigoGrupo() {
        return "Trocado";
    }
    
    @Override
    public String nomeProduto() {
        return "VERO CONEXOES";
    }
    
    public Bthotajm_Retorno deletarEc(String cnpjCpf) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cnpjCpf", cnpjCpf);
        return executarSql("Bvruaajm_BagExcluirEc", campos);
    }
    
    public Bthotajm_Retorno deletarOfertaEc(String cnpjCpf) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cnpjCpf", cnpjCpf);
        return executarSql("Bvruaajm_BagDeletarOfertaEc", campos);
    }
    
    public Bthotajm_Retorno incluirEc(String cnpjCpf , String tipoPessoa , int codCategoria , String cadFinalizado , String status_perfil) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cnpjCpf", cnpjCpf);
        campos.put("tipoPessoa", tipoPessoa);
        campos.put("codCategoria", String.valueOf(codCategoria));
        campos.put("cadFinalizado", cadFinalizado);
        campos.put("status_perfil", status_perfil);
        return executarSql("Bvruaajm_BagInserirEcPerfil", campos);
    }
    
    public Bthotajm_Retorno criarNovaOferta(String cnpjCpf , String tipoPessoa , String tipoOferta , String nome , String descricaoOferta , String statusOfertas , String diaSeg , String diaTer , String diaQuart , String diaQuinta , String diaSex , String diaSab , String diaDom ) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("EC_CPF_CNPJ", cnpjCpf);
        campos.put("EC_TIPO_PESSOA", tipoPessoa);
        campos.put("TIPO_OFERTA", tipoOferta);
        campos.put("NOME", nome);
        campos.put("DESC_OFERTA", descricaoOferta);
        campos.put("STATUS_OFERTA", statusOfertas);
        campos.put("DIA_SEG", diaSeg);
        campos.put("DIA_TER", diaTer);
        campos.put("DIA_QUAR", diaQuart);
        campos.put("DIA_QUIN", diaQuinta);
        campos.put("DIA_SEX", diaSex);
        campos.put("DIA_SAB", diaSab);
        campos.put("DIA_DOM", diaDom);        
        return executarSql("Bvruaajm_BagCriarNovaOferta" , campos);
    }
    
    public Bthotajm_Retorno atualizarStatusDaOferta(String status , String codOferta) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("STATUS_OFERTA", status);
        campos.put("COD_OFERTA", codOferta);
        return executarSql("Bvruaajm_BagAtualizarStatusOfertaPorCodOferta" , campos);
    }
    
    public Bthotajm_Retorno atualizarStatusEcPerfil (String status, String cnpjCpf) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("STATUS_PERFIL", status);
        campos.put("cnpjCpf", cnpjCpf);
        return executarSql("Bvruaajm_BagAtualizarStatusEcPerfil" , campos);
    }
    
    public Bthotajm_Retorno atualizarTermoDeAdesao(String cnpjCpf, String status) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cnpjCpf", cnpjCpf);
        campos.put("status", status);
        return executarSql("Bvruaajm_BagAtualizarTermoDeAdesao", campos);

    }
}
