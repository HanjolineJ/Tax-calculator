import java.util.Scanner;

public class Help {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        double amount = 0;
        double incomes = 0;
        
        double totalDeductions = 0;

        System.out.print("Enter the income and deductions until 0: ");
        amount = keyboard.nextDouble();

        while (amount != 0) {
            if (amount > 0 && amount <= 68000) {
                incomes = incomes + amount;
                totalDeductions = totalDeductions + Math.round((amount * .1911) -15);
            } else if (amount > 0 && amount <= 122000) {
                incomes = incomes + amount;
                totalDeductions = totalDeductions + Math.round(Math.abs(((amount * 0.20459)) -18));
            }
            System.out.print("Enter the amount: ");
            amount = keyboard.nextDouble();
        }
        double taxableIncome = incomes - Math.abs(totalDeductions);

        double tax = 0;

        double[] taxBrackets = {9700, 39475, 84200, 160725, 204100, 510300};
        double[] taxRates = {0.1, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};
        double[] taxOwed = {728.5, 4301.5, 14043.5, 317459.5, 46386.5, 153556.5};
        
       
        
        for (int i = 0; i < taxBrackets.length; i++) {
    	    if (taxableIncome <= taxBrackets[i]) {
    	        tax = (taxableIncome - (i > 0 ? taxBrackets[i - 1] : 0)) * taxRates[i] + (i > 0 ? taxOwed[i - 1] : 0) ;
    	        break;
    	    } else {
    	        tax = (taxBrackets[i] - (i > 0 ? taxBrackets[i - 1] : 0)) * taxRates[i] + (i > 0 ? taxOwed[i - 1] : 0) ;
    	    }
    	} 
        System.out.println("Reporting...");
        System.out.println("Incomes: " + incomes);
        System.out.println("Deductions: " + (double) Math.round(totalDeductions * 10) / 10);
        System.out.println("Taxable Income: " + taxableIncome);
        System.out.println("Tax amount: " + tax);
    }
}

