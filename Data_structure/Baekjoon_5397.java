import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */

public class Baekjoon_5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            String input = br.readLine();

            Deque<Character> cursorLeft = new LinkedList<>();
            Deque<Character> cursorRight = new LinkedList<>();

            for (char ch : input.toCharArray()) {
                if (ch == '<') {
                    if (!cursorLeft.isEmpty()) {
                        cursorRight.addFirst(cursorLeft.pollLast());
                    }
                } else if(ch == '>') {
                    if (!cursorRight.isEmpty()) {
                        cursorLeft.addLast(cursorRight.pollFirst());
                    }
                } else if (ch == '-') {
                    if(!cursorLeft.isEmpty()) {
                        cursorLeft.pollLast();
                    }
                } else {
                    cursorLeft.addLast(ch);
                }
            }

            while (!cursorLeft.isEmpty()) {
                sb.append(cursorLeft.pollFirst());
            }
            while (!cursorRight.isEmpty()) {
                sb.append(cursorRight.pollFirst());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}