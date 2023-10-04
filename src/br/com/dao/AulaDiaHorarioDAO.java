package br.com.dao;

import java.util.List;

/**
 *
 * @author Lucas
 */
public interface AulaDiaHorarioDAO {

    public void create(AulaDiaHorarioDAO a);

    public List<AulaDiaHorarioDAO> read();

    public List<AulaDiaHorarioDAO> search(AulaDiaHorarioDAO a);

    public void update(AulaDiaHorarioDAO a);

    public void delete(AulaDiaHorarioDAO a);
}
