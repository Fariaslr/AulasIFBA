package br.com.dao;

import br.com.data.DiaSemana;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface DiaSemanaDAO {

    public void create(DiaSemana dia);

    public List<DiaSemana> read();

    public List<DiaSemana> search(DiaSemana dia);

    public void update(DiaSemana dia);

    public void delete(DiaSemana dia);
}
