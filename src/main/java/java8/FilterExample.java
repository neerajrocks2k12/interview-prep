package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Neeraj", 100);
        map.put("Is", 100);
        map.put("A", 1);
        map.put("Loser", 9);
        map.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        map.entrySet().stream().filter(entry -> {
            return entry.getValue().intValue() >= 4;
        }).collect(Collectors.toMap(entry -> entry.getValue(), entry -> entry.getKey())).
                entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

}
