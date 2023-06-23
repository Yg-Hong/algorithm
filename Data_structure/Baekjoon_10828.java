import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] stack = new int[100000];
        int top = -1;

        for(int test_case = 1;test_case <= T;test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push" :
                    int x = Integer.parseInt(st.nextToken());
                    stack[++top] = x;
                    break;
                case "pop" :
                    if (top < 0) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack[top--]);
                    }
                    break;
                case "size" :
                    System.out.println(top + 1);
                    break;
                case "empty" :
                    if (top < 0)
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                case "top" :
                    if (top < 0)
                        System.out.println("-1");
                    else
                        System.out.println(stack[top]);
                    break;
            }
        }
    }
}