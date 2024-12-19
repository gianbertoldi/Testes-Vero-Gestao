package bergs.Bvr.Bvruaajm.test.utils.enums;

import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_Estabelecimento;
import bergs.Bvr.Bvruaajm.test.utils.model.Bvruaajm_RedeEstabelecimentoTerminal;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Formatador;

public enum Bvruaajm_EnumEstabelecimentoConveniado {

    EmpresaPjPaulo{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("EMPRESA PJ PAULO", Long.parseLong("62907237000108"),
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            return estabelecimento;
        }
    },

    RelatorioVisita {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("TESTE RELATORIO VISITA", Long.parseLong("00056782000171"),
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            return estabelecimento;
        }
    },

    Aduana {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("ADUANA", Long.parseLong("72099922000109"),
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            return estabelecimento;
        }
    },
    
    SupermercadoGecepel {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("SUPERMERCADO GECEPEL", Long.parseLong("92733559000149"),
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            return estabelecimento;
        }
    },

    TestEmbosso {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("TESTE", Long.parseLong("191"),
                    Bvruaajm_EnumTipoPessoa.FISICA,"PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    TestForaRedeBWT {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("MERCADO TREVISAN", Long.parseLong("89442578000101"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    BancoBergs {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("BANCO BERGS", Long.parseLong("92702067000196"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    TesteBVR {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabTesteBVR = new Bvruaajm_Estabelecimento();
            estabTesteBVR.definirNome("TESTE BVR");
            estabTesteBVR.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.FISICA);
            estabTesteBVR.definirCpfCnpj(Integer.parseInt(Bmouaajm_Formatador.filtrarNaoDigitos("010.038.590-70")));
            return estabTesteBVR;
        }
    },
    
    TesteGustavoImagens {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("HELLEN CRISTIANE AGUIAR COSTA", Long.parseLong("01049476085"), 
                    Bvruaajm_EnumTipoPessoa.FISICA, "PORTO ALEGRE");
            return estabelecimento;
        }
  	},
    
    ZuleicaMelo {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabTesteBVR = new Bvruaajm_Estabelecimento();
            estabTesteBVR.definirNome("ZULEICA MELLO GARCEZ");
            estabTesteBVR.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.FISICA);
            estabTesteBVR.definirCpfCnpj(Integer.parseInt(Bmouaajm_Formatador.filtrarNaoDigitos("000.003.490-89")));
            return estabTesteBVR;
        }
    },
    
    TumeleroLoja1 {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("TUMELERO - LOJA 1", Long.parseLong("92860238000105"),
                    Bvruaajm_EnumTipoPessoa.JURIDICA,"PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    PedroManica {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("PEDRO MANICA", Long.parseLong("07712191000163"),
                    Bvruaajm_EnumTipoPessoa.JURIDICA,"PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    AmeliaVargas {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabTesteBVR = new Bvruaajm_Estabelecimento();
            estabTesteBVR.definirNome("AMELIA IZOLETES VARGAS");
            estabTesteBVR.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.FISICA);
            estabTesteBVR.definirCpfCnpj(Integer.parseInt(Bmouaajm_Formatador.filtrarNaoDigitos("000.004.830-52")));
            return estabTesteBVR;
        }
    },
    
    TesteGusavo2 {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabTesteBVR = new Bvruaajm_Estabelecimento();
            estabTesteBVR.definirNome("TESTE GUSAVO 2");
            estabTesteBVR.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.FISICA);
            estabTesteBVR.definirCpfCnpj(Integer.parseInt(Bmouaajm_Formatador.filtrarNaoDigitos("016.786.640-06")));
            return estabTesteBVR;
        }
    },
    
    InstalacoesHidCuritibaLtda {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("INSTALACOES HID CURITIBA LTDA", Long.parseLong("00115145000138"),
                    Bvruaajm_EnumTipoPessoa.JURIDICA,"PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    MaicoDaSilva {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabTesteBVR = new Bvruaajm_Estabelecimento();
            estabTesteBVR.definirNome("MAICO DA SILVA");
            estabTesteBVR.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.FISICA);
            estabTesteBVR.definirCpfCnpj(Integer.parseInt(Bmouaajm_Formatador.filtrarNaoDigitos("009.067.630-02")));
            return estabTesteBVR;
        }
    },
    
    MercadoTrevisan{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("MERCADO TREVISAN", Long.parseLong("89442578000101"), 
                    Bvruaajm_EnumTipoPessoa.FISICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
        
    LucianeCorreaGarcia{                                        
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("LUCIANE CORREA GARCIA", Long.parseLong("47924560025"), 
                    Bvruaajm_EnumTipoPessoa.FISICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    CasaDoPintor7Teste {                                        
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("CASA DO PINTOR", Long.parseLong("00066122000180"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    CasaDoPintor2Teste {                                        
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("CASA DO PINTOR TESTE 2", Long.parseLong("00066122000261"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    PsrExterno {                                        
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("MARILIA MAKE", Long.parseLong("90308653000125"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    PsrHabilitado {                                        
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("LUCIANE CORREA GARCIA", Long.parseLong("00000000353"), 
                    Bvruaajm_EnumTipoPessoa.FISICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },


    // EC que não possui Rede BWT Cadastrada no cartao 60987847520
    TestePixVero{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("TESTE VERO PIX", Long.parseLong("51915556000149"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    LionsClubDeCotipora{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("LIONS CLUB DE COTIPORA", Long.parseLong("00074346000134"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    SweetFlavors{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("SWEET FLAVORS", Long.parseLong("23576591000145"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },

    // EC com Rede BWT Desabilitada no cartao 60987847520
    BetosLancheria2{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("BETOS LANCHERIA 2", Long.parseLong("00512052000228"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    BetosLancheriaLtda{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("BETOS LANCHERIA LTDA", Long.parseLong("00512052000147"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    GabrielaSchreiner{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabTesteUmaContaCorrente = new Bvruaajm_Estabelecimento();
            estabTesteUmaContaCorrente.definirNome("GABRIELA SCHREINER");
            estabTesteUmaContaCorrente.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.FISICA);
            estabTesteUmaContaCorrente.definirCpfCnpj(Integer.parseInt(Bmouaajm_Formatador.filtrarNaoDigitos("000.585.570-59")));
            return estabTesteUmaContaCorrente;
        }
    },
    
    BanrisulEstab2377{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_RedeEstabelecimentoTerminal terminal = new Bvruaajm_RedeEstabelecimentoTerminal("411286000", "8", "WALLET");
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("BANRISUL ESTAB 2377", Long.parseLong("92702067015037"), 
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            estabelecimento.definirTerminalQRCode(terminal);
            return estabelecimento;
        }
    },
    
    ConsultoriaInfoteca{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("CONSULTORIA INFOTECA");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("00.110.560/0001-07")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    
    TestePJ04 {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("Teste PJ 04");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("93.489.904/0001-03")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    
    VERO {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("VERO");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("92.934.215/0001-06")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },   
        
    TestPixOrdenarContas {
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("VERO", Long.parseLong("92934215000106"),
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "PORTO ALEGRE");
            return estabelecimento;
        }
    },
       
    TestPixComFalha{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabTesteUmaContaCorrente = new Bvruaajm_Estabelecimento();
            estabTesteUmaContaCorrente.definirNome("ZULEICA MELLO GARCEZ");
            estabTesteUmaContaCorrente.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.FISICA);
            estabTesteUmaContaCorrente.definirCpfCnpj(Integer.parseInt(Bmouaajm_Formatador.filtrarNaoDigitos("000.003.490-89")));
            return estabTesteUmaContaCorrente;
        }

    },
    
    PostoNevoeiro{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("POSTO NEVOEIRO");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("95.425.369/0013-96")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
        
    },
    
    MassaNona{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("MASSAS DA NONA TESTE");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("88.974.506/0001-42")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    Alberto{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("ALBERTO ABRAHAO LEVY");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("05599636020")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.FISICA);
            return estab;
        }
    },
    
    EstiloLu{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("ESTILO LU");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("02.748.381/0001-17")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    
    MercadoBernard{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("MERCADO E ACOUGUE BERNARD");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("10.497.745/0001-61")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    
    JoalheriaPiratini{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("JOALHERIA PIRATINI");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("96.923.461/0001-05")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    
    Vg8Vj{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("VG8VJ TECNOLOGIA SA");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("32.890.315/0001-48")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    
    Digimer{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("DIGIMER");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("88.153.119/0001-45")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    
    Agrocenter{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("AGROCENTER");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("04.664.097/0001-98")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    
    DaianaMoraes{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("DAIANA MORAES");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("000.560.030-80")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    PrimoCar{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("PRIMO CAR COMERCIO DE AUTOMOVEIS LT");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("00.087.420/0001-57")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.JURIDICA);
            return estab;
        }
    },
    JonathanBarbiero{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("JONATHAN ANDREIS BARBIERO");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("029.071.219-01")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.FISICA);
            return estab;
        }
    },
    CnpjInvalido{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("Cnpj Invalido", Long.parseLong("12345678910112"),
                    Bvruaajm_EnumTipoPessoa.JURIDICA, "Porto Alegre");
            return estabelecimento;
        }
    },
    CpfInvalido{
            public Bvruaajm_Estabelecimento obterEstabelecimento() {
                Bvruaajm_Estabelecimento estabelecimento = new Bvruaajm_Estabelecimento("Cpf Invalido", Long.parseLong("12345678901"),
                        Bvruaajm_EnumTipoPessoa.FISICA, "Porto Alegre");
                return estabelecimento;
            }
    },
    JoaoLuisTesteBvr{
        public Bvruaajm_Estabelecimento obterEstabelecimento() {
            Bvruaajm_Estabelecimento estab = new Bvruaajm_Estabelecimento();
            estab.definirNome("JOAO LUIS TESTE BVR");
            estab.definirCpfCnpj(Long.parseLong(Bmouaajm_Formatador.filtrarNaoDigitos("047.272.688-92")));
            estab.definirTipoPessoa(Bvruaajm_EnumTipoPessoa.FISICA);
            return estab;
        }
    };

    public abstract Bvruaajm_Estabelecimento obterEstabelecimento();

}
