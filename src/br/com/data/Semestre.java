package br.com.data;

public class Semestre {
	
	private int codigoSemestre;
	private String descricaoSemestre;
	
	public int getCodigoSemestre() {
		return codigoSemestre;
	}
	public void setCodigoSemestre(int codigoSemestre) {
		this.codigoSemestre = codigoSemestre;
	}
	public String getDescricaoSemestre() {
		return descricaoSemestre;
	}
	public void setDescricaoSemestre(String descricaoSemestre) {
		this.descricaoSemestre = descricaoSemestre;
	}

    @Override
    public String toString() {
        return descricaoSemestre;
    }
	
	
}
