package practice.functional;

import resource.general.Converter;
import resource.general.MaxOrMin;
import resource.general.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class Task1 {
    private static Stream<Person> toStream(List<Person> personList, MaxOrMin maxOrMin) {

        Stream<Person> personStream;
        if (maxOrMin == MaxOrMin.MAX) {
            personStream = personList.stream()
                    .filter(elem -> !elem.getAge().equals(personList.stream()
                            .max(Comparator.comparing(Person::getAge))
                            .get()
                            .getAge()));
        } else {
            personStream = personList.stream()
                    .filter(elem -> !elem.getAge().equals(personList.stream()
                            .min(Comparator.comparing(Person::getAge))
                            .get()
                            .getAge()));
        }
        return personStream;
    }


    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(20, "Kirill"));
        people.add(new Person(80, "Timoshenko"));
        people.add(new Person(25, "Bazanov"));
        people.add(new Person(65, "Putin"));
        System.out.println("Input list: " + people);
        List<Person> listWithoutMin = Converter.toListTask(toStream(people, MaxOrMin.MIN));
        List<Person> listWithoutMax = Converter.toListTask(toStream(people, MaxOrMin.MAX));
        Map<Integer, Person> mapWithoutMin = Converter.toMapTask(toStream(people, MaxOrMin.MIN));
        Map<Integer, Person> mapWithoutMax = Converter.toMapTask(toStream(people, MaxOrMin.MAX));
        System.out.println("List without min: " + listWithoutMin);
        System.out.println("List without max: " + listWithoutMax);
        System.out.println("Map without min: " + mapWithoutMin);
        System.out.println("Map without max: " + mapWithoutMax);

    }
}
