package br.com.darp.escola.dominio.aluno;

import br.com.darp.escola.exceptions.DomainException;

// VALUE OBJECT => Classe simples, se existir algum e-mail igual trata como sendo mesmo objeto
public class Email {
    private String email;
    public Email(String email){
        validaEmail(email);
        this.email = email;
    }

    private void validaEmail(String email) {
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(email == null || !email.matches(regex)){
            throw new DomainException("Endereco de e-mail informado fora do padrao aceito." +
                    "\nExemplo: endereco@provedor.com");
        }
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Email: " + email;
    }
}
