package br.com.data;

public class Materia {

    private int codigoMateria;
    private String nomeMateria;
    private Semestre semestre;
    private SemestreVigente semestreVigente;
    private Professor professor;
    private LocalDaAula localDaAula;

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

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public SemestreVigente getSemestreVigente() {
        return semestreVigente;
    }

    public void setSemestreVigente(SemestreVigente semestreVigente) {
        this.semestreVigente = semestreVigente;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public LocalDaAula getLocalDaAula() {
        return localDaAula;
    }

    public void setLocalDaAula(LocalDaAula localDaAula) {
        this.localDaAula = localDaAula;
    }

}
