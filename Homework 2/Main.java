import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Double> cardValues = Arrays.asList(50.0, 30.0, 20.0, 15.0, 10.0);
        double targetValue = 100.0;

        balanceCard(cardValues, targetValue);
    }

    public static void balanceCard(List<Double> cardValues, double targetValue) {
        double totalValue = cardValues.stream().mapToDouble(Double::doubleValue).sum();
        double averageValue = totalValue / cardValues.size();

        List<Double> positiveValues = new ArrayList<>();
        List<Double> negativeValues = new ArrayList<>();

        positiveValues = cardValues.stream()
                .filter(value -> value > averageValue)
                .collect(Collectors.toList());

        negativeValues = cardValues.stream()
                .filter(value -> value <= averageValue)
                .collect(Collectors.toList());

        System.out.println("Исходные значения:");
        System.out.println("Положительные значения: " + positiveValues);
        System.out.println("Отрицательные значения: " + negativeValues);

        double balance = totalValue - targetValue;
        if (balance > 0) {

            System.out.println("Балансируем: уменьшаем положительные значения");
            balanceValues(positiveValues, balance);
        } else if (balance < 0) {

            System.out.println("Балансируем: увеличиваем отрицательные значения");
            balance = -balance;
            balanceValues(negativeValues, balance);
        }

        System.out.println("Результаты балансировки:");
        System.out.println("Положительные значения: " + positiveValues);
        System.out.println("Отрицательные значения: " + negativeValues);
    }

    public static void balanceValues(List<Double> values, double balance) {
        double averageValue = values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        for (int i = 0; i < values.size(); i++) {
            double newValue = values.get(i) - (values.get(i) - averageValue) * (balance / values.size() / averageValue);
            values.set(i, newValue);
        }
    }
}
