package br.com.dao;

import br.com.dal.ConnectionMySQL;
import java.sql.*;
import br.com.data.Professor;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProfessorDAOJDBC implements ProfessorDAO {

    @Override
    public void create(Professor p) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String insert = "INSERT INTO professor (nomeProfessor,matricula) VALUE(?,?)";

        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, p.getNomeProfessor());
            pst.setString(2, p.getMatricula());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }

    }

    @Override
    public List<Professor> read() {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Professor> professores = new ArrayList<>();
        String list = "SELECT * FROM professor ORDER BY nomeProfessor";

        try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor();

                professor.setCodigoProfessor(rs.getInt("codigoProfessor"));
                professor.setNomeProfessor(rs.getString("nomeProfessor"));
                professor.setMatricula(rs.getString("matricula"));

                professores.add(professor);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return professores;
    }

    @Override
    public List<Professor> search(Professor prof) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Professor> professores = new ArrayList<>();
        String search = "SELECT * FROM professor WHERE nomeProfessor LIKE ?";

        try {
            pst = conexao.prepareStatement(search);
            pst.setString(1, "%" + prof.getNomeProfessor() + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor();

                professor.setCodigoProfessor(rs.getInt("codigoProfessor"));
                professor.setNomeProfessor(rs.getString("nomeProfessor"));
                professor.setMatricula(rs.getString("matricula"));

                professores.add(professor);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return professores;
    }

    @Override
    public void update(Professor p) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "UPDATE professor SET nomeProfessor = ?,matricula = ? WHERE codigoProfessor = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setString(1, p.getNomeProfessor());
            pst.setString(2, p.getMatricula());
            pst.setInt(3, p.getCodigoProfessor());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

}
