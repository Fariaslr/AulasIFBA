package br.com.dao;

import br.com.data.SemestreVigente;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface SemestreVigenteDAO {

    public void create(SemestreVigente s);

    public List<SemestreVigente> read();

    public List<SemestreVigente> search(SemestreVigente s);

    public void update(SemestreVigente s);

    public void delete(SemestreVigente s);
}
