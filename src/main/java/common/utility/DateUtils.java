package common.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Set;

public final class DateUtils {

    private DateUtils() {}
    public static String getFormattedDate(int daysToAdd, String pattern) {
        return LocalDate.now()
                .plusDays(daysToAdd)
                .format(DateTimeFormatter.ofPattern(pattern));
    }

    public static int getRandomUniqueDay(Set<Integer> usedDays) {
        Random random = new Random();
        int randomDay;
        do {
            randomDay = random.nextInt(30) + 1;
        } while (!usedDays.add(randomDay));
        return randomDay;
    }

}
