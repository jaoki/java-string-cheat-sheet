package net.debuginthewoods.javastringcheatsheet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class TripleDoubleQuoteCheatSheetTest {

    private static void print(String value) {
        System.out.println("----- start from the next line -----");
        System.out.println(value + "<---- end");
    }

    @Test
    @DisplayName("indentations are interesting with triple double quotes")
    public void test1() {

        String base =
            "Line1\n" +
            "Line2\n" +
            "Line3\n"    // <---- note there is a new line
            ;

        String text1 = """
                Line1
                Line2
                Line3
                """;

        // note the indentations are different
        String text2 = """
Line1
Line2
Line3
""";

        String text3 =
            // the starting quotes starts from a weird place
                            """ 
                Line1
                Line2
                Line3
                                        """; // <--- spaces are ignored but only the new line stays

        print(text1);
        print(text2);
        print(text3);

        assertThat(base, is(text1)); // <---- pass
        assertThat(base, is(text2)); // <---- pass
        assertThat(base, is(text3)); // <---- pass

    }

    @Test
    @DisplayName("there is a new line at the end or not")
    public void test2() {

        String text1 = """
                Line1
                Line2
                Line3
                """;

        String text2 = """
                Line1
                Line2
                Line3""";

        print(text1);
        print(text2);

        assertThat(text1, is(not(text2))); // <----- pass note they are not the same

    }

    @Test
    @DisplayName("indentation is interesting2")
    public void test3() {

        String base =
            "Line1\n" +
            "    Line2\n" +
            "        Line3"    // <---- no new line
            ;

        String text1 = """
            Line1
                Line2
                    Line3""";

        String text2 = """
Line1
    Line2
        Line3""";

        String text3 = """
Line1
    Line2
        Line3           """; // <---- interestingly the spaces after line3 is ignored

        print(text1);
        print(text2);
        print(text3);

        assertThat(base, is(text1)); // <-- pass
        assertThat(base, is(text2)); // <-- pass
        assertThat(base, is(text3)); // <-- pass

    }

    @Test
    @DisplayName("indentation is interesting2")
    public void test4() {
        // TODO add base
        String text1 = """
                Line1
            Line2
        Line3
        """;

        String text2 = """
        Line1
    Line2
Line3
""";

        String text3 = """
        Line1
    Line2
Line3
    """;

        print(text1);
        print(text2);

        assertThat(text1, is(text2)); // <-- pass
        assertThat(text1, is(text3)); // <-- pass

    }


    @Test
    @DisplayName("less intuitive indentation and trimming")
    public void test5() {
        // TODO add base
        String text1 = """
                Line1
            Line2
        Line3
        """;

        String text2 = """
                Line1
            Line2
        Line3
            """; // <---- spaces are ignored

        String text3 = """
                Line1
            Line2
        Line3
    """;     // <----- this shifts the whole text blocks.

        print(text1);
        print(text2);
        print(text3);

        assertThat(text1, is(text2)); // <-- pass
        assertThat(text1, is(not(text3))); // <-- pass. it is not the same because the whole block is shifted

    }

    @Test
    @DisplayName("you can have \\n (new line character) but point less")
    public void test6() {

        String text1 = """
                Line1\nLine2\nLine3""";

        String text2 = """
                Line1
                Line2
                Line3""";

        print(text1);
        print(text2);

        assertThat(text1, is(text2)); // <-- pass

    }


    @Test
    @DisplayName("trailing spaces")
    public void test7() {

        String base = "Line1  ";

        String text1 = """
                Line1  """; // <---- 2 spaces but ignored

        String text2 = """
                Line1\s\s"""; // <---- use escape sequence

        print(base);
        print(text1);
        print(text2);

        assertThat(base, is(not(text1))); // <--- pass. note not the same
        assertThat(base, is(text2)); // <-- pass

    }

    @Test
    @DisplayName("Requires a new line after the staring triple double quotes")
    public void test0() {
        // This is a compile error. you can't write a character after the triple double quotes
//        String text = """Line1 <------
//                Line2
//                Line3
//                """;

    }

}
