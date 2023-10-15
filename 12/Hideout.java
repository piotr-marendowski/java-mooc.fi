import java.util.List;
import java.util.ArrayList;

public class Hideout<T> {
    private List<T> things;

    public Hideout() {
        this.things = new ArrayList<T>();
    }

    public void putIntoHideout(T toHide) {
        if (!this.things.isEmpty())
            return;

        this.things.add(toHide);
    }

    public T takeFromHideout() {
        if (this.things.isEmpty())
            return null;

        T obj = this.things.get(0);
        this.things.remove(0);
        return obj;
    }

    public boolean isInHideout() {
        if (this.things.isEmpty())
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Hideout<String> den = new Hideout<>();
        System.out.println(den.isInHideout());
        den.putIntoHideout("peekaboo");
        System.out.println(den.isInHideout());
        System.out.println(den.takeFromHideout());
        System.out.println(den.isInHideout());
        den.putIntoHideout("toodaloo");
        den.putIntoHideout("heelloo");
        System.out.println(den.isInHideout());
        System.out.println(den.takeFromHideout());
        System.out.println(den.isInHideout());
    }
}
