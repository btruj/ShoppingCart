import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    // Add an item to the cart
    public void addItem(Item item) {
        items.add(item);
    }

    // Remove an item from the cart
    public void removeItem(Item item) {
        items.remove(item);
    }

    // Calculate the total cost of the items in the cart
    public double calculateTotalCost() {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    // Apply a discount to the total cost if the customer is eligible
    public double applyDiscount(Customer customer) {
        double totalCost = calculateTotalCost();
        if (customer.isEligibleForDiscount()) {
            totalCost *= 0.9; // 10% discount
        }
        return totalCost;
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("book", 10.00);
        Item item2 = new Item("pen", 5.00);
        cart.addItem(item1);
        cart.addItem(item2);
        System.out.println("Total cost of cart before discount: " + cart.calculateTotalCost());
        Customer customer = new Customer("John", true);
        double totalCostWithDiscount = cart.applyDiscount(customer);
        System.out.println("Total cost of cart after discount: " + totalCostWithDiscount);
    }
}

class Item {
    private double price;

    public Item(String name, double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Customer {
    private boolean eligibleForDiscount;

    public Customer(String name, boolean eligibleForDiscount) {
        this.eligibleForDiscount = eligibleForDiscount;
    }

    public boolean isEligibleForDiscount() {
        return eligibleForDiscount;
    }
}
