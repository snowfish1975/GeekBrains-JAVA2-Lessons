import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<String>> list = new HashMap<>();

    public void put(String lastName, String phoneNumber){
        if (list.containsKey(lastName))
            list.get(lastName).add(phoneNumber); // если такая фамилия есть в списке, просто добавь еще один номер телефона
        else {
            List<String> phoneList = new ArrayList<>();  // если фамилия встретилась впервые, создай новый список телефонов,
            phoneList.add(phoneNumber);                  // внеси в него переданный номер телефона
            list.put(lastName, phoneList);               // и сохрани пару "фамилия-номер" в телефонном списке
        }
    }

    public List<String> get(String lastName){
        return list.get(lastName);
    }

}
