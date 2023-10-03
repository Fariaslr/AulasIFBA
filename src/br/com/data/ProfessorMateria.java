/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.data;

/**
 *
 * @author Lucas
 */
public class ProfessorMateria {

    private Materia codigoMateria;
    private Professor codigoProfessor;
    private SemestreVigente codigoSemestreVigente;

    public Materia getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(Materia codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public Professor getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(Professor codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    public SemestreVigente getCodigoSemestreVigente() {
        return codigoSemestreVigente;
    }

    public void setCodigoSemestreVigente(SemestreVigente codigoSemestreVigente) {
        this.codigoSemestreVigente = codigoSemestreVigente;
    }

}
