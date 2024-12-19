package bergs.Bvr.Bvruaajm.test.utils.enums;

import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartoesPgto;

public enum Bvruaajm_EnumCartoesPgto {
    CREDITO_MASTERCARD{
        public Bvruaajm_CartoesPgto obterNumeroCartao() {
            return new Bvruaajm_CartoesPgto(Long.parseLong("5200000000002235"), "Gera Qr Code", "092030", "191", "91787866","181");
        }  
    },
    CREDITO_VISA{
        public Bvruaajm_CartoesPgto obterNumeroCartao() {
            return new Bvruaajm_CartoesPgto(Long.parseLong("4000000000002701"), "Gera Qr Code", "092031", "200", "91787866","181");
        }  
    },
    CREDITO_ELO{
        public Bvruaajm_CartoesPgto obterNumeroCartao() {
            return new Bvruaajm_CartoesPgto(Long.parseLong("6505290000001002"), "Gera Qr Code", "092031", "200", "91787866","181");
        } 
    },
    ERRO_MASTERCARD{
        public Bvruaajm_CartoesPgto obterNumeroCartao() {
            return new Bvruaajm_CartoesPgto(Long.parseLong("5200000000002276"), "Gera Qr Code", "092031", "200", "91787866","181");
        }
    },
    ERRO_VISA{
        public Bvruaajm_CartoesPgto obterNumeroCartao() {
            return new Bvruaajm_CartoesPgto(Long.parseLong("4000000000002925"), "Gera Qr Code", "092031", "200", "91787866","181");
        }
    },
    DEBITO_MASTERCARD{
        public Bvruaajm_CartoesPgto obterNumeroCartao() {
            return new Bvruaajm_CartoesPgto(Long.parseLong("5200000000002235"), "Gera Qr Code", "092031", "200", "91787866","181");
        }
    },
    ERRO_ELO{
        public Bvruaajm_CartoesPgto obterNumeroCartao() {
            return new Bvruaajm_CartoesPgto(Long.parseLong("6505290000001010"), "Gera Qr Code", "092031", "200", "91787866","181");
        }
    };
    
    public abstract Bvruaajm_CartoesPgto obterNumeroCartao();
}
