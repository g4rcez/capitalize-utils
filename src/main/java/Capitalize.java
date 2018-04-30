import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Capitalize {

    private static final String ALL_UPPER_CASE = "A-Z";
    private static final String ALL_SPECIAL_UPPER_CASE = ALL_UPPER_CASE + "ÇÁÀÃÂÂÉÈẼÊÌÍĨÎÕÓÒÔŨÚÙÜÛ";
    private static final String ALL_SPECIAL_LOWER_CASE = "a-zcáàãâéèẽêìíĩîõóòôũúùüû";
    private static final String REGEX_ALL_UPPER_CASE = "[" + ALL_SPECIAL_UPPER_CASE + "]";
    private static final String REGEX_ALL_LOWER_CASE = "[" + ALL_SPECIAL_LOWER_CASE + "]";

    private static Matcher getMatcher(String string) {
        return Pattern
                .compile(REGEX_ALL_UPPER_CASE + "{2,}(?=" + REGEX_ALL_UPPER_CASE + REGEX_ALL_LOWER_CASE +
                        "+[0-9]*|\\b)|" + REGEX_ALL_UPPER_CASE + "?" + REGEX_ALL_LOWER_CASE
                        + "+[0-9]*|" + REGEX_ALL_UPPER_CASE + "|[0-9]+")
                .matcher(string);
    }

    /**
     * @param sentence
     * @return
     */
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
                .replaceAll(" E ", " e ")
                .replaceAll(" Da ", " da ")
                .replaceAll(" Das ", " das ")
                .replaceAll(" De ", " de ")
                .replaceAll(" Del ", " del ")
                .replaceAll(" Do ", " do ")
                .replaceAll(" Dos ", " dos ")
                ;
    }

    public static String toCamelCase(String string) {
        StringBuilder newString = new StringBuilder();
        Matcher m = getMatcher(string);
        while (m.find()) {
            newString.append(
                    m.group(0).substring(0, 1)
                            .toUpperCase()).append(m.group(0)
                    .substring(1).toLowerCase()
            );
        }
        return String.valueOf(newString).trim();
    }

    public static String toSneakCase(String string) {
        StringBuilder newString = new StringBuilder();
        Matcher m = getMatcher(string);
        while (m.find())
            newString.append(m.group(0).toLowerCase().concat("_"));
        return newString.toString()
                .trim()
                .replaceAll("_$", "");
    }

    public static String toSlugCase(String string) {
        StringBuilder newString = new StringBuilder();
        Matcher m = getMatcher(string);
        while (m.find())
            newString.append(m.group(0).toLowerCase().concat("-"));
        return newString.toString()
                .trim()
                .replaceAll("-$", "");
    }

    public static String camelCaseToAnother(String string, String replace) {
        String replacement = "$1" + replace + "$2";
        return string
                .replaceAll("([" + ALL_SPECIAL_LOWER_CASE + "\\d])" +
                        "(" + REGEX_ALL_UPPER_CASE + ")", replacement)
                .replaceAll("(" + REGEX_ALL_UPPER_CASE + "+)" +
                        "(" + REGEX_ALL_UPPER_CASE + "[" +
                        ALL_SPECIAL_LOWER_CASE + "\\d]+)", replacement);
    }
}
