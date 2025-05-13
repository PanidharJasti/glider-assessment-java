public class Light implements Appliance {
    private boolean isOn = true;

    public void toggleSwitch() {
        isOn = !isOn;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Light is " + (isOn ? "ON" : "OFF");
    }
}
