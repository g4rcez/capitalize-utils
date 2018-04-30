import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Allan 'vandalvnl' Garcez
 */
public final class Capitalize {

    private static final String ALL_SPECIAL_UPPER_CASE = "A-ZÇÁÀÃÂÉÈẼÊÌÍĨÎÕÓÒÔŨÚÙÜÛ";
    private static final String ALL_SPECIAL_LOWER_CASE = "a-zçáàãâéèẽêìíĩîõóòôũúùüû";
    private static final String REGEX_ALL_UPPER_CASE = "[" + ALL_SPECIAL_UPPER_CASE + "]";
    private static final String REGEX_ALL_LOWER_CASE = "[" + ALL_SPECIAL_LOWER_CASE + "]";

    private static Matcher getMatcher(String s) {
        return Pattern.compile(REGEX_ALL_UPPER_CASE + "{2,}(?=" + REGEX_ALL_UPPER_CASE + REGEX_ALL_LOWER_CASE +
                "+[0-9]*|\\b)|" + REGEX_ALL_UPPER_CASE + "?" + REGEX_ALL_LOWER_CASE
                + "+[0-9]*|" + REGEX_ALL_UPPER_CASE + "|[0-9]+").matcher(s);
    }

    /**
     * @param w
     * @return
     */
    public static String capitalizeByWords(String w) {
        if (w.length() == 0) return w;
        StringBuilder s = new StringBuilder();
        StringTokenizer t = new StringTokenizer(w, " \t\r\n", true);
        for (; t.hasMoreTokens(); ) {
            String p = t.nextToken();
            s.append(p.substring(0, 1).toUpperCase().concat(p.substring(1)));
        }
        return s.toString().trim();
    }

    public static String brazillianCapitalize(String p) {
        return capitalizeByWords(p).replaceAll(" E ", " e ")
                .replaceAll(" Da ", " da ").replaceAll(" Das ", " das ")
                .replaceAll(" De ", " de ").replaceAll(" Del ", " del ")
                .replaceAll(" Do ", " do ").replaceAll(" Dos ", " dos ");
    }

    public static String toCamelCase(String s) {
        StringBuilder n = new StringBuilder();
        Matcher m = getMatcher(s);
        while (m.find())
            n.append(m.group(0).substring(0, 1).toUpperCase()).append(m.group(0).substring(1).toLowerCase());
        return String.valueOf(n).trim();
    }

    public static String toSneakCase(String string) {
        StringBuilder n = new StringBuilder();
        Matcher m = getMatcher(string);
        while (m.find())
            n.append(m.group(0).toLowerCase().concat("_"));
        return n.toString().replaceAll("_$", "");
    }

    public static String toSlugCase(String s) {
        StringBuilder n = new StringBuilder();
        Matcher m = getMatcher(s);
        while (m.find())
            n.append(m.group(0).toLowerCase().concat("-"));
        return n.toString().replaceAll("-$", "");
    }

    public static String camelCaseToAnother(String s, String r) {
        String rl = "$1" + r + "$2";
        return s.replaceAll("([" + ALL_SPECIAL_LOWER_CASE + "\\d])" +
                "(" + REGEX_ALL_UPPER_CASE + ")", rl).replaceAll("(" + REGEX_ALL_UPPER_CASE + "+)" +
                "(" + REGEX_ALL_UPPER_CASE + "[" +
                ALL_SPECIAL_LOWER_CASE + "\\d]+)", rl);
    }
}
