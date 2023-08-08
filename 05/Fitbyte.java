public class Fitbyte {
    private int age;
    private int restingHeartRate;
    private double maximumHeartRate;

    public Fitbyte(int age, int restingHeartRate) {
        this.age = age;
        this.restingHeartRate = restingHeartRate;
        this.maximumHeartRate = 206.3 - (0.711 * age);
    }

    public double targetHeartRate(double percentageOfMaximum) {
        return ((maximumHeartRate - restingHeartRate) * (percentageOfMaximum) + restingHeartRate);
    }

    public static void main(String[] args) {
        Fitbyte assistant = new Fitbyte(30, 60);

        double percentage = 0.5;

        while (percentage < 1.0) {
            double target = assistant.targetHeartRate(percentage);
            System.out.println("Target " + (percentage * 100) + "% of maximum: " + target);
            percentage = percentage + 0.1;
        }
    }
}
