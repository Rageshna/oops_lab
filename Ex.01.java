import java.util.Scanner;

class Subscription {
    String name, plan;
    double amount;

    Subscription(String name, String plan, double amount) {
        this.name = name;
        this.plan = plan;
        this.amount = amount;
    }

    void generateBill() {
        System.out.println("\n--- Monthly Subscription Bill ---");
        System.out.println("Customer Name : " + name);
        System.out.println("Plan          : " + plan);
        System.out.println("Monthly Bill  : Rs." + amount);
    }
}

public class StreamingBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Plan: ");
        String plan = sc.nextLine();

        System.out.print("Enter Monthly Amount: ");
        double amount = sc.nextDouble();

        Subscription s = new Subscription(name, plan, amount);
        s.generateBill();
    }
}
Output:
Enter Customer Name: Priya
Enter Plan: Premium
Enter Monthly Amount: 499

--- Monthly Subscription Bill ---
Customer Name : Priya
Plan          : Premium
Monthly Bill  : Rs.499.0
