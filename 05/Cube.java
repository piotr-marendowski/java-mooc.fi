public class Cube {
    private int edgeLength;

    public Cube (int edgeLength) {
        this.edgeLength = edgeLength;
    }

    public int volume() {
        return (edgeLength * edgeLength * edgeLength);
    }

    public String toString() {
        return "The length of the edge is " + edgeLength + " and the volume " + volume();
    }

    public static void main(String[] args) {
        Cube oSheaJackson = new Cube(4);
        System.out.println(oSheaJackson.volume());
        System.out.println(oSheaJackson);

        System.out.println();

        Cube salt = new Cube(2);
        System.out.println(salt.volume());
        System.out.println(salt);
    }
}
