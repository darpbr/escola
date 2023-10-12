package br.com.darp.escola.infra.aluno;

import br.com.darp.escola.dominio.aluno.Aluno;
import br.com.darp.escola.dominio.aluno.CPF;
import br.com.darp.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.darp.escola.dominio.aluno.Telefone;
import br.com.darp.escola.exceptions.DomainException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RepositorioDeAlunosJDBC implements RepositorioDeAlunos {
    private final Connection connection;
    public RepositorioDeAlunosJDBC(Connection connection){
        this.connection = connection;
    }
    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNO VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES (?, ?)";
            ps = connection.prepareStatement(sql);

            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new DomainException(e.getMessage());
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return null;
    }

    @Override
    public List<Aluno> ListarTodosAlunosMatriculados() {
        return null;
    }
}
