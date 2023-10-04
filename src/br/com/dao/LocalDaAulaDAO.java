package br.com.dao;

import br.com.data.LocalDaAula;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface LocalDaAulaDAO {

    public void create(LocalDaAula local);

    public List<LocalDaAula> read();

    public List<LocalDaAula> search(LocalDaAula local);

    public void update(LocalDaAula local);

    public void delete(LocalDaAula local);
}
