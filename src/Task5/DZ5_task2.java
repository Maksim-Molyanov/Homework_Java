//Пусть дан список сотрудников:
//        Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов
// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

package Task5;

import java.util.*;

public class DZ5_task2 {
    private static Random random = new Random();

    public static void main(String[] args) {
        HashMap<String, Integer> namesMap = new HashMap<>();      

        String[] names = new String[] {"Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};

        for (String fullName : names) {
            String name = fullName.split(" ")[0];
            if (!namesMap.containsKey(name)) 
                namesMap.put(name, 0);
            namesMap.put(name, namesMap.get(name) + 1);            
        }
        System.out.println(namesMap);

        List<HashMap.Entry<String, Integer>> namesList = new ArrayList<>(namesMap.entrySet());    
        namesList.sort(HashMap.Entry.<String, Integer>comparingByValue().reversed());

        for (HashMap.Entry<String, Integer> entry : namesList) {
            if (entry.getValue() > 1) 
                System.out.println(entry.getKey() + ": " + entry.getValue());
        }   
    }
}
