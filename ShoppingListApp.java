
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingListApp {
    // ArrayList to store shopping items
    private ArrayList<String> shoppingList;

    // Constructor
    public ShoppingListApp() {
        shoppingList = new ArrayList<>();
    }

    // Method to add a new item
    public void addItem(String item) {
        shoppingList.add(item);
        System.out.println(item + " has been added to the list.");
    }

    // Method to update an existing item
    public void updateItem(String oldItem, String newItem) {
        int index = shoppingList.indexOf(oldItem);
        if (index != -1) {
            shoppingList.set(index, newItem);
            System.out.println("Item updated from " + oldItem + " to " + newItem + ".");
        } else {
            System.out.println("Item " + oldItem + " not found in the list.");
        }
    }

    // Method to delete an item
    public void deleteItem(String item) {
        if (shoppingList.remove(item)) {
            System.out.println(item + " has been removed from the list.");
        } else {
            System.out.println("Item " + item + " not found in the list.");
        }
    }

    // Method to display the shopping list
    public void displayList() {
        if (shoppingList.isEmpty()) {
            System.out.println("The shopping list is empty.");
        } else {
            System.out.println("Shopping List:");
            for (int i = 0; i < shoppingList.size(); i++) {
                System.out.println((i + 1) + ". " + shoppingList.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingListApp app = new ShoppingListApp();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Delete Item");
            System.out.println("4. View Shopping List");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // To handle line break

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String item = scanner.nextLine();
                    app.addItem(item);
                    break;
                case 2:
                    System.out.print("Enter the name of the item to update: ");
                    String oldItem = scanner.nextLine();
                    System.out.print("Enter the new name: ");
                    String newItem = scanner.nextLine();
                    app.updateItem(oldItem, newItem);
                    break;
                case 3:
                    System.out.print("Enter the name of the item to delete: ");
                    String deleteItem = scanner.nextLine();
                    app.deleteItem(deleteItem);
                    break;
                case 4:
                    app.displayList();
                    break;
                case 5:
                    System.out.println("Exiting the application. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}