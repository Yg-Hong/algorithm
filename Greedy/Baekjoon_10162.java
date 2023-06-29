import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10162 {
    static int[] DP, P;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int time = Integer.parseInt(br.readLine());
        int[] count = new int[3];
        while (time != 0) {
            if (time < 10) {
                System.out.println("-1");
                return;
            }
            if(time >= 300){
                time -= 300;
                count[0]++;
            } else if (time >= 60) {
                time -= 60;
                count[1]++;
            } else if (time >= 10) {
                time -= 10;
                count[2]++;
            }
        }
        System.out.println(count[0] + " " + count[1] + " " + count[2]);
    }
}