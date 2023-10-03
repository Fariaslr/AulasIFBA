/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
}
