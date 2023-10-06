package br.com.data;

public class AulaDiaHorario {

    private int codigoAula;
    private Materia codigoMateria;
    private DiaSemana codigoDiaSemana;
    private Horario codigoHorario;

    public int getCodigoAula() {
        return codigoAula;
    }

    public void setCodigoAula(int codigoAula) {
        this.codigoAula = codigoAula;
    }

    public Materia getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(Materia codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public DiaSemana getCodigoDiaSemana() {
        return codigoDiaSemana;
    }

    public void setCodigoDiaSemana(DiaSemana codigoDiaSemana) {
        this.codigoDiaSemana = codigoDiaSemana;
    }

    public Horario getCodigoHorario() {
        return codigoHorario;
    }

    public void setCodigoHorario(Horario codigoHorario) {
        this.codigoHorario = codigoHorario;
    }

}
