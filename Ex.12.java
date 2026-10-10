import java.time.LocalDate; import java.util.ArrayList;

// Base Class - Encapsulation & Abstraction class Medicine {
private int id; private String name; private double price;
private LocalDate expiryDate; private int stock;

public Medicine(int id, String name, double price, LocalDate expiryDate, int stock) { this.id = id;
this.name = name; this.price = price;
this.expiryDate = expiryDate; this.stock = stock;
}

public boolean isExpired() {
return LocalDate.now().isAfter(expiryDate);
}

public void displayInfo() {
System.out.println(id + " | " + name + " | Rs." + price + " | Exp: " + expiryDate + " | Stock: " + stock);
}

// Getters - Encapsulation
public String getName() { return name; } public double getPrice() { return price; } public int getStock() { return stock; }
public void setStock(int stock) { this.stock = stock; }
}

// Inheritance - Prescription Medicine
class PrescriptionMedicine extends Medicine { private String doctorName;

public PrescriptionMedicine(int id, String name, double price, LocalDate expiryDate, int stock, String doctorName) {
super(id, name, price, expiryDate, stock); this.doctorName = doctorName;
 
}

@Override
public void displayInfo() { super.displayInfo();
System.out.println(" -> Prescription Required from Dr. " + doctorName);
}
}

// Customer Class class Customer {
private int customerId; private String customerName; private int age;

public Customer(int customerId, String customerName, int age) { this.customerId = customerId;
this.customerName = customerName; this.age = age;
}

public String getCustomerName() { return customerName; }
}

// Order Class - HAS-A Relationship + Polymorphism class Order {
private Customer customer;
private ArrayList<Medicine> medicineList;

public Order(Customer customer) { this.customer = customer; this.medicineList = new ArrayList<>();
}

public void addMedicine(Medicine med) { if (med.isExpired()) {
System.out.println("WARNING: " + med.getName() + " is EXPIRED! Cannot add to order.");
} else if (med.getStock() <= 0) {
System.out.println("Sorry, " + med.getName() + " Out of Stock!");
} else {
medicineList.add(med); System.out.println(med.getName() + " Added to Cart");
}
}

public double calculateBill() { double total = 0;
System.out.println("\n--- BILL for " + customer.getCustomerName() + " ---");
 
for (Medicine m : medicineList) { System.out.println(m.getName() + " - Rs." + m.getPrice()); total += m.getPrice();
}
System.out.println("Total Amount: Rs." + total); return total;
}
}

// Main Class
public class PharmacyMain {
public static void main(String[] args) {
// Creating Medicines
Medicine m1 = new Medicine(101, "Paracetamol", 25.5, LocalDate.of(2027, 12, 31), 50);
Medicine m2 = new Medicine(102, "Vitamin C", 120.0, LocalDate.of(2025, 5, 10), 20); // Expired
PrescriptionMedicine m3 = new PrescriptionMedicine(103, "Azithromycin", 180.0, LocalDate.of(2027, 8, 15), 30, "Arun");

System.out.println("--- Available Medicines in Pharmacy ---"); m1.displayInfo();
m2.displayInfo(); m3.displayInfo();

// Customer Places Order
Customer c1 = new Customer(1, "Priya", 21); Order order1 = new Order(c1);

System.out.println("\n--- Placing Order ---"); order1.add Medicine(m1);
order1.addMedicine(m2); // This will show expiry warning order1.addMedicine(m3);

// Generate Bill order1.calculateBill();
}
}
