package resource.general;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converter {
    public static Map<Integer, Person> toMapTask(Stream<Person> personStream) {
        return personStream.collect(Collectors.toMap(Person::hashCode, Function.identity()));
    }

    public static List<Person> toListTask(Stream<Person> personStream) {
        return personStream.collect(Collectors.toList());
    }
}
