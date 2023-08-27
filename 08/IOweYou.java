import java.util.HashMap;

class IOU {
    private HashMap<String, Double> ledger;

    public IOU() {
        this.ledger = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        this.ledger.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return this.ledger.get(toWhom);
    }
}

public class IOweYou {
    public static void main(String[] args) {
        IOU mattsIOU = new IOU();
        mattsIOU.setSum("Arthur", 51.5);
        mattsIOU.setSum("Michael", 30);

        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
        System.out.println(mattsIOU.howMuchDoIOweTo("Michael"));
    }
}
