import java.time.LocalDateTime;
import java.util.concurrent.*;

public class SmartHomeSystem {
    private final Light light = new Light();
    private final Fan fan = new Fan();
    private final AirConditioner ac = new AirConditioner();
    private volatile boolean updateTriggered = false;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void systemUpdate(LocalDateTime now) {
        if (!updateTriggered &&
            now.getMonthValue() == 1 &&
            now.getDayOfMonth() == 1 &&
            now.getHour() == 1 &&
            now.getMinute() == 0) {

            light.turnOff();
            fan.turnOff();
            ac.turnOff();
            updateTriggered = true;

            System.out.println("[System Update] Jan 1st 1:00AM - All devices turned OFF.");
        }
    }

    public void startUpdateScheduler() {
        Runnable updateTask = () -> {
            LocalDateTime now = LocalDateTime.now();
            systemUpdate(now);
        };

        scheduler.scheduleAtFixedRate(updateTask, 0, 1, TimeUnit.MINUTES);
    }

    public void shutdownScheduler() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
        }
    }

    public void showStatus() {
        System.out.println(light);
        System.out.println(fan);
        System.out.println(ac);
    }

    public Light getLight() { return light; }
    public Fan getFan() { return fan; }
    public AirConditioner getAC() { return ac; }
}
