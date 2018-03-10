package resource.general;

import java.util.ArrayList;
import java.util.List;

public class People {
    public static List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(20, "Kirill"));
        people.add(new Person(80, "Timoshenko"));
        people.add(new Person(25, "Bazanov"));
        people.add(new Person(65, "Putin"));
        return people;
    }
}
