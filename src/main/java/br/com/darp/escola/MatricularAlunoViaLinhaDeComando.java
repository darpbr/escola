package br.com.darp.escola;

import br.com.darp.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.darp.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.darp.escola.infra.aluno.RepositorioDeAlunosMemoria;

/* Classe criada para exemplificar o comportamento de um usuário ao inserir dados de matricula de alunos
em um prompt de comandos
* */
public class MatricularAlunoViaLinhaDeComando {
    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano.silva@gmail.com";

        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosMemoria());
        matricular.executa(new MatricularAlunoDTO(nome,cpf,email));
    }
}
