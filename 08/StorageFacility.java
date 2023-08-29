import java.util.HashMap;
import java.util.ArrayList;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storage;

    public StorageFacility() {
        this.storage = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.storage.putIfAbsent(unit, new ArrayList<>());

        ArrayList<String> items = this.storage.get(unit);

        items.add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        for (String i: this.storage.keySet()) {
            if (i.contains(storageUnit))
                return this.storage.get(storageUnit);
        }

        return new ArrayList<>();
    }

    /* part 2 */
    public void remove(String storageUnit, String item) {
        this.storage.get(storageUnit).remove(item);

        if (this.storage.get(storageUnit).isEmpty())
            this.storage.remove(storageUnit);
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<>();
        
        for (String i: this.storage.keySet()) {
            if (!this.storage.get(i).isEmpty())
                units.add(i);
        }

        return units;
    }

    public static void main(String[] args) {
        StorageFacility facility = new StorageFacility();
        facility.add("a14", "ice skates");
        facility.add("a14", "ice hockey stick");
        facility.add("a14", "ice skates");

        facility.add("f156", "rollerblades");
        facility.add("f156", "rollerblades");

        facility.add("g63", "six");
        facility.add("g63", "pi");

        facility.remove("f156", "rollerblades");

        System.out.println(facility.contents("f156"));

        facility.remove("f156", "rollerblades");

        System.out.println(facility.storageUnits());
    }
}
