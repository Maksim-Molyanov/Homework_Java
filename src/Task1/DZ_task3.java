package Task1;//Реализовать простой калькулятор
import java.util.Scanner;

public class DZ_task3 {
    static double Sum(int a, int b) {
        return a + b;
    }
    static double Prod(int a, int b) {
        return a * b;
    }
    static double Sub(int a, int b) {
        return a - b;
    }
    static double Div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = iScanner.nextInt();
        System.out.println("Введите операцию: ");
        char oper = iScanner.next().charAt(0);
        System.out.println("Введите второе число: ");
        int b = iScanner.nextInt();
        if(oper == '+'){
            System.out.println(Sum(a, b));
        }
        else if (oper == '-') {
            System.out.println(Sub(a, b));
        }
        else if (oper == '*') {
            System.out.println(Prod(a, b));
        }
        else if (oper == '/') {
            System.out.println(Div(a, b));
        }

    }
}
