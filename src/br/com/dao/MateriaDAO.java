package br.com.dao;

import br.com.data.Materia;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface MateriaDAO {

    public void create(Materia m);

    public List<Materia> read();

    public List<Materia> search(Materia m);

    public void update(Materia m);

    public void delete(Materia m);
}
