// part 3
package application;

import java.util.List;
import java.util.ArrayList;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> averageReadings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.averageReadings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        if (this.sensors.size() > 0) {
            for (Sensor s: this.sensors) {
                if (s.isOn() == false)
                    return false;
            }

            return true;
        } else
            return false;
    }

    @Override
    public void setOn() {
        for (Sensor s: this.sensors)
            s.setOn();
    }

    @Override
    public void setOff() {
        for (Sensor s: this.sensors)
            s.setOff();
    }

    @Override
    public int read() {
        if (this.isOn() == false || this.sensors.size() == 0)
            throw new IllegalStateException("Sensor is off or has no sensors");
        else {
            int sum = 0;
            for (Sensor s: this.sensors) {
                sum = s.read();
            }

            int average = sum / this.sensors.size();
            this.averageReadings.add(average);

            return average;
        }
    }

    // part 4
    public List<Integer> readings() {
        return this.averageReadings;
    }
}
