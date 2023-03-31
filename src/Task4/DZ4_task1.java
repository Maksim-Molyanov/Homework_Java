//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.

package Task4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DZ4_task1 {
    public static void main (String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(2, 1, 5, 6));
        System.out.println(list);
        list = reverse(list);
        System.out.println(list);
    }
    public static LinkedList<Integer> reverse(LinkedList<Integer> list){
        LinkedList<Integer> result = new LinkedList<>();
        Iterator<Integer> iter = list.descendingIterator();
        while (iter.hasNext()){
            result.add(iter.next());
        }
        return result;
    }
}
