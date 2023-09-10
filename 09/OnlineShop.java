import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/* part 1 */
class Warehouse {
    private Map<String, Integer> stocks;    // name, stock
    private Map<String, Integer> prices;    // name, price

    public Warehouse() {
        this.stocks = new HashMap<>();
        this.prices = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.stocks.put(product, stock);
        this.prices.put(product, price);
    }

    public int price(String product) {
        if (this.prices.containsKey(product))
            return this.prices.get(product);

        return -99;
    }

    /* part 2 */
    public int stock(String product) {
        if (this.stocks.containsKey(product))
            return this.stocks.get(product);

        return 0;
    }

    public boolean take(String product) {
        if (this.stocks.containsKey(product)) {
            int stock = this.stocks.get(product);
            this.stocks.remove(product);

            if ((stock - 1) >= 0) {
                stock--;

                this.stocks.put(product, stock);
                return true;
            }
        }

        return false;
    }

    /* part 3 */
    public Set<String> products() {
        Set<String> keys = new HashSet<>();

        for (String key: this.prices.keySet())
            keys.add(key);

        return keys;
    }
}

/* part 4 */
class Item {
    private String name;
    private int qty;
    private int unitPrice;

    public Item(String product, int qty, int unitPrice) {
        this.name = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int price() {
        return this.unitPrice * this.qty;
    }

    public void increaseQuantity() {
        this.qty++;
    }

    public String toString() {
        return this.name + ": " + this.qty;
    }

    public String getName() {
        return this.name;
    }
}

/* part 5 */
class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    /* part 7 */
    public void add(String product, int price) {
        boolean isInCart = false;

        for (Item i: items) {
            if (i.getName().equals(product)) {
                isInCart = true;
                i.increaseQuantity();
            }
        }

        if (!isInCart)
            this.items.add(new Item(product, 1, price));
    }

    public int price() {
        int price = 0;

        for (Item i: items)
            price += i.price();    

        return price;
    }

    /* part 6 */
    public void print() {
        for (Item i: items)
            System.out.println(i);
    }
}

/* part 8 */
class Store {
    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    // the method that handles the customers visit to the store.
    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");

        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while (true) {
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();
            if (product.isEmpty()) {
                break;
            }

            // Add code here that adds the product to the cart,
            // If there is any in the warehouse, and reduces the stock in the warehouse
            // Don't touch any of the other code!
            if (this.warehouse.take(product))
                cart.add(product, this.warehouse.price(product));
        }

        System.out.println("your shoppingcart contents:");
        cart.print();
        System.out.println("total: " + cart.price());
    }
}

public class OnlineShop {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("coffee", 5, 10);
        warehouse.addProduct("milk", 3, 20);
        warehouse.addProduct("cream", 2, 55);
        warehouse.addProduct("bread", 7, 8);

        Scanner scanner = new Scanner(System.in);

        Store store = new Store(warehouse, scanner);
        store.shop("John");
    }
}
