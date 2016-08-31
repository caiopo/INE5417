package model.local;

public class Laboratorio extends Local {

	private final int numeroDeComputadores;

	public Laboratorio(String nome, int capacidade, int numeroDeComputadores) {
		super(nome, capacidade);
		this.numeroDeComputadores = numeroDeComputadores;
	}

}
