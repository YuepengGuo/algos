package g.y.p;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTests {
    public static void main(String[] args) {
        SortedMap<Integer,String> sortedMap= new TreeMap<>();
        sortedMap.put(3,"333");
        sortedMap.put(4,"344");
        sortedMap.put(2,"23");

        sortedMap.keySet().stream().forEach(System.out::println);
        sortedMap.values().stream().forEach(System.out::println);


        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(4);
        treeSet.add(6);
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(1);

        treeSet.subSet(1,3).stream().forEach(System.out::println);



    }
}
