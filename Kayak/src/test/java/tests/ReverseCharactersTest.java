package tests;

import org.junit.Assert;
import org.junit.Test;
import utils.ReverseCharacters;

public class ReverseCharactersTest {
    private final String BAR_WITHOUT_PARENTESIS = "bar";
    private final String BAR_ONE_PARENTESIS = "(bar";
    private final String BAR = "(bar)";
    private final String FOO_BAR_AR = "foo(bar)ar";
    private final String FOO_BAR_BAZ_BLIM = "foo(bar(baz))blim";

    @Test
    public void firstUnitTest(){
        Assert.assertEquals("rab", ReverseCharacters.withParenthesis(BAR));
    }

    @Test
    public void secondUnitTest(){
        Assert.assertEquals("foorabar",  ReverseCharacters.withParenthesis(FOO_BAR_AR));
    }

    @Test
    public void thirdUnitTest(){
        Assert.assertEquals("foobazrabblim",  ReverseCharacters.withParenthesis(FOO_BAR_BAZ_BLIM));
    }

    @Test
    public void fourthUnitTest(){
        Assert.assertEquals("bar", ReverseCharacters.withParenthesis(BAR_WITHOUT_PARENTESIS));
    }

    @Test
    public void fivethUnitTest(){
        Assert.assertEquals("(bar", ReverseCharacters.withParenthesis(BAR_ONE_PARENTESIS));
    }
}
