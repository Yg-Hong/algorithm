import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N];
        int[] oil = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(distance));

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(oil));
        long result = 0;
        long minCost = oil[1];
        for (int i = 1; i <= N - 1; i++) {
            if(oil[i] < minCost){
                minCost = oil[i];
            }

            result += minCost * distance[i];
        }
        System.out.println(result);
    }
}