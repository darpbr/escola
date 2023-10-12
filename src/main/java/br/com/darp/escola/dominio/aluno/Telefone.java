package br.com.darp.escola.dominio.aluno;

import br.com.darp.escola.exceptions.DomainException;

// VALUE OBJECT
public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        validarDados(ddd, numero);
        this.ddd = ddd;
        this.numero = numero;
    }

    private void validarDados(String ddd, String numero) {
        String regexDdd = "\\d{2}";
        String regexNumero = "\\d{4}\\-\\d{4}";
        if (ddd == null || !ddd.matches(regexDdd)){
            throw new DomainException("DDD informado invalido! Favor verificar: " + ddd);
        }
        if(numero == null || !numero.matches(regexNumero)){
            throw new DomainException("Numero telefone informado invalido! Favor verificar: " + numero);
        }
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Telefone: (0" + ddd + ") " + numero;
    }
}
