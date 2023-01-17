import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Regex {

    @Test
    public void testSymbolQuestionMark() {
        //pytajnik - element znajdujący się przed '?' jest opcjonalny
        Pattern pattern = Pattern.compile("kr?at");
        assertTrue(pattern.matcher("krat").matches());
        assertTrue(pattern.matcher("kat").matches());
        assertFalse(pattern.matcher("krrat").matches());
        assertFalse(pattern.matcher("kot").matches());
    }

    @Test
    public void testSymbolAsterix() {
        //gwiazdka * - element przed gwiazdką może się powtórzyć dowolną liczbę razy (0 lub więcej)
        Pattern pattern = Pattern.compile("uwa*ga");
        assertTrue(pattern.matcher("uwga").matches());
        assertTrue(pattern.matcher("uwaga").matches());
        assertTrue(pattern.matcher("uwaaaaaaga").matches());
        assertFalse(pattern.matcher("uwagaaaa").matches());
    }

    @Test
    public void testSymbolPlus() {
        //plus + - element przed plusem MUSI się powtórzyć 1 lub więcej razy
        Pattern pattern = Pattern.compile("trampo+lina");
        assertTrue(pattern.matcher("trampolina").matches());
        assertTrue(pattern.matcher("trampoooolina").matches());
        assertFalse(pattern.matcher("tramplina").matches());
    }

    @Test
    public void testSymbolDot() {
        //kropka . - znak kropki oznacza dowolny symbol (poza znakiem nowej linii)
        Pattern pattern = Pattern.compile("ko.ek");
        assertTrue(pattern.matcher("kotek").matches());
        assertTrue(pattern.matcher("korek").matches());
        assertFalse(pattern.matcher("koek").matches());
        assertFalse(pattern.matcher("ktek").matches());
    }

    @Test
    public void testSymbolDotWithOthers() {
        Pattern pattern = Pattern.compile("k+a.*ta");
//        czyli:
//        k+ - litera k powtórzona conajmniej jeden raz
//        a - litera a
//        .* - dowolna litera powtórzona dowolną ilość razy
//        ta - litery 'ta'

        assertTrue(pattern.matcher("katapulta").matches());
        assertTrue(pattern.matcher("karta").matches());
        assertTrue(pattern.matcher("kasia ma kota").matches());
        assertTrue(pattern.matcher("kkkka#$*&JHDFSta").matches());
        assertFalse(pattern.matcher("ata").matches());
        assertFalse(pattern.matcher("kta").matches());
    }

    @Test
    public void testSimpleClasses() {
        //nawiasy [] oznaczają grupy symboli
        Pattern pattern = Pattern.compile("[rtmp]aca");
        assertTrue(pattern.matcher("raca").matches());
        assertTrue(pattern.matcher("taca").matches());
        assertTrue(pattern.matcher("maca").matches());
        assertTrue(pattern.matcher("paca").matches());
        assertFalse(pattern.matcher("praca").matches());
        assertFalse(pattern.matcher("pacanow").matches());
    }

    @Test
    public void testClassWithRangeNumber() {
        //[0-7] oznacza, że może wystąpić cyfra w przedziale od 0 do 7
        Pattern pattern = Pattern.compile("[0-7]xyz");
        assertTrue(pattern.matcher("0xyz").matches());
        assertTrue(pattern.matcher("1xyz").matches());
        assertTrue(pattern.matcher("7xyz").matches());
        assertFalse(pattern.matcher("8xyz").matches());
        assertFalse(pattern.matcher("07xyz").matches());
    }

    @Test
    public void testClassWithMultipleRanges() {
        Pattern pattern = Pattern.compile("[a-cA-C0-3]bum");
        assertTrue(pattern.matcher("abum").matches());
        assertTrue(pattern.matcher("Bbum").matches());
        assertTrue(pattern.matcher("0bum").matches());
        assertFalse(pattern.matcher("dbum").matches());
        assertFalse(pattern.matcher("aA0bum").matches());
    }

    @Test
    public void testClassNegation() {
        //znak ^ oznacza negację np. [^xyz] - znaki x, y lub z nie mogą się pojawić
        Pattern pattern = Pattern.compile("[^xyz]awa");
        assertTrue(pattern.matcher("kawa").matches());
        assertTrue(pattern.matcher("pawa").matches());
        assertTrue(pattern.matcher("Wawa").matches());
        assertFalse(pattern.matcher("zawa").matches());
        assertFalse(pattern.matcher("yawa").matches());
    }

    @Test
    public void testPredefinedClases() {
//        \d - jakakolwiek cyfra
//        \w - jakikolwiek znak używany w słowach [a-zA-Z0-9_]
        Pattern pattern = Pattern.compile("\\d\\w\\d");
        assertTrue(pattern.matcher("0_0").matches());
        assertTrue(pattern.matcher("0X1").matches());
        assertFalse(pattern.matcher("a0b").matches());
        assertFalse(pattern.matcher("0 0").matches());
    }

    @Test
    public void testBasicGroups() {
        Pattern pattern = Pattern.compile("[^-]*--(\\w+)--.*");
        Matcher matcher = pattern.matcher("Ala ma kota. Kota ma na imie --Zygmunt--. Kot jest czarny.");
        matcher.matches();
        assertEquals("Zygmunt", matcher.group(1));
    }

    //Zachłanność wyrażeń regularnych
    @Test
    public void shouldBeGreedy() {
        Pattern pattern = Pattern.compile("<(.+)>");
        Matcher matcher = pattern.matcher("<em>some emphasized text</em>");
        assertTrue(matcher.find());
        assertEquals("em>some emphasized text</em", matcher.group(1));
    }

    @Test
    public void shouldTurnOffGreedinessForPlus() {
        Pattern pattern = Pattern.compile("<(.+?)>");
        Matcher matcher = pattern.matcher("<em>some emphasized text</em>");
        assertTrue(matcher.find());
        assertEquals("em", matcher.group(1));
    }

    @Test
    public void shouldTurnOffGreedinessForAsterix() {
        Pattern pattern = Pattern.compile("<(.*?)>");
        Matcher matcher = pattern.matcher("<em>some emphasized text</em>");
        assertTrue(matcher.find());
        assertEquals("em", matcher.group(1));
    }

    @Test
    public void shouldBeAbleToCheatGreadiness() {
        Pattern pattern = Pattern.compile("<([^>]+)>");
        Matcher matcher = pattern.matcher("<em>some emphasized text</em>");
        assertTrue(matcher.find());
        assertEquals("em", matcher.group(1));
    }

    @Test
    public void shouldTurnOffGreadinessForCurlyBraces() {
        Pattern pattern = Pattern.compile("(.{3,5}?)");
        Matcher matcher = pattern.matcher("12345");
        assertTrue(matcher.find());
        assertEquals("123", matcher.group(1));
    }

    //znak alternatywy
    @Test
    public void shouldParseAlternative() {
        Pattern pattern = Pattern.compile("skręć w (prawo|lewo)");
        Matcher matcher = pattern.matcher("skręć w lewo");
        assertTrue(matcher.find());
        assertEquals("lewo", matcher.group(1));

        matcher = pattern.matcher("skręć w prawo");
        assertTrue(matcher.find());
        assertEquals("prawo", matcher.group(1));
    }

    @Test
    public void shouldPickOneFromMultipleAlternatives() {
        Pattern pattern = Pattern.compile("pies|kot|lew");
        Matcher matcher = pattern.matcher("lew");
        assertTrue(matcher.matches());
        assertEquals("lew", matcher.group());
    }

    // użycie znaków ?: powoduje, że wyr regularne w nawiasie nie zostanie zapamiętane
    @Test
    public void shouldUseNonCapturingGroups() {
        Pattern pattern = Pattern.compile("(?:Ala|Ola) ma (kota|psa)");
        Matcher matcher = pattern.matcher("Ola ma psa");
        assertTrue(matcher.matches());
        assertEquals("psa", matcher.group(1));
    }

    //<nazwa> - pozwala na nazwanie grupy w nawiasie
    @Test
    public void shouldUseNamedGroups() {
        Pattern pattern = Pattern.compile("(?<day>\\d{2}).(?<month>\\d{2})\\.(?<year>\\d{4})");
        Matcher matcher = pattern.matcher("04.01.2017");
        assertTrue(matcher.matches());
        assertEquals("04", matcher.group("day"));
        assertEquals("04", matcher.group(1));
        assertEquals("2017", matcher.group("year"));
        assertEquals("2017", matcher.group(3));
    }

    //ponowne użycie grup w wyrażeniu - \\1 oznacza, że w danym miejscu zostanie użyta grupa z 1go nawiasu
    @Test
    public void shouldReuseGroupsInsideRegexp() {
        Pattern pattern = Pattern.compile("<(.+?)>(.+?)</\\1>");
        Matcher matcher = pattern.matcher("<p>Some paragraph <em>emphasized</em></p><p>Other paragraph</p>");
        assertTrue(matcher.find());
        assertEquals("p", matcher.group(1));
        assertEquals("Some paragraph <em>emphasized</em>", matcher.group(2));
    }

    //kotwice:
    // ^ oznacza początek łańcucha znaków
    // $ oznacza koniec łańcucha znaków
    @Test
    public void shouldShowDifferenceBetweenFindAndMatches() {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("abc123def");
        assertTrue(matcher.find());
        assertFalse(matcher.matches());
    }

    @Test
    public void shouldShowDifferenceBetweenFindAndMatchesWithAncors() {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher("abc123def");
        assertFalse(matcher.find());
        assertFalse(matcher.matches());
    }

    @Test
    public void shouldCheckIPNumber() {
        // \\d{1,2} - zakres 0-99
        // (0|1)\\d{2} - zakres 000 - 199
        // 2[0-4]\\d - zakres 200-249
        // 25[0-5] - zakres 250-255
        String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String pattern = zeroTo255 + "\\."+ zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

        Pattern p = Pattern.compile(pattern);
    }

    @Test
    public void shouldRemoveDuplicateWords() {
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
    }

}
