import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class InventoryManagementSystem {
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    viewInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }

    private static void addProduct() {
        System.out.println("\nAdding Product");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        Product product = new Product(name, price, quantity);
        inventory.add(product);
        System.out.println("Product added successfully.");
    }

    private static void removeProduct() {
        System.out.println("\nRemoving Product");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        boolean removed = false;
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(name)) {
                inventory.remove(product);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void updateProduct() {
        System.out.println("\nUpdating Product");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        boolean updated = false;
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new price: ");
                double price = scanner.nextDouble();
                product.setPrice(price);
                System.out.print("Enter new quantity: ");
                int quantity = scanner.nextInt();
                product.setQuantity(quantity);
                updated = true;
                break;
            }
        }
        if (updated) {
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewInventory() {
        System.out.println("\nInventory:");
        for (Product product : inventory) {
            System.out.println("Name: " + product.getName() + ", Price: $" + product.getPrice() + ", Quantity: " + product.getQuantity());
        }
    }
}
