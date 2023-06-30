import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] DP, P;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long num = Long.parseLong(br.readLine());
        long sum = 0;
        int count = 0;

        for (int i = 1; ; i++) {
            if(sum > num) break;
            sum += i;
            count++;
        }
        System.out.println(count - 1);
    }
}