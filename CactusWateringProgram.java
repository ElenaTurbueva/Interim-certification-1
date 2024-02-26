import java.time.LocalDate;
import java.util.Random;

class Cactus {
    private LocalDate currentDate;

    public Cactus(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public LocalDate getNextWateringDate() {
        String season = determineSeason(currentDate);
        int humidity = Sensor.getHumidity();

        if (humidity < 30) {
            return currentDate;
        }

        if (season.equals("зима")) {
            return currentDate.plusMonths(1);
        } else if (season.equals("весна") || season.equals("осень")) {
            return currentDate.plusWeeks(1);
        } else {
            return currentDate.plusDays(2);
        }
    }

    private String determineSeason(LocalDate date) {
        int month = date.getMonthValue();
        if (month >= 3 && month <= 5) {
            return "весна";
        } else if (month >= 6 && month <= 8) {
            return "лето";
        } else if (month >= 9 && month <= 11) {
            return "осень";
        } else {
            return "зима";
        }
    }

    public boolean needsImmediateWatering() {
        int humidity = Sensor.getHumidity();
        return humidity < 30;
    }
}

class Sensor {
    public static int getHumidity() {
        Random random = new Random();
        return random.nextInt(101);
    }
}

public class CactusWateringProgram {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        Cactus cactus = new Cactus(currentDate);
        LocalDate nextWateringDate = cactus.getNextWateringDate();
        if (cactus.needsImmediateWatering()) {
            System.out.println("Кактус нужно полить сегодня!");
        } else {
            System.out.println("Дата следующего полива: " + nextWateringDate);
        }
    }
}

