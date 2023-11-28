package task1;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
 * 1.1 Найти максимальное
 * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
 * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 * <p>
 */

public class Program {
    public static void main(String[] args) {

        // region 1.0 (Создать список из 1_000 рандомных чисел от 1 до 1_000_000)
        List<Integer> listRandomNumbers = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1_000_000))
                .limit(1_000)
                .toList();
        // endregion

        // region 1.1 (Найти максимальное)
        System.out.println(listRandomNumbers.stream().max(Integer::compareTo));
        // endregion

        // region 1.2 (Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать)
        System.out.println(listRandomNumbers.stream()
                .filter(number -> number > 500_000)
                .mapToInt(number -> number * 5 - 150)
                .sum());
        // endregion

        // region 1.3 (Найти количество чисел, квадрат которых меньше, чем 100_000)
        long x = listRandomNumbers.stream()
                .filter(number -> number < 317)
                .count();
        System.out.println(x);
        // endregion
    }
}
