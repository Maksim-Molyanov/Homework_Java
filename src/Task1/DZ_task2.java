package Task1;//Вывести все простые числа от 1 до 1000
import java.util.Scanner;

public class DZ_task2 {
    static boolean isPrime(int n) {
        for(int i = 2; i < Math.sqrt(n)+1; i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 1;
        for(int i = 1; i<1000; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}