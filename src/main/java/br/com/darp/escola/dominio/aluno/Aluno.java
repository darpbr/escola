package br.com.darp.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

// Entidade Aluno => Não devem existir dois Alunos com mesmo cpf
public class Aluno {
    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();
    private String senha;
    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    //    Regra de Negócio!
//    Método para adicionar um numero de telefone, já que um aluno pode adicionar um telefone a qualquer
//    momento
    public void adicionarTelefone(String ddd, String numero){
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCpf() {
        return cpf.getNumero();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
