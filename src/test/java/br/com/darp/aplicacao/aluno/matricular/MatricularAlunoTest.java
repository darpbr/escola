package br.com.darp.aplicacao.aluno.matricular;

import br.com.darp.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.darp.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.darp.escola.dominio.aluno.Aluno;
import br.com.darp.escola.dominio.aluno.CPF;
import br.com.darp.escola.infra.aluno.RepositorioDeAlunosMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatricularAlunoTest {
    @Test
    void alunoDeveriaSerPersistido(){
//        Poderia utilizar MOCK com Mockito para testes de unidade
        RepositorioDeAlunosMemoria repositorio = new RepositorioDeAlunosMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatricularAlunoDTO dados = new MatricularAlunoDTO(
                "Joao",
                "123.456.789-00",
                "joao@gmail.com");
        useCase.executa(dados);

        Aluno resultado = repositorio.buscarPorCPF(new CPF("123.456.789-00"));

        Assertions.assertEquals("Joao",resultado.getNome());
        Assertions.assertEquals("123.456.789-00",resultado.getCpf());
        Assertions.assertEquals("joao@gmail.com",resultado.getEmail());
    }
}
