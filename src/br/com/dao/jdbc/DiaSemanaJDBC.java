package br.com.dao.jdbc;

import br.com.dal.ConnectionMySQL;
import br.com.dao.DiaSemanaDAO;
import br.com.data.DiaSemana;
import br.com.data.Horario;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class DiaSemanaJDBC implements DiaSemanaDAO {

    @Override
    public void create(DiaSemana dia) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String insert = "INSERT INTO diaSemana (diaSemana) VALUE(?)";

        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, dia.getDescricaoDia());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    public List<DiaSemana> read() {

    Connection conexao = ConnectionMySQL.conectar();
    PreparedStatement pst = null;
    ResultSet rs = null;

    List<DiaSemana> diasSemana = new ArrayList<>();
    String list = "SELECT * FROM diaSemana ORDER BY codigoDiaSemana";

    try {
        pst = conexao.prepareStatement(list);
        rs = pst.executeQuery();

        while (rs.next()) {
            DiaSemana diaSemana = new DiaSemana();

            diaSemana.setCodigoDiaSemana(rs.getInt("codigoDiaSemana"));
            diaSemana.setDescricaoDia(rs.getString("descricaoDia"));

            diasSemana.add(diaSemana);
        }
    } catch (SQLException e) {
        System.out.println("Aqui é o erro: " + e);
    } finally {
        ConnectionMySQL.closeConnection(conexao, pst);
    }
    return diasSemana;
}

@Override
public List<DiaSemana> search(DiaSemana dia) {

    Connection conexao = ConnectionMySQL.conectar();
    PreparedStatement pst = null;
    ResultSet rs = null;

    List<DiaSemana> diasSemana = new ArrayList<>();
    String search = "SELECT * FROM diaSemana WHERE descricaoDia LIKE ?";

    try {
        pst = conexao.prepareStatement(search);
        pst.setString(1, "%" + dia.getDescricaoDia()+ "%");

        rs = pst.executeQuery();

        while (rs.next()) {
            DiaSemana diaSemana = new DiaSemana();

            diaSemana.setCodigoDiaSemana(rs.getInt("codigoDiaSemana"));
            diaSemana.setDescricaoDia(rs.getString("descricaoDia"));

            diasSemana.add(diaSemana);
        }
    } catch (SQLException e) {
        System.out.println("Aqui é o erro: " + e);
    } finally {
        ConnectionMySQL.closeConnection(conexao, pst);
    }
    return diasSemana;
}

@Override
public void update(DiaSemana d) {

    Connection conexao = ConnectionMySQL.conectar();
    PreparedStatement pst = null;

    String update = "UPDATE diaSemana SET descricaoDia = ? WHERE codigoDiaSemana = ?";

    try {
        pst = conexao.prepareStatement(update);
        pst.setString(1, d.getDescricaoDia());
        pst.setInt(3, d.getCodigoDiaSemana());

        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + e);
    } finally {
        ConnectionMySQL.closeConnection(conexao, pst);
    }
}

@Override
public void delete(DiaSemana d) {

    Connection conexao = ConnectionMySQL.conectar();
    PreparedStatement pst = null;

    String update = "DELETE FROM diaSemana WHERE codigoDia = ?";

    try {
        pst = conexao.prepareStatement(update);
        pst.setInt(1, d.getCodigoDiaSemana());

        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + e);
    } finally {
        ConnectionMySQL.closeConnection(conexao, pst);
    }
} 
    
}
