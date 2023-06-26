import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Baekjoon_1946 {
    static class Rank implements Comparable<Rank> {
        int doc;
        int interview;

        Rank(int doc, int interview){
            this.doc = doc;
            this.interview = interview;
        }

        @Override
        public int compareTo(Rank o) {
            if(this.doc > o.doc) {
                return 1;
            }
            else
                return -1;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Rank> arr = new ArrayList<>();

            for(int i = 0;i < N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                arr.add(new Rank(doc, interview));
            }
            Collections.sort(arr);

            int result = 1; // 서류 1등은 무조건 통과
            int min = arr.get(0).interview;
            for(int i = 1; i < N; i++) {
                if(arr.get(i).interview < min) {
                    result++;
                    min = arr.get(i).interview;
                }
            }
            System.out.println(result);
        }
    }
}