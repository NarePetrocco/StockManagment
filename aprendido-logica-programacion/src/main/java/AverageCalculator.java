import java.util.Scanner;

public class AverageCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] numbers = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce el número " + (i + 1));
            numbers[i] = sc.nextDouble();
        }

        double average = calculateAverage(numbers);
        System.out.println("El resultado de la media es: " + average);
    }

    private static double calculateAverage(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }

        return sum / numbers.length;
    }
}
