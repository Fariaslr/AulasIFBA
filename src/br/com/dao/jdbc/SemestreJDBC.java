/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao.jdbc;

import br.com.dal.ConnectionMySQL;
import br.com.dao.SemestreDAO;
import br.com.data.Semestre;
import java.sql.*;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class SemestreJDBC implements SemestreDAO {

    public void create(Semestre s) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String insert = "INSERT INTO semestre (descricaoSemestre) VALUE(?)";

        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, s.getDescricaoSemestre());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    @Override
    public List<Semestre> read() {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Semestre> semestres = new ArrayList<>();
        String list = "SELECT * FROM semestre ORDER BY codigoSemestre";

        try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            while (rs.next()) {
                Semestre semestre = new Semestre();

                semestre.setCodigoSemestre(rs.getInt("codigoSemestre"));
                semestre.setDescricaoSemestre(rs.getString("descricaoSemestre"));

                semestres.add(semestre);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return semestres;
    }

    @Override
    public List<Semestre> search(Semestre sem) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Semestre> semestres = new ArrayList<>();
        String search = "SELECT * FROM semestre WHERE descricaoSemestre LIKE ?";

        try {
            pst = conexao.prepareStatement(search);
            pst.setString(1, "%" + sem.getDescricaoSemestre() + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                Semestre semestre = new Semestre();

                semestre.setCodigoSemestre(rs.getInt("codigoSemestre"));
                semestre.setDescricaoSemestre(rs.getString("descricaoSemestre"));

                semestres.add(semestre);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return semestres;
    }

    @Override
    public void update(Semestre s) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "UPDATE semestre SET descricaoSemestre = ? WHERE codigoSemestre = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setString(1, s.getDescricaoSemestre());

            pst.setInt(2, s.getCodigoSemestre());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    @Override
    public void delete(Semestre s) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "DELETE FROM semestre WHERE codigoSemestre = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setInt(1, s.getCodigoSemestre());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

}
