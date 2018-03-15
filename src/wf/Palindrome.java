package wf;

/*
https://www.testdome.com/d/java-interview-questions/4 #1
A palindrome is a word that reads the same backward or forward.

Write a function that checks if a given word is a palindrome. Character case should be ignored.

For example, isPalindrome("Deleveled") should return true as character case should be ignored, resulting in "deleveled", which is a palindrome since it reads the same backward and forward.*/
public class Palindrome {
    public static boolean isPalindrome(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        int size = word.length();
        if (size == 1) {
            return true;
        }
        
        word = word.toLowerCase();
        for (int left = 0, right = size - 1; left < right; left++, right--) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
        System.out.println(Palindrome.isPalindrome(""));
        System.out.println(Palindrome.isPalindrome(null));
        System.out.println(Palindrome.isPalindrome("s"));
    }
}