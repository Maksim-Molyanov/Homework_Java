// 4*. К калькулятору из предыдущего дз добавить логирование.

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DZ2_task3 {
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
        Logger log = Logger.getLogger(DZ2_task3.class.getName());
        configureLog(log);

        log.info("Ввод чисел и операции");

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = iScanner.nextInt();
        System.out.println("Введите операцию: ");
        char oper = iScanner.next().charAt(0);
        System.out.println("Введите второе число: ");
        int b = iScanner.nextInt();
        log.info("Конец ввода чисел и операций");

        log.info("Начало работы калькулятора");
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
        log.info("Конец работы калькулятора");

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