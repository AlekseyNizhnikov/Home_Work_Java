/*Реализовать простой калькулятор 
("введите первое число"... "Введите второе число"... "укажите операцию, 
которую надо выполнить с этими числами"... "ответ: ...") */

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите операцию: ");
        String operand = scanner.nextLine();

        System.out.println("Введите число a: ");
        Integer a = scanner.nextInt();

        System.out.println("Введите число b: ");
        Integer b = scanner.nextInt();

        double result = calculate(a, b, operand);
        System.out.printf("Результат: %.0f", result);
    }

    public static double calculate(int a, int b, String operand){
        double result = 0.0;

        switch (operand){
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
        }
        return result;
    }
}
