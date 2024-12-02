/*
 * Authors: Rogelio Flores, Kian Naderi, Samuel Otis
 * Description: This is a class file that aids CS1400_Project_Tip_Pooling.java, it is 
 * responsible for processing the resturant checks, tracking the total sales and tips.
 * It manages the overall operation of check handling within the resturant and ensures
 * accurate handling of the sales and tip data.
 */
public class RestaurantCheckManager {
    private double totalSaleAmount = 0.0;
    private double totalTipAmount = 0.0;
    private int numberOfChecks = 0;

    // Method to process each check.
    public void processCheck(double saleAmount, double tipAmount, double totalAmount) {
        numberOfChecks++;

        // Handles edge cases and calculates the correct tip if necessary.
        if (totalAmount == 0) {
            // Case where total is missing, assumes total = sale + tip.
            totalAmount = saleAmount + tipAmount;
        } else if (saleAmount > totalAmount) {
            // If the total amount is less than the sale, assumes no tip.
            tipAmount = 0;
            totalAmount = saleAmount;
        } else if (totalAmount != (saleAmount + tipAmount)) {
            // If there's a mismatch between the sale and total, calculates the tip.
            tipAmount = totalAmount - saleAmount;
            
            if (tipAmount < 0) {
                tipAmount = 0;
            }
        }

        // Updates the totals.
        totalSaleAmount += saleAmount;
        totalTipAmount += tipAmount;
    }

    // Returns total sales amount.
     public double getTotalSaleAmount(){
        return totalSaleAmount;
     }

    // Returns total tips amount.
     public double getTotalTipAmount(){
        return totalTipAmount;
     }

    // Returns the number of processed checks.
     public int getCheckCount(){
        return numberOfChecks;
     }

    // Method to display the final results.
    public void displayResults() {
        System.out.printf("\nTotal Sale Amount: $%.2f\n",
         totalSaleAmount);
        System.out.printf("Total Tip Amount: $%.2f\n", totalTipAmount);
        System.out.println("Number of Checks Processed: " + numberOfChecks);
    }
}