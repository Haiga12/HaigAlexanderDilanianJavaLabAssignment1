// @Author Haig-Alexander Dilanian
package LabAssignment1;
import java.util.Scanner; // Imported Scanner so that the application is able to take user input and run the desired method.

public class LabAssignment1 {
    // Instantiating the Scanner once, so that all the methods can use it.
    private final Scanner sc;
    
    public LabAssignment1(){
        sc = new Scanner(System.in);
    }
    //Main menu of the application where you can choose what you want to do by entering a number from 1 to 4.
    public static void main(String[] args) {
        new LabAssignment1().perform();
}
    public void perform(){
        while (true) {
            System.out.println("Financial Calculator:");
            System.out.println("1) Loan Calculator");
            System.out.println("2) Future Value of Savings Calculator");
            System.out.println("3) Savings Goal Calculator");
            System.out.println("4) Exit \n");
            System.out.println("Enter Wanted Calculator:");
            int chosenOption = sc.nextInt();
            
            switch (chosenOption) {
                case 1 -> loanCalculator();
                case 2 -> futureSavingsCalculator();
                case 3 -> savingsGoalCalculator();
                case 4 -> {System.out.println("Exiting..."); System.exit(0);}
                default -> System.out.println("Error. Enter a number between 1 and 4.");
            }
        }
    }   
    //Loan Calculator
    private void loanCalculator() {    
        System.out.print("Loan Amount: ");
        double loanAmount = sc.nextDouble();
        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = sc.nextDouble();
        System.out.print("Term In Months: ");
        int termMonths = sc.nextInt();

        double monthlyInterestRate = annualInterestRate/12;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1-Math.pow(1+monthlyInterestRate, -termMonths));
        System.out.printf("\n Monthly Payment: $%.2f%n \n", monthlyPayment);
    }  
    // Future Savings Calculator
    private void futureSavingsCalculator() {
        System.out.print("Amount Each Month: ");
        double amountPerMonth = sc.nextDouble();
        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = sc.nextDouble();
        System.out.print("Number Of Years: ");
        int years = sc.nextInt();

        double monthlyInterestRate = annualInterestRate/12;
        int numberOfMonths = years*12;
        double futureValue = amountPerMonth*((Math.pow(1+monthlyInterestRate, numberOfMonths)-1)/ monthlyInterestRate);
        System.out.printf("\n Future Value Of Savings: $%.2f%n \n", futureValue);
    }
    // Savings Goal Calculator
    private void savingsGoalCalculator() {
        System.out.print("Target Amount Desired: ");
        double targetAmount = sc.nextDouble();
        System.out.print("Annual Interest Rate Expected: ");
        double annualInterestRate = sc.nextDouble();
        System.out.print("Number Of Years: ");
        int years = sc.nextInt();

        double monthlyInterestRate = annualInterestRate/12;
        int numberOfMonths = years*12;
        double monthlyPayment = targetAmount*monthlyInterestRate/((Math.pow(1+monthlyInterestRate, numberOfMonths)-1));
        System.out.printf("\n You have to put aside $%.2f per month.%n \n", monthlyPayment);
    }
}
