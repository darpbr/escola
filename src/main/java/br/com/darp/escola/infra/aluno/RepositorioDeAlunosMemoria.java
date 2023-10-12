package br.com.darp.escola.infra.aluno;

import br.com.darp.escola.dominio.aluno.Aluno;
import br.com.darp.escola.dominio.aluno.CPF;
import br.com.darp.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.darp.escola.exceptions.AlunoNaoEncontrado;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosMemoria implements RepositorioDeAlunos {
    private List<Aluno> matriculados = new ArrayList<>();
    @Override
    public void matricular(Aluno aluno) {
        matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return matriculados.stream()
                .filter(a -> a.getCpf().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> ListarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
