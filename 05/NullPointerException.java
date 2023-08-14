public class NullPointerException {
    static class Cube {
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
    }

    public static void main(String[] args) {
        Cube cube = new Cube(4);

        cube = null;
        cube.volume();
    }
}
