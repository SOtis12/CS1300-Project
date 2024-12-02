/*
 * Authors: Rogelio Flores, Kian Naderi, Samuel Otis
 * Description: This is a class file that aids CS1400_Project_Tip_Pooling.java, it is
 * responsible for calculating and displaying how the tips are distributed among various 
 * roles in the resturant. It ensures fairness in the distribution based on our pre-decided
 * percentages for each role, taking into account the number of servers present and the 
 * work that is done. (50% divided among the servers present (Only three servers hired, one 
 * server present), 25% divided among the kitchen and staff (50% chef, 30% sous-chef, 
 * 20% kitchen aid), 7% for the busser, 5% for the host/hostess). 
 */
public class TipDistribution{
    public void distriubuteTips(double totalTipAmount, int SERVERS_PRESENT){
    // Splits the pooled tips to the workers.
     double serverPercent = (totalTipAmount * 0.50) / SERVERS_PRESENT;
     double kitchenPercent = totalTipAmount * 0.25;
     double busserPercent = totalTipAmount * 0.15;
     double hostPercent = totalTipAmount * 0.10;

    // Kitchen percentage breakdown.
     double chefPercent = kitchenPercent * 0.50;
     double sousChefPercent = kitchenPercent * 0.30;
     double kitchenAidPercent = kitchenPercent * 0.20;

    // Prints out how the tip pool is distributed
    System.out.println("\nTip Distribution");
    System.out.printf("  Each Server: $%.2f (Total for %d servers)\n", serverPercent, SERVERS_PRESENT);
    System.out.printf("  Chef: $%.2f\n", chefPercent);
    System.out.printf("  Sous-Chef: $%.2f\n", sousChefPercent);
    System.out.printf("  Kitchen Aid: $%.2f\n", kitchenAidPercent);
    System.out.printf("  Busser: $%.2f\n", busserPercent);
    System.out.printf("  Host/Hostess: $%.2f\n", hostPercent);
    }
}