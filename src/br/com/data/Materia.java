package br.com.data;

public class Materia {

    private int codigoMateria;
    private Disciplina disciplina;
    private Semestre semestre;
    private SemestreVigente semestreVigente;
    private LocalDaAula localDaAula;

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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

    public LocalDaAula getLocalDaAula() {
        return localDaAula;
    }

    public void setLocalDaAula(LocalDaAula localDaAula) {
        this.localDaAula = localDaAula;
    }

}
