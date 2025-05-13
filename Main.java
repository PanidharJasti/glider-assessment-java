public class Main {
    public static void main(String[] args) throws InterruptedException {
        SmartHomeSystem system = new SmartHomeSystem();

        system.getLight().toggleSwitch();
        system.getFan().setSpeed(2);
        system.getAC().setThermostat("cool");

        System.out.println("Initial Status:");
        system.showStatus();

        system.startUpdateScheduler();

        for (int i = 0; i < 5; i++) {
            System.out.println("\n[Monitor] " + java.time.LocalDateTime.now());
            system.showStatus();
            Thread.sleep(60_000);
        }

        system.shutdownScheduler();
        System.out.println("\nSystem shutdown complete.");
    }
}
