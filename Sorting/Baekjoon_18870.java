import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 15분
 */

public class Baekjoon_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pos = new int[N];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
            set.add(pos[i]);
        }

        Integer[] sortedPosSet = set.toArray(new Integer[0]);
        Arrays.sort(sortedPosSet);

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = Arrays.binarySearch(sortedPosSet, pos[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}