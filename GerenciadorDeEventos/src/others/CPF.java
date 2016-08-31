package others;

import exceptions.BadCPFException;

public class CPF implements Identificador {

	private String cpf;

	public CPF(String cpf) {
		// xxx.xxx.xxx-xx
		// xxxxxxxxxxx

		if (cpf.length() == 14) {
			cpf = cpf.replace(".", "").replace("-", "");
		}

		if (cpf.length() != 11) {
			throw new BadCPFException();
		}

		int[] nums = new int[11];

		for (int i = 0; i < cpf.length(); i++) {
			nums[i] = Integer.parseInt(cpf.substring(i, i + 1));
		}

		this.cpf = cpf;
	}

	@Override
	public String getID() {
		return cpf;
	}
}
