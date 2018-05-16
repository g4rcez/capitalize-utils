/*
 * Capitalize it's a little class to implements capitalize strings, convert cases (Slug, Camel and Sneak).
 * Using Capitalize:
 * String name = "pedRO DE ALcÂntARA joão carlOs";
 * // General purpose capitalize
 * Capitalize.capitalizeByWords(name); // Pedro De Alcântara João Carlos
 * // Brazilian capitalize names (connectives are not UPPER CASE)
 * Capitalize.brazilianCapitalize(name); // Pedro de Alcântara João Carlos
 * // Every String to camelCaseString
 * Capitalize.toCamelCase(name); // PedRoDeALcÂntAraJoãoCarlOs - Ops...maybe this isn't the expected string, so...
 * Capitalize.toCamelCase(Capitalize.capitalizeByWords(name); // PedroDeAlcântaraJoãoCarlos - Works great !!!
 * // Every String to sneak_case
 * Capitalize.toSneakeCase(name); // ped_ro_de_a_lc_ânt_ara_joão_carl_os - Same case, same solution
 * // Every String to slug-case
 * Capitalize.toSlugCase(name); // ped-ro-de-a-lc-ânt-ara-joão-carl-os - Same case, same solution ^2
 * Capitalize.toSlugCase(Capitalize.capitalizeByWords(name); // pedro-de-alcântara-joão-carlos - Works great, again !!! ^2
 * */

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Allan 'vandalvnl' Garcez
 */
public final class Capitalize {

    /**
     * All accented characters in the Portuguese alphabet, in UPPER CASE
     */
    private static final String ALL_SPECIAL_UPPER_CASE = "A-ZÇÁÀÃÂÉÈẼÊÌÍĨÎÕÓÒÔŨÚÙÜÛ.";
    /**
     * All accented characters in the Portuguese alphabet, in lower case
     */
    private static final String ALL_SPECIAL_LOWER_CASE = "a-zçáàãâéèẽêìíĩîõóòôũúùüû.";

    /**
     * Just regex for characters in ALL_SPECIAL...in cases where groups covering the
     */
    private static final String REGEX_ALL_UPPER_CASE = "[" + ALL_SPECIAL_UPPER_CASE + "]";
    /**
     * Same for REGEX_ALL_UPPER_CASE
     */
    private static final String REGEX_ALL_LOWER_CASE = "[" + ALL_SPECIAL_LOWER_CASE + "]";

    /**
     * GetMatcher provide a compiled regex to Slug/Camel/Sneak Case. Inspired by http://30secondsofcode.org
     *
     * @param string
     * @return
     */
    private static Matcher getMatcher(String string) {
        return Pattern.compile(REGEX_ALL_UPPER_CASE +
                "{2,}(?=" + REGEX_ALL_UPPER_CASE + REGEX_ALL_LOWER_CASE +
                "+[0-9]*|\\b)|" + REGEX_ALL_UPPER_CASE + "?" + REGEX_ALL_LOWER_CASE
                + "+[0-9]*|" + REGEX_ALL_UPPER_CASE + "|[0-9]+").matcher(string);
    }

    /**
     * Capitalize every first character in words. Split by spaces(" "), tabulations("\t") and line breaker("\n")
     *
     * @param words
     * @return
     */
    public static String capitalizeByWords(String words) {
        if (words.length() == 0) return words;
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer tokens = new StringTokenizer(words, " \t\n", true);
        for (; tokens.hasMoreTokens(); ) {
            String slice = tokens.nextToken();
            stringBuilder.append(slice.substring(0, 1)
                    .toUpperCase()
                    .concat(slice.substring(1).toLowerCase()));
        }
        return stringBuilder.toString().trim();
    }

    /**
     * The same thing of capitalizeByWords(), but this replace all connectives name's in Portuguese BR
     *
     * @param words
     * @return
     */
    public static String brazilianCapitalize(String words) {
        return capitalizeByWords(words).replaceAll(" E ", " e ")
                .replaceAll(" Da ", " da ").replaceAll(" Das ", " das ")
                .replaceAll(" De ", " de ").replaceAll(" Del ", " del ")
                .replaceAll(" Do ", " do ").replaceAll(" Dos ", " dos ");
    }

    /**
     * Convert any string to camelCase. Ideal to create method names ou class
     *
     * @param string
     * @return
     */
    public static String toPascalCase(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        Matcher matcher = getMatcher(string);
        while (matcher.find())
            stringBuilder.append(matcher.group(0).substring(0, 1).toUpperCase()).append(matcher.group(0).substring(1).toLowerCase());
        return String.valueOf(stringBuilder).trim();
    }

    public static String toCamelCase(String string) {
        String camelCase = toPascalCase(string);
        return camelCase.substring(0, 1).toLowerCase()
                .concat(camelCase.substring(1));
    }

    /**
     * Convert any string to camelCase. Ideal to rename files before to save on server
     *
     * @param string
     * @return
     */
    public static String toSneakCase(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        Matcher matcher = getMatcher(string);
        while (matcher.find())
            stringBuilder.append(matcher.group(0).toLowerCase().concat("_"));
        return stringBuilder.toString().replaceAll("_$", "");
    }

    /**
     * Convert any string to camelCase. Ideal to create route names dynamically
     *
     * @param string
     * @return
     */
    public static String toSlugCase(String string) {
        StringBuilder n = new StringBuilder();
        Matcher matcher = getMatcher(string);
        while (matcher.find())
            n.append(matcher.group(0).toLowerCase().concat("-"));
        return n.toString().replaceAll("-$", "");
    }
}
