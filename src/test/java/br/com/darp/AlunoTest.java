package br.com.darp;

import br.com.darp.escola.dominio.aluno.Aluno;
import br.com.darp.escola.dominio.aluno.FabricaDeAluno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTest {
    @Test
    void deveCriarAlunoValido(){
        FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
        Aluno aluno = fabricaDeAluno.comNomeCPFEmail("joao", "123.456.789-11", "joao@gmail.com")
                .comTelefone("82", "1234-5678")
                .criar();

        Assertions.assertEquals("joao", aluno.getNome());
        Assertions.assertTrue(aluno.getCpf().contains("123.456.789-11"));
        Assertions.assertTrue(aluno.getEmail().contains("joao@gmail.com"));
        Assertions.assertEquals(1, aluno.getTelefones().size());
    }
}
