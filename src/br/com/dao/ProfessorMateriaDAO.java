package br.com.dao;

import br.com.data.ProfessorMateria;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface ProfessorMateriaDAO {

    public void create(ProfessorMateria pm);

    public List<ProfessorMateria> read();

    public List<ProfessorMateria> search(ProfessorMateria pm);

    public void update(ProfessorMateria pm);

    public void delete(ProfessorMateria pm);
}
