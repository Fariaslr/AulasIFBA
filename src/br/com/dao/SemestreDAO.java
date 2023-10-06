package br.com.dao;

import br.com.data.Semestre;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface SemestreDAO {

    public void create(Semestre s);

    public List<Semestre> read();

    public List<Semestre> search(Semestre s);

    public void update(Semestre s);

    public void delete(Semestre s);
}
