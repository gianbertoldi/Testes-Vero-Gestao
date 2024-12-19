package bergs.Bvr.Bvruaajm.test.utils.conexaoSql;

import java.util.HashMap;
import java.util.Map;

import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_SQL;
import bergs.bth.comunicacao.pojo.Bthotajm_Retorno;

public class Bvruaajm_SqlBjr extends Bmouaajm_SQL{

    public Bvruaajm_SqlBjr() {
        caminhoSql = "cntl/sql/";
    }
    
    @Override
    public String codigoGrupo() {
        return "GJRADM";
    }

    @Override
    public String nomeProduto() {
        return "VERO";
    }
    
    public Bthotajm_Retorno deletarSolicitacaoPSR(Bvruaajm_CartaoAcesso cartaoAcesso, Bvruaajm_Estabelecimento estab) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cpf", String.valueOf(cartaoAcesso.obterCpf()));
        campos.put("cnpj", estab.obterCnpjZerosAEsquerda());
        return executarSql("Bvruaajm_DeletarSolicitacaoPsrBJR", campos);
    }
}
