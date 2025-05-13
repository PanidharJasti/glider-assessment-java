public class Fan implements Appliance {
    private int speed = 1;

    public void setSpeed(int speed) {
        if (speed < 0 || speed > 2) {
            throw new IllegalArgumentException("Speed must be 0, 1, or 2");
        }
        this.speed = speed;
    }

    @Override
    public void turnOff() {
        this.speed = 0;
    }

    @Override
    public boolean isOn() {
        return speed > 0;
    }

    @Override
    public String toString() {
        return "Fan speed is " + speed;
    }
}
