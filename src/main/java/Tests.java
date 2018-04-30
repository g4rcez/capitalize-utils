import java.util.ArrayList;
import java.util.List;

public class Tests {
    public static void main(String[] args) {
        for (String name : dumpNames()) {
            testAll(name);
            toCamelCase(name);
            toSneakCase(name);
            toSlugCase(name);
        }
    }

    public static void testAll(String name) {
        long init = System.currentTimeMillis() % 1000;
        String capitalize = Capitalize.capitalizeByWords(name);
        long end = System.currentTimeMillis() % 1000;
        System.out.println(end - init + "ms. " + capitalize);
    }

    public static void toSlugCase(String name) {
        long init = System.currentTimeMillis() % 1000;
        String capitalized = Capitalize.toSlugCase(name);
        long end = System.currentTimeMillis() % 1000;
        System.out.println(end - init + "ms. Total chars: " + capitalized);
    }

    public static void toCamelCase(String name) {
        long init = System.currentTimeMillis() % 1000;
        String capitalized = Capitalize.toCamelCase(name);
        long end = System.currentTimeMillis() % 1000;
        System.out.println(end - init + "ms. Total chars: " + capitalized);
    }

    public static void toSneakCase(String name) {
        long init = System.currentTimeMillis() % 1000;
        String capitalized = Capitalize.toSneakCase(name);
        long end = System.currentTimeMillis() % 1000;
        System.out.println(end - init + "ms. Total chars: " + capitalized);
    }

    public static List<String> dumpNames() {
        List<String> list = new ArrayList<>();
        list.add("Ada Lovelace");
        list.add("Ray Tomlinson");
        list.add("James Gosling");
        list.add("Dennis Ritchie");
        list.add("Linus Torvalds");
        list.add("Edsger Dijkstra");
        list.add("Tim Berners-Lee");
        list.add("Richard Stallman");
        list.add("Grace Murray Hopper");
        list.add("pedro de alcântara joão carlos leopoldo salvador bibiano francisco xavier de paula leocádio miguel gabriel rafael gonzaga");
        return list;
    }

}
