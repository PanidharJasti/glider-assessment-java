public class AirConditioner implements Appliance {
    private String thermostatSetting = "cool";

    public void setThermostat(String mode) {
        if (!mode.equalsIgnoreCase("cool") && !mode.equalsIgnoreCase("off")) {
            throw new IllegalArgumentException("Invalid mode: use 'cool' or 'off'");
        }
        thermostatSetting = mode;
    }

    @Override
    public void turnOff() {
        thermostatSetting = "off";
    }

    @Override
    public boolean isOn() {
        return !thermostatSetting.equalsIgnoreCase("off");
    }

    @Override
    public String toString() {
        return "Air Conditioner is " + thermostatSetting;
    }
}
