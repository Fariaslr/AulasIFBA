package br.com.dao;

import br.com.dal.ConnectionMySQL;
import java.sql.*;
import br.com.data.Professor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProfessorDAOJDBC implements ProfessorDAO {

    public void create(Professor p) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        try {
            pst = conexao.prepareStatement("INSERT INTO professor (nomeProfessor,matricula) VALUE(?,?)");
            pst.setString(1, p.getNomeProfessor());
            pst.setString(2, p.getMatricula());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }

    }

    public List<Professor> read() {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Professor> professores = new ArrayList<>();

        try {
            pst = conexao.prepareStatement("SELECT * FROM professor ORDER BY nomeProfessor");
            rs = pst.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor();

                professor.setCodigoProfessor(rs.getInt("codigoProfessor"));
                professor.setNomeProfessor(rs.getString("nomeProfessor"));
                professor.setMatricula(rs.getString("matricula"));
                
                professores.add(professor);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return professores;
    }

    public List<Professor> search(Professor prof) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Professor> professores = new ArrayList<>();

        try {
            pst = conexao.prepareStatement("SELECT * FROM professor WHERE nomeProfessor LIKE ?");
            pst.setString(1, "%" + prof.getNomeProfessor() + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor();

                professor.setCodigoProfessor(rs.getInt("codigoProfessor"));
                professor.setNomeProfessor(rs.getString("nomeProfessor"));
                professor.setMatricula(rs.getString("matricula"));
                
                professores.add(professor);
            }
        } catch (Exception e) {
            System.out.println("Aqui é o erro" + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return professores;
    }
}
