import java.util.Scanner;

public class Calculator {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Introoduce el primer número");
            double firstNumber = sc.nextDouble();

            System.out.println("Introoduce el segundo número");
            double secondNumber = sc.nextDouble();
            // ya tenemos la entrada de los dos numeros//

            System.out.println("Introoduce la operacion");
            String operation = sc.next();
            /* la entrada de la operacion// */

            //llamar a la funcion y se guarda el resultado en una variable//
            double result = doCalculation (firstNumber, secondNumber, operation);


                System.out.println("El resultado de operacion " +operation+ " es " +result);

        }

        // creamos la funcion para hacer las operaciones de la calculadora//
        private static double doCalculation(double firstNumber, double secondNumber, String operation) {
            switch (operation) {
                case "+" -> {
                    return sum(firstNumber, secondNumber);
                }
                case "-" -> {
                    return minus(firstNumber, secondNumber);
                }
                case "*" -> {
                    return multiply(firstNumber, secondNumber);
                }
                case "/" -> {
                    return division ( firstNumber, secondNumber);
                }
                default -> {
                   throw new IllegalArgumentException("Operacion desconocida");
                }
            }

        }
    // funcion de la suma//
    private static double sum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
    private static double minus(double firstNumber, double secondNumber)  {
        return firstNumber - secondNumber;
    }
    private static double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
    private static double division(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }
}

