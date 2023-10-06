package br.com.dao.jdbc;

import br.com.dal.ConnectionMySQL;
import br.com.dao.HorarioDAO;
import br.com.data.Horario;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class HorarioJDBC implements HorarioDAO {

    @Override
    public void create(Horario h) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String insert = "INSERT INTO horario (descricaoHorario) VALUE(?)";

        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, h.getDescricaoHorario());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    @Override
    public List<Horario> read() {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Horario> Horarios = new ArrayList<>();
        String list = "SELECT * FROM horario ORDER BY descricaoHorario";

        try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            while (rs.next()) {
                Horario h = new Horario();

                h.setCodigoHorario(rs.getInt("codigoHorario"));
                h.setDescricaoHorario(rs.getString("descricaoHorario"));

                Horarios.add(h);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return Horarios;
    }

    @Override
    public List<Horario> search(Horario h) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Horario> Horarios = new ArrayList<>();
        String search = "SELECT * FROM horario WHERE descricaoHorario LIKE ?";

        try {
            pst = conexao.prepareStatement(search);
            pst.setString(1, "%" + h.getDescricaoHorario() + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                Horario horario = new Horario();
                h.setCodigoHorario(rs.getInt("codigoHorario"));
                h.setDescricaoHorario(rs.getString("descricaoHorario"));

                Horarios.add(horario);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return Horarios;
    }

    @Override
    public void update(Horario h) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "UPDATE horario SET descricaoHorario = ? WHERE codigoHorario = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setString(1, h.getDescricaoHorario());
            pst.setInt(2, h.getCodigoHorario());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    @Override
    public void delete(Horario h) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "DELETE FROM horario WHERE codigohorario = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setInt(1, h.getCodigoHorario());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }
}
