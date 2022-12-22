// Вычислить n-ое треугольного число(сумма чисел от 1 до n)

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите число n: ");

        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        triangularNumber(n);
    }

    public static void triangularNumber(int n){
        int result = (n * (n + 1)) / 2;
        System.out.printf("Сумма чисел от 1 до %d: %d", n, result);
    }
}
