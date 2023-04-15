package project2;

import java.util.Scanner;

public class Tax {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double taxIncome;
		double pos = 0;
		double neg = 0;

		while (true) {
			System.out.print("Enter your tax income, enter 0 to stop: ");
			taxIncome = input.nextDouble();

			if (taxIncome == 0) {
				break;
			}else if (taxIncome > 0) {
				pos += taxIncome;
			} else if (taxIncome < 0) {
				neg += Math.abs(taxIncome);
			}
		}

		double totalIncome = pos ;
		System.out.println("Your tax income is: " + totalIncome);

		double deductions;
		double taxableIncome;

		if (neg <= 10275) {
			deductions = 12950;
			System.out.println("Deductions: " + deductions);
			taxableIncome = totalIncome - deductions;
			System.out.println("Taxable income: " + taxableIncome);

		}else {
			deductions = neg;
			taxableIncome = totalIncome - neg;
			System.out.println("Deductions: " + neg);
			System.out.println("Taxable income: " + taxableIncome);
		}

		double please = 0;

		if (taxableIncome <= 41775) {
			please = 1027.5 + 0.12 * (taxableIncome - 10275);
		} else if (taxableIncome <= 89075) {
			please = 4807.5 + 0.22 * (taxableIncome - 41775);
		} else if (taxableIncome <= 170050) {
			please = 15213.5 + 0.24 * (taxableIncome - 89075);
		} else if (taxableIncome <= 215950) {
			please = 34647.5 + 0.32 * (taxableIncome - 170050);
		} else if (taxableIncome <= 539900) {
			please = 49335.5 + 0.35 * (taxableIncome - 215950);
		} else {
			please = 162718 + 0.37 * (taxableIncome - 539900);
		}

		double taxable = please;

		System.out.println("Tax amount: " + (taxable ));
	}
}


	

