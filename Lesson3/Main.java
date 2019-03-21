import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // ЗАДАНИЕ 1
        // Создаем массив уникальных и повторяющихся слов
        String[] wordsArray = {"бабушка","дедушка","бабушка","мама","папа","брат","сестра","брат","дочь","дочь","сын",
                "шурин","сват","деверь","сноха","внук","внучка","внук","внук","невестка"};
        // Создаем Map, в котором будут храниться уникальные слова и счетчики их повторений в массиве
        Map<String, Integer> relatives = new HashMap<String, Integer>();
        System.out.println("Вывод уникальных значений массива:");
        // Заполняем Map парами ключ (родственник), значение (количество)
        for(String familyMember: wordsArray)
            relatives.put(familyMember, relatives.getOrDefault(familyMember, 0) + 1);
        // Проходим по Map и выводим результаты подсчета
        for (Map.Entry member : relatives.entrySet())
            System.out.println("Родственник " + member.getKey() +" встречается " + member.getValue() + " раз(а).");

        // ЗАДАНИЕ 2
        //
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.put("Иванов", "+7(920)140-55-09");
        phoneBook.put("Иванов", "+7(920)140-07-84");
        phoneBook.put("Петров", "+7(910)102-11-43");
        phoneBook.put("Петров", "+7(902)030-76-00");
        phoneBook.put("Петров", "+7(914)123-87-90");

        System.out.println("Телефоны жителей с фамилией \"ИВАНОВ\": " + phoneBook.get("Иванов").toString());
        System.out.println("Телефоны жителей с фамилией \"ПЕТРОВ\": " + phoneBook.get("Петров").toString());
    }
}
