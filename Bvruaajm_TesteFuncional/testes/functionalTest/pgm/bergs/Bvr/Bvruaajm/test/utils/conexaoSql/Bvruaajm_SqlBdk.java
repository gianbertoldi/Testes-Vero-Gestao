package bergs.Bvr.Bvruaajm.test.utils.conexaoSql;

import java.util.HashMap;
import java.util.Map;

import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_SQL;
import bergs.bth.comunicacao.pojo.Bthotajm_Retorno;

public class Bvruaajm_SqlBdk extends Bmouaajm_SQL{

    public Bvruaajm_SqlBdk() {
        caminhoSql = "cntl/sql/";
    }
    
    @Override
    public String codigoGrupo() {
        return "GDKADM";
    }

    @Override
    public String nomeProduto() {
        return "VERO CREDENCIAMENTO";
    }
    
    public Bthotajm_Retorno atualizaPropostaCpfCnpjBdk(String cpfConveniado) {
        Map<String, String> campos = new HashMap<String, String>();
        campos.put("cpfConveniado", cpfConveniado);
        return executarSql("Bvruaajm_AtualizaPropostaCpfCnpjBdk", campos);
    }
    
    //UPDATE BDK.PROPOSTA SET SIT_PROPOSTA_ITEM = 9 WHERE CPF_CNPJ_CONV = $cpfConveniado$  60701395001
}
