package bergs.Bvr.Bvruaajm.test.utils.model;

import bergs.Bvr.Bvruaajm.test.utils.enums.Bvruaajm_EnumTipoPessoa;
import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Formatador;

public class Bvruaajm_Estabelecimento implements Comparable<Bvruaajm_Estabelecimento> {

    protected String nome;
    protected long cpfCnpj;
    protected Bvruaajm_EnumTipoPessoa tipoPessoa;
    protected String cidade;
    protected Bvruaajm_RedeEstabelecimentoTerminal terminalQRCode;
    protected String tipo;

    public Bvruaajm_Estabelecimento() {

    }

    public Bvruaajm_Estabelecimento(String nome, long cpfCnpj, Bvruaajm_EnumTipoPessoa tipoPessoa, String cidade) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.tipoPessoa = tipoPessoa;
        this.cidade = cidade;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public String obterNome() {
        return nome;
    }

    public void definirCpfCnpj(long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public long obterCpfCnpj() {
        return cpfCnpj;
    }

    public String obterCpfCnpjFormatado() {
        if (tipoPessoa == Bvruaajm_EnumTipoPessoa.FISICA) {
            return Bmouaajm_Formatador.formatarCPF(String.valueOf(cpfCnpj));
        } else if (tipoPessoa == Bvruaajm_EnumTipoPessoa.JURIDICA) {
            return Bmouaajm_Formatador.formatarCNPJ(String.valueOf(cpfCnpj));
        }
        return null;
    }
    
    public String obterCnpjZerosAEsquerda() {
        return Bmouaajm_Formatador.preencherAEsquerda(String.valueOf(cpfCnpj),14,"0");
    }

    public void definirTipoPessoa(Bvruaajm_EnumTipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Bvruaajm_EnumTipoPessoa obterTipoPessoa() {
        return tipoPessoa;
    }

    public void definirCidade(String cidade) {
        this.cidade = cidade;
    }

    public String obterCidade() {
        return cidade;
    }

    public void definirTerminalQRCode(Bvruaajm_RedeEstabelecimentoTerminal terminal) {
        this.terminalQRCode = terminal;
    }

    public Bvruaajm_RedeEstabelecimentoTerminal obterTerminalQRCode() {
        return terminalQRCode;
    }
    
    public void definirTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String obterTipo() {
        return tipo;
    }

    @Override
    public int compareTo(Bvruaajm_Estabelecimento o) {
        long cpf1 = obterCpfCnpj();
        long cpf2 = o.obterCpfCnpj();
        if (this.tipoPessoa == Bvruaajm_EnumTipoPessoa.FISICA) {
            cpf1 = cpf1 * 1000;
        }
        if (o.tipoPessoa == Bvruaajm_EnumTipoPessoa.FISICA) {
            cpf2 = cpf2 * 1000;
        }
        if (cpf1 == cpf2) {
            return o.obterTipo().compareTo(obterTipo());
        } else {
            return cpf1 > cpf2 ? 1 : -1;
        }
    }
    
    @Override
    public String toString() {
        return nome + " | " + cpfCnpj + " | " + tipo;
    }

}

