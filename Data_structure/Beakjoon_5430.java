import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Beakjoon_5430 {

    public static ArrayDeque<Integer> deque;
    public static boolean direction; //true: -> & false: <-

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for (int i = 0; i < n; i++)
                deque.add(Integer.parseInt(st.nextToken()));
            direction = true;

            if (AC(p, deque)) {
                //출력문 생성
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (deque.size() > 0) {
                    if (direction) {
                        sb.append(deque.pollFirst());

                        while(!deque.isEmpty()) {
                            sb.append(",").append(deque.pollFirst());
                        }
                    } else {
                        sb.append(deque.pollLast());

                        while (!deque.isEmpty()) {
                            sb.append(",").append(deque.pollLast());
                        }
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }

    public static boolean AC(String command, ArrayDeque<Integer> deque) {
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
                case 'R':
                    direction = !direction;
                    break;
                case 'D':
                    if (deque.size() == 0) {
                        System.out.println("error");
                        return false;
                    }
                    if (direction) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                    break;
            }
        }
        return true;
    }
}