package u3pp;

public class PalindromeTester {

    /**
     * Tests whether a string is a palindrome. Case insensitive. 
     * @param s  the string to test
     * @return true if the string is a palindrome
     */
    
    public static boolean isPalindrome(String s) { 
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        String s_reversed = sb.toString();
        
    
        String s_lowerCase = s.toLowerCase();

        String s_reversed_lowerCase = s_reversed.toLowerCase();
        
        Boolean result = s_lowerCase.equals(s_reversed_lowerCase);
        return result;
    } 







    
}
