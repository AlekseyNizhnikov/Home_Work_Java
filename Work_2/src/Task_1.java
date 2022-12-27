/**+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
 * Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет. */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

 public class Task_1 {
    public static void main(String[] args) throws Exception {
        String equation = inputEquation();
        calculation(inputCoffEquation(equation));
    }

    // Ввод уравнения. Метод возвращает строку-уравнение.
    public static String inputEquation(){
        System.out.println("Введите уравнение вида a + b + .... + d.");
        boolean flag = true;
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s*");

        String equation = "";

        // Проверка на корректный ввод уравнения.
        while(flag){
            equation = scanner.nextLine();

            for(char i: equation.toCharArray()){
                if(Character.isAlphabetic(i) == false && i != '-' && i != '+' && i != ' '){
                    System.out.println("Некорректный ввод!");
                    flag = true;
                    break;
                }
                else flag = false;
            }
        }
        return equation;
    }

    // Проверка корректности ввода. Ввод коэффициентов. Возвращает словарь коэффициентов.
    public static Map <String, String []> inputCoffEquation(String equation){
        Scanner scanner = new Scanner(System.in);
        Map <String, String []> dict = new HashMap<String, String []>();
        Integer count = 1;
        

        equation = equation.replace("+", " ");
        equation = equation.replace("=", " ");
        
        String[] array = equation.split(" ");
        System.out.println("Введите коэффициенты:");

        for (int i = 0; i < array.length; i++){
            String number;
            String[] package_dict = new String [2];

            if (array[i] == null || array[i] == " " || array[i] == "") continue;
            if (dict.get(array[i]) == null) {
                while (true){
                    System.out.printf("%s = ", array[i]);
                    number = scanner.nextLine();

                    if(Character.isDigit(number.charAt(0)) == false) System.out.println("Некорректный ввод!");
                    else {
                        count = 1;
                        package_dict[0] = number;
                        package_dict[1] = Integer.toString(count);
                        dict.put(array[i], package_dict);
                        break;
                    }
                }
            }
            else{
                count = Integer.parseInt(dict.get(array[i])[1]) + 1;
                dict.get(array[i])[1] = Integer.toString(count);
                continue;
            }
        }
        return dict;
    }

    //Вычисление. Метод выводит результат на экран.
    public static void calculation(Map<String, String []> dict){
        Integer result = 0;

        for(Entry<String, String[]> item: dict.entrySet()){
            result += Integer.parseInt(item.getValue()[0]) * Integer.parseInt(item.getValue()[1]);
        }
        System.out.printf("Результат: %d", result);
    }
}
