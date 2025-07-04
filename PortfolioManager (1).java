
import java.util.ArrayList;
import java.util.Scanner;

// Investment class
class Investment {
    String name;
    String type;
    double amount;

    Investment(String name, String type, double amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    public void display() {
        System.out.println("Name: " + name + ", Type: " + type + ", Amount: ₹" + amount);
    }
}

// Portfolio class
public class PortfolioManager {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Investment> portfolio = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n---- Portfolio Management ----");
            System.out.println("1. Add Investment");
            System.out.println("2. View Portfolio");
            System.out.println("3. Total Investment");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            while (!input.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                input.next();
            }
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Investment Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Type (e.g. Stock, Mutual Fund): ");
                    String type = input.nextLine();
                    System.out.print("Enter Amount (₹): ");
                    while (!input.hasNextDouble()) {
                        System.out.println("Please enter a valid amount.");
                        input.next();
                    }
                    double amount = input.nextDouble();
                    portfolio.add(new Investment(name, type, amount));
                    System.out.println("Investment added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Your Portfolio ---");
                    if (portfolio.isEmpty()) {
                        System.out.println("No investments added yet.");
                    } else {
                        for (Investment inv : portfolio) {
                            inv.display();
                        }
                    }
                    break;

                case 3:
                    double total = 0;
                    for (Investment inv : portfolio) {
                        total += inv.amount;
                    }
                    System.out.println("Total Investment Value: ₹" + total);
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        input.close();
    }
}
