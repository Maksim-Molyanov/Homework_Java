package Task1;//Вычислить [n-ое треугольного число](сумма чисел от 1 до n), n! (произведение чисел от 1 до n)


import java.util.Scanner;

public class DZ_task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        int n = iScanner.nextInt();
        int TriangularNum = 0;
        int FactNum = 1;
        for(int i = 1; i <= n; i++){
            TriangularNum += i;
            FactNum *= i;
        }
        System.out.println(TriangularNum);
        System.out.println(FactNum);
    }
}