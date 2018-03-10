package practice.functional;

import resource.general.Converter;
import resource.general.MoreOrLess;
import resource.general.People;
import resource.general.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Task2 {


    private static Stream<Person> toStream(List<Person> list, Object value, MoreOrLess moreOrLess) {
        Stream stream;

        if (moreOrLess.equals(MoreOrLess.MORE)) {
            stream = list.stream().filter(elem -> elem.getAge() < ((Integer) value));
        } else {
            stream = list.stream().filter(elem -> elem.getAge() > ((Integer) value));
        }
        return stream;
    }

    public static void main(String[] args) {
        List<Person> listLessValue = Converter.toListTask(toStream(People.getPeople(), 60, MoreOrLess.LESS));
        List<Person> listMoreValue = Converter.toListTask(toStream(People.getPeople(), 60, MoreOrLess.MORE));
        Map<Integer, Person> mapLessValue = Converter.toMapTask(toStream(People.getPeople(), 60, MoreOrLess.LESS));
        Map<Integer, Person> mapMoreValue = Converter.toMapTask(toStream(People.getPeople(), 60, MoreOrLess.MORE));
        System.out.println("List without less than value: " + listLessValue);
        System.out.println("List without more than value: " + listMoreValue);
        System.out.println("Map without less than value: " + mapLessValue);
        System.out.println("Map without more than value: " + mapMoreValue);
    }
}
