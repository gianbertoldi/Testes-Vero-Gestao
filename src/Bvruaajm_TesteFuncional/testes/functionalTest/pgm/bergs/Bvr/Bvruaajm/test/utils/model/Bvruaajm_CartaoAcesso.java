package bergs.Bvr.Bvruaajm.test.utils.model;

import bergs.bmo.bmouaajm.suporte.util.Bmouaajm_Formatador;

public class Bvruaajm_CartaoAcesso {

    protected long cpf;
    protected String apelido;
    protected String email;
    protected String telefone;
    protected String codigoAtivacao;
    protected String senha;

    public Bvruaajm_CartaoAcesso(long cpf, String apelido, String email, String telefone, String codigoAtivacao, String senha) {
        this.cpf = cpf;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.codigoAtivacao = codigoAtivacao;
        this.senha = senha;
    }

    public long obterCpf() {
        return cpf;
    }

    public String obterCpfFormatado() {
        String str = String.valueOf(cpf);
        return Bmouaajm_Formatador.formatarCPF(str);
    }

    public String obterApelido() {
        return apelido;
    }

    public String obterEmail() {
        return email;
    }

    public String obterTelefone() {
        return telefone;
    }

    public String obterCodigoAtivacao() {
        return codigoAtivacao;
    }

    public String obterSenha() {
        return senha;
    }
    
    @Override
    public String toString() {
        return apelido + " " + Bmouaajm_Formatador.formatarCPF(String.valueOf(cpf));
    }
}
