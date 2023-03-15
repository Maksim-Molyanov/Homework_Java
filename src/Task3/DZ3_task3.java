package Task3;

import java.util.ArrayList;

//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
public class DZ3_task3 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(15);
        list.add(7);
        list.add(21);
        list.add(33);
        list.add(25);
        list.add(11);
        int min = list.get(0);
        int max = list.get(0);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) < min) {
                min = list.get(i);
            }
            if(list.get(i) > max) {
                max = list.get(i);
            }
            sum+= list.get(i);
        }
        int avg = sum / list.size();
        System.out.println(min);
        System.out.println(max);
        System.out.println(avg);
    }
}
