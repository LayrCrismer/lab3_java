package src.ru.crismer.utils;

public class MathUtils {
    public static double sum(Object... numbers) {
        double total = 0;
        for (Object num : numbers) {
            if (num instanceof Number) {
                total += ((Number) num).doubleValue();
            } else if (num != null) {
                throw new IllegalArgumentException("Объект не является числом: " + num);
            }
        }
        return total;
    }
}