package model.id;

import java.util.ArrayList;
import java.util.List;

import exceptions.BadCPFException;

public class CPF extends Identificador {

	private String cpf;

	public CPF(String cpf) {
		if (!isValid(cpf)) {
			throw new BadCPFException();
		}

		this.cpf = cpf;
	}

	@Override
	public String get() {
		return cpf;
	}

	public static boolean isValid(String cpf) {
		// xxx.xxx.xxx-xx
		// xxxxxxxxxxx

		if (cpf.length() == 14 && cpf.charAt(3) == '.' && cpf.charAt(7) == '.'
				&& cpf.charAt(11) == '-') {

			cpf = cpf.replace(".", "").replace("-", "");
		}

		if (cpf.length() != 11) {
			return false;
		}

		List<Integer> nums = new ArrayList<>();

		cpf.chars().forEach(i -> nums.add(Character.getNumericValue(i)));

		for (int i = 0; i < 9; i++) {
			final int j = i;
			if (nums.stream().allMatch(n -> n == j)) {
				return false;
			}
		}

		int dig1 = 0;

		for (int i = 0; i < 9; i++) {
			dig1 += nums.get(i) * (10 - i);
		}

		dig1 = 11 - (dig1 % 11);

		if (dig1 > 9) {
			dig1 = 0;
		}

		int dig2 = 0;

		for (int i = 0; i < 9; i++) {
			dig2 += nums.get(i) * (11 - i);
		}

		dig2 = 11 - (dig2 % 11);

		if (dig2 > 9) {
			dig2 = 0;
		}

		if (!(dig1 == nums.get(9) && dig2 == nums.get(10))) {
			return false;
		}

		return true;
	}

}
