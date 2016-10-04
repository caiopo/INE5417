package model.local;

public class Laboratorio extends Local {

	private int numeroDeComputadores;

	public Laboratorio(String nome, int capacidade, int numeroDeComputadores) {
		super(nome, capacidade);
		this.numeroDeComputadores = numeroDeComputadores;
	}

	@Override
	public String toString() {
		String superts = super.toString();

		return superts.substring(0, superts.length() - 2) + String
				.format(", numeroDeComputadores=%d)", numeroDeComputadores);
	}

	public int getNumeroDeComputadores() {
		return numeroDeComputadores;
	}

	public void setNumeroDeComputadores(int numeroDeComputadores) {
		this.numeroDeComputadores = numeroDeComputadores;
	}

}
