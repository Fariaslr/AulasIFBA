/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao.jdbc;

import br.com.dal.ConnectionMySQL;
import br.com.dao.SemestreVigenteDAO;
import br.com.data.SemestreVigente;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class SemestreVigenteJDBC implements SemestreVigenteDAO {

    @Override
    public void create(SemestreVigente s) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String insert = "INSERT INTO semestreVigente (descricaoSemestreVigente) VALUE(?)";

        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, s.getDescricaoSemestreVigente());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }

    }

    public List<SemestreVigente> read() {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<SemestreVigente> semestresVigentes = new ArrayList<>();
        String list = "SELECT * FROM semestreVigente ORDER BY descricaoSemestreVigente";

        try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            while (rs.next()) {
                SemestreVigente semestre = new SemestreVigente();

                semestre.setCodigoSemestreVigente(rs.getInt("codigoSemestreVigente"));
                semestre.setDescricaoSemestreVigente(rs.getString("descricaoSemestreVigente"));

                semestresVigentes.add(semestre);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return semestresVigentes;
    }

    @Override
    public List<SemestreVigente> search(SemestreVigente s) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<SemestreVigente> semestresVigentes = new ArrayList<>();
        String search = "SELECT * FROM semestreVigente WHERE descricaoSemestre LIKE ?";

        try {
            pst = conexao.prepareStatement(search);
            pst.setString(1, "%" + s.getDescricaoSemestreVigente()+ "%");

            rs = pst.executeQuery();

            while (rs.next()) {

                s.setCodigoSemestreVigente(rs.getInt("codigoSemestreVigente"));
                s.setDescricaoSemestreVigente(rs.getString("descricaoSemestreVigente"));

                semestresVigentes.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return semestresVigentes;
    }

    @Override
    public void update(SemestreVigente s) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "UPDATE semestreVigente SET descricaoSemestreVigente = ? WHERE codigoSemestreVigente = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setString(1, s.getDescricaoSemestreVigente());

            pst.setInt(2, s.getCodigoSemestreVigente());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    @Override
    public void delete(SemestreVigente s) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "DELETE FROM semestreVigente WHERE codigoSemestreVigente = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setInt(1, s.getCodigoSemestreVigente());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

}
