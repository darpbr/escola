package br.com.darp;

import br.com.darp.escola.Telefone;
import br.com.darp.escola.exceptions.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TelefoneTest {
    @Test
    void naoDeveCriarTelefoneInvalido(){
        Assertions.assertThrows(DomainException.class,
                () -> new Telefone(null,"1234-1234"));
        Assertions.assertThrows(DomainException.class,
                () -> new Telefone("82",null));
        Assertions.assertThrows(DomainException.class,
                () -> new Telefone(null,null));

        Assertions.assertThrows(DomainException.class,
                () -> new Telefone("","1234-1234"));
        Assertions.assertThrows(DomainException.class,
                () -> new Telefone("82",""));
        Assertions.assertThrows(DomainException.class,
                () -> new Telefone("",""));

        Assertions.assertThrows(DomainException.class,
                () -> new Telefone("555","1234-1234"));
        Assertions.assertThrows(DomainException.class,
                () -> new Telefone("5","1234-1234"));

        Assertions.assertThrows(DomainException.class,
                () -> new Telefone("82","12345-1234"));
        Assertions.assertThrows(DomainException.class,
                () -> new Telefone("82","12341234"));
    }
    @Test
    void deveCadastrarTelefoneValido(){
        Telefone telefone = new Telefone("61","1234-1234");
        Assertions.assertTrue(telefone.toString().contains("1234-1234"));
        Assertions.assertTrue(telefone.toString().contains("61"));
    }
}
