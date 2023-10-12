package br.com.darp;

import br.com.darp.escola.Email;
import br.com.darp.escola.exceptions.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest {
    @Test
    void naoDeveCriarEmailsComEnderecoInvalido(){
        Assertions.assertThrows(DomainException.class,
                () -> new Email(null));

        Assertions.assertThrows(DomainException.class,
                () -> new Email(""));

        Assertions.assertThrows(DomainException.class,
                () -> new Email("email-invalido"));
    }
    @Test
    void deveCadastrarEmailValido(){
        Email email = new Email("darp@gmail.com");
        Assertions.assertTrue(email.toString().contains("darp@gmail.com"));
    }
}
