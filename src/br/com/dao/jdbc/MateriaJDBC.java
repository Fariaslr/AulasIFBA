package br.com.dao.jdbc;

import br.com.dal.*;
import br.com.dao.*;
import br.com.data.*;
import java.awt.HeadlessException;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class MateriaJDBC implements MateriaDAO {

    Materia materia = new Materia();
    Semestre semestre = new Semestre();
    SemestreVigente semestreVigente = new SemestreVigente();
    LocalDaAula localDaAula = new LocalDaAula();

    @Override
    public void create(Materia m) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String insert = "INSERT INTO materia (nomeMateria,codigoSemestre,codigoSemestreVigente,codigoLocalDaAula) VALUE(?,?,?,?)";

        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, m.getNomeMateria());
            pst.setInt(2, m.getSemestre().getCodigoSemestre());
            pst.setInt(3, m.getSemestreVigente().getCodigoSemestreVigente());
            pst.setInt(4, m.getLocalDaAula().getCodigolocalDaAula());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    @Override
    public List<Materia> read() {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Materia> materias = new ArrayList<>();
        String list = "SELECT * FROM materia "
                + "INNER JOIN semestre ON semestre.codigoSemestre = materia.codigoSemestre "
                + "INNER JOIN localDaAula ON localDaAula.codigoLocalDaAula = materia.codigoLocalDaAula";

        try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            while (rs.next()) {
                materia.setCodigoMateria(rs.getInt("codigoMateria"));
                materia.setNomeMateria(rs.getString("nomeMateria"));
                semestre.setCodigoSemestre(rs.getInt("codigoSemestre"));
                semestre.setDescricaoSemestre(rs.getString("descricaoSemestre"));
                semestreVigente.setCodigoSemestreVigente(rs.getInt("codigoSemestreVigente"));
                semestreVigente.setDescricaoSemestreVigente(rs.getString("desricaoSemestreVigente"));
                localDaAula.setCodigolocalDaAula(rs.getInt("codigoLocalAula"));
                localDaAula.setLocalDaAula(rs.getString("localDaAula"));
                
                materia.setSemestre(semestre);
                materia.setSemestreVigente(semestreVigente);
                materia.setLocalDaAula(localDaAula);

                materias.add(materia);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return materias;
    }

    @Override
    public List<Materia> search(Materia m) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Materia m) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Materia m) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
