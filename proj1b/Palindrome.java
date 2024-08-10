public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }

        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        if (word.isEmpty() || word.length() == 1) {
            return true;
        }

        int firstCharacterIndex = 0;
        int lastCharacterIndex = word.length() - 1;

        while (firstCharacterIndex < lastCharacterIndex) {
            if (word.charAt(firstCharacterIndex) != word.charAt(lastCharacterIndex)) {
                return false;
            }

            firstCharacterIndex++;
            lastCharacterIndex--;
        }

        return true;
    }
}
