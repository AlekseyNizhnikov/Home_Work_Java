// Вычислить n! (произведение чисел от 1 до n)
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите число n: ");

        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        Integer result = factorial(n);
        System.out.printf("Факториал числа %d: %d", n, result);
    }

    public static int factorial(int n){
        if (n > 1){
            Integer result = n * factorial(n - 1);
            return result;
        }     
        else return 1;
        
    }
}
