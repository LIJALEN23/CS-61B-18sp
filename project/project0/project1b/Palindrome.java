package project1b;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        LinkListDeque<Character> wordDeque = new LinkListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }

        return wordDeque;
    }

//    public boolean isPalindrome(String word){
//        for (int i = 0; i < word.length() / 2; i++) {
//            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isPalindrome(String word) {
        Deque wordDeque = wordToDeque(word);

        //头字符和尾字符
        char front = 0;
        char rear = 0;

        //当队列不为空且队列的长度大于一
        while (!wordDeque.isEmpty() && wordDeque.size() > 1) {
            if (!wordDeque.isEmpty()) {
                front = (char) wordDeque.removeFirst();
            }
            if (!wordDeque.isEmpty()) {
                rear = (char) wordDeque.removeLast();
            }

            if (front != rear) {
                return false;
            }
        }

        //通过上述检查后即为回文
        return true;
    }

    //差一的广义回文
    public boolean isPalindrome(String word, CharacterComparator cc) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(word.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
