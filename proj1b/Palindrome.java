public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        char[] c = word.toCharArray();
        for (char cc: c) {
            deque.addLast(cc);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return true;
        }
        for (int i = 0; i < (int) word.length()/2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
