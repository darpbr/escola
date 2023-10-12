package br.com.darp;

import br.com.darp.escola.dominio.aluno.CPF;
import br.com.darp.escola.exceptions.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CPFTest {
    @Test
    void naoDeveCriarCpfInvalido(){
        Assertions.assertThrows(DomainException.class,
                () -> new CPF(null));

        Assertions.assertThrows(DomainException.class,
                () -> new CPF(""));

        Assertions.assertThrows(DomainException.class,
                () -> new CPF("32165498711"));
    }
    @Test
    void deveCadastrarCpfValido(){
        CPF cpf = new CPF("123.123.123-11");
        Assertions.assertTrue(cpf.toString().contains("123.123.123-11"));
    }
}
