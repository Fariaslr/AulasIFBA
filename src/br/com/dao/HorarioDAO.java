package br.com.dao;

import br.com.data.Horario;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface HorarioDAO {
    public void create(Horario h);
    public List<Horario> read();
    public List<Horario> search(Horario h);
    public void update(Horario h);
    public void delete (Horario h);   
}
