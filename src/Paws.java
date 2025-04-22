import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Paws {
    public static void main(String[] args) {
        Homepage.displayMenu();
    }
}

class Homepage {
    public static void displayMenu() {
        System.out.println("************************");
        System.out.println("Welcome to The Paws Shop");
        System.out.println("************************");
        System.out.println("1. Manager");
        System.out.println("2. Cashier");
        System.out.println("Enter your option:");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> new ManagerLogin().login();
            case 2 -> new CashierLogin().login();
            default -> System.out.println("Invalid choice! Restarting...");
        }
    }
}

abstract class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void menu();
}

class Cashier extends User {
    @Override
    public void menu() {
        System.out.println("1. View Pet Supplies");
        System.out.println("2. Add Pet Supply");
        System.out.println("3. Search Pet Supplies");
        System.out.print("Enter your option: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> new ViewSupplies().view();
            case 2 -> new AddSupply().add();
            case 3 -> new SearchSupply().search();
            default -> System.out.println("Invalid choice! Returning to menu...");
        }
    }
}

class Manager extends Cashier {
    @Override
    public void menu() {
        System.out.println("1. View Pet Supplies");
        System.out.println("2. Add Pet Supply");
        System.out.println("3. Search Pet Supplies");
        System.out.println("4. Create Cashier Account");
        System.out.print("Enter your option: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> new ViewSupplies().view();
            case 2 -> new AddSupply().add();
            case 3 -> new SearchSupply().search();
            case 4 -> createCashierAccount();
            default -> System.out.println("Invalid choice! Returning to menu...");
        }
    }

    public void createCashierAccount() {
        try (FileWriter writer = new FileWriter("cashier_accounts.txt", true)) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Username for Cashier: ");
            String username = scanner.next();
            writer.write("Username: " + username + " | ");

            System.out.print("Enter Password for Cashier: ");
            String password = scanner.next();
            writer.write("Password: " + password + "\n");

            System.out.println("Cashier account created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

class ManagerLogin {
    public void login() {
        System.out.println("Enter Manager Username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();

        System.out.println("Enter Manager Password:");
        int password = scanner.nextInt();

        if (username.equals("admin") && password == 1234) {
            System.out.println("Login Successful!");
            new Manager().menu();
        } else {
            System.out.println("Invalid Credentials! Try Again.");
            login();
        }
    }
}

class CashierLogin {
    public void login() {
        System.out.println("Enter Cashier Username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();

        System.out.println("Enter Cashier Password:");
        int password = scanner.nextInt();

        if (username.equals("cashier") && password == 5678) {
            System.out.println("Login Successful!");
            new Cashier().menu();
        } else {
            System.out.println("Invalid Credentials! Try Again.");
            login();
        }
    }
}

class ViewSupplies {
    public void view() {
        try {
            File file = new File("pet_supplies.txt");
            if (!file.exists()) {
                System.out.println("No product file found. Please add products first.");
                return;
            }
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

class AddSupply {
    public void add() {
        try (FileWriter writer = new FileWriter("pet_supplies.txt", true)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter PRODUCT ID: ");
            int productId = scanner.nextInt();
            writer.write(String.format("%-15d", productId));

            System.out.print("Enter NAME: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            writer.write(String.format("%-20s", name));

            System.out.print("Enter BRAND: ");
            String brand = scanner.nextLine();
            writer.write(String.format("%-15s", brand));

            System.out.print("Enter CATEGORY: ");
            String category = scanner.nextLine();
            writer.write(String.format("%-15s", category));

            System.out.print("Enter PRICE: ");
            double price = scanner.nextDouble();
            writer.write(String.format("%-10.2f", price));

            System.out.print("Enter STOCK: ");
            int stock = scanner.nextInt();
            writer.write(String.format("%-10d", stock));

            System.out.print("Enter REMAINING STOCK: ");
            int remainingStock = scanner.nextInt();
            writer.write(String.format("%-10d%n", remainingStock));

            System.out.println("Product added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

class SearchSupply {
    public void search() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter category to search: ");
            String category = scanner.nextLine();

            File file = new File("pet_supplies.txt");
            Scanner reader = new Scanner(file);
            boolean found = false;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.contains(category)) {
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No supplies found in category: " + category);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
