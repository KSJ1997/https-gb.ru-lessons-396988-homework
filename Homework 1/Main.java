import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        double averageOfEvenNumbers = numbers.stream()       // Создаем поток из списка чисел
                .filter(number -> number % 2 == 0)           // Фильтруем только четные числа
                .mapToInt(Integer::intValue)                 // Преобразуем Integer в int
                .average()                                   // Вычисляем среднее значение
                .orElse(0.0);                                // Возвращаем среднее значение или 0, если список пуст

        System.out.println("Среднее значение четных чисел: " + averageOfEvenNumbers);
    }
}
