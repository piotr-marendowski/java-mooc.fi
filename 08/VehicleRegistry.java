import java.util.HashMap;
import java.util.ArrayList;

class LicensePlate {
    // these instance variables have been defined as final, meaning
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    /* part 1 */
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (!(object instanceof LicensePlate))
            return false;

        LicensePlate comparedLicense = (LicensePlate) object;

        if (this.liNumber == comparedLicense.liNumber &&
            this.country == comparedLicense.country)
            return true;

        return false;
    }

    @Override
    public int hashCode() {
        return this.liNumber.hashCode() + this.country.hashCode();
    }
}

public class VehicleRegistry {
    /* part 2 */
    private HashMap<LicensePlate, String> cars;

    public VehicleRegistry() {
        this.cars = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        /* i fucking ~~love~~ hate java sometimes */
        for (Object obj: this.cars.keySet()) {
            LicensePlate i = (LicensePlate) obj;
            if (i.equals(licensePlate))
                return false;
        }

        this.cars.put(licensePlate, owner);

        return true;
    }

    public String get(LicensePlate licensePlate) {
        if (this.cars.get(licensePlate) == null)
            return null;

        return this.cars.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (get(licensePlate) != null) {
            this.cars.remove(licensePlate);
            return true;
        }

        return false;
    }

    /* part 3 */
    public void printLicensePlates() {
        for (Object obj: this.cars.keySet()) {
            LicensePlate i = (LicensePlate) obj;
            System.out.println(i);
        }
    }

    public void printOwners() {
        ArrayList<String> names = new ArrayList<>();

        for (String i : cars.values()) {
            if (!names.contains(i))
                names.add(i);
        }

        for (String i : names)
            System.out.println(i);
    }

    public static void main(String[] args) {
        LicensePlate li1 = new LicensePlate("FI", "ABC-123");
        LicensePlate li2 = new LicensePlate("FI", "UXE-465");
        /* don't know why it must be this way, some static stuff which shouldn't
         * interfere with codding, and how can you not love high level languages? */
        VehicleRegistry obj = new VehicleRegistry();

        if (!obj.add(li1, "Arto"))
            System.out.println("License plate " + li1 + " already has an owner");
                                              
        if (!obj.add(li2, "Jürgen"))          
            System.out.println("License plate " + li2 + " already has an owner");
                                              
        if (!obj.add(li1, "Finn"))            
            System.out.println("License plate " + li1 + " already has an owner");

        System.out.println("License plate's " + li1 + " owner is " + obj.get(li1));

        if (obj.remove(li2))
            System.out.println("License plate " + li2 + " removed successfully");

        obj.printLicensePlates();

        obj.printOwners();
    }
}
