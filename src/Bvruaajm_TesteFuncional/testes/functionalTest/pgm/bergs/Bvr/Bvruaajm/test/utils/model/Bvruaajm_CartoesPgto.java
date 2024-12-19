package bergs.Bvr.Bvruaajm.test.utils.model;



import org.apache.commons.lang3.StringUtils;

import bergs.Bvr.Bvruaajm.test.utils.Bvruaajm_Formatador;

public class Bvruaajm_CartoesPgto {
    protected long numeroCartao;
    protected String nomeNoCartao;
    protected String dataValidade;
    protected String cvv;
    protected String cep;
    protected String numeroResidencia;
    
    
    
    public Bvruaajm_CartoesPgto(long numeroCartao, String nomeNoCartao, String dataValidade, String cvv, String cep, String numeroResidencia) {
        this.numeroCartao = numeroCartao;
        this.nomeNoCartao = nomeNoCartao;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
        this.cep = cep;
        this.numeroResidencia = numeroResidencia;
    }
    
    public long obterNumeroCartao() {
        return numeroCartao;
    }
     public String NumeroCartaoFormatado() {
         String str = StringUtils.leftPad(String.valueOf(numeroCartao), 16, "0");
         return Bvruaajm_Formatador.formatarNumCartao(str);
     }
     
     public String obterNomeNoCartao() {
         return nomeNoCartao;
     }
     
     public String obterDataValidade() {
         return dataValidade;
     }
     
     public String obterCvv() {
         return cvv;
     }
     
     public String obterCep() {
         return cep;
     }
     public String obterNumeroResidencial() {
         return numeroResidencia;
     }
}
