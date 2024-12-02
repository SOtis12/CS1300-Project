import java.util.Scanner;
/*
 * Authors: Rogelio Flores, Kian Naderi, Samuel Otis
 * Description: This program is a practice of creating loops to manage repetitive action (tracking amount mentioned in checks),
 * analyzing various formulations of fairness in dividing resources, developing an algorithm that you think is fair in dividing
 * the pooled tip amount, implementing the tip division algorithm in Java, and evaluating alternative approaches to dividing the 
 * pooled amount.
 */

public class CS1400_Project_Tip_Pooling {
    public static void main(String[] args) {
        // Initializes the scanner and variables to keep track of totals.
        Scanner scnr = new Scanner(System.in);
        double saleAmount = 0.0;
        double tipAmount = 0.0;
        double totalAmount = 0.0;
        String managerResponse = "";
        // Locked variable of 2 server working while 3 servers are hired
        final int SERVERS_PRESENT = 2;

        // Creates an instance of RestaurantCheckManager.
        RestaurantCheckManager checkManager = new RestaurantCheckManager(); 
        TipDistribution tipDistributor = new TipDistribution();


        // Starts the loop that runs until the manager decides to stop.
        while (true) {
            System.out.print("\nEnter sale amount: ");
            saleAmount = getValidAmount(scnr);

            System.out.print("Enter tip amount: ");
            tipAmount = getValidAmount(scnr);

            System.out.print("Enter total amount: ");
            totalAmount = getValidAmount(scnr);

            // Passes the values to RestaurantCheckManager to process the check.
            checkManager.processCheck(saleAmount, tipAmount, totalAmount);

            // Displays running totals and tip distribution
            System.out.printf("Check Count: %d\n", checkManager.getCheckCount());
            System.out.printf("Total Sale So Far: $%.2f\n", checkManager.getTotalSaleAmount());
            System.out.printf("Total Pooled Tip So Far: $%.2f\n", checkManager.getTotalTipAmount());
            tipDistributor.distriubuteTips(checkManager.getTotalTipAmount(), SERVERS_PRESENT);


            // Asks the manager if they want to continue
            System.out.print("Do you want to stop? (y/n): ");
            managerResponse = scnr.next();

            // Exits the loop if manager types 'y' or 'Y'
            if (managerResponse.equalsIgnoreCase("y")) {
                break;
            }
        }

        // After finishing the loop, display the results
        checkManager.displayResults();
        scnr.close();
    }

    // Helper method to get a valid amount input (with validation)
    private static double getValidAmount(Scanner scnr) {
        double amount = 0.0;
    
        while (true) {
            if (scnr.hasNextDouble()) {
                amount = scnr.nextDouble();
                
                if (amount < 0) {
                    System.out.print("Amount cannot be negative. Please enter a valid amount: ");
                } else {
                    return amount;
                }
            } else {
                System.out.print("Invalid input. Please enter a valid number: ");
                scnr.next();  // Clears the invalid input
            }
        }
    }
}
