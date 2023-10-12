package br.com.darp.escola.infra.indicacao;

import br.com.darp.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.darp.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
//        Logica de envio de e-mail com a lib Java Mail
    }
}
