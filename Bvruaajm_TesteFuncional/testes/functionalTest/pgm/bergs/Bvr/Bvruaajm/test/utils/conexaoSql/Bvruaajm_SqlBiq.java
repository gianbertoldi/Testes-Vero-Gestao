package bergs.Bvr.Bvruaajm.test.utils.conexaoSql;

import java.util.HashMap;
import java.util.Map;

import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_SQL;
import bergs.bth.comunicacao.pojo.Bthotajm_Retorno;

public class Bvruaajm_SqlBiq extends Bmouaajm_SQL{

    public Bvruaajm_SqlBiq() {
        caminhoSql = "cntl/sql/";
    }
    
    @Override
    public String codigoGrupo() {
        return "GIQADM";
    }

    @Override
    public String nomeProduto() {
        return "AVALIACAO DE JORNADA";
    }

    public Bthotajm_Retorno deletarLinhaAvaliacaoLinkBIQ(Bvruaajm_CartaoAcesso cartaoAcesso) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cpf", String.valueOf(cartaoAcesso.obterCpf()));
        return executarSql("Bvruaajm_DeletarAvaliacaoLinkPgtoNoBIQ", campos);
    }
}
