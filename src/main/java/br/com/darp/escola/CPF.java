package br.com.darp.escola;

import br.com.darp.escola.exceptions.DomainException;

// VALUE OBJECT => caso seja informado mesmo numero de cpf é tratado como sendo o mesmo objeto
public class CPF {
    private String numero;

    public CPF(String numero){
        validaCpf(numero);
        this.numero = numero;
    }

    private void validaCpf(String numero) {
        String regex = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}";
        if(numero == null || !numero.matches(regex)){
            throw new DomainException("Valor de cpf informado invãlido!");
        }
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "CPF: " + numero;
    }
}
