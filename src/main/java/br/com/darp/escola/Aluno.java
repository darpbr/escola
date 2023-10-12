package br.com.darp.escola;

import java.util.ArrayList;
import java.util.List;

// Entidade Aluno => Não devem existir dois Alunos com mesmo cpf
public class Aluno {
    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

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

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
