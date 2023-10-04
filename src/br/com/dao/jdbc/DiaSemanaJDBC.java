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
            pst.setString(1, dia.getDiaSemana());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    @Override
    public List<DiaSemana> read() {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<DiaSemana> diaSemana = new ArrayList<>();
        String list = "SELECT * FROM diaSemana ORDER BY diaSemana";

        /*try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            /*while (rs.next()) {
                DiaSemana dia = new DiaSemana();

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
    }*/
        return diaSemana;
}

@Override
public List<DiaSemana> search(DiaSemana dia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
public void update(DiaSemana dia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
public void delete(DiaSemana dia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
