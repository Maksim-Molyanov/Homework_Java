//В калькулятор добавьте возможность отменить последнюю операцию.

package Task4;


import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DZ4_task3 {


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
        Logger log = Logger.getLogger(DZ4_task3.class.getName());
        configureLog(log);

        Stack<Double> history = new Stack<>();

        log.info("Ввод чисел и операции");

        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите первое число: ");
            int a = iScanner.nextInt();
            System.out.println("Введите операцию: ");
            char oper = iScanner.next().charAt(0);
            System.out.println("Введите второе число: ");
            int b = iScanner.nextInt();
            log.info("Конец ввода чисел и операций");

            log.info("Начало работы калькулятора");
            if (oper == '+') {
                history.push(Sum(a, b));
            } else if (oper == '-') {
                history.push(Sub(a, b));
            } else if (oper == '*') {
                history.push(Prod(a, b));
            } else if (oper == '/') {
                if (b == 0) System.out.println("На ноль делить нельзя");
                else history.push(Div(a, b));

            }
            log.info("Конец работы калькулятора");
            System.out.println(history.peek());
            System.out.println("Введите для выхода q или для возврата операции <, а для продолжения > ");
            char key = iScanner.next().charAt(0);
            if (key == '<') {
                if (!history.empty())
                    history.pop();
                System.out.println(history.peek());
                } else if (key == 'q'){
                break;
                } else if (key == '>') {

            }
        }
    }

    public static void configureLog(Logger logger) {
        try {
            FileHandler fh = new FileHandler("calcLog.txt");
            logger.addHandler(fh);
            logger.setLevel(Level.INFO);
        } catch (IOException exception) {
            System.out.println("IO problems opening the files");
        }
    }


}
