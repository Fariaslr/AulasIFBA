package br.com.dao;

import br.com.data.Professor;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface ProfessorDAO {
    public void create(Professor p);
    public List<Professor> read();
    public List<Professor> search(Professor p);
    public void update(Professor p);
    public void delete (Professor p);
}
