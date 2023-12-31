package br.com.darp.escola.aplicacao.aluno.matricular;

import br.com.darp.escola.dominio.aluno.Aluno;
import br.com.darp.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
    private final RepositorioDeAlunos repositorio;
    public MatricularAluno(RepositorioDeAlunos repositorio){
        this.repositorio = repositorio;
    }

    public void executa(MatricularAlunoDTO dados){
        Aluno novo = dados.criarAluno();
        repositorio.matricular(novo);
    }
}
