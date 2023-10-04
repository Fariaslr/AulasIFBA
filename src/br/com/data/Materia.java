package br.com.data;

public class Materia {

    private int codigoMateria;
    private String nomeMateria;
    private Semestre codigoSemestre;
    private Professor codigoProfessor;

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public Semestre getCodigoSemestre() {
        return codigoSemestre;
    }

    public void setCodigoSemestre(Semestre codigoSemestre) {
        this.codigoSemestre = codigoSemestre;
    }

    public Professor getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(Professor codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

}
