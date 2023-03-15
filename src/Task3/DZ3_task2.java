package Task3;

import java.util.ArrayList;

//Пусть дан произвольный список целых чисел, удалить из него чётные числа
public class DZ3_task2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        //System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
