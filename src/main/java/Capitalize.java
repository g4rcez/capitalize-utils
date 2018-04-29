import java.util.Objects;

public final class Capitalize {

    public static String capitalizeByWords(String sentence) {
        StringBuilder newString = new StringBuilder();
        try {
            for (String word : sentence.toLowerCase().split(" ")) {
                newString.append(word.substring(0, 1)
                        .toUpperCase()
                        .concat(word.substring(1))
                        .concat(" "));
            }
        } catch (Exception ignored) {
        }
        return newString.toString().trim();
    }

    public static String brazillianCapitalize(String palavra) {
        return Objects.requireNonNull(capitalizeByWords(palavra))
                .replaceAll(" Da ", " da ")
                .replaceAll(" Das ", " das ")
                .replaceAll(" De ", " de ")
                .replaceAll(" Del ", " del ")
                .replaceAll(" Do ", " do ")
                .replaceAll(" Dos ", " dos ")
                ;
    }

}
