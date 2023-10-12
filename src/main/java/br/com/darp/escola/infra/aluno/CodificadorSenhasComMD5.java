package br.com.darp.escola.infra.aluno;

import br.com.darp.escola.dominio.aluno.GeradorSenhaCodificada;
import br.com.darp.escola.exceptions.DomainException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CodificadorSenhasComMD5 implements GeradorSenhaCodificada {
    @Override
    public String gerarSenhaCodificada(String senha) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }catch (NoSuchAlgorithmException e){
            throw new DomainException("erro ao gerar hash da senha.");
        }
    }

    @Override
    public boolean validarSenhaCodificada(String senhaCodificada, String senha) {
        return senhaCodificada.equals(gerarSenhaCodificada(senha));
    }
}
