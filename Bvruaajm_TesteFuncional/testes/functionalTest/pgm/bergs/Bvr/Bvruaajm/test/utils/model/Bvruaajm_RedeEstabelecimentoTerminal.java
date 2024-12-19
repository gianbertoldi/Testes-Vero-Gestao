package bergs.Bvr.Bvruaajm.test.utils.model;

public class Bvruaajm_RedeEstabelecimentoTerminal {

    String rede;
    String estab;
    String terminal;

    public Bvruaajm_RedeEstabelecimentoTerminal(String rede, String estab, String terminal) {
        this.rede = rede;
        this.estab = estab;
        this.terminal = terminal;
    }

    public String obterRede() {
        return rede;
    }

    public String obterEstab() {
        return estab;
    }

    public String obterTerminal() {
        return this.terminal;
    }
}
