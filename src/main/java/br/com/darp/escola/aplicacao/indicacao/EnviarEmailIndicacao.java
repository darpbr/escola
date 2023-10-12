package br.com.darp.escola.aplicacao.indicacao;

import br.com.darp.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
    void enviarPara(Aluno indicado);
}
