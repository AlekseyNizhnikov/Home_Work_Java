/**+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
 * Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет. */
import java.util.Scanner;

 public class Task_5 {
    public static void main(String[] args) throws Exception {
        calculation(inputEquation());
    }

    // Ввод уравнения. Метод возвращает строку-уравнение.
    public static String inputEquation(){
        System.out.println("Введите уравнение вида a + b = c, где некоторые цифры числа a, b и c могут быть заменены знаком ?.");
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        String equation = "";

        while(flag){
            equation = scanner.nextLine();

            for(char i: equation.toCharArray()){
                if(Character.isDigit(i) == false && i != '?' && i != '=' && i != '-' && i != '+' && i != ' '){
                    System.out.println("Некорректный ввод!");
                    flag = true;
                    break;
                }
                else flag = false;
            }
        }
        return equation;
    }

    //Вычисление неизвестных цифр. Метод выводит результат на экран.
    public static void calculation(String equation){
        
        int a = 0;
        int b = 0;
        int c = 0;
        int count = 0;

        // Замена всех знаков на пробел.
        equation = equation.replace("+", " ");
        equation = equation.replace("=", " ");
        
        String[] array = equation.split(" ");
        String[] array_equation = new String [3];

        // Удаляем пустые элементы после split. [2?, '', '+'...] 
        for(int i = 0; i < array.length; i++){
            if(array[i] != ""){
                array_equation[count] = array[i]; 
                count++;
            }
        }

        // Перебираем цифры от 0 до 99. Для всех неизвестных, пока не найдем верное решение.
        for(int i = 0; i <= 99; i++){
            array_equation[0] = array_equation[0].replace('?', Integer.toString(i).charAt(0));
            a = Integer.parseInt(array_equation[0]);

            c = Integer.parseInt(array_equation[2]);

            for(int j = 0; j <= 99; j++){
                array_equation[1] = array_equation[1].replace('?', Integer.toString(j).charAt(0));
                b = Integer.parseInt(array_equation[j]);
                if (a + b == c){
                    System.out.printf("Результат: %d + %d = %d", a, b, c);
                    return;
                }
            }
        }
        System.out.println("Решение не найдено!");
    }
}
