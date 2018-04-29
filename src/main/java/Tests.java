import java.util.ArrayList;
import java.util.List;

public class Tests {
    public static void main(String[] args) {
        for (String name : dumpNames()) {
            testAll(name, "New Capitalize Method -->");
            testAllWithOld(name, "Old Capitalize Method");
        }
    }

    public static String testAll(String name, String message) {
        long init = System.currentTimeMillis() % 1000;
        String capitalize = Capitalize.brazillianCapitalize(name);
        long end = System.currentTimeMillis() % 1000;
        System.out.println(end - init + "ms. Total chars: " + name.length() + ". " + message);
        return name;
    }

    public static String testAllWithOld(String name, String message) {
        long init = System.currentTimeMillis() % 1000;
        String capitalize = OldCapitalize.capitalize(name);
        long end = System.currentTimeMillis() % 1000;
        System.out.println(end - init + "ms. Total chars: " + name.length() + ". " + message);
        return name;
    }

    public static List<String> dumpNames() {
        List<String> list = new ArrayList<>();
        list.add("tomás turbando nassuakara");
        list.add("pedro de alcântara joão carlos leopoldo salvador bibiano francisco xavier de paula leocádio miguel gabriel rafael gonzaga");
        list.add("pedro de alcântara joão carlos leopoldo salvador bibiano francisco xavier de paula leocádio miguel gabriel rafael gonzaga da silva lima soares reis de moraes tristão rodrigues fernandes freitas garcez caetano prestes muller e abreu");
        list.add("Luiz Inácio da Silva");
        list.add("James Gosling");
        list.add("Dilma Vana Rousseff");
        list.add("Grace Murray Hopper");
        list.add("Ada Lovelace");
        list.add("Edsger Dijkstra");
        list.add("Tim Berners-Lee");
        list.add("Ray Tomlinson");
        list.add("Linus Torvalds");
        list.add("Dennis Ritchie");
        list.add("Richard Stallman");
        list.add("matheus lucas leandro thiago henrique gomes lima e silva");
        return list;
    }

}
