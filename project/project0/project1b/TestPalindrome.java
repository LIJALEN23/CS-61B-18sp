package project1b;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        String word1 = "abcdcba";
        String word2 = "abcdefg";

        assertTrue(palindrome.isPalindrome(word1));
        assertFalse(palindrome.isPalindrome(word2));

    }

    @Test
    public void testIsPalindrome2() {
        String word1 = "abcddcb";
        String word2 = "abcdefg";
        CharacterComparator cc = new OffByOne();

        assertTrue(palindrome.isPalindrome(word1, cc));
        assertFalse(palindrome.isPalindrome(word2, cc));

    }

}