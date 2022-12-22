/*Вывести все простые числа от 1 до 1000 (простые числа - это числа которые делятся только на себя и на единицу без остатка. 
Чтобы найти остаток от деления используйте оператор % , например 10%3 будет равно единице) */

public class Task_3 {
    public static void main(String[] args) throws Exception {
        int LIMIT_NUMBER = 1000;
        printNaturalNumbers(LIMIT_NUMBER);
    }

    public static void printNaturalNumbers(int LIMIT_NUMBER){
        boolean flag = true;
        System.out.println("Список простых чисел от 1 до 1000:");

        for (int i = 1; i < LIMIT_NUMBER; i++){
            for (int j = 2; j < i; j++){
                if (i % j == 0) flag = false;
            }
            if(flag == true) System.out.printf("%d ", i);
            else flag = true;
        }
    }    
}
