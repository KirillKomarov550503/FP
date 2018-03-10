package practice.functional;

import resource.general.MaxOrMin;
import resource.general.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task1 {
    private static Stream<Person> streamTask1(List<Person> personList, MaxOrMin maxOrMin) {

        Stream<Person> personStream;
        if (maxOrMin == MaxOrMin.MAX) {
            personStream = personList.stream()
                    .filter(elem -> elem.getAge() != personList.stream()
                            .max(Comparator.comparing(Person::getAge))
                            .get()
                            .getAge());
        } else {
            personStream = personList.stream()
                    .filter(elem -> elem.getAge() != personList.stream()
                            .min(Comparator.comparing(Person::getAge))
                            .get()
                            .getAge());
        }
        return personStream;
    }

    public static Map<Integer, Person> toMapTask1(List<Person> personList, MaxOrMin maxOrMin) {
        return streamTask1(personList, maxOrMin).collect(Collectors.toMap(Person::hashCode, Function.identity()));
    }

    public static List<Person> toListTask1(List<Person> personList, MaxOrMin maxOrMin) {
        return streamTask1(personList, maxOrMin).collect(Collectors.toList());
    }




    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(20, "Kirill"));
        people.add(new Person(80, "Timoshenko"));
        people.add(new Person(25, "Bazanov"));
        people.add(new Person(65, "Putin"));
        System.out.println("Input list: " + people);
        List<Person> listWithoutMin = toListTask1(people, MaxOrMin.MIN);
        List<Person> listWithoutMax = toListTask1(people, MaxOrMin.MAX);
        Map<Integer, Person> mapWithoutMin = toMapTask1(people, MaxOrMin.MIN);
        Map<Integer, Person> mapWithoutMax = toMapTask1(people, MaxOrMin.MAX);
        System.out.println("List without min: " + listWithoutMin);
        System.out.println("List without max: " + listWithoutMax);
        System.out.println("Map without min: " + mapWithoutMin);
        System.out.println("Map without max: " + mapWithoutMax);

    }
}
