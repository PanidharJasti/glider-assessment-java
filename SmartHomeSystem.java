// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.time.LocalDateTime;

interface Appliance {
    void turnOff();
    boolean isOn();
}

//Light implementation
class Light implements Appliance {
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

  public String toString() {
   return "Light is " + (isOn ? "ON" : "OFF"); 
  }
}

//Fan implementation
class Fan implements Appliance {
  private int speed = 1;
  
  public void setSpeed(int speed) {
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

 public String toString() {
   return "Fan speed is " + speed;
 } 
}

//Air conditioner implementation
class AirConditioner implements Appliance {
 private String thermostatSetting = "cool";
 
 public void setThermostat(String mode) {
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
 public String toString()  {
  return "Air conditioner is " + thermostatSetting;
 }
}

//Smart system implementation
class SmartHomeSystem {
  private Light light = new Light();
  private Fan fan = new Fan();
  private AirConditioner ac = new AirConditioner();

 public void systemUpdate() {
  LocalDateTime now = LocalDateTime.now();
  if(now.getMonthValue() == 1 && now.getDayOfMonth() ==1 && now.getHour()==1) {
   //Autoupdate
   light.turnOff();
   fan.turnOff();
   ac.turnOff();
   
   System.out.println("System updated on Jan 1st 1:00 AM - All devices turned off");
  }
 }

 public void showStatus() {
     System.out.println(light);
     System.out.println(fan);
     System.out.println(ac); 
}

 public Light getLight() {
  return light;
 }

 public Fan getFan() {
  return fan;
 }

 public AirConditioner getAC() {
  return ac; 
 } 
}

class Main {

    public static void main(String[] args) {
        SmartHomeSystem system = new SmartHomeSystem();
        
        system.getLight().toggleSwitch();  //toggle light
        system.getFan().setSpeed(2); //set fan speed to 2
        system.getAC().setThermostat("cool");
        
        System.out.println("Initial Status:");
        system.showStatus();
        
        system.systemUpdate(); // simulate update - turn off on Jan 1st
        
        System.out.println("\nFinal Status:");
        system.showStatus();
    }
}