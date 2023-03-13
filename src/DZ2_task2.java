import javax.print.attribute.standard.PrinterMakeAndModel;
import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

//2) Реализуйте алгоритм сортировки пузырьком числового массива,
//        результат после каждой итерации запишите в лог-файл.
public class DZ2_task2 {
    public static void main(String[] args) {

        int[] nums = GetArray();
        PrintArray(nums);
        BubbleSort(nums);
        PrintArray(nums);
    }

    public static void BubbleSort(int[] arr) {
        Logger log = Logger.getLogger(DZ2_task2.class.getName());
        configureLog(log);

        log.info("Старт сортировки");
        int len = arr.length;
        boolean swapped;
        do {
            swapped = false;
            log.info("Новый проход");
            for (int i = 1; i < len; i++) {
                if (arr[i - 1] > arr[i]) {
                    log.info(String.format("Обмен %d, %d", arr[i], arr[i - 1]));
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swapped = true;
                }
            }
            --len;
        } while (swapped);
        log.info("Конец сортировки");
    }

    public static int[] GetArray() {
        Random generator = new Random();
        int[] res = new int[generator.nextInt(10, 20)];

        for (int i = 0; i < res.length; i++) {
            res[i] = generator.nextInt(10, 100);
        }
        return res;
    }

    public static void configureLog(Logger logger) {
        try {
            FileHandler fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            logger.setLevel(Level.INFO);
        } catch (IOException exception) {
            System.out.println("IO problems opening the files");
        }
    }

    public static void PrintArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
