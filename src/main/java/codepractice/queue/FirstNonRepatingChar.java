package codepractice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepatingChar {
    public String FirstNonRepeating(String s) {
        Queue<Character> queue = new LinkedList<>();
        int[] freq = new int[26]; // To store frequency of each character
        char[] ch = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++; // Increment frequency of character

            // Add the character to queue if its frequency is 1 (non-repeating)
            if (freq[c - 'a'] == 1) {
                queue.add(c);
            }

            // Remove characters from the front of the queue if their frequency is greater than 1
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            // If the queue is empty, there is no non-repeating character, otherwise peek the front of the queue
            if (queue.isEmpty()) {
                ch[i] = '#';
            } else {
                ch[i] = queue.peek();
            }
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        String s="aabc";
        FirstNonRepatingChar firstNonRepatingChar=new FirstNonRepatingChar();
        System.out.println(firstNonRepatingChar.FirstNonRepeating(s));
    }
}
