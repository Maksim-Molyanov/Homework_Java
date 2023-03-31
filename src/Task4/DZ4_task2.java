//Реализуйте очередь с помощью LinkedList со следующими методами:
//        • enqueue() — помещает элемент в конец очереди,
//        • dequeue() — возвращает первый элемент из очереди и удаляет его,
//        • first() — возвращает первый элемент из очереди, не удаляя.

package Task4;

import java.util.LinkedList;

public class DZ4_task2 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        enqueue(list, 123);
        enqueue(list, 125);
        enqueue(list, 126);
        dequeue(list);
        System.out.println(firts(list));
        enqueue(list, 127);
        dequeue(list);
        System.out.println(firts(list));
    }
    public static void enqueue (LinkedList<Integer>list, int element){
        list.add(element);
    }
    public  static int dequeue (LinkedList<Integer>list){
        int result = list.getFirst();
        list.poll();
        return result;
    }
    public  static int firts (LinkedList<Integer>list){
        return list.getFirst();
    }
}