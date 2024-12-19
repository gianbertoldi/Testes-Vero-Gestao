package bergs.Bvr.Bvruaajm.test.utils.enums;

import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_CartaoAcesso;


public enum Bvruaajm_EnumCartaoAcesso {

    Grasi {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("98574531049"), "Grasi", "teste@teste.com.br", "51999999999", "111111",
                    "teste0102");
        }
    },
    
    PerfilVendedor {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("12345678909"), "Vendedor", "teste@teste.com.br", "51999999999", "111111",
                    "teste0102");
        }
    },

    Kuhn {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("65784793098"), "Carlos Kuhn", "teste@teste.com.br", "51999999999", "111111",
                    "teste0102");
        }
    },
    
    Pannuvia {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("60987847520"), "Pannuvia", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },
    
    UsuarioBvrAdmin {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("00022799320"), "AAdministrador", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },
    
    UsuarioBvrConsulta {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("92625527420"), "AConsulta", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },
    
    UsuarioBvrVendedor {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("82316711456"), "AVendedor", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },
    
    UsuarioParaEditar {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("36473476202"), "AEditar", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },
    
    LeopoldinoSilva {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("00000000353"), "Leopoldino", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },
    
    UsuarioParaExcluir {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("76222756549"), "AExcluir", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },
    
    ExcluirMeta {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("14366356163"), "ExcluirMeta", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },

    Eduardo {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("82201838020"), "Eduardo", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },
    
    TesteIncidentes{
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("05214178050"), "Incidentes", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },

    UsuarioConvAduana {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("97794694515"), "ConvAduana", "pf@teste.com", "51999999999",
                    "111111", "teste0102");
        }
    },

    UsuarioRelTaxas {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("01003859070"), "UsuarioRelTa", "pf@teste.com", "51984083340", "111111",
                    "teste0102");
        }
    },

    QrCode {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("00000000191"), "Gera Qr Code", "pf@teste.com", "51999999999", "111111", "teste0102");
        }
    },

    OutroContatoPF {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("46703083002"), "outro contato PF", "", "", "111111", "teste0102");
        }
    },

    OutroContatoPJ {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("46703083002"), "outro contato PJ", "", "", "111111", "teste0102");
        }
    },

    UsuarioAduana {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("26388997040"), "Aduana", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },

    UserSemAcesso {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("75402221073"), "UserSemAcesso", "pf@teste.com", "51999999999", "111111",
                    "teste0102");
        }
    },
    Josiane{
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("90373600097"),"Josiane","","51999999999","111111","teste0102");
        }
    },
    GustavoMachado{
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("62844636004"), "Gustavo", "", "51999999999", "111111", "teste0102");
        }
    },
    TesteKuhn{
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("64649644020"), "TesteBdk", "", "51999999999", "111111", "teste0102");
        }
    },
    AdesaoLink{
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("00813189012"), "TesteBanri", "", "51999999999", "111111", "teste0102");
        }
    },
    Matheus {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("04386458042"), "Matheus", "", "51999618810", "111111","teste0102");
        }
    },
    CPFInvalido {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("12345678901"), "CPF invalido", "", "51999999999", "111111","teste0102");
        }
    },
    TesteQA {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("26844922043"), "Teste QA", "", "51999999999", "111111","teste0102");
        }
    },
    CpfAceiteDigital {
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("60701395001"), "Aceite Digital", "", "51999999999", "111111","teste0102");
        }
    },
    Vinicius{
        public Bvruaajm_CartaoAcesso obterCartaoAcesso() {
            return new Bvruaajm_CartaoAcesso(Long.parseLong("01355819075"),"Vinicius","","51999999999","111111","teste0102");
        }
    },;
    
    public abstract Bvruaajm_CartaoAcesso obterCartaoAcesso();
}
