import java.util.*;
import java.util.stream.*;
class SensorReading {
    String sensorId;
    double temperature;

    public SensorReading(String sensorId, double temperature) {
        this.sensorId = sensorId;
        this.temperature = temperature;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<SensorReading> readings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            double temp = scanner.nextDouble();
            readings.add(new SensorReading(id, temp));
        }
        scanner.close();
         Map<String, Double> avgMap = readings.stream()
            .filter(r -> r.temperature > 50)
            .collect(Collectors.groupingBy(
                r -> r.sensorId,
                Collectors.averagingDouble(r -> r.temperature)
            ));

        avgMap.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
