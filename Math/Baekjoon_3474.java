import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_3474 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int five = 0;
            for (int i = 5; i <= N; i *= 5) {
                five += N / i;
            }

            System.out.println(five);
        }
    }
}