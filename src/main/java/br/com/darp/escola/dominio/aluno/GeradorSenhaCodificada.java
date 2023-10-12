package br.com.darp.escola.dominio.aluno;

public interface GeradorSenhaCodificada {
    String gerarSenhaCodificada(String senha);
    boolean validarSenhaCodificada(String senhaCodificada, String senha);
}
