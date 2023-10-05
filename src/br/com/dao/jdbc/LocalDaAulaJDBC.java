/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao.jdbc;

import br.com.dal.ConnectionMySQL;
import br.com.dao.LocalDaAulaDAO;
import br.com.data.LocalDaAula;
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
public class LocalDaAulaJDBC implements LocalDaAulaDAO {

    @Override
    public void create(LocalDaAula local) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String insert = "INSERT INTO localDaAula (localDaAula) VALUE(?)";

        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, local.getLocalDaAula());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    @Override
    public List<LocalDaAula> read() {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<LocalDaAula> locais = new ArrayList<>();
        String list = "SELECT * FROM localDaAula ORDER BY localDaAula";

        try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            while (rs.next()) {
                LocalDaAula local = new LocalDaAula();

                local.setCodigolocalDaAula(rs.getInt("codigoLocalDaAula"));
                local.setLocalDaAula(rs.getString("localDaAula"));

                locais.add(local);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return locais;
    }

    @Override
    public List<LocalDaAula> search(LocalDaAula local) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<LocalDaAula> locais = new ArrayList<>();
        String search = "SELECT * FROM localDaAula WHERE localDaAula LIKE ?";

        try {
            pst = conexao.prepareStatement(search);
            pst.setString(1, "%" + local.getLocalDaAula() + "%");

            rs = pst.executeQuery();

            while (rs.next()) {

                local.setCodigolocalDaAula(rs.getInt("codigoLocalDaAula"));
                local.setLocalDaAula(rs.getString("localDaAula"));

                locais.add(local);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return locais;
    }

    @Override
    public void update(LocalDaAula local) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "UPDATE localDaAula SET localDaAula = ? WHERE codigoLocalDaAula = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setString(1, local.getLocalDaAula());
            pst.setInt(2, local.getCodigolocalDaAula());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    @Override
    public void delete(LocalDaAula local) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "DELETE FROM localDaAula WHERE codigolocalDaAula = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setInt(1, local.getCodigolocalDaAula());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

}
